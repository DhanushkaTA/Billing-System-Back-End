package lk.icbt.billing_system.service.custome;

import lk.icbt.billing_system.dto.CustomerDTO;
import lk.icbt.billing_system.service.SuperService;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService extends SuperService {
    boolean addNewCustomer(CustomerDTO customerDTO) throws SQLException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO) throws SQLException;

    void deleteCustomer(String id) throws SQLException;

    List<CustomerDTO> getAll() throws SQLException;
}
