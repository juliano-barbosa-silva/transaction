package br.com.transaction.codesignal_java_challenge.dto;

import java.math.BigDecimal;

public record TransactionStatisticsDTO(
        BigDecimal total,
        BigDecimal average,
        BigDecimal max,
        BigDecimal min,
        long duplicatedTransactions
) {
}
