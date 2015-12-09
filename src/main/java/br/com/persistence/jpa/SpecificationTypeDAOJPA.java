package br.com.persistence.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.persistence.dao.SpecificationTypeDAO;
import br.com.persistence.entity.SpecificationType;

@Stateless
public class SpecificationTypeDAOJPA implements SpecificationTypeDAO {
	
    private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext(unitName="ccell-pu")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public SpecificationType save(SpecificationType entity) {
		SpecificationType entityFound = find(entity.getId());
		
		if (entityFound == null) {
			entityManager.persist(entity);
		} else {
			entityManager.merge(entity);
		}
		
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SpecificationType> list() {
		Query query = entityManager.createQuery("SELECT s FROM SpecificationType s");
        entityManager.flush();
        entityManager.clear();
        return query.getResultList();		
	}

	@Override
	public void delete(String id) {
		SpecificationType spec = find(id);
		if(spec != null) {
	        this.entityManager.remove(spec);
		}
		
	}
	
	@Override
	public SpecificationType find(String id){
		return this.entityManager.find(SpecificationType.class, id);
	}

}
