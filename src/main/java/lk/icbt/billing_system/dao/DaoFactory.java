package lk.icbt.billing_system.dao;

import lk.icbt.billing_system.dao.custome.impl.CustomerDAOImpl;

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
//            case ORDER:
//                return new OrderDAOImpl();
//            case ORDER_DETAIL:
//                return new OrderDetailsDAOImpl();
            default:
                return null;
        }
    }
}
