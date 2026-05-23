# 🚀 Desafio CodeSignal - Senior Software Engineer Java

## 📌 Objetivo

Este repositório contém um desafio técnico inspirado no processo utilizado pelo CodeSignal para vagas de **Senior Software Engineer** em empresas de alta performance.

O desafio foi dividido em **4 fases progressivas**, aumentando gradualmente o nível de:

- Complexidade algorítmica
- Arquitetura de software
- Modelagem orientada a objetos
- Concorrência e performance
- Boas práticas de engenharia
- Design de sistemas

A stack principal será:

- Java 21
- Maven
- JUnit 5
- Mockito
- Docker (opcional nas fases finais)

---

# 🧩 Estrutura do Desafio

| Fase | Tema | Complexidade |
|---|---|---|
| 1 | Algoritmos e Estruturas de Dados | 🟢 Fácil/Médio |
| 2 | Backend Orientado a Objetos | 🟡 Médio |
| 3 | Arquitetura e Concorrência | 🟠 Difícil |
| 4 | Sistema Distribuído e Escalabilidade | 🔴 Senior/Staff |

---

# 📂 Estrutura Esperada do Projeto

```bash
codesignal-java-challenge/
│
├── src/
│   ├── main/java/
│   └── test/java/
│
├── README.md
├── pom.xml
└── docker-compose.yml
```

---

# 🟢 FASE 1 — Algoritmos e Estruturas de Dados

## 🎯 Objetivo

Avaliar:

- Lógica
- Complexidade computacional
- Uso correto de estruturas de dados
- Código limpo

---

## 📋 Problema

Implemente um sistema que receba milhões de transações financeiras e retorne:

- Soma total
- Média
- Maior transação
- Menor transação
- Quantidade de transações duplicadas

---

## 📥 Entrada

```java
List<BigDecimal> transactions
```

---

## 📤 Saída Esperada

```java
TransactionStatistics {
    BigDecimal total;
    BigDecimal average;
    BigDecimal max;
    BigDecimal min;
    Long duplicatedTransactions;
}
```

---

## ✅ Requisitos

- Complexidade O(n)
- Não utilizar loops aninhados
- Utilizar Stream API quando fizer sentido
- Cobertura mínima de testes: 80%

---

## ⭐ Diferenciais

- Imutabilidade
- Uso de records do Java 21
- Paralelismo com `parallelStream()`

---

# 🟡 FASE 2 — Backend Orientado a Objetos

## 🎯 Objetivo

Avaliar:

- Design orientado a objetos
- SOLID
- Clean Code
- Tratamento de exceções
- Modelagem de domínio

---

## 📋 Problema

Crie uma API de carteira digital.

A carteira deve permitir:

- Criar conta
- Depositar
- Sacar
- Transferir
- Consultar saldo

---

## 🏗️ Regras de Negócio

### Conta

```java
class Wallet {
    UUID id;
    String owner;
    BigDecimal balance;
}
```

---

### Regras

- Não permitir saldo negativo
- Transferências devem ser atômicas
- Registrar histórico de transações
- Cada operação deve possuir timestamp

---

## 📌 Requisitos Técnicos

- Java 21
- Spring Boot
- JUnit 5
- Mockito
- Exception Handler global
- API REST

---

## 📂 Endpoints Esperados

### Criar carteira

```http
POST /wallets
```

### Depositar

```http
POST /wallets/{id}/deposit
```

### Transferir

```http
POST /wallets/transfer
```

---

## ⭐ Diferenciais

- Hexagonal Architecture
- DTO Pattern
- OpenAPI/Swagger
- Validações com Bean Validation

---

# 🟠 FASE 3 — Concorrência e Performance

## 🎯 Objetivo

Avaliar:

- Concorrência
- Thread safety
- Performance
- Processamento assíncrono
- Conhecimento JVM

---

## 📋 Problema

O sistema agora recebe:

- 50 mil transferências simultâneas
- Operações concorrentes na mesma conta

Você deve garantir:

- Consistência de saldo
- Alta performance
- Segurança transacional

---

# 📌 Requisitos Técnicos

