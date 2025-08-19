package lk.icbt.billing_system.dao.custome.impl;

import lk.icbt.billing_system.dao.custome.OrderDetailsDAO;
import lk.icbt.billing_system.dao.exception.ConstrainViolationException;
import lk.icbt.billing_system.dao.util.DBUtil;
import lk.icbt.billing_system.entity.OrderDetails;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    @Override
    public boolean add(OrderDetails orderDetails, Connection connection) throws SQLException {

        return DBUtil.executeUpdate(connection, "INSERT INTO OrderDetail VALUES(?,?,?,?)", orderDetails.getOrderID(),
                orderDetails.getItemCode(), orderDetails.getQty(), orderDetails.getUnitPrice());

    }

    @Override
    public void delete(String s, Connection connection) throws SQLException, ConstrainViolationException {

    }

    @Override
    public OrderDetails update(OrderDetails entity, Connection connection) throws SQLException {
        return null;
    }

    @Override
    public List<OrderDetails> getAll(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public OrderDetails getByPk(String s, Connection connection) throws SQLException {
        return null;
    }
}
