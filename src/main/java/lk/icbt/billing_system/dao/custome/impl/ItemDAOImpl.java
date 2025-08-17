package lk.icbt.billing_system.dao.custome.impl;

import lk.icbt.billing_system.dao.custome.ItemDAO;
import lk.icbt.billing_system.dao.exception.ConstrainViolationException;
import lk.icbt.billing_system.dao.util.DBUtil;
import lk.icbt.billing_system.entity.Customer;
import lk.icbt.billing_system.entity.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean add(Item item, Connection connection) throws SQLException {
        return DBUtil.executeUpdate(
                connection,
                "INSERT INTO Item VALUES(?,?,?,?,?)",
                item.getItemCode(),
                item.getDescription(),
                item.getUnitPrice(),
                item.getQtyOnHand()
        );
    }

    @Override
    public void delete(String code, Connection connection) throws SQLException, ConstrainViolationException {
        if (!DBUtil.executeUpdate(connection, "DELETE FROM Item WHERE itemCode=?", code)){
            throw new ConstrainViolationException("Item not deleted!");
        }
    }

    @Override
    public Item update(Item item, Connection connection) throws SQLException {
        boolean isSuccess = DBUtil.executeUpdate(
                connection,
                "UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE itemCode=?",
                item.getDescription(),
                item.getUnitPrice(),
                item.getQtyOnHand(),
                item.getItemCode()
        );
        return isSuccess ? item : null;
    }

    @Override
    public List<Item> getAll(Connection connection) throws SQLException {
        return getList(DBUtil.executeQuery(connection,"SELECT * FROM Item"));
    }

    private List<Item> getList(ResultSet resultSet) throws SQLException {

        List<Item> itemList = new ArrayList<>();

        while (resultSet.next()) {

            itemList.add(
                    new Item(
                            resultSet.getString("itemCode"),
                            resultSet.getString("description"),
                            resultSet.getDouble("unitPrice"),
                            resultSet.getInt("qtyOnHand")
                    ));
        }

        return itemList;
    }
}
