package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.Type_operationDAO;
import main.SQLconnexion;
import pojo.Type_operation;

public class Type_operationDAOTest {
	private Type_operation to;

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
		// on initialise un Type_operation et l'insere dans la bdd pour tester
		Type_operation to = new Type_operation("Test");
		int cle = Type_operationDAO.getInstance().create(to);
		to.setId_type_op(cle);
		this.to = to;
	}

	@After
	public void clear() {// etre execute apres qu'une teste soit terminee
		Type_operationDAO.getInstance().delete(this.to);
	}

	@Test
	public void testGetInstance() {
		assertTrue(Type_operationDAO.getInstance() instanceof Type_operationDAO);
	}

	@Test
	public void testGetById() {
		Type_operation tox = Type_operationDAO.getInstance().getById(this.to.getId_type_op());
		assertEquals(to, tox);
	}

	@Test
	public void testCreate() {
		Type_operation tox = Type_operationDAO.getInstance().getById(this.to.getId_type_op());
		assertEquals(to, tox);
	}

	@Test
	public void testUpdate() {
		this.to.setLib_type_op("Test for update");
		Type_operationDAO.getInstance().update(this.to);
		Type_operation tox = Type_operationDAO.getInstance().getById(this.to.getId_type_op());
		assertEquals(to, tox);
	}

	@Test
	public void testDelete() {
		Type_operationDAO.getInstance().delete(this.to);
		assertNull(Type_operationDAO.getInstance().getById(this.to.getId_type_op()));
	}

	@Test
	public void testFindAll() {
		assertNotNull(Type_operationDAO.getInstance().findAll());
	}

}
