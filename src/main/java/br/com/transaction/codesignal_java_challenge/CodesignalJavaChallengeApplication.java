package br.com.transaction.codesignal_java_challenge;

import br.com.transaction.codesignal_java_challenge.domain.transaction.Transaction;
import br.com.transaction.codesignal_java_challenge.domain.transaction.TransactionStatisticsDTO;
import br.com.transaction.codesignal_java_challenge.aplication.usecase.TransactionStatisticsUseCase;
import br.com.transaction.codesignal_java_challenge.aplication.service.impl.TransactionStatisticsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class CodesignalJavaChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodesignalJavaChallengeApplication.class, args);

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

        TransactionStatisticsUseCase statisticsService =
                new TransactionStatisticsService();

        Optional<TransactionStatisticsDTO> result =
                statisticsService.operations(transactions);

        result.ifPresent(statistics -> {

            System.out.println("Soma total: " + statistics.total());
            System.out.println("Média: " + statistics.average());
            System.out.println("Maior transação: " + statistics.max());
            System.out.println("Menor transação: " + statistics.min());
            System.out.println("Duplicadas: " + statistics.duplicatedTransactions());

        });
    }

}
