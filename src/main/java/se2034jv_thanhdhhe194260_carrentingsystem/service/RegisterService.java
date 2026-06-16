package se2034jv_thanhdhhe194260_carrentingsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se2034jv_thanhdhhe194260_carrentingsystem.dto.RegisterDTO;
import se2034jv_thanhdhhe194260_carrentingsystem.entities.Account;
import se2034jv_thanhdhhe194260_carrentingsystem.entities.Customer;
import se2034jv_thanhdhhe194260_carrentingsystem.entities.Role;
import se2034jv_thanhdhhe194260_carrentingsystem.mapper.RegisterMapper;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final CustomerService customerService;
    private final AccountService accountService;

    public void registerAccount(RegisterDTO registerDTO) {
        String password = registerDTO.getPassword();
        String confirmPassword = registerDTO.getConfirmPassword();
        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("password and confirm password are not equal");
        }

        String email = registerDTO.getEmail();
        if (customerService.findByEmail(email) != null) {
            throw new IllegalArgumentException("email already exists");
        }

        String accountName = registerDTO.getAccountName();
        if (accountService.findByAccountName(accountName) != null) {
            throw new IllegalArgumentException("account already exists");
        }

        Account account = new Account();
        account.setAccountName(accountName);
        account.setRole(Role.CUSTOMER);
        accountService.saveAccount(account);
        Customer customer = RegisterMapper.toCustomer(registerDTO);
        customer.setAccount(account);
        customerService.saveCustomer(customer);

    }
}
