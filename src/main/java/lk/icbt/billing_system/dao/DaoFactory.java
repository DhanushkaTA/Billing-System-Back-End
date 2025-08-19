package lk.icbt.billing_system.dao;

import lk.icbt.billing_system.dao.custome.impl.CustomerDAOImpl;
import lk.icbt.billing_system.dao.custome.impl.ItemDAOImpl;
import lk.icbt.billing_system.dao.custome.impl.OrderDAOImpl;
import lk.icbt.billing_system.dao.custome.impl.OrderDetailsDAOImpl;

import java.sql.Connection;

public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory(){}

    public static DaoFactory getDaoFactory(){
        return daoFactory==null ? daoFactory=new DaoFactory() : daoFactory;
    }

    public SuperDAO getDAO(DaoTypes daoTypes){
        switch (daoTypes){
//            case USER:
//                return new UserDAOImpl();
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDER_DETAIL:
                return new OrderDetailsDAOImpl();
            default:
                return null;
        }
    }
}
