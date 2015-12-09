package br.com.persistence.jpa;

import java.io.Serializable;

import br.com.persistence.dao.GenericDAO;

/*@Stateless
@Local(GenericDAO.class)*/
public class GenericDAOJPA <T, PK extends Serializable> implements GenericDAO<T, PK>{

	@Override
	public T create(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T find(PK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T update(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		
	}

    /*protected Class<T> entityClass;

    @PersistenceContext(unitName = "CompareCell-PU")
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
	public GenericDAOJPA() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
             .getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    @Override
    public T create(T t) {
        this.entityManager.persist(t);
        return t;
    }

    @Override
    public T find(PK id) {
        return this.entityManager.find(entityClass, id);
    }

    @Override
    public T update(T t) {
        return this.entityManager.merge(t);
    }

    @Override
    public void delete(T t) {
        t = this.entityManager.merge(t);
        this.entityManager.remove(t);
    }

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}*/
    
}
