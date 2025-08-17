package lk.icbt.billing_system.service.util;

import lk.icbt.billing_system.dto.CustomerDTO;
import lk.icbt.billing_system.entity.Customer;

public class Mapper {

    public static Customer toCustomer (CustomerDTO dto){
        return new Customer(
                dto.getAccountNumber(),
                dto.getFullName(),
                dto.getAddress(),
                dto.getPhoneNumber(),
                dto.getUniteConsumed()
        );
    }

    public static CustomerDTO toCustomerDTO(Customer customer){
        return new CustomerDTO(
                customer.getAccountNumber(),
                customer.getFullName(),
                customer.getAddress(),
                customer.getPhoneNumber(),
                customer.getUniteConsumed()
        );
    }

}
