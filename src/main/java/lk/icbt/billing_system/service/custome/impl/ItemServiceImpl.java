package lk.icbt.billing_system.service.custome.impl;

import lk.icbt.billing_system.dao.DaoFactory;
import lk.icbt.billing_system.dao.DaoTypes;
import lk.icbt.billing_system.dao.custome.ItemDAO;
import lk.icbt.billing_system.dto.CustomerDTO;
import lk.icbt.billing_system.dto.ItemDTO;
import lk.icbt.billing_system.entity.Customer;
import lk.icbt.billing_system.entity.Item;
import lk.icbt.billing_system.service.custome.ItemService;
import lk.icbt.billing_system.service.exception.NotFoundException;
import lk.icbt.billing_system.service.util.Convertor;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class ItemServiceImpl implements ItemService {

    private final BasicDataSource bds;

    private final ItemDAO itemDAO = (ItemDAO) DaoFactory.getDaoFactory().getDAO(DaoTypes.ITEM);

    public ItemServiceImpl(BasicDataSource bds){
        this.bds=bds;
    }

    @Override
    public boolean addNewItem(ItemDTO itemDTO) throws SQLException {
        try (Connection connection = this.bds.getConnection();){
            return itemDAO.add(Convertor.toItem(itemDTO),connection);
        }
    }

    @Override
    public ItemDTO updateItem(ItemDTO itemDTO) throws SQLException {
        try (Connection connection = this.bds.getConnection();){
            Item updatedItem =
                    itemDAO.update(Convertor.toItem(itemDTO), connection);
            if (updatedItem!=null){
                return Convertor.toItemDTO(updatedItem);
            }else {
                return null;
            }
        }
    }

    @Override
    public void deleteItem(String code) throws SQLException {
        try (Connection connection = this.bds.getConnection()){
            // find customer first

            // delete customer
            itemDAO.delete(code, connection);
        }
    }

    @Override
    public List<ItemDTO> getAll() throws SQLException {
        try (Connection connection = this.bds.getConnection()){
            // delete customer
            return itemDAO.getAll(connection).stream().map(Convertor::toItemDTO).collect(Collectors.toList());
        }
    }

    @Override
    public ItemDTO getItemByCode(String code) throws SQLException, NotFoundException {
        try (Connection connection = this.bds.getConnection()){
            Item item = itemDAO.getByPk(code, connection);

            if (item == null){
                throw new NotFoundException("Item not found!");
            }
            return new ItemDTO(
                    item.getItemCode(),
                    item.getDescription(),
                    item.getUnitPrice(),
                    item.getQtyOnHand());
        }
    }
}
