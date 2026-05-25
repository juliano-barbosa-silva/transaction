package br.com.transaction.codesignal_java_challenge.service;

import br.com.transaction.codesignal_java_challenge.domain.model.Transaction;
import br.com.transaction.codesignal_java_challenge.dto.TransactionStatisticsDTO;
import br.com.transaction.codesignal_java_challenge.service.impl.TransactionStatisticsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TransactionStatisticsTest {

    private TransactionStatistics transactionStatistics;

    @BeforeEach
    void setUp(){
        transactionStatistics = new TransactionStatisticsImpl();
    }

    @Test
    @DisplayName("Teste execucao completa")
    void validateTransaction(){
        List<Transaction> transactions = List.of(

                new Transaction(
                        UUID.randomUUID(),
                        "ACC-001",
                        new BigDecimal("100.00"),
                        Transaction.TransactionType.DEPOSIT,
                        LocalDateTime.now(),
                        "Depósito",
                        "CORR-001",
                        Transaction.TransactionStatus.COMPLETED
                ),

                new Transaction(
                        UUID.randomUUID(),
                        "ACC-002",
                        new BigDecimal("250.00"),
                        Transaction.TransactionType.PAYMENT,
                        LocalDateTime.now(),
                        "Pagamento",
                        "CORR-002",
                        Transaction.TransactionStatus.COMPLETED
                ),

                new Transaction(
                        UUID.randomUUID(),
                        "ACC-003",
                        new BigDecimal("100.00"),
                        Transaction.TransactionType.TRANSFER,
                        LocalDateTime.now(),
                        "PIX",
                        "CORR-003",
                        Transaction.TransactionStatus.COMPLETED
                )
        );

        Optional<TransactionStatisticsDTO> result =
                transactionStatistics.operations(transactions);
        var dto = result.get();

        assertTrue(result.isPresent());
//        Soma total: 450.00
        assertEquals(new BigDecimal("450.00"), dto.total());
//        Média: 150.00
        assertEquals(new BigDecimal("150.00"), dto.average());
//        Maior transação: 250.00
        assertEquals(new BigDecimal("250.00"), dto.max());
//        Menor transação: 100.00
        assertEquals(new BigDecimal("100.00"), dto.min());

    }
    @Test
    @DisplayName("teste com lista vazia")
    void transactionEmpty(){

        List<Transaction> transactionList = new ArrayList<>();

        Optional<TransactionStatisticsDTO> result =
                transactionStatistics.operations(transactionList);

        assertTrue(result.isEmpty());

    }


}
