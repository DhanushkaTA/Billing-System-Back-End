package lk.icbt.billing_system.service.custome;

import lk.icbt.billing_system.dto.UserDTO;
import lk.icbt.billing_system.service.SuperService;

public interface UserService extends SuperService {

    boolean verifyPassword(UserDTO userDTO);

    UserDTO getUser(String username);

}
