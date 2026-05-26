package br.com.transaction.codesignal_java_challenge.adapters.outbound.repositories;

import br.com.transaction.codesignal_java_challenge.adapters.outbound.entities.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaWalletRepository extends JpaRepository<WalletEntity, UUID> {
}
