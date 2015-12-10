package br.com.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.persistence.entity.Cellular;
import br.com.persistence.entity.Specification;
import br.com.persistence.jpa.CellularDAOJPA;
import br.com.persistence.jpa.SpecificationDAOJPA;
import br.com.persistence.jpa.SpecificationTypeDAOJPA;
import br.com.util.InitDB;

import static org.junit.Assert.*;

public class CellularTest {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CompareCell-PU-Test");
	private static EntityManager entityManager;
	private static EntityTransaction transaction;
	
	private static CellularDAOJPA dao;
	private static SpecificationDAOJPA daoSpec;
	private static SpecificationTypeDAOJPA daoSpecType;
	
	private static InitDB initDB;

	@BeforeClass
	public static void setUpClass() {
		entityManager = (EntityManager) emf.createEntityManager();

		dao = new CellularDAOJPA();
		dao.setEntityManager(entityManager);
		
		daoSpec = new SpecificationDAOJPA();
		daoSpec.setEntityManager(entityManager);
		
		daoSpecType = new SpecificationTypeDAOJPA();
		daoSpecType.setEntityManager(entityManager);
		
		transaction = entityManager.getTransaction();
		entityManager.setFlushMode(FlushModeType.COMMIT);
		initDB = new InitDB(dao, daoSpec, daoSpecType);
		transaction.begin();
		initDB.fillDB();
		transaction.commit();
	}

	@AfterClass
	public static void tearDownClass() {
		emf.close();
	}

	@Before
	public void setUp() {
		transaction = entityManager.getTransaction();
		entityManager.setFlushMode(FlushModeType.COMMIT);
	}

	@After
	public void tearDown() {
	}
	
	@Test
	public void listTest(){
		transaction.begin();
		List<Cellular> cellulars = dao.list(false);
		transaction.commit();
		
		assertNotNull(cellulars);
		assertTrue(!cellulars.isEmpty());
	}
	
	@Test
	public void retrieveTest(){
		transaction.begin();
		List<Cellular> cellulars = dao.list(false);
		transaction.commit();
		
		assertNotNull(cellulars);
		assertTrue(!cellulars.isEmpty());
		
		Cellular cellular = cellulars.get(0);
		transaction.begin();
		Cellular cellularRetrieved = dao.find(cellular.getId());
		transaction.commit();
		
		assertNotNull(cellularRetrieved);
	}
	
	@Test
	public void favouriteTest() {
		transaction.begin();
		List<Cellular> cellulars = dao.list(true);
		transaction.commit();
		
		assertNotNull(cellulars);
		assertTrue(!cellulars.isEmpty());
		
		Cellular cellular = cellulars.get(0);
		int favourite = cellular.getFavourite();
		
		int newFavourite = favourite + 1;
		cellular.setFavourite(newFavourite);
		
		transaction.begin();
		cellular = dao.save(cellular);
		transaction.commit();
		
		assertEquals(cellular.getFavourite(), newFavourite);
	}
	
	@Test
	public void compareTest(){
		transaction.begin();
		List<Cellular> cellulars = dao.list(false);
		transaction.commit();
		
		assertNotNull(cellulars);
		assertTrue(!cellulars.isEmpty());
		assertTrue(cellulars.size()>1);
		
		Cellular cellular1 = cellulars.get(0);
		Cellular cellular2 = cellulars.get(1);
		
		Cellular better = null;
		
		for(Specification spec1: cellular1.getSpecs()){
			if(spec1.getType().getId().equals("PREC")){
				for(Specification spec2: cellular2.getSpecs()){
					if(spec2.getType().getId().equals("PREC")){
						int pos1 = spec1.getPosition();
						int pos2 = spec2.getPosition();
						
						if(pos1 < pos2) {
							better = cellular1;
						} else {
							better = cellular2;
						}
					}
				}
			}
		}
		
		assertNotNull(better);
	}
	
}
