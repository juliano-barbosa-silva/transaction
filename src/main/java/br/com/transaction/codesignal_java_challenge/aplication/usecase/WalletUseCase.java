package br.com.transaction.codesignal_java_challenge.aplication.usecase;

import br.com.transaction.codesignal_java_challenge.domain.wallet.Wallet;
import br.com.transaction.codesignal_java_challenge.domain.wallet.WalletDTO;

import java.util.List;
import java.util.UUID;

public interface WalletUseCase {

    public Wallet createWallet(WalletDTO walletDTO);

    public WalletDTO findByIdWallet (UUID id);

    public List<WalletDTO> findAllWallet();
}
