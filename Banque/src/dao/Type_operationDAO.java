package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.SQLconnexion;
import pojo.Type_operation;

public class Type_operationDAO implements DAO<Type_operation> {
	private static Type_operationDAO instance;
	private ArrayList<Type_operation> al = new ArrayList<Type_operation>();
	private PreparedStatement reqprep;// requete preparee

	public static Type_operationDAO getInstance() {
		if (instance == null) {
			instance = new Type_operationDAO();
		}
		return instance;
	}

	private Type_operationDAO() {

	}

	@Override
	public Type_operation getById(int id) {
		String req = "select * from TYPE_OPERATION where id_type_op=?";
		Type_operation x1 = null;
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, id);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_type_op");
				String res2 = resset.getString("lib_type_op");
				x1 = new Type_operation(res1, res2);
			}
			return x1;
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return x1;
	}

	@Override
	public int create(Type_operation x1) {
		String req = "insert into TYPE_OPERATION (lib_type_op) values(?)";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req,
					Statement.RETURN_GENERATED_KEYS);
			this.reqprep.setString(1, x1.getLib_type_op());
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
	public void update(Type_operation x1) {
		String req = "Update TYPE_OPERATION set lib_type_op=? where id_type_op=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setString(1, x1.getLib_type_op());
			this.reqprep.setInt(2, x1.getId_type_op());
			this.reqprep.executeUpdate();
			System.out.println("Modifie");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public void delete(Type_operation x1) {
		String req = "delete from TYPE_OPERATION where id_type_op=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, x1.getId_type_op());
			this.reqprep.executeUpdate();
			System.out.println("Supprime");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public ArrayList<Type_operation> findAll() {
		String req = "select * from TYPE_OPERATION";
		this.al.clear();// vider ArrayList
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_type_op");
				String res2 = resset.getString("lib_type_op");
				this.al.add(new Type_operation(res1, res2));
			}
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return this.al;
	}

}
