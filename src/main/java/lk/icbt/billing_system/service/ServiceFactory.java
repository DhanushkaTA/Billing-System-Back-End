package lk.icbt.billing_system.service;

import lk.icbt.billing_system.service.custome.impl.CustomerServiceImpl;

public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    private ServiceFactory(){}

    public static ServiceFactory getServiceFactory(){
        return serviceFactory==null ?
                serviceFactory=new ServiceFactory() : serviceFactory;
    }

    public SuperService getService(ServiceTypes serviceTypes){
        switch (serviceTypes){
//            case USER:
//                return new UserServiceImpl();
            case CUSTOMER:
                return new CustomerServiceImpl();
//            case ORDER:
//                return new OrderServiceImpl();
//            case ORDER_DETAIL:
//                return new OrderDetailsServiceImpl();
            default:
                return null;
        }
    }

}
