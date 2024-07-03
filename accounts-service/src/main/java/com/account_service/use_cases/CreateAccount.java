package com.account_service.use_cases;

import com.account_service.dtos.CreateAccountInputDTO;
import com.account_service.dtos.AccountOutputDTO;
import com.account_service.entities.Account;
import com.account_service.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateAccount {
    private final AccountRepository accountRepository;

    public AccountOutputDTO execute(CreateAccountInputDTO payload) {
        var publicId = UUID.randomUUID();

        var account = new Account();
        account.setPublicId(publicId);
        account.setBranch(payload.getBranch());

        accountRepository.save(account);

        var accountNumber = accountRepository.countAccountsByBranchAndIdLessThan(account.getBranch(), account.getId());
        account.setNumber(++accountNumber);

        accountRepository.save(account);

        return AccountOutputDTO.fromAccount(account);
    }
}
