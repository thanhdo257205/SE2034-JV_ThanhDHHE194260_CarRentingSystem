package se2034jv_thanhdhhe194260_carrentingsystem.mapper;


import se2034jv_thanhdhhe194260_carrentingsystem.dto.CustomerDTO;
import se2034jv_thanhdhhe194260_carrentingsystem.entities.Customer;

public class CustomerMapper {

    public static CustomerDTO toCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setRole(customer.getAccount().getRole());
        customerDTO.setId(customer.getCustomerId());
        customerDTO.setUsername(customer.getAccount().getAccountName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setMobile(customer.getMobile());
        customerDTO.setCustomerName(customer.getCustomerName());
        customerDTO.setLicenceNumber(customer.getLicenceNumber());
        customerDTO.setLicenceDate(customer.getLicenceDate());
        customerDTO.setIdentityCard(customer.getIdentityCard());
        customerDTO.setBirthday(customer.getBirthday());
        return customerDTO;
    }
}
