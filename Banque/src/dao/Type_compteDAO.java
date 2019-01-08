package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.SQLconnexion;
import pojo.Type_compte;

public class Type_compteDAO implements DAO<Type_compte> {
	private static Type_compteDAO instance;
	private ArrayList<Type_compte> al = new ArrayList<Type_compte>();
	private PreparedStatement reqprep;// requete preparee

	public static Type_compteDAO getInstance() {
		if (instance == null) {
			instance = new Type_compteDAO();
		}
		return instance;
	}

	private Type_compteDAO() {

	}

	@Override
	public Type_compte getById(int id) {
		String req = "select * from TYPE_COMPTE where id_type_cpte=?";
		Type_compte x1 = null;
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, id);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_type_cpte");
				String res2 = resset.getString("lib_type_cpte");
				x1 = new Type_compte(res1, res2);
			}
			return x1;
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return x1;
	}

	@Override
	public int create(Type_compte x1) {
		String req = "insert into TYPE_COMPTE (lib_type_cpte) values(?)";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req,
					Statement.RETURN_GENERATED_KEYS);
			this.reqprep.setString(1, x1.getLib_type_cpte());
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
	public void update(Type_compte x1) {
		String req = "Update TYPE_COMPTE set lib_type_cpte=? where id_type_cpte=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setString(1, x1.getLib_type_cpte());
			this.reqprep.setInt(2, x1.getId_type_cpte());
			this.reqprep.executeUpdate();
			System.out.println("Modifie");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public void delete(Type_compte x1) {
		String req = "delete from TYPE_COMPTE where id_type_cpte=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, x1.getId_type_cpte());
			this.reqprep.executeUpdate();
			System.out.println("Supprime");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public ArrayList<Type_compte> findAll() {
		String req = "select * from TYPE_COMPTE";
		this.al.clear();// vider ArrayList
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_type_cpte");
				String res2 = resset.getString("lib_type_cpte");
				this.al.add(new Type_compte(res1, res2));
			}
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return this.al;
	}

}
