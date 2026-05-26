package br.com.transaction.codesignal_java_challenge.domain.wallet;

import java.util.List;
import java.util.UUID;

public interface WalletRepository {

    Wallet save(Wallet wallet);

    Wallet findById (UUID id);

    List<Wallet> findAll();
}
