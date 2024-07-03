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
    private Long branch;
    private int bankNumber;
    private Long number;

    public static AccountOutputDTO fromAccount(Account account) {
        return builder()
                .id(account.getPublicId())
                .bankNumber(account.getBankNumber())
                .branch(account.getBranch())
                .number(account.getNumber())
                .build();
    }
}
