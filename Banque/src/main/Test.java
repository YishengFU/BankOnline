package main;

import pojo.*;

import java.time.LocalDate;

import dao.*;

public class Test {

	public static void main(String[] args) {
		System.out.println("Bonjour");
		SQLconnexion.getInstance();
//		System.out.println(VilleDAO.getInstance().findAll());
//		System.out.println(Type_operationDAO.getInstance().findAll());
//		System.out.println(Type_compteDAO.getInstance().findAll());
//		System.out.println(StatutDAO.getInstance().findAll());
//		System.out.println(Statut_compteDAO.getInstance().findAll());
//		System.out.println(PosteDAO.getInstance().findAll());
//		System.out.println(PersonneDAO.getInstance().findAll());
//		System.out.println(EmployeDAO.getInstance().findAll());
//		System.out.println(OperationDAO.getInstance().findAll());
//		System.out.println(LogDAO.getInstance().findAll().toString());???
//		System.out.println(LogDAO.getInstance().getById(1));
//		System.out.println(LogDAO.getInstance().getById(2));
//		System.out.println(Etat_operationDAO.getInstance().findAll());
//		System.out.println(CritereDAO.getInstance().findAll());
//		System.out.println(Compte_epargneDAO.getInstance().findAll());
//		System.out.println(Compte_courantDAO.getInstance().findAll());
//		VilleDAO.getInstance().create(new Ville("Nancy", "FRANCE"));
//		Type_operationDAO.getInstance().create(new Type_operation("wait to delete"));
//		Type_compteDAO.getInstance().create(new Type_compte("wait to delete"));
//		StatutDAO.getInstance().create(new Statut("wait to delete"));
//		Statut_compteDAO.getInstance().create(new Statut_compte("wait to delete"));
//		PosteDAO.getInstance().create(new Poste("wait to delete", 789));
//		PersonneDAO.getInstance().create(PersonneDAO.getInstance().getById(1));
//		EmployeDAO.getInstance().create(EmployeDAO.getInstance().getById(2));
//		OperationDAO.getInstance().create(OperationDAO.getInstance().getById(1));
//		LogDAO.getInstance().create(LogDAO.getInstance().getById(1));
//		Etat_operationDAO.getInstance().create(Etat_operationDAO.getInstance().getById(1));
//		VilleDAO.getInstance().update(new Ville(3, "Nancy", "FRAN"));
//		Type_operationDAO.getInstance().update(new Type_operation(6, "wait.."));
//		Type_compteDAO.getInstance().update(new Type_compte(3, "wait.."));
//		StatutDAO.getInstance().update(new Statut(6, "wait.."));
//		Statut_compteDAO.getInstance().update(new Statut_compte(5, "wait.."));
//		PosteDAO.getInstance().update(new Poste(4, "wait..", 789));
//		Personne p=PersonneDAO.getInstance().getById(4);
//		p.setId_pers(3);
//		PersonneDAO.getInstance().update(p);
//		Employe e=EmployeDAO.getInstance().getById(3);
//		e.setPseudo_emp("je sais pas");
//		EmployeDAO.getInstance().update(e);
//		OperationDAO.getInstance().create(OperationDAO.getInstance().getById(1));
//		Log l=LogDAO.getInstance().getById(2);
//		l.setSon_hote(PersonneDAO.getInstance().getById(3));
//		LogDAO.getInstance().update(l);
//		Etat_operation e=Etat_operationDAO.getInstance().getById(4);
//		e.setLib_etat("ying");
//		Etat_operationDAO.getInstance().update(e);
//		Critere c=CritereDAO.getInstance().getById(2);
//		c.setValeur("1000");
//		CritereDAO.getInstance().update(c);
//		VilleDAO.getInstance().delete(VilleDAO.getInstance().getById(3));
//		Type_operationDAO.getInstance().delete(Type_operationDAO.getInstance().getById(7));
//		Type_compteDAO.getInstance().delete(Type_compteDAO.getInstance().getById(3));
//		StatutDAO.getInstance().delete(StatutDAO.getInstance().getById(6));
//		Statut_compteDAO.getInstance().delete(Statut_compteDAO.getInstance().getById(5));
//		PosteDAO.getInstance().delete(PosteDAO.getInstance().getById(4));
//		PersonneDAO.getInstance().delete(PersonneDAO.getInstance().getById(4));
//		EmployeDAO.getInstance().delete(EmployeDAO.getInstance().getById(3));
//		OperationDAO.getInstance().create(OperationDAO.getInstance().getById(1));
//		LogDAO.getInstance().delete(LogDAO.getInstance().getById(4));
//		Etat_operationDAO.getInstance().delete(Etat_operationDAO.getInstance().getById(4));
//		CritereDAO.getInstance().delete(CritereDAO.getInstance().getById(4));
//		System.out.println(OperationDAO.getInstance().getById(2));
//		System.out.println(CompteDAO.getInstance().findAll());
//		Compte c=CompteDAO.getInstance().getById(2);
//		c.setId_cpte(4);
//		CompteDAO.getInstance().delete(CompteDAO.getInstance().getById(4));
//		System.out.println(OperationDAO.getInstance().findAll());
//		System.out.println(OperationDAO.getInstance().getById(1));
//		Operation o=OperationDAO.getInstance().getById(2);
//		o.setId_op(3);
//		o.setLib_op("yingying");
//		o.setMontant(10000);
//		OperationDAO.getInstance().update(o);
//		OperationDAO.getInstance().delete(OperationDAO.getInstance().getById(3));
		System.out.println(PersonneDAO.getInstance().getById(2));
		
	}

}
