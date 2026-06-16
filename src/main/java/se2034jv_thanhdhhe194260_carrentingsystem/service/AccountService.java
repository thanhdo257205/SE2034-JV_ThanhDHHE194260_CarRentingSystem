package se2034jv_thanhdhhe194260_carrentingsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se2034jv_thanhdhhe194260_carrentingsystem.entities.Account;
import se2034jv_thanhdhhe194260_carrentingsystem.repository.AccountRepo;
import se2034jv_thanhdhhe194260_carrentingsystem.repository.CustomerRepo;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepo accountRepo;

    public Account findByAccountName(String accountName) {
        return accountRepo.findByAccountName(accountName);
    }

    public void saveAccount(Account account) {
        accountRepo.save(account);
    }
}
