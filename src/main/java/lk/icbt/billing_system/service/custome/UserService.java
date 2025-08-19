package lk.icbt.billing_system.service.custome;

import lk.icbt.billing_system.dto.UserDTO;
import lk.icbt.billing_system.service.SuperService;
import lk.icbt.billing_system.service.exception.NotFoundException;

import java.sql.SQLException;

public interface UserService extends SuperService {

    boolean verifyPassword(UserDTO userDTO) throws SQLException;

    UserDTO getUser(String username) throws SQLException, NotFoundException;

}
