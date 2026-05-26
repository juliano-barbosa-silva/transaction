package br.com.transaction.codesignal_java_challenge.adapters.outbound.repositories.impl;

import br.com.transaction.codesignal_java_challenge.adapters.outbound.entities.WalletEntity;
import br.com.transaction.codesignal_java_challenge.adapters.outbound.repositories.JpaWalletRepository;
import br.com.transaction.codesignal_java_challenge.domain.wallet.Wallet;
import br.com.transaction.codesignal_java_challenge.domain.wallet.WalletRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class WalletRepositoryImpl implements WalletRepository {

    private final JpaWalletRepository jpaWalletRepository;

    public WalletRepositoryImpl(JpaWalletRepository jpaWalletRepository) {
        this.jpaWalletRepository = jpaWalletRepository;
    }


    @Override
    public Wallet save(Wallet wallet) {
        WalletEntity walletEntity = new WalletEntity(wallet);
        this.jpaWalletRepository.save(walletEntity);
        return wallet;
    }

    @Override
    public Wallet findById(UUID id) {
        Optional<WalletEntity> walletEntityOptional = this.jpaWalletRepository.findById(id);
        return walletEntityOptional.map(walletEntity -> new Wallet(walletEntity.getId(), walletEntity.getOwner(), walletEntity.getBalance())).orElse(null);
    }

    @Override
    public List<Wallet> findAll() {
        return this.jpaWalletRepository.findAll()
                .stream()
                .map(walletEntity -> new Wallet(walletEntity.getId(), walletEntity.getOwner(), walletEntity.getBalance()))
                .collect(Collectors.toList());
    }
}
