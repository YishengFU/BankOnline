package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.StatutDAO;
import main.SQLconnexion;
import pojo.Statut;

public class StatutDAOTest {
	private Statut s;

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
		// on initialise un Statut et l'insere dans la bdd pour tester
		Statut s = new Statut("Test");
		int cle = StatutDAO.getInstance().create(s);
		s.setId_statut(cle);
		this.s = s;
	}

	@After
	public void clear() {// etre execute apres qu'une teste soit terminee
		StatutDAO.getInstance().delete(this.s);
	}

	@Test
	public void testGetInstance() {
		assertTrue(StatutDAO.getInstance() instanceof StatutDAO);
	}

	@Test
	public void testGetById() {
		Statut sx = StatutDAO.getInstance().getById(this.s.getId_statut());
		assertEquals(this.s, sx);
	}

	@Test
	public void testCreate() {
		Statut sx = StatutDAO.getInstance().getById(this.s.getId_statut());
		assertEquals(this.s, sx);
	}

	@Test
	public void testUpdate() {
		this.s.setLib_statut("Test for update");
		StatutDAO.getInstance().update(this.s);
		Statut sx = StatutDAO.getInstance().getById(this.s.getId_statut());
		assertEquals(s, sx);
	}

	@Test
	public void testDelete() {
		StatutDAO.getInstance().delete(this.s);
		assertNull(StatutDAO.getInstance().getById(this.s.getId_statut()));
	}

	@Test
	public void testFindAll() {
		assertNotNull(StatutDAO.getInstance().findAll());
	}

}
