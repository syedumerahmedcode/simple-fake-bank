package com.umer.simplefakebank.repsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.umer.simplefakebank.entities.Account;

@Repository
public interface AccountReposoitory extends JpaRepository<Account, Long> {

}
