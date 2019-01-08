package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.SQLconnexion;
import pojo.Statut;

public class StatutDAO implements DAO<Statut> {
	private static StatutDAO instance;
	private ArrayList<Statut> al = new ArrayList<Statut>();
	private PreparedStatement reqprep;// requete preparee

	public static StatutDAO getInstance() {
		if (instance == null) {
			instance = new StatutDAO();
		}
		return instance;
	}

	private StatutDAO() {

	}

	@Override
	public Statut getById(int id) {
		String req = "select * from STATUT where id_statut=?";
		Statut x1 = null;
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, id);
			ResultSet resset = reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_statut");
				String res2 = resset.getString("lib_statut");
				x1 = new Statut(res1, res2);
			}
			return x1;
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return x1;
	}

	@Override
	public int create(Statut x1) {
		String req = "insert into STATUT (lib_statut) values(?)";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req,
					Statement.RETURN_GENERATED_KEYS);
			this.reqprep.setString(1, x1.getLib_statut());
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
	public void update(Statut x1) {
		String req = "Update STATUT set lib_statut=? where id_statut=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setString(1, x1.getLib_statut());
			this.reqprep.setInt(2, x1.getId_statut());
			this.reqprep.executeUpdate();
			System.out.println("Modifie");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public void delete(Statut x1) {
		String req = "delete from STATUT where id_statut=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, x1.getId_statut());
			this.reqprep.executeUpdate();
			System.out.println("Supprime");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public ArrayList<Statut> findAll() {
		String req = "select * from STATUT";
		this.al.clear();// vider ArrayList
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_statut");
				String res2 = resset.getString("lib_statut");
				this.al.add(new Statut(res1, res2));
			}
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return this.al;
	}

}
