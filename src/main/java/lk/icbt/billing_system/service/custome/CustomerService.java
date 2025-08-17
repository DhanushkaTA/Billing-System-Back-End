package lk.icbt.billing_system.service.custome;

import lk.icbt.billing_system.dto.CustomerDTO;
import lk.icbt.billing_system.service.SuperService;

import java.sql.SQLException;

public interface CustomerService extends SuperService {
    boolean addNewCustomer(CustomerDTO customerDTO) throws SQLException;
}
