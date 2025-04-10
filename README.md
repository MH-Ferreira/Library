📚 Sistema de Biblioteca - API REST com Spring Boot
Este é um sistema simples de gerenciamento de biblioteca, desenvolvido com Spring Boot, que permite operações básicas como listar livros, buscar por ID e visualizar o cache de livros.

🔧 Tecnologias Utilizadas
Java 17+

Spring Boot

Spring Web

Spring Data JPA

MySQL

Lombok (opcional)

Cache simples (opcional)

📁 Estrutura do Projeto
bash
Copy
Edit
├── src
│   └── main
│       ├── java
│       │   └── com.example.biblioteca
│       │       ├── controller
│       │       │   └── LivroController.java
│       │       ├── dto
│       │       │   └── LivroDTO.java
│       │       ├── service
│       │       │   └── LivroService.java
│       │       └── model
│       │           └── Livro.java
│       └── resources
│           ├── application.properties
├── pom.xml
└── README.md
