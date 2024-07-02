package com.account_service.controllers;

import com.account_service.dtos.CreateAccountInputDTO;
import com.account_service.dtos.AccountOutputDTO;
import com.account_service.use_cases.CreateAccount;
import com.account_service.use_cases.ListAccounts;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Accounts")
@RestController
@RequestMapping("api/v1/accounts")
@RequiredArgsConstructor
@ControllerAdvice
@CrossOrigin(origins = "*", maxAge = 2900)
public class AccountsController {
    private final CreateAccount createAccount;
    private final ListAccounts listAccounts;

    @PostMapping()
    public ResponseEntity<AccountOutputDTO> create(@RequestBody @Valid CreateAccountInputDTO payload) {
        var output = createAccount.execute(payload);
        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }

    @GetMapping()
    public ResponseEntity<List<AccountOutputDTO>> list() {
        var accounts = listAccounts.execute();
        return ResponseEntity.status(HttpStatus.OK).body(accounts);
    }
}
