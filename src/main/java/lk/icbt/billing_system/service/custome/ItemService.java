package lk.icbt.billing_system.service.custome;

import lk.icbt.billing_system.dto.CustomerDTO;
import lk.icbt.billing_system.dto.ItemDTO;
import lk.icbt.billing_system.service.SuperService;
import lk.icbt.billing_system.service.exception.NotFoundException;

import java.sql.SQLException;
import java.util.List;

public interface ItemService extends SuperService {
    boolean addNewItem(ItemDTO itemDTO) throws SQLException;

    ItemDTO updateItem(ItemDTO itemDTO) throws SQLException;

    void deleteItem(String code) throws SQLException;

    List<ItemDTO> getAll() throws SQLException;

    ItemDTO getItemByCode(String code) throws SQLException, NotFoundException;
}
