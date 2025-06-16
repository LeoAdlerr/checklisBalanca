package com.uaga.checklist.controller;

import com.uaga.checklist.dto.CreateChecklistDto;
import com.uaga.checklist.dto.UpdateChecklistDto;
import com.uaga.checklist.dto.response.ChecklistResponseDto;
import com.uaga.checklist.service.ChecklistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/checklists")
@Tag(name = "Checklists", description = "Operações relacionadas ao gerenciamento de Checklists")
public class ChecklistController {

    private final ChecklistService checklistService;

    @Autowired
    public ChecklistController(ChecklistService checklistService) {
        this.checklistService = checklistService;
    }

    @PostMapping
    @Operation(summary = "Cria um novo checklist completo",
               description = "Cria um novo Checklist incluindo todos os seus itens, evidências e informações de lacre de saída.")
    @ApiResponse(responseCode = "201", description = "Checklist criado com sucesso",
                 content = @Content(mediaType = "application/json", schema = @Schema(implementation = ChecklistResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "Dados de requisição inválidos",
                 content = @Content(mediaType = "application/json"))
    public ResponseEntity<ChecklistResponseDto> createChecklist(@Valid @RequestBody CreateChecklistDto createChecklistDto) {
        ChecklistResponseDto createdChecklist = checklistService.createChecklist(createChecklistDto);
        return new ResponseEntity<>(createdChecklist, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Recupera todos os Checklists",
               description = "Retorna uma lista de todos os Checklists com seus detalhes associados.")
    @ApiResponse(responseCode = "200", description = "Lista de checklists recuperada com sucesso",
                 content = @Content(mediaType = "application/json", schema = @Schema(implementation = ChecklistResponseDto.class)))
    public ResponseEntity<List<ChecklistResponseDto>> getAllChecklists() {
        List<ChecklistResponseDto> checklists = checklistService.getAllChecklists();
        return new ResponseEntity<>(checklists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Recupera um Checklist específico por ID",
               description = "Retorna um único Checklist com base em seu identificador único.")
    @Parameter(name = "id", description = "ID do Checklist a ser recuperado", required = true, schema = @Schema(type = "long"))
    @ApiResponse(responseCode = "200", description = "Checklist recuperado com sucesso",
                 content = @Content(mediaType = "application/json", schema = @Schema(implementation = ChecklistResponseDto.class)))
    @ApiResponse(responseCode = "404", description = "Checklist não encontrado",
                 content = @Content(mediaType = "application/json"))
    public ResponseEntity<ChecklistResponseDto> getChecklistById(@PathVariable Long id) {
        ChecklistResponseDto checklist = checklistService.getChecklistById(id);
        return new ResponseEntity<>(checklist, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um Checklist existente",
               description = "Atualiza os campos de um Checklist existente identificado por seu ID.")
    @Parameter(name = "id", description = "ID do Checklist a ser atualizado", required = true, schema = @Schema(type = "long"))
    @ApiResponse(responseCode = "200", description = "Checklist atualizado com sucesso",
                 content = @Content(mediaType = "application/json", schema = @Schema(implementation = ChecklistResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "Dados de requisição inválidos ou falha na regra de negócio",
                 content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Checklist não encontrado",
                 content = @Content(mediaType = "application/json"))
    public ResponseEntity<ChecklistResponseDto> updateChecklist(@PathVariable Long id, @Valid @RequestBody UpdateChecklistDto updateChecklistDto) {
        ChecklistResponseDto updatedChecklist = checklistService.updateChecklist(id, updateChecklistDto);
        return new ResponseEntity<>(updatedChecklist, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um Checklist por ID",
               description = "Exclui um Checklist existente e todas as suas informações associadas.")
    @Parameter(name = "id", description = "ID do Checklist a ser excluído", required = true, schema = @Schema(type = "long"))
    @ApiResponse(responseCode = "204", description = "Checklist excluído com sucesso (Sem Conteúdo)")
    @ApiResponse(responseCode = "400", description = "Requisição inválida (ex: checklist já finalizado)")
    @ApiResponse(responseCode = "404", description = "Checklist não encontrado")
    public ResponseEntity<Void> deleteChecklist(@PathVariable Long id) {
        checklistService.deleteChecklist(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }

      /**
     * Endpoint para buscar checklists por um intervalo de datas.
     * Mapeado para /search para evitar conflito com /get/{id}.
     */
    @GetMapping("/search")
    @Operation(summary = "Busca checklists por intervalo de datas",
               description = "Retorna uma lista de checklists cuja data de início está dentro do período especificado.")
    @ApiResponse(responseCode = "200", description = "Checklists encontrados.")
    @ApiResponse(responseCode = "404", description = "Nenhum checklist encontrado para o período.")
    public ResponseEntity<List<ChecklistResponseDto>> getChecklistsByDateRange(
            @Parameter(description = "Data de início (formato YYYY-MM-DDTHH:MM:SS)", required = true, example = "2025-06-01T00:00:00")
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @Parameter(description = "Data de término (formato YYYY-MM-DDTHH:MM:SS)", required = true, example = "2025-06-30T23:59:59")
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        
        List<ChecklistResponseDto> checklists = checklistService.getChecklistsByDateRange(startDate, endDate);
        return ResponseEntity.ok(checklists);
    }

}
