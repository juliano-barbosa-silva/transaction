package br.com.transaction.codesignal_java_challenge.adapters.outbound.repositories.impl;

import br.com.transaction.codesignal_java_challenge.adapters.outbound.entities.WalletEntity;
import br.com.transaction.codesignal_java_challenge.adapters.outbound.repositories.JpaWalletRepository;
import br.com.transaction.codesignal_java_challenge.domain.wallet.Wallet;
import br.com.transaction.codesignal_java_challenge.domain.wallet.WalletRepository;
import br.com.transaction.codesignal_java_challenge.utills.WalletMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JpaWalletRepositoryImpl implements WalletRepository {

    private final JpaWalletRepository jpaWalletRepository;
    private final WalletMapper walletMapper;

    public JpaWalletRepositoryImpl(JpaWalletRepository jpaWalletRepository, WalletMapper walletMapper) {
        this.jpaWalletRepository = jpaWalletRepository;
        this.walletMapper = walletMapper;
    }


    @Override
    public Wallet save(Wallet wallet) {
        this.jpaWalletRepository.save(walletMapper.toEntity(wallet));
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
