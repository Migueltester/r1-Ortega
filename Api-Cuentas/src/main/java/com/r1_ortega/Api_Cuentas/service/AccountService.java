package com.r1_ortega.Api_Cuentas.service;

import com.r1_ortega.Api_Cuentas.model.Account;
import com.r1_ortega.Api_Cuentas.repository.AccountRepository;
import com.r1_ortega.Api_Cuentas.dto.UpdateAccountRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service

public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Metodo para obtener todas las cuentas y sus datos
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    // Metodo para obtener una cuenta por su id
    public Optional<Account> getAccountsById(Long id) {
        return accountRepository.findById(id);
    }

    // Metodo para crear una cuenta
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    // Metodo para actualizar saldo o nombre de la cuenta
    @Transactional
    public Account updateAccount(Long id, UpdateAccountRequest request) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        // actualizar el nombre si es diferente de null

        if (request.getNombreCliente() != null) {
            account.setNombreCliente(request.getNombreCliente());
        }

        // Actualizar el saldo si es diferente de 0

        if (request.getSaldo() != null) {
            account.setSaldo(request.getSaldo());

        }

        // Verificar si el saldo o el nombre de la cuenta se actualizo
        if (request.getSaldo() != null && request.getNombreCliente() != null) {
            throw new RuntimeException("No se actualizo el saldo o el nombre de la cuenta");

        }
        return accountRepository.save(account);
    }

    // Metodo para descativar la cuenta
    @Transactional
    public void deactivateAccount(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        account.setEstado(false);
        accountRepository.save(account);
    }

}
