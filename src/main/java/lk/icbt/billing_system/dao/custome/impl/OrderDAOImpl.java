package lk.icbt.billing_system.dao.custome.impl;

import lk.icbt.billing_system.dao.CrudDAO;
import lk.icbt.billing_system.dao.custome.OrderDAO;
import lk.icbt.billing_system.dao.exception.ConstrainViolationException;
import lk.icbt.billing_system.dao.util.DBUtil;
import lk.icbt.billing_system.entity.Orders;
import lk.icbt.billing_system.entity.SuperEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public boolean add(Orders order, Connection connection) throws SQLException {
        return DBUtil.executeUpdate(connection, "INSERT INTO Orders VALUES(?,?,?,?)", order.getOrderId(),
                order.getCustomerId(), order.getOrderDate(), order.getTotal());
    }

    @Override
    public void delete(String s, Connection connection) throws SQLException, ConstrainViolationException {

    }

    @Override
    public Orders update(Orders entity, Connection connection) throws SQLException {
        return null;
    }

    @Override
    public List<Orders> getAll(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public Orders getByPk(String s, Connection connection) throws SQLException {
        return null;
    }
}
