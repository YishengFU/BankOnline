package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.Etat_operationDAO;
import main.SQLconnexion;
import pojo.Etat_operation;

public class Etat_operationDAOTest {
	private Etat_operation eo;

	@BeforeClass // etre execute qu'une fois, quand on lance cette classe
	public static void connection() {
		SQLconnexion.getInstance().creeConnexion();
		System.out.println("Connected");
	}

	@AfterClass // etre execute qu'une fois, quand on termine cette classe
	public static void deconnection() {
		try {
			SQLconnexion.getInstance().creeConnexion().close();
			System.out.println("Disconnected");
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}

	@Before
	public void preparation() {// etre execute avant qu'une teste soit executee
		// on initialise un Etat_operation et l'insere dans la bdd pour tester
		Etat_operation e = new Etat_operation("Test");
		int cle = Etat_operationDAO.getInstance().create(e);
		e.setId_etat(cle);
		this.eo = e;
	}

	@After
	public void clear() {// etre execute apres qu'une teste soit terminee
		Etat_operationDAO.getInstance().delete(this.eo);
	}

	@Test
	public void testGetInstance() {
		assertTrue(Etat_operationDAO.getInstance() instanceof Etat_operationDAO);
	}

	@Test
	public void testGetById() {
		Etat_operation eox = Etat_operationDAO.getInstance().getById(this.eo.getId_etat());
		assertEquals(this.eo, eox);
	}

	@Test
	public void testCreate() {
		Etat_operation eox = Etat_operationDAO.getInstance().getById(this.eo.getId_etat());
		assertEquals(this.eo, eox);
	}

	@Test
	public void testUpdate() {
		this.eo.setLib_etat("Test for update");
		Etat_operationDAO.getInstance().update(this.eo);
		Etat_operation eox = Etat_operationDAO.getInstance().getById(this.eo.getId_etat());
		assertEquals(eo, eox);
	}

	@Test
	public void testDelete() {
		Etat_operationDAO.getInstance().delete(this.eo);
		assertNull(Etat_operationDAO.getInstance().getById(this.eo.getId_etat()));
	}

	@Test
	public void testFindAll() {
		assertNotNull(Etat_operationDAO.getInstance().findAll());
	}

}
