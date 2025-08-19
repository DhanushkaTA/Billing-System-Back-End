package lk.icbt.billing_system.service.custome.impl;

import lk.icbt.billing_system.dao.DaoFactory;
import lk.icbt.billing_system.dao.DaoTypes;
import lk.icbt.billing_system.dao.custome.UserDAO;
import lk.icbt.billing_system.dto.UserDTO;
import lk.icbt.billing_system.entity.User;
import lk.icbt.billing_system.service.custome.UserService;
import lk.icbt.billing_system.service.exception.NotFoundException;
import lk.icbt.billing_system.service.util.Convertor;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private final BasicDataSource bds;

    private final UserDAO userDAO = (UserDAO) DaoFactory.getDaoFactory().getDAO(DaoTypes.USER);

    public UserServiceImpl(BasicDataSource bds){
        this.bds=bds;
    }

    @Override
    public boolean verifyPassword(UserDTO userDTO) throws SQLException{
        return false;
    }

    @Override
    public UserDTO getUser(String username) throws SQLException,NotFoundException {

        try (Connection connection=bds.getConnection()){
            User userByUsername = userDAO.getByPk(username, connection);

            if (userByUsername == null){
                throw new NotFoundException("User not found!");
            }

            return Convertor.toUserDTO(userByUsername);

        }
    }
}
