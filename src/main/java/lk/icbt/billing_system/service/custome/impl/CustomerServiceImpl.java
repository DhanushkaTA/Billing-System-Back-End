package lk.icbt.billing_system.service.custome.impl;

import lk.icbt.billing_system.dao.DaoFactory;
import lk.icbt.billing_system.dao.DaoTypes;
import lk.icbt.billing_system.dao.custome.CustomerDAO;
import lk.icbt.billing_system.dao.util.DBUtil;
import lk.icbt.billing_system.dto.CustomerDTO;
import lk.icbt.billing_system.entity.Customer;
import lk.icbt.billing_system.service.custome.CustomerService;
import lk.icbt.billing_system.service.exception.NotFoundException;
import lk.icbt.billing_system.service.util.Convertor;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {

    private final BasicDataSource bds;

    private final CustomerDAO customerDAO = (CustomerDAO) DaoFactory.getDaoFactory().getDAO(DaoTypes.CUSTOMER);

    public CustomerServiceImpl(BasicDataSource bds){
        this.bds=bds;
    }

    @Override
    public boolean addNewCustomer(CustomerDTO customerDTO) throws SQLException {

        try (Connection connection = this.bds.getConnection();){
            //get next acc id
            String nextCustomerId = customerDAO.getNextCustomerId(connection);
            customerDTO.setAccountNumber(nextCustomerId);
            return customerDAO.add(Convertor.toCustomer(customerDTO),connection);
        }

    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) throws SQLException {

        try (Connection connection = this.bds.getConnection();){
            Customer updatedCustomer =
                    customerDAO.update(Convertor.toCustomer(customerDTO), connection);
            if (updatedCustomer!=null){
                return Convertor.toCustomerDTO(updatedCustomer);
            }else {
                return null;
            }
        }

    }

    @Override
    public void deleteCustomer(String id) throws SQLException,NotFoundException {

        try (Connection connection = this.bds.getConnection()){
            // find customer first
            Customer customer = customerDAO.getByPk(id, connection);
            if (customer == null){
                throw new NotFoundException("Customer new found!");
            }

            // delete customer
            customerDAO.delete(id, connection);
        }

    }

    @Override
    public List<CustomerDTO> getAll() throws SQLException {
        try (Connection connection = this.bds.getConnection()){
            // delete customer
            return customerDAO.getAll(connection).stream().map(Convertor::toCustomerDTO).collect(Collectors.toList());
        }
    }

    @Override
    public CustomerDTO getCustomerByAccNum(String accNum) throws SQLException,NotFoundException {
        try (Connection connection = this.bds.getConnection()){
            Customer customer = customerDAO.getByPk(accNum, connection);

            if (customer == null){
                throw new NotFoundException("Customer not found!");
            }
            return new CustomerDTO(
                    customer.getAccountNumber(),
                    customer.getFullName(),
                    customer.getAddress(),
                    customer.getPhoneNumber(),
                    customer.getUniteConsumed());
        }
    }
}
