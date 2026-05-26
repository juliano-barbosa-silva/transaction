package br.com.transaction.codesignal_java_challenge.domain.wallet;

import br.com.transaction.codesignal_java_challenge.adapters.outbound.entities.WalletEntity;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Wallet {

    private UUID id;
    private String owner;
    private BigDecimal balance;

    public Wallet(UUID id, String owner, BigDecimal balance){
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }

    public Wallet(WalletEntity walletEntity){
        this.id = walletEntity.getId();
        this.owner = walletEntity.getOwner();
        this.balance = walletEntity.getBalance();
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
        if(balance.compareTo(BigDecimal.ZERO) >= 0) this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(id, wallet.id) && Objects.equals(owner, wallet.owner) && Objects.equals(balance, wallet.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, owner, balance);
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                '}';
    }
}
