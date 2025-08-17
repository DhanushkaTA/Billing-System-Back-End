package lk.icbt.billing_system.service;

import lk.icbt.billing_system.dto.CustomerDTO;

public interface CustomerService extends SuperService {
    CustomerDTO addNewCustomer(CustomerDTO customerDTO);
}
