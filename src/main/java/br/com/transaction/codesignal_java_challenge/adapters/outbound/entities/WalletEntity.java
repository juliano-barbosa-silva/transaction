package br.com.transaction.codesignal_java_challenge.adapters.outbound.entities;

import br.com.transaction.codesignal_java_challenge.domain.wallet.Wallet;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "wallet")
public class WalletEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column (name = "owner", nullable = false)
    private String owner;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;


    public WalletEntity(Wallet wallet){
        this.id = wallet.getId();
        this.owner = wallet.getOwner();
        this.balance = wallet.getBalance();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
