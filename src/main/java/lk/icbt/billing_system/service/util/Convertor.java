package lk.icbt.billing_system.service.util;

import lk.icbt.billing_system.dto.*;
import lk.icbt.billing_system.entity.*;

public class Convertor {

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

    public static OrderDetails toOrderDetail(OrderDetailsDTO dto){
        return new OrderDetails(
                dto.getOrderID(),
                dto.getItemCode(),
                dto.getUnitPrice(),
                dto.getQty()
        );
    }

    public static Orders toOrders(OrderDTO dto){
        return new Orders(
                dto.getOrderId(),
                dto.getCustomerId(),
                dto.getOrderDate(),
                dto.getTotal()
        );
    }

    public static User toUser(UserDTO dto){
        return new User(
                dto.getUsername(),
                dto.getPassword()
        );
    }

    public static UserDTO toUserDTO(User user){
        return new UserDTO(
                user.getUsername(),
                user.getPassword()
        );
    }
}
