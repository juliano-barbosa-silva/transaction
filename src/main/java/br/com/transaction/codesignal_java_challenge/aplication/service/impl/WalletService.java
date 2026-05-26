package br.com.transaction.codesignal_java_challenge.aplication.service.impl;

import br.com.transaction.codesignal_java_challenge.aplication.usecase.WalletUseCase;
import br.com.transaction.codesignal_java_challenge.domain.wallet.Wallet;
import br.com.transaction.codesignal_java_challenge.domain.wallet.WalletDTO;
import br.com.transaction.codesignal_java_challenge.domain.wallet.WalletRepository;
import br.com.transaction.codesignal_java_challenge.utills.WalletMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class WalletService implements WalletUseCase{

    private final WalletRepository walletRepository;
    private final WalletMapper walletMapper;

    public WalletService(WalletRepository walletRepository, WalletMapper walletMapper) {
        this.walletRepository = walletRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    public Wallet createWallet(WalletDTO walletDTO) {
        return this.walletRepository.save(walletMapper.fromDTO(walletDTO));
    }

    @Override
    public WalletDTO findByIdWallet(UUID id) {
        return walletMapper.toDTO(this.walletRepository.findById(id));
    }

    @Override
    public List<WalletDTO> findAllWallet() {
        return this.walletRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private WalletDTO toDTO(Wallet wallet) {
        return new WalletDTO(
                wallet.getId(),
                wallet.getOwner(),
                wallet.getBalance()
        );
    }
}
