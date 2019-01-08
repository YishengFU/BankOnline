package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.SQLconnexion;
import pojo.Poste;

public class PosteDAO implements DAO<Poste> {
	private static PosteDAO instance;
	private ArrayList<Poste> al = new ArrayList<Poste>();
	private PreparedStatement reqprep;// requete preparee

	public static PosteDAO getInstance() {
		if (instance == null) {
			instance = new PosteDAO();
		}
		return instance;
	}

	private PosteDAO() {

	}

	@Override
	public Poste getById(int id) {
		String req = "select * from POSTE where id_poste=?";
		Poste x1 = null;
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, id);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_poste");
				String res2 = resset.getString("lib_poste");
				int res3 = resset.getInt("droit");
				x1 = new Poste(res1, res2, res3);
			}
			return x1;
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return x1;
	}

	@Override
	public int create(Poste x1) {
		String req = "insert into POSTE (lib_poste, droit) values(?,?)";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req,
					Statement.RETURN_GENERATED_KEYS);
			this.reqprep.setString(1, x1.getLib_poste());
			this.reqprep.setInt(2, x1.getDroit());
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
	public void update(Poste x1) {
		String req = "Update POSTE set lib_poste=?, droit=? where id_poste=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setString(1, x1.getLib_poste());
			this.reqprep.setInt(2, x1.getDroit());
			this.reqprep.setInt(3, x1.getId_poste());
			this.reqprep.executeUpdate();
			System.out.println("Modifie");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public void delete(Poste x1) {
		String req = "delete from POSTE where id_poste=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, x1.getId_poste());
			this.reqprep.executeUpdate();
			System.out.println("Supprime");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public ArrayList<Poste> findAll() {
		String req = "select * from POSTE";
		this.al.clear();// vider ArrayList
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_poste");
				String res2 = resset.getString("lib_poste");
				int res3 = resset.getInt("droit");
				this.al.add(new Poste(res1, res2, res3));
			}
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return this.al;
	}

}
