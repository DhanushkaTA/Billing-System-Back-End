package lk.icbt.billing_system.service.custome.impl;

import lk.icbt.billing_system.dto.UserDTO;
import lk.icbt.billing_system.service.custome.UserService;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;

public class UserServiceImpl implements UserService {

    private final BasicDataSource bds;

    public UserServiceImpl(BasicDataSource bds){
        this.bds=bds;
    }

    @Override
    public boolean verifyPassword(UserDTO userDTO) {
        return false;
    }

    @Override
    public UserDTO getUser(String username) {
        return null;
    }
}
