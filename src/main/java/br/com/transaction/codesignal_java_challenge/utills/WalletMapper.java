package br.com.transaction.codesignal_java_challenge.utills;

import br.com.transaction.codesignal_java_challenge.adapters.outbound.entities.WalletEntity;
import br.com.transaction.codesignal_java_challenge.domain.wallet.Wallet;
import br.com.transaction.codesignal_java_challenge.domain.wallet.WalletDTO;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {

    public Wallet toDomain(WalletEntity entity) {
        return new Wallet(
                entity.getId(),
                entity.getOwner(),
                entity.getBalance()
        );
    }

     public WalletEntity toEntity(Wallet domain) {
        WalletEntity entity = new WalletEntity();
        entity.setId(domain.getId());
        entity.setOwner(domain.getOwner());
        entity.setBalance(domain.getBalance());
        return entity;
    }

    public WalletDTO toDTO(Wallet domain) {
        return new WalletDTO(
                domain.getId(),
                domain.getOwner(),
                domain.getBalance()
        );
    }

    public Wallet fromDTO(WalletDTO dto) {
        return new Wallet(
                dto.id(),
                dto.owner(),
                dto.balance()
        );
    }






}
