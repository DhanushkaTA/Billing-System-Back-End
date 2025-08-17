package lk.icbt.billing_system.service.custome.impl;

import lk.icbt.billing_system.dao.DaoFactory;
import lk.icbt.billing_system.dao.DaoTypes;
import lk.icbt.billing_system.dao.custome.CustomerDAO;
import lk.icbt.billing_system.dto.CustomerDTO;
import lk.icbt.billing_system.entity.Customer;
import lk.icbt.billing_system.service.custome.CustomerService;
import lk.icbt.billing_system.service.util.Mapper;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService {

    private final BasicDataSource bds;

    private final CustomerDAO customerDAO = (CustomerDAO) DaoFactory.getDaoFactory().getDAO(DaoTypes.CUSTOMER);

    public CustomerServiceImpl(BasicDataSource bds){
        this.bds=bds;
    }

    @Override
    public boolean addNewCustomer(CustomerDTO customerDTO) throws SQLException {

        try (Connection connection = this.bds.getConnection();){
            return customerDAO.add(Mapper.toCustomer(customerDTO),connection);
        }

    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) throws SQLException {

        try (Connection connection = this.bds.getConnection();){
            Customer updatedCustomer =
                    customerDAO.update(Mapper.toCustomer(customerDTO), connection);
            if (updatedCustomer!=null){
                return Mapper.toCustomerDTO(updatedCustomer);
            }else {
                return null;
            }
        }

    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {

        try (Connection connection = this.bds.getConnection()){
            // find customer first

            // delete customer
            customerDAO.delete(id, connection);
        }
        return true;
    }
}
