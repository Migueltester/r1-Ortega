package com.r1_ortega.Api_Cuentas.repository;

import com.r1_ortega.Api_Cuentas.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AccountRepository extends JpaRepository<Account, Long> {
}
