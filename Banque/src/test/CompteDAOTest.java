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

import dao.CompteDAO;
import dao.PersonneDAO;
import dao.StatutDAO;
import dao.Statut_compteDAO;
import dao.Type_compteDAO;
import dao.VilleDAO;
import main.SQLconnexion;
import pojo.Compte;
import pojo.Compte_courant;
import pojo.Personne;
import pojo.Sexe;
import pojo.Statut;
import pojo.Statut_compte;
import pojo.Type_compte;
import pojo.Ville;

public class CompteDAOTest {
	private Compte_courant cc;

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
		// on initialise un Compte et l'insere dans la bdd pour tester
		// pour tester un Compte, il faut d'abord initialiser une Personne
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
		// pour tester un Compte, il faut encore initialiser un Type_compte et un Statut_compte
		// partie Type_compte
		Type_compte tc = new Type_compte("Test");
		int t_cle = Type_compteDAO.getInstance().create(tc);
		tc.setId_type_cpte(t_cle);
		// partie Statut_compte
		Statut_compte sc = new Statut_compte("Test");
		int sc_cle = Statut_compteDAO.getInstance().create(sc);
		sc.setId_statut_cpte(sc_cle);
		// apres on initialise un Compte_courant selon la Personne qu'on vient d'initialiser
		Compte_courant cc = new Compte_courant(p, tc, sc, 0, datetest, 0);
		int cc_cle = CompteDAO.getInstance().create(cc);
		cc.setId_cpte(cc_cle);
		this.cc = cc;
	}

	@After
	public void clear() {// etre execute apres qu'une teste soit terminee
		VilleDAO.getInstance().delete(this.cc.getSon_hote().getSa_ville());
		StatutDAO.getInstance().delete(this.cc.getSon_hote().getSon_statut());
		PersonneDAO.getInstance().delete(this.cc.getSon_hote());
		Type_compteDAO.getInstance().delete(this.cc.getSon_type_cpte());
		Statut_compteDAO.getInstance().delete(this.cc.getSon_statut_cpte());
		CompteDAO.getInstance().delete(this.cc);
	}

	@Test
	public void testGetInstance() {
		assertTrue(CompteDAO.getInstance() instanceof CompteDAO);
	}

	@Test
	public void testGetById() {
		Compte ccx = CompteDAO.getInstance().getById(this.cc.getId_cpte());// dans CompteDAO, on initialise
		// Compte_courant ou Compte_epargne selon l'id_type_cpte, ici ccx est bien un
		// compte_courant
		assertEquals(this.cc, ccx);
	}

	@Test
	public void testCreate() {
		Compte ccx = CompteDAO.getInstance().getById(this.cc.getId_cpte());// dans CompteDAO, on initialise
		// Compte_courant ou Compte_epargne selon l'id_type_cpte, ici ccx est bien un
		// compte_courant
		assertEquals(this.cc, ccx);
	}

	@Test
	public void testUpdate() {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate datetest = LocalDate.parse("2020/01/01", formatage);
		this.cc.setDate_creation(datetest);
		CompteDAO.getInstance().update(this.cc);
		Compte cx = CompteDAO.getInstance().getById(this.cc.getId_cpte());
		assertEquals(this.cc, cx);
	}

	@Test
	public void testDelete() {
		CompteDAO.getInstance().delete(this.cc);
		assertNull(CompteDAO.getInstance().getById(this.cc.getId_cpte()));
	}

	@Test
	public void testFindAll() {
		assertNotNull(CompteDAO.getInstance().findAll());
	}

}
