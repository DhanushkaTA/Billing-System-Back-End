package lk.icbt.billing_system.dao;

import lk.icbt.billing_system.dao.exception.ConstrainViolationException;
import lk.icbt.billing_system.entity.SuperEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T extends SuperEntity,ID> extends SuperDAO{

    boolean add(T entity, Connection connection) throws SQLException;

    void delete(ID id, Connection connection) throws SQLException, ConstrainViolationException;

    T update(T entity,Connection connection) throws SQLException;

    List<T> getAll(Connection connection) throws SQLException;

    T getByPk(ID id,Connection connection) throws SQLException;

}