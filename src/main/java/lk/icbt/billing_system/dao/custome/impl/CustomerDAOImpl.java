package lk.icbt.billing_system.dao.custome.impl;

import lk.icbt.billing_system.dao.custome.CustomerDAO;
import lk.icbt.billing_system.dao.exception.ConstrainViolationException;
import lk.icbt.billing_system.dao.util.DBUtil;
import lk.icbt.billing_system.entity.Customer;
import lk.icbt.billing_system.entity.SuperEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

//    private Connection connection;
//
//    public CustomerDAOImpl(Connection connection) {
//
//        this.connection = connection;
//    }

    @Override
    public boolean add(Customer customer, Connection connection) throws SQLException {

        return DBUtil.executeUpdate(
                connection,
                "INSERT INTO Customer VALUES(?,?,?,?,?)",
                customer.getAccountNumber(),
                customer.getFullName(),
                customer.getAddress(),
                customer.getPhoneNumber(),
                customer.getUniteConsumed()
        );
//        return null;
    }

    @Override
    public void delete(String id, Connection connection) throws SQLException , ConstrainViolationException{
        if (!DBUtil.executeUpdate(connection, "DELETE FROM Customer WHERE accountNumber=?", id)){
            throw new ConstrainViolationException("Customer not deleted!");
        }
    }

    @Override
    public Customer update(Customer customer,Connection connection) throws SQLException {
        boolean isSuccess = DBUtil.executeUpdate(
                connection,
                "UPDATE Customer SET fullName=?, address=?, phoneNumber=?, uniteConsumed=? WHERE accountNumber=?",
                customer.getFullName(),
                customer.getAddress(),
                customer.getPhoneNumber(),
                customer.getUniteConsumed(),
                customer.getAccountNumber()
        );
        return isSuccess ? customer : null;
    }

    @Override
    public List<Customer> getAll(Connection connection) throws SQLException {
        return null;
    }
}
