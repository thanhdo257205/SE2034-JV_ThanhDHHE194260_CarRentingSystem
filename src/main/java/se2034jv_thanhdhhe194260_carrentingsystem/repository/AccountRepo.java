package se2034jv_thanhdhhe194260_carrentingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se2034jv_thanhdhhe194260_carrentingsystem.entities.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {
    Account findByAccountName(String accountName);
}
