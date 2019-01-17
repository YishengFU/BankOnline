package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.EmployeDAO;
import dao.PersonneDAO;
import dao.PosteDAO;
import dao.StatutDAO;
import dao.VilleDAO;
import main.SQLconnexion;
import pojo.Employe;
import pojo.Personne;
import pojo.Poste;
import pojo.Sexe;
import pojo.Statut;
import pojo.Ville;

public class EmployeDAOTest {
	private Employe e;

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
		// on initialise un Employe et l'insere dans la bdd pour tester
		// pour test un employe, il faut d'abord initialiser une Personne
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
		// pour tester un employer, il faut ensuite initialiser un Poste
		Poste po = new Poste("Test", 111);
		int po_cle = PosteDAO.getInstance().create(po);
		po.setId_poste(po_cle);
		// apres on initialise un Employe selon l'id_pers qu'on vient d'initialiser
		Employe e = new Employe(p_cle, "Test", "test", datetest, "test", v, new Sexe(1), s, "test", "test", "test",
				"test", null, p_cle, po, "test", "test", "test");// Sexe(1): Masculin, defini dans POJO
		int e_cle = EmployeDAO.getInstance().create(e);
		e.setId_employe(e_cle);// normalement id_employe est egale a id_pers de Personne
		this.e = e;
	}

	@After
	public void clear() {// etre execute apres qu'une teste soit terminee
		VilleDAO.getInstance().delete(this.e.getSa_ville());
		StatutDAO.getInstance().delete(this.e.getSon_statut());
		PersonneDAO.getInstance().delete(this.e);
		EmployeDAO.getInstance().delete(this.e);
	}

	@Test
	public void testGetInstance() {
		assertTrue(EmployeDAO.getInstance() instanceof EmployeDAO);
	}

	@Test
	public void testGetById() {
		Employe ex = EmployeDAO.getInstance().getById(this.e.getId_employe());
		assertEquals(e, ex);
	}

	@Test
	public void testCreate() {
		Employe ex = EmployeDAO.getInstance().getById(this.e.getId_employe());
		assertEquals(e, ex);
	}

	@Test
	public void testUpdate() {
		this.e.setPseudo_emp("Test for update");
		EmployeDAO.getInstance().update(this.e);
		Employe ex = EmployeDAO.getInstance().getById(this.e.getId_employe());
		assertEquals(this.e, ex);
	}

	@Test
	public void testDelete() {
		EmployeDAO.getInstance().delete(this.e);
		assertNull(EmployeDAO.getInstance().getById(this.e.getId_employe()));
	}

	@Test
	public void testFindAll() {
		assertNotNull(EmployeDAO.getInstance().findAll());
	}

}
