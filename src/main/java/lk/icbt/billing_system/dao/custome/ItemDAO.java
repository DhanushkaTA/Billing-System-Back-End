package lk.icbt.billing_system.dao.custome;

import lk.icbt.billing_system.dao.CrudDAO;
import lk.icbt.billing_system.entity.Item;

import java.sql.Connection;
import java.sql.SQLException;

public interface ItemDAO extends CrudDAO<Item, String> {

    boolean reduceItemQty(String itemCode,int qty, Connection connection) throws SQLException;

}
