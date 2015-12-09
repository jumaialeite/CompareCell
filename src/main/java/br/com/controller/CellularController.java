package br.com.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;

import br.com.exception.NullParameterException;
import br.com.persistence.dao.CellularDAO;
import br.com.persistence.entity.Cellular;

@Stateful
@Local(CellularControllerLocal.class)
public class CellularController implements CellularControllerLocal {

	@EJB
	private CellularDAO dao;

	public CellularDAO getDao() {
		return dao;
	}

	public void setDao(CellularDAO dao) {
		this.dao = dao;
	}

	@Override
	public Cellular save(Cellular cellular) throws NullParameterException {
		if (cellular == null) {
			throw new NullParameterException();
		}

		return dao.save(cellular);
	}
	
	@Override
	public Cellular find(Long id){
		return dao.find(id);
	}
	
	@Override
	public List<Cellular> list(boolean order){
		return dao.list(order);
	}
	
	@Override
	public void remove(Long id) {
		dao.delete(id);
	}
	
	@Override
	public Cellular findByName(String name) {
		return dao.findByName(name);
	}
	
	public Cellular addFavourite(String cellularName) throws NullParameterException {
		Cellular cellular = findByName(cellularName);
		
		if(cellular == null) {
			throw new NullParameterException();
		}
		
		int favouritePoints = cellular.getFavourite();
		
		cellular.setFavourite(favouritePoints + 1);
		return save(cellular);
	}

}
