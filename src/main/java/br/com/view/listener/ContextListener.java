package br.com.view.listener;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.com.persistence.dao.CellularDAO;
import br.com.persistence.dao.SpecificationDAO;
import br.com.persistence.dao.SpecificationTypeDAO;
import br.com.util.InitDB;

/**
 * Classe executada na inicialização do sistema.
 * 
 * @author Juliana
 */
@WebListener
public class ContextListener implements ServletContextListener {

	@EJB
	private CellularDAO cellDAO;
	
	@EJB
	private SpecificationTypeDAO specTypeDAO;
	
	@EJB
	private SpecificationDAO specDAO;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		InitDB initDB = new InitDB(cellDAO, specDAO, specTypeDAO);
		initDB.fillDB();
	}

	public CellularDAO getCellDAO() {
		return cellDAO;
	}

	public void setCellDAO(CellularDAO cellDAO) {
		this.cellDAO = cellDAO;
	}

	public SpecificationTypeDAO getSpecTypeDAO() {
		return specTypeDAO;
	}

	public void setSpecTypeDAO(SpecificationTypeDAO specTypeDAO) {
		this.specTypeDAO = specTypeDAO;
	}

	public SpecificationDAO getSpecDAO() {
		return specDAO;
	}

	public void setSpecDAO(SpecificationDAO specDAO) {
		this.specDAO = specDAO;
	}

}
