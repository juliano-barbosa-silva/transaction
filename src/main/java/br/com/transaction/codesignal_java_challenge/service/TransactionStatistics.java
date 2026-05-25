package br.com.transaction.codesignal_java_challenge.service;

import br.com.transaction.codesignal_java_challenge.domain.model.Transaction;
import br.com.transaction.codesignal_java_challenge.dto.TransactionStatisticsDTO;
import java.util.List;
import java.util.Optional;

public interface TransactionStatistics {

    Optional<TransactionStatisticsDTO> operations(List<Transaction> transactionList);

}
