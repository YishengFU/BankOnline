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
import dao.Etat_operationDAO;
import dao.OperationDAO;
import dao.PersonneDAO;
import dao.StatutDAO;
import dao.Statut_compteDAO;
import dao.Type_compteDAO;
import dao.Type_operationDAO;
import dao.VilleDAO;
import main.SQLconnexion;
import pojo.Compte_courant;
import pojo.Etat_operation;
import pojo.Operation;
import pojo.Personne;
import pojo.Sexe;
import pojo.Statut;
import pojo.Statut_compte;
import pojo.Type_compte;
import pojo.Type_operation;
import pojo.Ville;

public class OperationDAOTest {
	private Operation o;

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
		// on initialise une Operation et l'insere dans la bdd pour tester
		// pour tester une Operation, il faut d'abord initialiser 2 Comptes
		// pour tester un Compte, il faut d'abord initialiser une Personne
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
		// pour tester un Compte, il faut encore initialiser un Type_compte et un Statut_compte
		// partie Type_compte
		Type_compte tc = new Type_compte("Test");
		int t_cle = Type_compteDAO.getInstance().create(tc);
		tc.setId_type_cpte(t_cle);
		// partie Statut_compte
		Statut_compte sc = new Statut_compte("Test");
		int sc_cle = Statut_compteDAO.getInstance().create(sc);
		sc.setId_statut_cpte(sc_cle);
		// apres on initialise 2 Compte_courant selon la Personne qu'on vient
		// d'initialiser
		Compte_courant cc1 = new Compte_courant(p, tc, sc, 0, datetest, 0);
		int cc1_cle = CompteDAO.getInstance().create(cc1);
		cc1.setId_cpte(cc1_cle);
		Compte_courant cc2 = new Compte_courant(p, tc, sc, 0, datetest, 0);
		int cc2_cle = CompteDAO.getInstance().create(cc2);
		cc2.setId_cpte(cc2_cle);
		// pour tester une Operation, il faut encore initialiser un Type_operation et un Etat_operation
		// partie Type_operation
		Type_operation to = new Type_operation("Test");
		int to_cle = Type_operationDAO.getInstance().create(to);
		to.setId_type_op(to_cle);
		// partie Etat_operation
		Etat_operation eo = new Etat_operation("Test");
		int cle = Etat_operationDAO.getInstance().create(eo);
		eo.setId_etat(cle);
		// apres on initilise une Operation selon les 2 Compte_courants qu'on vient
		// d'initialiser
		Operation o = new Operation(cc1, cc2, to, "test", 0, datetest, eo);
		int o_cle = OperationDAO.getInstance().create(o);
		o.setId_op(o_cle);
		this.o = o;
	}

	@After
	public void clear() {// etre execute apres qu'une teste soit terminee
		VilleDAO.getInstance().delete(this.o.getCpte_op_but().getSon_hote().getSa_ville());
		StatutDAO.getInstance().delete(this.o.getCpte_op_but().getSon_hote().getSon_statut());
		PersonneDAO.getInstance().delete(this.o.getCpte_op_but().getSon_hote());
		Type_compteDAO.getInstance().delete(this.o.getCpte_op_but().getSon_type_cpte());
		Statut_compteDAO.getInstance().delete(this.o.getCpte_op_but().getSon_statut_cpte());
		CompteDAO.getInstance().delete(this.o.getCpte_op_but());
		CompteDAO.getInstance().delete(this.o.getCpte_op_src());
		Type_operationDAO.getInstance().delete(this.o.getSon_type_op());
		Etat_operationDAO.getInstance().delete(this.o.getSon_etat());
		OperationDAO.getInstance().delete(this.o);
	}

	@Test
	public void testGetInstance() {
		assertTrue(OperationDAO.getInstance() instanceof OperationDAO);
	}

	@Test
	public void testGetById() {
		Operation ox = OperationDAO.getInstance().getById(this.o.getId_op());
		assertEquals(this.o, ox);
	}

	@Test
	public void testCreate() {
		Operation ox = OperationDAO.getInstance().getById(this.o.getId_op());
		assertEquals(this.o, ox);
	}

	@Test
	public void testUpdate() {
		this.o.setMontant(10);
		OperationDAO.getInstance().update(this.o);
		Operation ox = OperationDAO.getInstance().getById(this.o.getId_op());
		assertEquals(this.o, ox);
	}

	@Test
	public void testDelete() {
		OperationDAO.getInstance().delete(this.o);
		assertNull(OperationDAO.getInstance().getById(this.o.getId_op()));
	}

	@Test
	public void testFindAll() {
		assertNotNull(OperationDAO.getInstance().findAll());
	}

}
