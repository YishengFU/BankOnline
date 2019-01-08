package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.SQLconnexion;
import pojo.Statut_compte;

public class Statut_compteDAO implements DAO<Statut_compte> {
	private static Statut_compteDAO instance;
	private ArrayList<Statut_compte> al = new ArrayList<Statut_compte>();
	private PreparedStatement reqprep;// requete preparee

	public static Statut_compteDAO getInstance() {
		if (instance == null) {
			instance = new Statut_compteDAO();
		}
		return instance;
	}

	private Statut_compteDAO() {

	}

	@Override
	public Statut_compte getById(int id) {
		String req = "select * from STATUT_COMPTE where id_statut_cpte=?";
		Statut_compte x1 = null;
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, id);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_statut_cpte");
				String res2 = resset.getString("lib_statut_cpte");
				x1 = new Statut_compte(res1, res2);
			}
			return x1;
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return x1;
	}

	@Override
	public int create(Statut_compte x1) {
		String req = "insert into STATUT_COMPTE (lib_statut_cpte) values(?)";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req,
					Statement.RETURN_GENERATED_KEYS);
			this.reqprep.setString(1, x1.getLib_statut_cpte());
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
	public void update(Statut_compte x1) {
		String req = "Update STATUT_COMPTE set lib_statut_cpte=? where id_statut_cpte=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setString(1, x1.getLib_statut_cpte());
			this.reqprep.setInt(2, x1.getId_statut_cpte());
			this.reqprep.executeUpdate();
			System.out.println("Modifie");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public void delete(Statut_compte x1) {
		String req = "delete from STATUT_COMPTE where id_statut_cpte=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, x1.getId_statut_cpte());
			this.reqprep.executeUpdate();
			System.out.println("Supprime");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public ArrayList<Statut_compte> findAll() {
		String req = "select * from STATUT_COMPTE";
		this.al.clear();// vider ArrayList
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_statut_cpte");
				String res2 = resset.getString("lib_statut_cpte");
				this.al.add(new Statut_compte(res1, res2));
			}
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return this.al;
	}

}
