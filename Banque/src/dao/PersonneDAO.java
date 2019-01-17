package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import main.SQLconnexion;
import pojo.Employe;
import pojo.Personne;
import pojo.Sexe;
import pojo.Statut;
import pojo.Ville;

public class PersonneDAO implements DAO<Personne> {
	private static PersonneDAO instance;
	private ArrayList<Personne> al = new ArrayList<Personne>();
	private PreparedStatement reqprep;// requete preparee

	public static PersonneDAO getInstance() {
		if (instance == null) {
			instance = new PersonneDAO();
		}
		return instance;
	}

	public PersonneDAO() {

	}

	@Override
	public Personne getById(int id) {
		String req = "select * from PERSONNE where id_pers=?";
		Personne x1 = null;
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, id);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_pers");
				String res2 = resset.getString("nom");
				String res3 = resset.getString("prenom");
				LocalDate res4 = resset.getDate("date_naissance").toLocalDate();
				String res5 = resset.getString("adresse");
				Ville res6 = VilleDAO.getInstance().getById(resset.getInt("id_ville"));
				Sexe res7 = new Sexe(resset.getInt("id_sexe"));
				// comme on n'a que 2 sexes, dans le constructeur de sexe
				// c'est indique qu'on peut initialiser selon id_sexe
				Statut res8 = StatutDAO.getInstance().getById(resset.getInt("id_statut"));
				String res9 = resset.getString("telephone");
				String res10 = resset.getString("email");
				String res11 = resset.getString("pseudo");
				String res12 = resset.getString("mdp");
				Employe res13 = EmployeDAO.getInstance().getById(resset.getInt("id_charge_clientele"));
				x1 = new Personne(res1, res2, res3, res4, res5, res6, res7, res8, res9, res10, res11, res12, res13);
			}
			return x1;
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return x1;
	}

	@Override
	public int create(Personne x1) {
		String req0 = "select * from PERSONNE where pseudo=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req0,
					Statement.RETURN_GENERATED_KEYS);
			this.reqprep.setString(1, x1.getPseudo());
			this.reqprep.executeQuery();
			ResultSet resset = this.reqprep.getGeneratedKeys();
			while (resset.next()) {
				System.out.println("Pseudo existe deja");
				return -1;
			}
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		String req = "insert into PERSONNE (nom, prenom, date_naissance, adresse, id_ville, id_sexe, "
				+ "id_statut, telephone, email, pseudo, mdp, id_charge_clientele) " + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req,
					Statement.RETURN_GENERATED_KEYS);
			this.reqprep.setString(1, x1.getNom());
			this.reqprep.setString(2, x1.getPrenom());
			this.reqprep.setDate(3, java.sql.Date.valueOf(x1.getDate_naissance()));
			this.reqprep.setString(4, x1.getAdresse());
			this.reqprep.setInt(5, x1.getSa_ville().getId_ville());
			this.reqprep.setInt(6, x1.getSon_sexe().getId_sexe());
			this.reqprep.setInt(7, x1.getSon_statut().getId_statut());
			this.reqprep.setString(8, x1.getTelephone());
			this.reqprep.setString(9, x1.getEmail());
			this.reqprep.setString(10, x1.getPseudo());
			this.reqprep.setString(11, x1.getMdp());
			if (x1.getSon_employe() != null) {
				this.reqprep.setInt(12, x1.getSon_employe().getId_employe());
			} else {
				this.reqprep.setNull(12, Types.INTEGER);
			}
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
	public void update(Personne x1) {
		String req = "Update PERSONNE set nom=?, prenom=?, date_naissance=?, adresse=?, id_ville=?, id_sexe=?"
				+ ", id_statut=?, telephone=?, email=?, pseudo=?, mdp=?, id_charge_clientele=? where id_pers=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setString(1, x1.getNom());
			this.reqprep.setString(2, x1.getPrenom());
			this.reqprep.setDate(3, java.sql.Date.valueOf(x1.getDate_naissance()));
			this.reqprep.setString(4, x1.getAdresse());
			this.reqprep.setInt(5, x1.getSa_ville().getId_ville());
			this.reqprep.setInt(6, x1.getSon_sexe().getId_sexe());
			this.reqprep.setInt(7, x1.getSon_statut().getId_statut());
			this.reqprep.setString(8, x1.getTelephone());
			this.reqprep.setString(9, x1.getEmail());
			this.reqprep.setString(10, x1.getPseudo());
			this.reqprep.setString(11, x1.getMdp());
			if (x1.getSon_employe() != null) {
				this.reqprep.setInt(12, x1.getSon_employe().getId_employe());
			} else {
				this.reqprep.setNull(12, Types.INTEGER);
			}
			this.reqprep.setInt(13, x1.getId_pers());
			this.reqprep.executeUpdate();
			System.out.println("Modifie");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public void delete(Personne x1) {
		String req = "delete from PERSONNE where id_pers=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, x1.getId_pers());
			this.reqprep.executeUpdate();
			System.out.println("Supprime");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public ArrayList<Personne> findAll() {
		String req = "select * from PERSONNE";
		this.al.clear();// vider ArrayList
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_pers");
				String res2 = resset.getString("nom");
				String res3 = resset.getString("prenom");
				LocalDate res4 = resset.getDate("date_naissance").toLocalDate();
				String res5 = resset.getString("adresse");
				Ville res6 = VilleDAO.getInstance().getById(resset.getInt("id_ville"));
				Sexe res7 = new Sexe(resset.getInt("id_sexe"));
				// comme on n'a que 2 sexes, dans le constructeur de sexe
				// c'est indique qu'on peut initialiser selon id_sexe
				Statut res8 = StatutDAO.getInstance().getById(resset.getInt("id_statut"));
				String res9 = resset.getString("telephone");
				String res10 = resset.getString("email");
				String res11 = resset.getString("pseudo");
				String res12 = resset.getString("mdp");
				Employe res13 = EmployeDAO.getInstance().getById(resset.getInt("id_charge_clientele"));
				this.al.add(
						new Personne(res1, res2, res3, res4, res5, res6, res7, res8, res9, res10, res11, res12, res13));
			}
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return this.al;
	}

	public Personne login(String pseudo, String mdp) throws SQLException {
		Personne p = null;

		String req = "select * from PERSONNE where pseudo = ? and mdp = ?";
		try {

			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setString(1, pseudo);
			this.reqprep.setString(2, mdp);
			ResultSet resset = this.reqprep.executeQuery();
			if (resset.next()) {

				p = PersonneDAO.getInstance().getById(resset.getInt("id_pers"));
				System.out.println("Login success");
				return p;
			} else {
				System.out.println("Login fail");
			}
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return p;
	}

	public boolean exists(String nom, String prenom, LocalDate date) throws SQLException {
		boolean exists = false;
		String req = "select * from PERSONNE where nom = ? and prenom = ? and date_naissance =?";
		try {

			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setString(1, nom);
			this.reqprep.setString(2, prenom);
			this.reqprep.setDate(3, java.sql.Date.valueOf(date));
			ResultSet resset = this.reqprep.executeQuery();
			if (resset.next()) {

				System.out.println("le client a d茅ja exist");
			} else {
				System.out.println("L'inscription success");
			}
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return exists;

	}

	public boolean estClient(String pseudo, String mdp) {
		boolean client = false;
		String req = "select * from PERSONNE where pseudo=? and mdp=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setString(1, pseudo);
			this.reqprep.setString(2, mdp);
			ResultSet resset = this.reqprep.executeQuery();
			if (resset.next()) {
				client = true;
				System.out.println("C'est un client");
			} else {
				System.out.println("Ce n'est pas un client");
			}
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return client;
	}
}
