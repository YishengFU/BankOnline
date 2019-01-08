package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.SQLconnexion;
import pojo.Employe;
import pojo.Personne;
import pojo.Poste;

public class EmployeDAO implements DAO<Employe> {
	private static EmployeDAO instance;
	private ArrayList<Employe> al = new ArrayList<Employe>();
	private PreparedStatement reqprep;// requete preparee

	public static EmployeDAO getInstance() {
		if (instance == null) {
			instance = new EmployeDAO();
		}
		return instance;
	}

	private EmployeDAO() {

	}

	@Override
	public Employe getById(int id) {
		String req = "select * from EMPLOYE where id_employe=?";
		Employe x1 = null;
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, id);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_employe");
				Poste res2 = PosteDAO.getInstance().getById(resset.getInt("id_poste"));
				String res3 = resset.getString("pseudo_emp");
				String res4 = resset.getString("mdp_emp");
				String res5 = resset.getString("email_emp");
				Personne p = PersonneDAO.getInstance().getById(resset.getInt("id_employe"));
				x1 = new Employe(p.getId_pers(), p.getNom(), p.getPrenom(), p.getDate_naissance(), p.getAdresse(),
						p.getSa_ville(), p.getSon_sexe(), p.getSon_statut(), p.getTelephone(), p.getEmail(),
						p.getPseudo(), p.getMdp(), p.getSon_employe(), res1, res2, res3, res4, res5);
			}
			return x1;
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return x1;
	}

	@Override
	public int create(Employe x1) {
		if (x1.getId_employe() != 0) {// insere avec id_employe
			String req = "insert into EMPLOYE (id_employe, id_poste, pseudo_emp, mdp_emp, email_emp) "
					+ "values(?,?,?,?,?)";
			try {
				this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req,
						Statement.RETURN_GENERATED_KEYS);
				this.reqprep.setInt(1, x1.getId_employe());
				this.reqprep.setInt(2, x1.getSon_poste().getId_poste());
				this.reqprep.setString(3, x1.getPseudo_emp());
				this.reqprep.setString(4, x1.getMdp_emp());
				this.reqprep.setString(5, x1.getEmail_emp());
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
		} else {// insere sans id_employe
			String req = "insert into EMPLOYE (id_poste, pseudo_emp, mdp_emp, email_emp) " + "values(?,?,?,?)";
			try {
				this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req,
						Statement.RETURN_GENERATED_KEYS);
				this.reqprep.setInt(1, x1.getSon_poste().getId_poste());
				this.reqprep.setString(2, x1.getPseudo_emp());
				this.reqprep.setString(3, x1.getMdp_emp());
				this.reqprep.setString(4, x1.getEmail_emp());
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
		}
		return -1;
	}

	@Override
	public void update(Employe x1) {
		String req = "Update EMPLOYE set id_poste=?, pseudo_emp=?, mdp_emp=?, email_emp=? where id_employe=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, x1.getSon_poste().getId_poste());
			this.reqprep.setString(2, x1.getPseudo_emp());
			this.reqprep.setString(3, x1.getMdp_emp());
			this.reqprep.setString(4, x1.getEmail_emp());
			this.reqprep.setInt(5, x1.getId_employe());
			this.reqprep.executeUpdate();
			System.out.println("Modifie");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public void delete(Employe x1) {
		String req = "delete from EMPLOYE where id_employe=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, x1.getId_employe());
			this.reqprep.executeUpdate();
			System.out.println("Supprime");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public ArrayList<Employe> findAll() {
		String req = "select * from EMPLOYE";
		this.al.clear();// vider ArrayList
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_employe");
				Poste res2 = PosteDAO.getInstance().getById(resset.getInt("id_poste"));
				String res3 = resset.getString("pseudo_emp");
				String res4 = resset.getString("mdp_emp");
				String res5 = resset.getString("email_emp");
				Personne p = PersonneDAO.getInstance().getById(resset.getInt("id_employe"));
				this.al.add(new Employe(p.getId_pers(), p.getNom(), p.getPrenom(), p.getDate_naissance(),
						p.getAdresse(), p.getSa_ville(), p.getSon_sexe(), p.getSon_statut(), p.getTelephone(),
						p.getEmail(), p.getPseudo(), p.getMdp(), null, res1, res2, res3, res4, res5));
			}
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return this.al;
	}

}
