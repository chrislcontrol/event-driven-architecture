package com.account_service.dtos;

import com.account_service.entities.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class AccountOutputDTO {
    private UUID id;
    private Account.Status status;
    private Long branch;
    private int bankNumber;

    public static AccountOutputDTO fromAccount(Account account) {
        return builder()
                .id(account.getPublicId())
                .status(account.getStatus())
                .bankNumber(account.getBankNumber())
                .branch(account.getBranch())
                .build();
    }
}