## Implementar:

- `ExecutorService`
- `CompletableFuture`
- Locks
- Processamento assíncrono

---

## 📌 Regras

- Nenhuma transação pode ser perdida
- Nenhuma conta pode ficar inconsistente
- O sistema deve suportar múltiplas threads

---

## 🧠 O que será avaliado

### Concorrência

```java
ReentrantLock
StampedLock
synchronized
```

### Performance

- Garbage Collection
- Pool de conexões
- Uso eficiente de memória

---

## ⭐ Diferenciais

- Virtual Threads (Java 21)
- Benchmark com JMH
- Cache com Caffeine

---

# 🔴 FASE 4 — Arquitetura Distribuída (Senior/Staff)

## 🎯 Objetivo

Avaliar capacidade de:

- Arquitetura de sistemas
- Escalabilidade
- Observabilidade
- Engenharia de produção
- Resiliência

---

# 📋 Problema

Transforme a aplicação em uma plataforma distribuída de pagamentos.

---

# 📌 Novos Requisitos

## Serviços

### Wallet Service

- Gestão de saldo

### Transaction Service

- Processamento financeiro

### Notification Service

- Envio de eventos

### Fraud Detection Service

- Análise de risco

---

# 📌 Requisitos Arquiteturais

## Mensageria

Utilizar:

- Kafka ou RabbitMQ

---

## Banco de Dados

Escolha entre:

- PostgreSQL
- MongoDB
- Redis

---

## Observabilidade

Implementar:

- Logs estruturados
- Métricas
- Tracing distribuído

---

# 📌 Requisitos de Engenharia

## Docker

```bash
docker-compose up
```

---

## Kubernetes (Opcional)

Criar:

- Deployment
- Service
- ConfigMap

---

# 📌 Requisitos de Segurança

- JWT
- OAuth2
- Rate limiting

---

# 📌 Requisitos de Resiliência

- Retry
- Circuit Breaker
- Timeout
- Dead Letter Queue

---

# ⭐ Diferenciais Senior/Staff

- Event Driven Architecture
- CQRS
- SAGA Pattern
- Outbox Pattern
- Idempotência
- Multi-threading avançado
- Estratégia de escalabilidade

---

# 🧪 Critérios de Avaliação

| Critério | Peso |
|---|---|
| Código limpo | 20% |
| Arquitetura | 20% |
| Performance | 20% |
| Testes | 15% |
| Concorrência | 15% |
| Escalabilidade | 10% |

---

# 📌 O que normalmente reprova candidatos

- Código sem testes
- Falta de tratamento de erro
- Violação de SOLID
- Falta de preocupação com concorrência
- Complexidade desnecessária
- Acoplamento excessivo
- Não pensar em produção

---

# 🏆 O que diferencia um Senior forte

- Código simples e escalável
- Excelente modelagem
- Clareza arquitetural
- Observabilidade
- Resiliência
- Capacidade de justificar decisões técnicas
- Preocupação com performance real

---

# 🚀 Como executar o projeto

## Build

```bash
mvn clean install
```

---

## Rodar aplicação

```bash
mvn spring-boot:run
```

---

## Rodar testes

```bash
mvn test
```

---

# 📚 Tecnologias Recomendadas

| Tecnologia | Uso |
|---|---|
| Java 21 | Linguagem principal |
| Spring Boot | Backend |
| PostgreSQL | Persistência |
| Kafka | Mensageria |
| Redis | Cache |
| Docker | Containers |
| Kubernetes | Orquestração |
| Prometheus | Métricas |
| Grafana | Observabilidade |

---

# 🎯 Objetivo Final

Ao concluir todas as fases, o candidato terá demonstrado:

- Capacidade de atuar como Senior Software Engineer
- Conhecimento profundo de backend Java
- Capacidade de construir sistemas financeiros escaláveis
- Conhecimento próximo do cenário real de fintechs modernas

---

# 👨‍💻 Boa sorte!

Este desafio simula problemas reais encontrados em ambientes de engenharia de alta escala como fintechs, bancos digitais e plataformas distribuídas modernas.