package br.com.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;

import br.com.persistence.dao.SpecificationTypeDAO;
import br.com.persistence.entity.SpecificationType;

@Stateful
@Local(SpecificationTypeControllerLocal.class)
public class SpecificationTypeController implements SpecificationTypeControllerLocal {
	
	@EJB
	private SpecificationTypeDAO dao;

	public SpecificationTypeDAO getDao() {
		return dao;
	}

	public void setDao(SpecificationTypeDAO dao) {
		this.dao = dao;
	}
	
	public void save(SpecificationType entity){
		dao.save(entity);
	}
	
	public List<SpecificationType> list(){
		return dao.list();
	}
	
}
