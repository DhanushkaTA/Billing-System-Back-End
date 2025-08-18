package lk.icbt.billing_system.dao.custome.impl;

import lk.icbt.billing_system.dao.CrudDAO;
import lk.icbt.billing_system.dao.custome.OrderDAO;
import lk.icbt.billing_system.dao.exception.ConstrainViolationException;
import lk.icbt.billing_system.entity.SuperEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public boolean add(SuperEntity entity, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public void delete(Object o, Connection connection) throws SQLException, ConstrainViolationException {

    }

    @Override
    public SuperEntity update(SuperEntity entity, Connection connection) throws SQLException {
        return null;
    }

    @Override
    public List getAll(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public SuperEntity getByPk(Object o, Connection connection) throws SQLException {
        return null;
    }
}
