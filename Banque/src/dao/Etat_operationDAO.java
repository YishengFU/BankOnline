package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.SQLconnexion;
import pojo.Etat_operation;

public class Etat_operationDAO implements DAO<Etat_operation> {
	private static Etat_operationDAO instance;
	private ArrayList<Etat_operation> al = new ArrayList<Etat_operation>();
	private PreparedStatement reqprep;// requete preparee

	public static Etat_operationDAO getInstance() {
		if (instance == null) {
			instance = new Etat_operationDAO();
		}
		return instance;
	}

	private Etat_operationDAO() {

	}

	@Override
	public Etat_operation getById(int id) {
		String req = "select * from ETAT_OPERATION where id_etat=?";
		Etat_operation x1 = null;
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, id);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_etat");
				String res2 = resset.getString("lib_etat");
				x1 = new Etat_operation(res1, res2);
			}
			return x1;
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return x1;
	}

	@Override
	public int create(Etat_operation x1) {
		String req = "insert into ETAT_OPERATION (lib_etat) values(?)";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req,
					Statement.RETURN_GENERATED_KEYS);
			this.reqprep.setString(1, x1.getLib_etat());
			this.reqprep.executeUpdate();
			ResultSet resset = this.reqprep.getGeneratedKeys();
			while (resset.next()) {
				System.out.println("Ajoute");
				return resset.getInt(1);
			}
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return -1;
	}

	@Override
	public void update(Etat_operation x1) {
		String req = "Update ETAT_OPERATION set lib_etat=? where id_etat=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setString(1, x1.getLib_etat());
			this.reqprep.setInt(2, x1.getId_etat());
			this.reqprep.executeUpdate();
			System.out.println("Modifie");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public void delete(Etat_operation x1) {
		String req = "delete from ETAT_OPERATION where id_etat=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, x1.getId_etat());
			this.reqprep.executeUpdate();
			System.out.println("Supprime");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public ArrayList<Etat_operation> findAll() {
		String req = "select * from ETAT_OPERATION";
		this.al.clear();// vider ArrayList
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_etat");
				String res2 = resset.getString("lib_etat");
				this.al.add(new Etat_operation(res1, res2));
			}
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return this.al;
	}

}
