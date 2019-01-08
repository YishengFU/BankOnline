package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.SQLconnexion;
import pojo.Critere;
import pojo.Personne;

public class CritereDAO implements DAO<Critere> {
	private static CritereDAO instance;
	private ArrayList<Critere> al = new ArrayList<Critere>();
	private PreparedStatement reqprep;// requete preparee

	public static CritereDAO getInstance() {
		if (instance == null) {
			instance = new CritereDAO();
		}
		return instance;
	}

	private CritereDAO() {

	}

	@Override
	public Critere getById(int id) {
		String req = "select * from CRITERE where id_critere=?";
		Critere x1 = null;
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, id);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_critere");
				Personne res2 = PersonneDAO.getInstance().getById(resset.getInt("id_pers"));
				String res3 = resset.getString("valeur");
				String res4 = resset.getString("operateur");
				String res5 = resset.getString("lib_critere");
				x1 = new Critere(res1, res2, res3, res4, res5);
			}
			return x1;
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return x1;
	}

	@Override
	public int create(Critere x1) {
		String req = "insert into CRITERE (id_pers, valeur, operateur, lib_critere) " + "values(?,?,?,?)";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req,
					Statement.RETURN_GENERATED_KEYS);
			this.reqprep.setInt(1, x1.getSon_hote().getId_pers());
			this.reqprep.setString(2, x1.getValeur());
			this.reqprep.setString(3, x1.getOperateur());
			this.reqprep.setString(4, x1.getLib_critere());
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
	public void update(Critere x1) {
		String req = "Update CRITERE set id_pers=?, valeur=?, operateur=?, lib_critere=? where id_critere=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, x1.getSon_hote().getId_pers());
			this.reqprep.setString(2, x1.getValeur());
			this.reqprep.setString(3, x1.getOperateur());
			this.reqprep.setString(4, x1.getLib_critere());
			this.reqprep.setInt(5, x1.getId_critere());
			this.reqprep.executeUpdate();
			System.out.println("Modifie");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public void delete(Critere x1) {
		String req = "delete from CRITERE where id_critere=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, x1.getId_critere());
			this.reqprep.executeUpdate();
			System.out.println("Supprime");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public ArrayList<Critere> findAll() {
		String req = "select * from CRITERE";
		this.al.clear();// vider ArrayList
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_critere");
				Personne res2 = PersonneDAO.getInstance().getById(resset.getInt("id_pers"));
				String res3 = resset.getString("valeur");
				String res4 = resset.getString("operateur");
				String res5 = resset.getString("lib_critere");
				this.al.add(new Critere(res1, res2, res3, res4, res5));
			}
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return this.al;
	}

}
