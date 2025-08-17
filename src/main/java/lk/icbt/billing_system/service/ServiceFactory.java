package lk.icbt.billing_system.service;

import lk.icbt.billing_system.service.custome.impl.CustomerServiceImpl;
import org.apache.commons.dbcp2.BasicDataSource;

public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    private ServiceFactory(){}

    public static ServiceFactory getServiceFactory(){
        return serviceFactory==null ?
                serviceFactory=new ServiceFactory() : serviceFactory;
    }

    public SuperService getService(ServiceTypes serviceTypes, BasicDataSource bds){
        switch (serviceTypes){
//            case USER:
//                return new UserServiceImpl();
            case CUSTOMER:
                return new CustomerServiceImpl(bds);
//            case ORDER:
//                return new OrderServiceImpl();
//            case ORDER_DETAIL:
//                return new OrderDetailsServiceImpl();
            default:
                return null;
        }
    }

}
