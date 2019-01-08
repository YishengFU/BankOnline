package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.PosteDAO;
import main.SQLconnexion;
import pojo.Poste;

public class PosteDAOTest {
	private Poste p;

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
		// on initialise un Poste et l'insere dans la bdd pour tester
		Poste p = new Poste("Test", 111);
		int cle = PosteDAO.getInstance().create(p);
		p.setId_poste(cle);
		this.p = p;
	}

	@After
	public void clear() {// etre execute apres qu'une teste soit terminee
		PosteDAO.getInstance().delete(this.p);
	}

	@Test
	public void testGetInstance() {
		assertTrue(PosteDAO.getInstance() instanceof PosteDAO);
	}

	@Test
	public void testGetById() {
		Poste px = PosteDAO.getInstance().getById(this.p.getId_poste());
		assertEquals(p, px);
	}

	@Test
	public void testCreate() {
		Poste px = PosteDAO.getInstance().getById(this.p.getId_poste());
		assertEquals(p, px);
	}

	@Test
	public void testUpdate() {
		this.p.setLib_poste("Test for update");
		PosteDAO.getInstance().update(this.p);
		Poste px = PosteDAO.getInstance().getById(this.p.getId_poste());
		assertEquals(p, px);
	}

	@Test
	public void testDelete() {
		PosteDAO.getInstance().delete(this.p);
		assertNull(PosteDAO.getInstance().getById(this.p.getId_poste()));
	}

	@Test
	public void testFindAll() {
		assertNotNull(PosteDAO.getInstance().findAll());
	}

}
