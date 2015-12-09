package br.com.persistence.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.persistence.dao.SpecificationDAO;
import br.com.persistence.entity.Specification;

@Stateless
public class SpecificationDAOJPA /*extends GenericDAOJPA<Specification, Long>*/ implements SpecificationDAO {
	
    private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext(unitName="ccell-pu")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public Specification save(Specification entity){
		Specification foundSpecification = find(entity.getId());
		
		if(foundSpecification == null) {
			entityManager.persist(entity);
		} else {
			entityManager.merge(entity);
		}
		
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Specification> list() {
		Query query = entityManager.createQuery("SELECT s FROM Specification s");
        entityManager.flush();
        entityManager.clear();
        return query.getResultList();		
	}

	@Override
	public void delete(String id) {
		Specification spec = find(id);
		if(spec != null) {
			entityManager.remove(spec);
		}
		
	}
	
	@Override
	public Specification find(String id) {
		return entityManager.find(Specification.class, id);
	}
	
}
