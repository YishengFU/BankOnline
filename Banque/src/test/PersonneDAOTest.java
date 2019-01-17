package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.PersonneDAO;
import dao.StatutDAO;
import dao.VilleDAO;
import main.SQLconnexion;
import pojo.Personne;
import pojo.Sexe;
import pojo.Statut;
import pojo.Ville;

public class PersonneDAOTest {
	private Personne p;

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
		// on initialise une Personne et l'insere dans la bdd pour tester
		// pour tester une Personne, il faut d'abord initialiser une Ville et un Statut
		// partie date
		LocalDate datetest = LocalDate.now();
		// partie Ville
		Ville v = new Ville("Test", "Test");
		int v_cle = VilleDAO.getInstance().create(v);
		v.setId_ville(v_cle);
		// partie Statut
		Statut s = new Statut("Test");
		int s_cle = StatutDAO.getInstance().create(s);
		s.setId_statut(s_cle);
		// partie Personne
		Personne p = new Personne("Test", "test", datetest, "test", v, new Sexe(1), s, "test", "test", "test", "test",
				null);// Sexe(1): Masculin, defini dans POJO
		int p_cle = PersonneDAO.getInstance().create(p);
		p.setId_pers(p_cle);
		this.p = p;
	}

	@After
	public void clear() {// etre execute apres qu'une teste soit terminee
		VilleDAO.getInstance().delete(this.p.getSa_ville());
		StatutDAO.getInstance().delete(this.p.getSon_statut());
		PersonneDAO.getInstance().delete(this.p);
	}

	@Test
	public void testGetInstance() {
		assertTrue(PersonneDAO.getInstance() instanceof PersonneDAO);
	}

	@Test
	public void testGetById() {
		Personne px = PersonneDAO.getInstance().getById(this.p.getId_pers());
		assertEquals(p, px);
	}

	@Test
	public void testCreate() {
		Personne px = PersonneDAO.getInstance().getById(this.p.getId_pers());
		assertEquals(p, px);
	}

	@Test
	public void testUpdate() {
		this.p.setNom("Test for update");
		PersonneDAO.getInstance().update(this.p);
		Personne px = PersonneDAO.getInstance().getById(this.p.getId_pers());
		assertEquals(this.p, px);
	}

	@Test
	public void testDelete() {
		PersonneDAO.getInstance().delete(this.p);
		assertNull(PersonneDAO.getInstance().getById(this.p.getId_pers()));
	}

	@Test
	public void testFindAll() {
		assertNotNull(PersonneDAO.getInstance().findAll());
	}

}
