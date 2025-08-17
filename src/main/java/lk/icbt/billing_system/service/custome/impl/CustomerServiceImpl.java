package lk.icbt.billing_system.service.custome.impl;

import lk.icbt.billing_system.dto.CustomerDTO;
import lk.icbt.billing_system.service.custome.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDTO addNewCustomer(CustomerDTO customerDTO) {

        System.out.println("Print in service");

        System.out.println(customerDTO.toString());



        return null;
    }
}
