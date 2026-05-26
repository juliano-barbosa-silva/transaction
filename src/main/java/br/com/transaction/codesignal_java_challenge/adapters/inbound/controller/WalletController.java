package br.com.transaction.codesignal_java_challenge.adapters.inbound.controller;

import br.com.transaction.codesignal_java_challenge.aplication.usecase.WalletUseCase;
import br.com.transaction.codesignal_java_challenge.domain.wallet.Wallet;
import br.com.transaction.codesignal_java_challenge.domain.wallet.WalletDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    private final WalletUseCase walletUseCase;

    public WalletController(WalletUseCase walletUseCase) {
        this.walletUseCase = walletUseCase;
    }

    public Wallet createWallet(@RequestBody WalletDTO walletDTO,
                               UriComponentsBuilder builder){
       return walletUseCase.createWallet(walletDTO);
    }



}
