package com.account_service.use_cases;

import com.account_service.dtos.AccountOutputDTO;
import com.account_service.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListAccounts {
    private final AccountRepository accountRepository;

    public List<AccountOutputDTO> execute() {
        var accounts = accountRepository.findAll();
        return accounts.stream().map(AccountOutputDTO::fromAccount).toList();
    }
}
