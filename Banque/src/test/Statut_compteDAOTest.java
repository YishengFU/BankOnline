package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.Statut_compteDAO;
import main.SQLconnexion;
import pojo.Statut_compte;

public class Statut_compteDAOTest {
	private Statut_compte sc;

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
		// on initialise une Ville et l'insere dans la bdd pour tester
		Statut_compte s = new Statut_compte("Test");
		int cle = Statut_compteDAO.getInstance().create(s);
		s.setId_statut_cpte(cle);
		this.sc = s;
	}

	@After
	public void clear() {// etre execute apres qu'une teste soit terminee
		Statut_compteDAO.getInstance().delete(this.sc);
	}

	@Test
	public void testGetInstance() {
		assertTrue(Statut_compteDAO.getInstance() instanceof Statut_compteDAO);
	}

	@Test
	public void testGetById() {
		Statut_compte scx = Statut_compteDAO.getInstance().getById(this.sc.getId_statut_cpte());
		assertEquals(this.sc, scx);
	}

	@Test
	public void testCreate() {
		Statut_compte scx = Statut_compteDAO.getInstance().getById(this.sc.getId_statut_cpte());
		assertEquals(this.sc, scx);
	}

	@Test
	public void testUpdate() {
		this.sc.setLib_statut_cpte("Test for update");
		Statut_compteDAO.getInstance().update(this.sc);
		Statut_compte scx = Statut_compteDAO.getInstance().getById(this.sc.getId_statut_cpte());
		assertEquals(sc, scx);
	}

	@Test
	public void testDelete() {
		Statut_compteDAO.getInstance().delete(this.sc);
		assertNull(Statut_compteDAO.getInstance().getById(this.sc.getId_statut_cpte()));
	}

	@Test
	public void testFindAll() {
		assertNotNull(Statut_compteDAO.getInstance().findAll());
	}

}
