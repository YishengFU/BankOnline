package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import main.SQLconnexion;
import pojo.Compte;
import pojo.Etat_operation;
import pojo.Operation;
import pojo.Type_operation;

public class OperationDAO implements DAO<Operation> {
	private static OperationDAO instance;
	private ArrayList<Operation> al = new ArrayList<Operation>();
	private PreparedStatement reqprep;// requete preparee

	public static OperationDAO getInstance() {
		if (instance == null) {
			instance = new OperationDAO();
		}
		return instance;
	}

	private OperationDAO() {

	}

	@Override
	public Operation getById(int id) {
		String req = "select * from OPERATION where id_op=?";
		Operation x1 = null;
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, id);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_op");
				Compte res2 = CompteDAO.getInstance().getById(resset.getInt("cpte_op_src"));
				Compte res3 = CompteDAO.getInstance().getById(resset.getInt("cpte_op_but"));
				Type_operation res4 = Type_operationDAO.getInstance().getById(resset.getInt("id_type_op"));
				String res5 = resset.getString("lib_op");
				double res6 = resset.getDouble("montant");
				LocalDate res7 = resset.getDate("date").toLocalDate();
				Etat_operation res8 = Etat_operationDAO.getInstance().getById(resset.getInt("id_etat"));
				x1 = new Operation(res1, res2, res3, res4, res5, res6, res7, res8);
			}
			return x1;
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return x1;
	}

	@Override
	public int create(Operation x1) {
		String req = "insert into OPERATION (cpte_op_src, cpte_op_but, id_type_op, lib_op, montant, date, id_etat)"
				+ " values(?,?,?,?,?,?,?)";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req,
					Statement.RETURN_GENERATED_KEYS);
			this.reqprep.setInt(1, x1.getCpte_op_src().getId_cpte());
			this.reqprep.setInt(2, x1.getCpte_op_but().getId_cpte());
			this.reqprep.setInt(3, x1.getSon_type_op().getId_type_op());
			this.reqprep.setString(4, x1.getLib_op());
			this.reqprep.setDouble(5, x1.getMontant());
			this.reqprep.setDate(6, java.sql.Date.valueOf(x1.getDate()));
			this.reqprep.setInt(7, x1.getSon_etat().getId_etat());
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
	public void update(Operation x1) {
		String req = "Update OPERATION set cpte_op_src=?, cpte_op_but=?, id_type_op=?, lib_op=?"
				+ ", montant=?, date=?, id_etat=? where id_op=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, x1.getCpte_op_src().getId_cpte());
			this.reqprep.setInt(2, x1.getCpte_op_but().getId_cpte());
			this.reqprep.setInt(3, x1.getSon_type_op().getId_type_op());
			this.reqprep.setString(4, x1.getLib_op());
			this.reqprep.setDouble(5, x1.getMontant());
			this.reqprep.setDate(6, java.sql.Date.valueOf(x1.getDate()));
			this.reqprep.setInt(7, x1.getSon_etat().getId_etat());
			this.reqprep.setInt(8, x1.getId_op());
			this.reqprep.executeUpdate();
			System.out.println("Modifie");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public void delete(Operation x1) {
		String req = "delete from OPERATION where id_op=?";
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, x1.getId_op());
			this.reqprep.executeUpdate();
			System.out.println("Supprime");
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
	}

	@Override
	public ArrayList<Operation> findAll() {
		String req = "select * from OPERATION";
		this.al.clear();// vider ArrayList
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_op");
				Compte res2 = CompteDAO.getInstance().getById(resset.getInt("cpte_op_src"));
				Compte res3 = CompteDAO.getInstance().getById(resset.getInt("cpte_op_but"));
				Type_operation res4 = Type_operationDAO.getInstance().getById(resset.getInt("id_type_op"));
				String res5 = resset.getString("lib_op");
				double res6 = resset.getDouble("montant");
				LocalDate res7 = resset.getDate("date").toLocalDate();
				Etat_operation res8 = Etat_operationDAO.getInstance().getById(resset.getInt("id_etat"));
				this.al.add(new Operation(res1, res2, res3, res4, res5, res6, res7, res8));
			}
			return this.al;
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return this.al;
	}
	
	public ArrayList<Operation> findById_pers(int id_pers) {
		String req = "select * from COMPTE c, OPERATION o where c.id_pers=? and (c.id_cpte=o.cpte_op_src or"
				+" c.id_cpte=o.cpte_op_but)";
		this.al.clear();// vider ArrayList
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, id_pers);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_op");
				Compte res2 = CompteDAO.getInstance().getById(resset.getInt("cpte_op_src"));
				Compte res3 = CompteDAO.getInstance().getById(resset.getInt("cpte_op_but"));
				Type_operation res4 = Type_operationDAO.getInstance().getById(resset.getInt("id_type_op"));
				String res5 = resset.getString("lib_op");
				double res6 = resset.getDouble("montant");
				LocalDate res7 = resset.getDate("date").toLocalDate();
				Etat_operation res8 = Etat_operationDAO.getInstance().getById(resset.getInt("id_etat"));
				this.al.add(new Operation(res1, res2, res3, res4, res5, res6, res7, res8));
			}
			return this.al;
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return this.al;
	}
	
	public ArrayList<Operation> findById_cpte(int id_cpte) {
		String req = "select * from OPERATION o where o.cpte_op_src=? or o.cpte_op_but=?";
		this.al.clear();// vider ArrayList
		try {
			this.reqprep = SQLconnexion.getInstance().creeConnexion().prepareStatement(req);
			this.reqprep.setInt(1, id_cpte);
			this.reqprep.setInt(2, id_cpte);
			ResultSet resset = this.reqprep.executeQuery();
			while (resset.next()) {
				int res1 = resset.getInt("id_op");
				Compte res2 = CompteDAO.getInstance().getById(resset.getInt("cpte_op_src"));
				Compte res3 = CompteDAO.getInstance().getById(resset.getInt("cpte_op_but"));
				Type_operation res4 = Type_operationDAO.getInstance().getById(resset.getInt("id_type_op"));
				String res5 = resset.getString("lib_op");
				double res6 = resset.getDouble("montant");
				LocalDate res7 = resset.getDate("date").toLocalDate();
				Etat_operation res8 = Etat_operationDAO.getInstance().getById(resset.getInt("id_etat"));
				this.al.add(new Operation(res1, res2, res3, res4, res5, res6, res7, res8));
			}
			return this.al;
		} catch (SQLException sqle) {
			System.out.println("SQL Syntaxe Erreur.");
			System.out.println(sqle.getMessage());
		}
		return this.al;
	}
	
	public boolean virement(int id_cpte_src, int id_cpte_but, double montant) {
		Compte cpte_src = CompteDAO.getInstance().getById(id_cpte_src);
		Compte cpte_but = CompteDAO.getInstance().getById(id_cpte_but);
		System.out.println("ying1"+cpte_src);
		System.out.println("ying2"+cpte_but);
		Type_operation to = Type_operationDAO.getInstance().getById(3);// virement
		LocalDate date = LocalDate.now();
		String lib_op = to.getLib_type_op() + " de " + montant + " euros de compte " + cpte_src.getId_cpte()
				+ " au compte " + cpte_but.getId_cpte() + date.toString();
		Etat_operation eo=Etat_operationDAO.getInstance().getById(1);//en cours
		Operation o1 = new Operation(cpte_src, cpte_but, to, lib_op, montant, date, eo);
		System.out.println("ying3"+o1);
		cpte_src.setSolde(cpte_src.getSolde()-montant);
		cpte_but.setSolde(cpte_but.getSolde()+montant);
		CompteDAO.getInstance().update(cpte_src);
		CompteDAO.getInstance().update(cpte_but);
		if(OperationDAO.getInstance().create(o1)!=0) {
			System.out.println("virement reussi");
			return true;
		}
		return false;
	}
	
}
