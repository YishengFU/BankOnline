package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import main.SQLconnexion;
import pojo.Compte;
import pojo.Compte_courant;
import pojo.Compte_epargne;
import pojo.Personne;
import pojo.Statut_compte;
import pojo.Type_compte;

public class CompteDAO implements DAO<Compte> {
	private static CompteDAO instance;
	private ArrayList<Compte> al = new ArrayList<Compte>();
	private PreparedStatement reqprep;// requete preparee

	public static CompteDAO getInstance() {
		if (instance == null) {
			instance = new CompteDAO();
		}
		return instance;
	}

	private CompteDAO() {

	}

	@Override
	public Compte getById(int id) {
		String req = "select * from COMPTE where id_cpte=?";
		Compte x1 = null;
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, id);
			ResultSet resset = reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_cpte");
				Personne res2 = PersonneDAO.getInstance().getById(resset.getInt("id_pers"));
				int id_type_cpte = resset.getInt("id_type_cpte");
				Type_compte res3 = Type_compteDAO.getInstance().getById(id_type_cpte);
				Statut_compte res4 = Statut_compteDAO.getInstance().getById(resset.getInt("id_statut_cpte"));
				double res5 = resset.getDouble("solde");
				double res6 = resset.getDouble("montant_decouvert");
				LocalDate res7 = resset.getDate("date_creation").toLocalDate();
				if (id_type_cpte == 2) {// compte epargne
					double prime = 0;
					int periode = 0;
					x1 = new Compte_epargne(res1, res2, res3, res4, res5, res7, prime, periode);
				} else {// compte courant ou d'autres
					x1 = new Compte_courant(res1, res2, res3, res4, res5, res7, res6);
				}
			}
			return x1;
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return x1;
	}

	@Override
	public int create(Compte x1) {
		String req = "insert into COMPTE (id_pers, id_type_cpte, id_statut_cpte, solde, montant_decouvert"
				+ ", date_creation)" + " values(?,?,?,?,?,?)";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req,
					Statement.RETURN_GENERATED_KEYS);
			this.reqprep.setInt(1, x1.getSon_hote().getId_pers());
			this.reqprep.setInt(2, x1.getSon_type_cpte().getId_type_cpte());
			this.reqprep.setInt(3, x1.getSon_statut_cpte().getId_statut_cpte());
			this.reqprep.setDouble(4, x1.getSolde());
			if (x1.getSon_type_cpte().getId_type_cpte() == 1) {// compte courant
				Compte_courant cc = (Compte_courant) x1;
				System.out.println("ying" + cc.getMontant_decouvert());
				this.reqprep.setDouble(5, cc.getMontant_decouvert());
			} else {// compte epargne ou d'autres
//				Compte_epargne ce=(Compte_epargne)x1;
				this.reqprep.setDouble(5, 0);
			}
			if(x1.getDate_creation()==null) {
				this.reqprep.setDate(6, java.sql.Date.valueOf(LocalDate.now()));
			}else {
				this.reqprep.setDate(6, java.sql.Date.valueOf(x1.getDate_creation()));
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
	
	public int createSimple(int id_pers, int id_type_cpte, int id_statut_cpte) {
		  String req = "insert into COMPTE (id_pers, id_type_cpte, id_statut_cpte, solde, montant_decouvert"
		    + ", date_creation)" + " values(?,?,?,0,0,?)";
		  try {
		   this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req,
		     Statement.RETURN_GENERATED_KEYS);
		   this.reqprep.setInt(1, id_pers);
		   this.reqprep.setInt(2, id_type_cpte);
		   this.reqprep.setInt(3, id_statut_cpte);
		   this.reqprep.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
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
	public void update(Compte x1) {
		String req = "Update COMPTE set id_pers=?, id_type_cpte=?, id_statut_cpte=?, solde=?"
				+ ",montant_decouvert=?, date_creation=?  where id_cpte=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, x1.getSon_hote().getId_pers());
			this.reqprep.setInt(2, x1.getSon_type_cpte().getId_type_cpte());
			this.reqprep.setInt(3, x1.getSon_statut_cpte().getId_statut_cpte());
			this.reqprep.setDouble(4, x1.getSolde());
			if (x1.getSon_type_cpte().getId_type_cpte() == 1) {// compte courant
				Compte_courant cc = (Compte_courant) x1;
				this.reqprep.setDouble(5, cc.getMontant_decouvert());
			} else {// compte epargne ou d'autres
//				Compte_epargne ce=(Compte_epargne)x1;
				this.reqprep.setDouble(5, 0);
			}
			this.reqprep.setDate(6, java.sql.Date.valueOf(x1.getDate_creation()));
			this.reqprep.setInt(7, x1.getId_cpte());
			this.reqprep.executeUpdate();
			System.out.println("Modifie");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public void delete(Compte x1) {
		String req = "delete from COMPTE where id_cpte=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, x1.getId_cpte());
			this.reqprep.executeUpdate();
			System.out.println("Supprime");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public ArrayList<Compte> findAll() {
		String req = "select * from COMPTE";
		this.al.clear();// vider ArrayList
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_cpte");
				Personne res2 = PersonneDAO.getInstance().getById(resset.getInt("id_pers"));
				int id_type_cpte = resset.getInt("id_type_cpte");
				Type_compte res3 = Type_compteDAO.getInstance().getById(id_type_cpte);
				Statut_compte res4 = Statut_compteDAO.getInstance().getById(resset.getInt("id_statut_cpte"));
				double res5 = resset.getDouble("solde");
				double res6 = resset.getDouble("montant_decouvert");
				LocalDate res7 = resset.getDate("date_creation").toLocalDate();
				if (id_type_cpte == 1) {// compte courant
					this.al.add(new Compte_courant(res1, res2, res3, res4, res5, res7, res6));
				} else if (id_type_cpte == 2) {// compte epargne
					double prime = 0;
					int periode = 0;
					this.al.add(new Compte_epargne(res1, res2, res3, res4, res5, res7, prime, periode));
				}
			}
			return this.al;
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return this.al;
	}
	public ArrayList<Compte> findById_pers(int id) {
		  String req = "select * from COMPTE where id_pers=?";
		  this.al.clear();// vider ArrayList
		  try {
		   this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
		   this.reqprep.setInt(1, id);
		   ResultSet resset = this.reqprep.executeQuery();
		   while (resset.next()) {
		    int res1 = resset.getInt("id_cpte");
		    Personne res2 = PersonneDAO.getInstance().getById(id);
		    int id_type_cpte = resset.getInt("id_type_cpte");
		    Type_compte res3 = Type_compteDAO.getInstance().getById(id_type_cpte);
		    Statut_compte res4 = Statut_compteDAO.getInstance().getById(resset.getInt("id_statut_cpte"));
		    double res5 = resset.getDouble("solde");
		    double res6 = resset.getDouble("montant_decouvert");
		    LocalDate res7 = resset.getDate("date_creation").toLocalDate();
		    if (id_type_cpte == 1) {// compte courant
		     this.al.add(new Compte_courant(res1, res2, res3, res4, res5, res7, res6));
		    } else if (id_type_cpte == 2) {// compte epargne
		     double prime = 0;
		     int periode = 0;
		     this.al.add(new Compte_epargne(res1, res2, res3, res4, res5, res7, prime, periode));
		    }
		   }
		   return this.al;
		  } catch (SQLException sqle) {
		   System.out.println("SQL Syntaxe Erreur.");
		   System.out.println(sqle.getMessage());
		  }
		  return this.al;
		 }
}
