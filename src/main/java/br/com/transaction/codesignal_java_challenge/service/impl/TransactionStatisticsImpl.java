package br.com.transaction.codesignal_java_challenge.service.impl;

import br.com.transaction.codesignal_java_challenge.domain.model.Transaction;
import br.com.transaction.codesignal_java_challenge.dto.TransactionStatisticsDTO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class TransactionStatisticsImpl implements TransactionStatistics {

    @Override
    public Optional<TransactionStatisticsDTO> operations(List<Transaction> transactionList) {

        if (transactionList.isEmpty()) {
            return Optional.empty();
        }

        // Soma total
        BigDecimal somaTotal = transactionList.stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Média
        BigDecimal media = somaTotal.divide(
                BigDecimal.valueOf(transactionList.size()),
                2,
                RoundingMode.HALF_UP
        );

        // Maior transação
        BigDecimal maximo = transactionList.stream()
                .map(Transaction::getAmount)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        // Menor transação
        BigDecimal minimo = transactionList.stream()
                .map(Transaction::getAmount)
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        // Quantidade de valores duplicados
        long duplicatedAmounts = transactionList.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getAmount,
                        Collectors.counting()
                ))
                .values()
                .stream()
                .filter(count -> count > 1)
                .count();

        TransactionStatisticsDTO dto = new TransactionStatisticsDTO(
                somaTotal,
                media,
                maximo,
                minimo,
                duplicatedAmounts
        );

        return Optional.of(dto);
    }
}
