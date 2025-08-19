package lk.icbt.billing_system.dao.custome.impl;

import lk.icbt.billing_system.dao.custome.UserDAO;
import lk.icbt.billing_system.dao.exception.ConstrainViolationException;
import lk.icbt.billing_system.dao.util.DBUtil;
import lk.icbt.billing_system.entity.Item;
import lk.icbt.billing_system.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean add(User entity, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public void delete(String s, Connection connection) throws SQLException, ConstrainViolationException {

    }

    @Override
    public User update(User entity, Connection connection) throws SQLException {
        return null;
    }

    @Override
    public List<User> getAll(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public User getByPk(String pk, Connection connection) throws SQLException {
        ResultSet resultSet =
                DBUtil.executeQuery(connection, "SELECT * FROM User WHERE username=?",pk);
        User user = null;

        if (resultSet.next()){
            user = new User(
                    resultSet.getString("username"),
                    resultSet.getString("password")
            );
        }

        return user;
    }
}
