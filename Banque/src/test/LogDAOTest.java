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

import dao.LogDAO;
import dao.PersonneDAO;
import dao.StatutDAO;
import dao.VilleDAO;
import main.SQLconnexion;
import pojo.Log;
import pojo.Personne;
import pojo.Sexe;
import pojo.Statut;
import pojo.Ville;

public class LogDAOTest {
	private Log l;

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
		// on initialise un Log et l'insere dans la bdd pour tester
		// pour tester un Log, il faut d'abord initialiser une Personne
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
		// apres on initialise un Log selon la Personne qu'on vient d'initialiser
		Log l = new Log(p, datetest);
		int l_cle = LogDAO.getInstance().create(l);
		l.setId_log(l_cle);
		this.l = l;
	}

	@After
	public void clear() {// etre execute apres qu'une teste soit terminee
		VilleDAO.getInstance().delete(this.l.getSon_hote().getSa_ville());
		StatutDAO.getInstance().delete(this.l.getSon_hote().getSon_statut());
		PersonneDAO.getInstance().delete(this.l.getSon_hote());
		LogDAO.getInstance().delete(this.l);
	}

	@Test
	public void testGetInstance() {
		assertTrue(LogDAO.getInstance() instanceof LogDAO);
	}

	@Test
	public void testGetById() {
		Log lx = LogDAO.getInstance().getById(this.l.getId_log());
		assertEquals(l, lx);
	}

	@Test
	public void testCreate() {
		Log lx = LogDAO.getInstance().getById(this.l.getId_log());
		assertEquals(l, lx);
	}

	@Test
	public void testUpdate() {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate datetest = LocalDate.parse("2020/01/01", formatage);
		this.l.setDate_connexion(datetest);
		LogDAO.getInstance().update(this.l);
		Log lx = LogDAO.getInstance().getById(this.l.getId_log());
		assertEquals(this.l, lx);
	}

	@Test
	public void testDelete() {
		LogDAO.getInstance().delete(this.l);
		assertNull(LogDAO.getInstance().getById(this.l.getId_log()));
	}

	@Test
	public void testFindAll() {
		assertNotNull(LogDAO.getInstance().findAll());
	}

}
