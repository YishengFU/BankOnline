package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.VilleDAO;
import main.SQLconnexion;
import pojo.Ville;

public class VilleDAOTest {
	private Ville v;

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
		Ville v = new Ville("Test", "Test");
		int cle = VilleDAO.getInstance().create(v);
		v.setId_ville(cle);
		this.v = v;
	}

	@After
	public void clear() {// etre execute apres qu'une teste soit terminee
		VilleDAO.getInstance().delete(this.v);
	}

	@Test
	public void testGetInstance() {
		assertTrue(VilleDAO.getInstance() instanceof VilleDAO);
	}

	@Test
	public void testGetById() {
		Ville vx = VilleDAO.getInstance().getById(this.v.getId_ville());
		assertEquals(this.v, vx);
	}

	@Test
	public void testCreate() {
		Ville vx = VilleDAO.getInstance().getById(this.v.getId_ville());
		assertEquals(v, vx);
	}

	@Test
	public void testUpdate() {
		this.v.setLib_ville("Test for update");
		VilleDAO.getInstance().update(this.v);
		Ville vx = VilleDAO.getInstance().getById(this.v.getId_ville());
		assertEquals(v, vx);
	}

	@Test
	public void testDelete() {
		VilleDAO.getInstance().delete(this.v);
		assertNull(VilleDAO.getInstance().getById(this.v.getId_ville()));
	}

	@Test
	public void testFindAll() {
		assertNotNull(VilleDAO.getInstance().findAll());
	}

}
