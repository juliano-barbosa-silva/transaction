package br.com.transaction.codesignal_java_challenge.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

    private UUID id;

    private String accountId;

    private BigDecimal amount;

    private TransactionType type;

    private LocalDateTime createdAt;

    private String description;

    private String correlationId;

    private TransactionStatus status;

    public Transaction(UUID id, String accountId, BigDecimal amount, TransactionType type, LocalDateTime createdAt,
                       String description, String correlationId, TransactionStatus status) {
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        this.type = type;
        this.createdAt = createdAt;
        this.description = description;
        this.correlationId = correlationId;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public enum TransactionType {
        DEPOSIT,
        WITHDRAW,
        TRANSFER,
        PAYMENT
    }

    public enum TransactionStatus {
        PENDING,
        PROCESSING,
        COMPLETED,
        FAILED,
        CANCELLED
    }


}
