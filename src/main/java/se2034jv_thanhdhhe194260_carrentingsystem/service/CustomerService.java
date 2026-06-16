package se2034jv_thanhdhhe194260_carrentingsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se2034jv_thanhdhhe194260_carrentingsystem.dto.CustomerDTO;
import se2034jv_thanhdhhe194260_carrentingsystem.entities.Customer;
import se2034jv_thanhdhhe194260_carrentingsystem.mapper.CustomerMapper;
import se2034jv_thanhdhhe194260_carrentingsystem.repository.CustomerRepo;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo customerRepo;

    public Customer findByEmail(String email) {
        return customerRepo.findByEmail(email);
    }

    public void saveCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public CustomerDTO findByUserNameAndPassword(String username, String password) {
        Customer customer = customerRepo.findByEmailAndPassword(username, password);
        if (customer == null) {
            throw new RuntimeException("Invalid UserName or Password");
        }
        CustomerDTO customerDTO = CustomerMapper.toCustomerDTO(customer);
        return customerDTO;
    }
}
