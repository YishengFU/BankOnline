package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.CritereDAO;
import dao.PersonneDAO;
import dao.StatutDAO;
import dao.VilleDAO;
import main.SQLconnexion;
import pojo.Critere;
import pojo.Personne;
import pojo.Sexe;
import pojo.Statut;
import pojo.Ville;

public class CritereDAOTest {
	private Critere c;

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
		// on initialise un Critere et l'insere dans la bdd pour tester
		// pour tester un Critere, il faut d'abord initialiser une Personne
		// pour tester une Personne, il faut d'abord initialiser une Ville et un Statut
		// partie date
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate datetest = LocalDate.parse("2019/01/01", formatage);
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
		// apres on initialise un Critere selon la Personne qu'on vient d'initialiser
		Critere c = new Critere(p, "Test", "Test", "Test");
		int c_cle = CritereDAO.getInstance().create(c);
		c.setId_critere(c_cle);
		this.c = c;
	}

	@After
	public void clear() {// etre execute apres qu'une teste soit terminee
		VilleDAO.getInstance().delete(this.c.getSon_hote().getSa_ville());
		StatutDAO.getInstance().delete(this.c.getSon_hote().getSon_statut());
		PersonneDAO.getInstance().delete(this.c.getSon_hote());
		CritereDAO.getInstance().delete(this.c);
	}

	@Test
	public void testGetInstance() {
		assertTrue(CritereDAO.getInstance() instanceof CritereDAO);
	}

	@Test
	public void testGetById() {
		Critere cx = CritereDAO.getInstance().getById(this.c.getId_critere());
		assertEquals(c, cx);
	}

	@Test
	public void testCreate() {
		Critere cx = CritereDAO.getInstance().getById(this.c.getId_critere());
		assertEquals(c, cx);
	}

	@Test
	public void testUpdate() {
		this.c.setLib_critere("Test for update");
		CritereDAO.getInstance().update(this.c);
		Critere cx = CritereDAO.getInstance().getById(this.c.getId_critere());
		assertEquals(this.c, cx);
	}

	@Test
	public void testDelete() {
		CritereDAO.getInstance().delete(this.c);
		assertNull(CritereDAO.getInstance().getById(this.c.getId_critere()));
	}

	@Test
	public void testFindAll() {
		assertNotNull(CritereDAO.getInstance().findAll());
	}

}
