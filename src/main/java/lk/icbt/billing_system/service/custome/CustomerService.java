package lk.icbt.billing_system.service.custome;

import lk.icbt.billing_system.dto.CustomerDTO;
import lk.icbt.billing_system.service.SuperService;

public interface CustomerService extends SuperService {
    CustomerDTO addNewCustomer(CustomerDTO customerDTO);
}
