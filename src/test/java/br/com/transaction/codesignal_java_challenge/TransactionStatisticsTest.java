package br.com.transaction.codesignal_java_challenge;

import br.com.transaction.codesignal_java_challenge.domain.model.Transaction;
import br.com.transaction.codesignal_java_challenge.dto.TransactionStatisticsDTO;
import br.com.transaction.codesignal_java_challenge.service.impl.TransactionStatistics;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

class TransactionStatisticsTest {

    @InjectMocks
    private TransactionStatistics transactionStatistics;

    @Test
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

    }


}
