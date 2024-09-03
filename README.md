
# API de Gestão de Clientes

Esta é uma API RESTful desenvolvida em Java utilizando Spring Boot para gerenciar informações de clientes e seus endereços.
A API permite realizar operações de CRUD para as entidades Cliente e Endereço.

## Funcionalidades

- **Clientes:**
  - Listar todos os clientes.
  - Buscar um cliente por ID.
  - Criar um novo cliente.
  - Atualizar os dados de um cliente existente.
  - Excluir um cliente.

- **Endereços:**
  - Associado a cada cliente, contém informações como CEP, logradouro, complemento, bairro, localidade e UF.

## Tecnologias Utilizadas

- Java 11+
- Spring Boot 2.5+
- Spring Data JPA
- Hibernate
- Maven
- **MySQL**
- Springdoc OpenAPI (para documentação com Swagger UI)

## Como utilizar a API

Após clonar o repositório, abrir o projeto pela IDE e rodar o comando "docker-compose up" no terminal.
   
## Endpoints
  - GET /clientes - Lista todos os clientes
  - GET /clientes/{id} - Busca um cliente por ID
  - POST /clientes - Cria um novo cliente
  - PUT /clientes/{id} - Atualiza os dados de um cliente existente
  - DELETE /clientes/{id} - Exclui um cliente


## Validações e Tratamento de Erros
- CPF e Email: Validação automática utilizando as anotações @CPF e @Email.
- Mensagens Personalizadas: Mensagens de erro customizadas(CPF e Email inválidos, por exemplo).


## Acesse a API/Documentação:
Após iniciar a API, pode acessar a documentação e também testar os endpoints atraves do seguinte endereço:

Swagger UI: http://localhost:8080/swagger-ui/index.html
