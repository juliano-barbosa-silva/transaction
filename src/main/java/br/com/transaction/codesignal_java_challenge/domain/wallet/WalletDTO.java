package br.com.transaction.codesignal_java_challenge.domain.wallet;

import java.math.BigDecimal;
import java.util.UUID;

public record WalletDTO(UUID id, String owner, BigDecimal balance) {
}
