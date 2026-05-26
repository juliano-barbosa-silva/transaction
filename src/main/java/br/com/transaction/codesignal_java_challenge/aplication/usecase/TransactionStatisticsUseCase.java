package br.com.transaction.codesignal_java_challenge.aplication.usecase;

import br.com.transaction.codesignal_java_challenge.domain.transaction.Transaction;
import br.com.transaction.codesignal_java_challenge.domain.transaction.TransactionStatisticsDTO;
import java.util.List;
import java.util.Optional;

public interface TransactionStatisticsUseCase {

    Optional<TransactionStatisticsDTO> operations(List<Transaction> transactionList);

}
