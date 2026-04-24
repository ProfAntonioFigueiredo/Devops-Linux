# portalweb

Projeto Spring Boot para CRUD de alunos (tabela t_aluno) conectado ao MySQL.

## Endpoints
- `GET /alunos` — lista todos os alunos
- `GET /alunos/{rmAluno}` — busca aluno por RM
- `POST /alunos` — cria novo aluno
- `PUT /alunos/{rmAluno}` — atualiza aluno
- `DELETE /alunos/{rmAluno}` — remove aluno

## Frontend
- `GET /` — tela visual para cadastrar, editar, listar e excluir alunos no navegador
- formulario de entrega final com nome, RM e turma para envio ao webhook do professor

## Entrega via webhook
- `POST /entregas` — recebe nome, RM e turma e encaminha a conclusao do desafio para o webhook configurado
- o webhook pode ser sobrescrito pela variavel `APP_WEBHOOK_URL`

## Configuração do banco
Veja `src/main/resources/application.properties` para detalhes de conexão.

## Build e execução
1. Execute `docker compose up --build` na raiz do projeto.
2. O build Maven roda dentro do Dockerfile.
3. A interface ficará disponível em `http://localhost:8080`.
4. A API continuará disponível em `http://localhost:8080/alunos`.

---

Ajuste conforme necessário para seu ambiente.
