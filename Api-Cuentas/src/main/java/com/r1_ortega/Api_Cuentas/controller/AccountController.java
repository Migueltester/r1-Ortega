package com.r1_ortega.Api_Cuentas.controller;

import com.r1_ortega.Api_Cuentas.model.Account;
import com.r1_ortega.Api_Cuentas.service.AccountService;
import com.r1_ortega.Api_Cuentas.dto.UpdateAccountRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")

public class AccountController {
    @Autowired
    private AccountService accountService;

    // get para obtener todas las cuentas
    // GET http://localhost:8080/api/v1/accounts
    @GetMapping
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    // Get para obtener una cuenta por su id
    // GET http://localhost:8080/api/v1/accounts/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountsById(@PathVariable Long id) {
        return accountService.getAccountsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Post para crear una cuenta
    // POST http://localhost:8080/api/v1/accounts

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    // Put para actualizar saldo o nombre de la cuenta
    // PUT http://localhost:8080/api/v1/accounts/{id}
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAccount(
            @PathVariable Long id,
            @RequestBody UpdateAccountRequest request) {
        try {
            Account updatedAccount = accountService.updateAccount(id, request);
            return ResponseEntity.ok(updatedAccount);
        } catch (RuntimeException e) {
            if (e instanceof IllegalArgumentException) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
            return ResponseEntity.notFound().build();
        }
    }

    // Delete para desactivar una cuenta
    // DELETE http://localhost:8080/api/v1/accounts/{id}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivateAccount(@PathVariable Long id) {
        accountService.deactivateAccount(id);
        return ResponseEntity.noContent().build();
    }

}
