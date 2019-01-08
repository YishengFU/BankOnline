package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.Type_compteDAO;
import main.SQLconnexion;
import pojo.Type_compte;

public class Type_compteDAOTest {
	private Type_compte tc;

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
		// on initialise un Type_compte et l'insere dans la bdd pour tester
		Type_compte tc = new Type_compte("Test");
		int cle = Type_compteDAO.getInstance().create(tc);
		tc.setId_type_cpte(cle);
		this.tc = tc;
	}

	@After
	public void clear() {// etre execute apres qu'une teste soit terminee
		Type_compteDAO.getInstance().delete(this.tc);
	}

	@Test
	public void testGetInstance() {
		assertTrue(Type_compteDAO.getInstance() instanceof Type_compteDAO);
	}

	@Test
	public void testGetById() {
		Type_compte tcx = Type_compteDAO.getInstance().getById(this.tc.getId_type_cpte());
		assertEquals(tc, tcx);
	}

	@Test
	public void testCreate() {
		Type_compte tcx = Type_compteDAO.getInstance().getById(this.tc.getId_type_cpte());
		assertEquals(tc, tcx);
	}

	@Test
	public void testUpdate() {
		this.tc.setLib_type_cpte("Test for update");
		Type_compteDAO.getInstance().update(this.tc);
		Type_compte tcx = Type_compteDAO.getInstance().getById(this.tc.getId_type_cpte());
		assertEquals(tc, tcx);
	}

	@Test
	public void testDelete() {
		Type_compteDAO.getInstance().delete(this.tc);
		assertNull(Type_compteDAO.getInstance().getById(this.tc.getId_type_cpte()));
	}

	@Test
	public void testFindAll() {
		assertNotNull(Type_compteDAO.getInstance().findAll());
	}

}
