package lk.icbt.billing_system.dao;

import lk.icbt.billing_system.entity.SuperEntity;

public interface CrudDAO<T extends SuperEntity,ID> extends SuperDAO{

    T add(T entity) ;

    boolean delete(ID id) ;

}