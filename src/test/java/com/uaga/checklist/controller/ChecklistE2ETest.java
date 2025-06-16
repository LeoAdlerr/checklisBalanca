package com.uaga.checklist.controller;

import com.uaga.checklist.AbstractIntegrationTest;
import com.uaga.checklist.dto.response.ChecklistResponseDto;
import com.uaga.checklist.entity.Checklist;
import com.uaga.checklist.repository.ChecklistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChecklistE2ETest extends AbstractIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ChecklistRepository checklistRepository;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @BeforeEach
    void setUp() {
        checklistRepository.deleteAll();
    }
    
    @Test
    void createChecklist_whenValidBody_shouldSaveAndReturnCreated() {
        // Usa a data e hora atuais para garantir que a validação @PastOrPresent passe.
        String requestBody = createChecklistRequestBody("Ricardo Mendes", LocalDateTime.now());
        HttpEntity<String> requestEntity = createRequestEntity(requestBody);

        ResponseEntity<ChecklistResponseDto> response = restTemplate.exchange(
                getBaseUrl(), HttpMethod.POST, requestEntity, ChecklistResponseDto.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        ChecklistResponseDto responseBody = response.getBody();
        assertThat(responseBody).isNotNull();
    }

    @Test
    void workflow_deleteInProgress_and_createAndFinalizeNew_shouldSucceed() {
        // ETAPA 1: O inspetor inicia um checklist.
        ChecklistResponseDto checklistParaDeletar = createInitialTestChecklist("Inspetor Com Erro", LocalDateTime.now().minusMinutes(30));
        Long idParaDeletar = checklistParaDeletar.getId();
        
        // ETAPA 2: O inspetor percebe o erro e deleta o checklist em andamento.
        ResponseEntity<Void> deleteResponse = restTemplate.exchange(getBaseUrl() + "/{id}", HttpMethod.DELETE, null, Void.class, idParaDeletar);
        
        assertThat(deleteResponse.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        assertThat(checklistRepository.findById(idParaDeletar)).isEmpty();

        // ETAPA 3: O inspetor começa de novo, com o checklist correto.
        ChecklistResponseDto checklistCorreto = createInitialTestChecklist("Inspetor Correto", LocalDateTime.now().minusMinutes(15));
        Long idCorreto = checklistCorreto.getId();

        // ETAPA 4: O inspetor preenche todos os 18 pontos do novo checklist.
        for (int i = 2; i <= 18; i++) {
            String itemJson = String.format("{\"itens\": [{\"pontoVerificacaoId\": %d, \"statusConformidadeId\": 401, \"observacoes\": \"Ponto %d verificado.\"}]}", i, i);
            restTemplate.put(getBaseUrl() + "/{id}", createRequestEntity(itemJson), idCorreto);
        }
        
        // ETAPA 5: O inspetor finaliza a inspeção.
        String finalizationBody = String.format("{\"dataHoraTermino\": \"%s\"}", LocalDateTime.now().format(formatter));
        ResponseEntity<ChecklistResponseDto> finalResponse = restTemplate.exchange(
                getBaseUrl() + "/{id}", HttpMethod.PUT, createRequestEntity(finalizationBody), ChecklistResponseDto.class, idCorreto
        );

        assertThat(finalResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(finalResponse.getBody().getDataHoraTermino()).isNotNull();
    }

    @Test
    void getChecklistsByDateRange_shouldReturnMatchingChecklists() {
        // ARRANGE: Cria checklists usando datas relativas a "hoje".
        LocalDateTime today = LocalDateTime.now();
        createInitialTestChecklist("Inspetor de Hoje-A", today.minusHours(2));
        createInitialTestChecklist("Inspetor de Hoje-B", today.minusHours(1));
        createInitialTestChecklist("Inspetor de Ontem", today.minusDays(1));

        String startDate = today.toLocalDate().atStartOfDay().format(formatter);
        String endDate = today.toLocalDate().atTime(23, 59, 59).format(formatter);

        String url = UriComponentsBuilder.fromHttpUrl(getBaseUrl() + "/search")
                .queryParam("startDate", startDate)
                .queryParam("endDate", endDate)
                .toUriString();

        // ACT
        ResponseEntity<List<ChecklistResponseDto>> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<>() {}
        );

        // ASSERT
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        List<ChecklistResponseDto> foundChecklists = response.getBody();
        assertThat(foundChecklists).isNotNull().hasSize(2);
    }

    // --- MÉTODOS AUXILIARES ---

    private String getBaseUrl() {
        return "http://localhost:" + port + "/api/checklists";
    }

    private HttpEntity<String> createRequestEntity(String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(body, headers);
    }
    
    private ChecklistResponseDto createInitialTestChecklist(String inspectorName, LocalDateTime startTime) {
        String requestBody = createChecklistRequestBody(inspectorName, startTime);
        ResponseEntity<ChecklistResponseDto> response = restTemplate.postForEntity(
                getBaseUrl(), createRequestEntity(requestBody), ChecklistResponseDto.class
        );
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        return response.getBody();
    }

    private String createChecklistRequestBody(String inspectorName, LocalDateTime startTime) {
        String formattedStartTime = startTime.format(formatter);
        String exitDate = startTime.toLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE);

        return String.format("""
        {
          "dataHoraInicio": "%s",
          "tipoInspecaoModalidadeId": 101, "operacaoId": 201, "tipoUnidadeId": 301,
          "nomeRespInspecao": "%s",
          "assinaturaRespInspecao": "assinatura_inspetor.png",
          "nLacreUagaPosInspecao": "UAGA-INSP-123",
          "nLacreUagaPosCarregamento": "UAGA-CARGA-456",
          "nomeRespLacre": "Resp Lacre",
          "assinaturaRespLacre": "assinatura_lacre.png",
          "nomeRespDeslacrePosCarregamento": "Resp Deslacre",
          "assinaturaRespDeslacrePosCarregamento": "assinatura_deslacre.png",
          "nLacreArmador": "ARMADOR-XYZ",
          "nLacreRfb": "RFB-789",
          "observacoesGerais": "Observação inicial.",
          "providenciasTomadas": "Nenhuma.",
          "assinaturaMotorista": "assinatura_motorista.png",
          "itens": [{"pontoVerificacaoId": 1, "statusConformidadeId": 401, "observacoes": "Item inicial OK"}],
          "lacresSaida": {
              "lacreRfbId": 2, 
              "lacreArmadorPosUnitizacaoId": 2, 
              "fitaLacreUagaCompartimentoId": 1, 
              "nomeRespVerificacao": "Resp Verificação", 
              "assinaturaRespVerificacao": "assinatura_verificacao.png", 
              "dataSaida": "%s"
          }
        }
        """, formattedStartTime, inspectorName, exitDate);
    }
}
