package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.SQLconnexion;
import pojo.Ville;

public class VilleDAO implements DAO<Ville> {
	private static VilleDAO instance;
	private ArrayList<Ville> al = new ArrayList<Ville>();
	private PreparedStatement reqprep;// requete preparee

	public static VilleDAO getInstance() {
		if (instance == null) {
			instance = new VilleDAO();
		}
		return instance;
	}

	private VilleDAO() {

	}

	@Override
	public Ville getById(int id) {
		String req = "select * from VILLE where id_ville=?";
		Ville x1 = null;
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, id);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_ville");
				String res2 = resset.getString("lib_ville");
				String res3 = resset.getString("pays");
				x1 = new Ville(res1, res2, res3);
			}
			return x1;
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return x1;
	}

	@Override
	public int create(Ville x1) {
		String req = "insert into VILLE (lib_ville, pays) values(?,?)";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req,
					Statement.RETURN_GENERATED_KEYS);
			this.reqprep.setString(1, x1.getLib_ville());
			this.reqprep.setString(2, x1.getPays());
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
	public void update(Ville x1) {
		String req = "Update VILLE set lib_ville=?, pays=? where id_ville=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setString(1, x1.getLib_ville());
			this.reqprep.setString(2, x1.getPays());
			this.reqprep.setInt(3, x1.getId_ville());
			this.reqprep.executeUpdate();
			System.out.println("Modifie");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public void delete(Ville x1) {
		String req = "delete from VILLE where id_ville=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, x1.getId_ville());
			this.reqprep.executeUpdate();
			System.out.println("Supprime");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public ArrayList<Ville> findAll() {
		String req = "select * from VILLE";
		this.al.clear();// vider ArrayList
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_ville");
				String res2 = resset.getString("lib_ville");
				String res3 = resset.getString("pays");
				this.al.add(new Ville(res1, res2, res3));
			}
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return this.al;
	}

}
