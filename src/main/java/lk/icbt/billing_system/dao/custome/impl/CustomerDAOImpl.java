package lk.icbt.billing_system.dao.custome.impl;

import lk.icbt.billing_system.dao.custome.CustomerDAO;
import lk.icbt.billing_system.dao.util.DBUtil;
import lk.icbt.billing_system.entity.Customer;
import lk.icbt.billing_system.entity.SuperEntity;

import java.sql.Connection;
import java.sql.SQLException;

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
    public boolean delete(String s, Connection connection) {
        return false;
    }
}
