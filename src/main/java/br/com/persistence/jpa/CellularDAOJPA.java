package br.com.persistence.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.persistence.dao.CellularDAO;
import br.com.persistence.entity.Cellular;

@Stateless
public class CellularDAOJPA implements CellularDAO {

	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext(unitName = "ccell-pu")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Cellular save(Cellular entity) {
		if (entity.getId() == null) {
			entityManager.persist(entity);
		} else {
			entityManager.merge(entity);
		}

		return entity;
	}

	@Override
	public Cellular find(Long id) {
		return entityManager.find(Cellular.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cellular> list(boolean order) {
		String listQuery = "SELECT c FROM Cellular c";
		if (order) {
			listQuery = listQuery + " ORDER BY c.favourite DESC";
		}

		Query query = entityManager.createQuery(listQuery);
		entityManager.flush();
		entityManager.clear();
		return query.getResultList();
	}

	@Override
	public void delete(Long id) {
		Cellular spec = find(id);
		if (spec != null) {
			entityManager.remove(spec);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public Cellular findByName(String name) {
		String listQuery = "SELECT c FROM Cellular c WHERE c.name = '"+name+"'";

		Query query = entityManager.createQuery(listQuery);
		List<Cellular> cellulars = query.getResultList();
		
		Cellular cellular = null;
		
		if(cellulars != null && !cellulars.isEmpty()){
			cellular = cellulars.get(0);
		}
		
		return cellular;
	}

}
