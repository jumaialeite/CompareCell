package br.com.controller;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;

import br.com.persistence.dao.SpecificationDAO;

@Stateful
@Local(SpecificationControllerLocal.class)
public class SpecificationController implements SpecificationControllerLocal {
	
	@EJB
	private SpecificationDAO dao;

	public SpecificationDAO getDao() {
		return dao;
	}

	public void setDao(SpecificationDAO dao) {
		this.dao = dao;
	}
	
}
