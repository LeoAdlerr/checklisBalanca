# ARQUITETURA


springChecklistBalanca/
├── pom.xml                                   # Configuração do Maven
├── src/
└── main/
│    └── java/
│        └── com/
│            └── uaga/
│                └── checklist/
│                    ├── controller/
│                    ├── dto/
│                    │   └── response/
│                    │       ├── ChecklistResponseDto.java
│                    │       └── ErrorResponseDto.java  
│                    ├── entity/
│                    ├── exception/                     <-- NOVO PACOTE
│                    │   └── GlobalExceptionHandler.java  <-- AQUI
│                    ├── repository/
│                    └── service/
└── test/
│      └── java/
│           └── com/
│               └── uaga/
│                   └── checklist/
│                       └── ... (Testes)