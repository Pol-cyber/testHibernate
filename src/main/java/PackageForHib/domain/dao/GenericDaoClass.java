package PackageForHib.domain.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDaoClass<T,ID> implements GenericDaoInterface<T,ID> {

    @PersistenceContext
    public EntityManager entityManager;

    public Class<T> entity;


    public GenericDaoClass(Class<T> tClass){
        entity = tClass;
    }

    @Override
    public T findById(ID id) {
         return entityManager.find(entity,id);

    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
