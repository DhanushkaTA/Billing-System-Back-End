package lk.icbt.billing_system.dao.custome;

import lk.icbt.billing_system.dao.CrudDAO;
import lk.icbt.billing_system.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;

public interface CustomerDAO extends CrudDAO<Customer, String> {
    String getNextCustomerId(Connection connection) throws SQLException;
}
