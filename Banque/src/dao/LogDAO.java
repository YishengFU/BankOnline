package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import main.SQLconnexion;
import pojo.Etat_operation;
import pojo.Log;
import pojo.Personne;

public class LogDAO implements DAO<Log> {
	private static LogDAO instance;
	private ArrayList<Log> al = new ArrayList<Log>();
	private PreparedStatement reqprep;// requete preparee

	public static LogDAO getInstance() {
		if (instance == null) {
			instance = new LogDAO();
		}
		return instance;
	}

	private LogDAO() {

	}

	@Override
	public Log getById(int id) {
		String req = "select * from LOG where id_log=?";
		Log x1 = null;
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, id);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_log");
				Personne res2 = PersonneDAO.getInstance().getById(resset.getInt("id_pers"));
				LocalDate res3 = resset.getDate("date_connexion").toLocalDate();
				x1 = new Log(res1, res2, res3);
			}
			return x1;
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return x1;
	}

	@Override
	public int create(Log x1) {
		String req = "insert into LOG (id_pers, date_connexion)" + " values(?,?)";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req,
					Statement.RETURN_GENERATED_KEYS);
			this.reqprep.setInt(1, x1.getSon_hote().getId_pers());
			this.reqprep.setDate(2, java.sql.Date.valueOf(x1.getDate_connexion()));
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
	public void update(Log x1) {
		String req = "Update LOG set id_pers=?, date_connexion=? where id_log=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, x1.getSon_hote().getId_pers());
			this.reqprep.setDate(2, java.sql.Date.valueOf(x1.getDate_connexion()));
			this.reqprep.setInt(3, x1.getId_log());
			this.reqprep.executeUpdate();
			System.out.println("Modifie");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public void delete(Log x1) {
		String req = "delete from LOG where id_log=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, x1.getId_log());
			this.reqprep.executeUpdate();
			System.out.println("Supprime");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public ArrayList<Log> findAll() {
		String req = "select * from LOG";
		this.al.clear();// vider ArrayList
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_log");
				Personne res2 = PersonneDAO.getInstance().getById(resset.getInt("id_pers"));
				LocalDate res3 = resset.getDate("date_connexion").toLocalDate();
				this.al.add(new Log(res1, res2, res3));
			}
			return this.al;
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return this.al;
	}

}
