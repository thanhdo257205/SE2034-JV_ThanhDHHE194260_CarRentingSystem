package se2034jv_thanhdhhe194260_carrentingsystem.mapper;

import se2034jv_thanhdhhe194260_carrentingsystem.dto.RegisterDTO;
import se2034jv_thanhdhhe194260_carrentingsystem.entities.Customer;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class RegisterMapper {

    public static RegisterDTO toRegisterDTO(Customer customer) {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setCustomerName(customer.getCustomerName());
        registerDTO.setBirthday(customer.getBirthday().toLocalDate());
        registerDTO.setEmail(customer.getEmail());
        registerDTO.setMobile(customer.getMobile());
        registerDTO.setIdentityCard(customer.getIdentityCard());
        registerDTO.setLicenceDate(customer.getLicenceDate().toLocalDate());
        registerDTO.setLicenceNumber(customer.getLicenceNumber());
        registerDTO.setPassword(customer.getPassword());
        return registerDTO;
    }

    public static Customer toCustomer(RegisterDTO registerDTO) {
        Customer customer = new Customer();
        customer.setBirthday(LocalDateTime.of(registerDTO.getBirthday(), LocalTime.now()));
        customer.setEmail(registerDTO.getEmail());
        customer.setMobile(registerDTO.getMobile());
        customer.setIdentityCard(registerDTO.getIdentityCard());
        customer.setLicenceDate(LocalDateTime.of(registerDTO.getLicenceDate(), LocalTime.now()));
        customer.setLicenceNumber(registerDTO.getLicenceNumber());
        customer.setPassword(registerDTO.getPassword());
        customer.setCustomerName(registerDTO.getCustomerName());
        return customer;
    }
}
