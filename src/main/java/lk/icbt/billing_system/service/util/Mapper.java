package lk.icbt.billing_system.service.util;

import lk.icbt.billing_system.dao.custome.ItemDAO;
import lk.icbt.billing_system.dto.CustomerDTO;
import lk.icbt.billing_system.dto.ItemDTO;
import lk.icbt.billing_system.entity.Customer;
import lk.icbt.billing_system.entity.Item;

public class Mapper {

    public static Customer toCustomer (CustomerDTO dto){
        return new Customer(
                dto.getAccountNumber(),
                dto.getFullName(),
                dto.getAddress(),
                dto.getPhoneNumber(),
                dto.getUniteConsumed()
        );
    }

    public static CustomerDTO toCustomerDTO(Customer customer){
        return new CustomerDTO(
                customer.getAccountNumber(),
                customer.getFullName(),
                customer.getAddress(),
                customer.getPhoneNumber(),
                customer.getUniteConsumed()
        );
    }

    public static Item toItem(ItemDTO dto){
        return new Item(
                dto.getItemCode(),
                dto.getDescription(),
                dto.getUnitPrice(),
                dto.getQtyOnHand()
        );
    }

    public static ItemDTO toItemDTO(Item item){
        return new ItemDTO(
                item.getItemCode(),
                item.getDescription(),
                item.getUnitPrice(),
                item.getQtyOnHand()
        );
    }

}
