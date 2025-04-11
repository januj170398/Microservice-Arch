package com.anuj.accounts.repository;

import com.anuj.accounts.entity.Accounts;
import com.anuj.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

}
