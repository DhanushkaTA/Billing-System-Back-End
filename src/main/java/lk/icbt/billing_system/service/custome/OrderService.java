package lk.icbt.billing_system.service.custome;

import lk.icbt.billing_system.dao.exception.ConstrainViolationException;
import lk.icbt.billing_system.dto.OrderDTO;
import lk.icbt.billing_system.service.SuperService;
import lk.icbt.billing_system.service.exception.NotFoundException;

import java.sql.SQLException;

public interface OrderService extends SuperService {

    void addNewOrder(OrderDTO orderDTO) throws SQLException, NotFoundException, ConstrainViolationException;

}
