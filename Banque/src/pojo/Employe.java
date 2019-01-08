package pojo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Employe extends Personne {
	private int id_employe;// identifiant
	private Poste son_poste;// cle etrangere
	private String pseudo_emp, mdp_emp, email_emp;
	private ArrayList<Personne> liste;
	// dans laquelle on sauvegarde les clients qu'un employe se charge

	public Employe(int id_pers, String nom, String prenom, LocalDate date_naissance, String adresse, Ville sa_ville,
			Sexe son_sexe, Statut son_statut, String telephone, String email, String pseudo, String mdp,
			Employe son_employe, int id_employe, Poste son_poste, String pseudo_emp, String mdp_emp, String email_emp) {
		super(id_pers, nom, prenom, date_naissance, adresse, sa_ville, son_sexe, son_statut, telephone, email, pseudo,
				mdp, son_employe);
		this.id_employe = id_employe;
		this.son_poste = son_poste;
		this.pseudo_emp = pseudo_emp;
		this.mdp_emp = mdp_emp;
		this.email_emp = email_emp;
		this.liste = new ArrayList<Personne>();
	}

	public Employe(int id_pers, String nom, String prenom, LocalDate date_naissance, String adresse, Ville sa_ville,
			Sexe son_sexe, Statut son_statut, String telephone, String email, String pseudo, String mdp,
			Employe son_employe, Poste son_poste, String pseudo_emp, String mdp_emp, String email_emp) {
		super(id_pers, nom, prenom, date_naissance, adresse, sa_ville, son_sexe, son_statut, telephone, email, pseudo,
				mdp, son_employe);
		this.son_poste = son_poste;
		this.pseudo_emp = pseudo_emp;
		this.mdp_emp = mdp_emp;
		this.email_emp = email_emp;
		this.liste = new ArrayList<Personne>();
	}

	public int getId_employe() {
		return id_employe;
	}

	public void setId_employe(int id_employe) {
		this.id_employe = id_employe;
	}

	public Poste getSon_poste() {
		return son_poste;
	}

	public void setSon_poste(Poste son_poste) {
		this.son_poste = son_poste;
	}

	public String getPseudo_emp() {
		return pseudo_emp;
	}

	public void setPseudo_emp(String pseudo_emp) {
		this.pseudo_emp = pseudo_emp;
	}

	public String getMdp_emp() {
		return mdp_emp;
	}

	public void setMdp_emp(String mdp_emp) {
		this.mdp_emp = mdp_emp;
	}

	public String getEmail_emp() {
		return email_emp;
	}

	public void setEmail_emp(String email_emp) {
		this.email_emp = email_emp;
	}

	public ArrayList<Personne> getListe() {
		return liste;
	}

	public void setListe(ArrayList<Personne> liste) {
		this.liste = liste;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email_emp == null) ? 0 : email_emp.hashCode());
		result = prime * result + id_employe;
		result = prime * result + ((liste == null) ? 0 : liste.hashCode());
		result = prime * result + ((mdp_emp == null) ? 0 : mdp_emp.hashCode());
		result = prime * result + ((pseudo_emp == null) ? 0 : pseudo_emp.hashCode());
		result = prime * result + ((son_poste == null) ? 0 : son_poste.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employe other = (Employe) obj;
		if (email_emp == null) {
			if (other.email_emp != null)
				return false;
		} else if (!email_emp.equals(other.email_emp))
			return false;
		if (id_employe != other.id_employe)
			return false;
		if (liste == null) {
			if (other.liste != null)
				return false;
		} else if (!liste.equals(other.liste))
			return false;
		if (mdp_emp == null) {
			if (other.mdp_emp != null)
				return false;
		} else if (!mdp_emp.equals(other.mdp_emp))
			return false;
		if (pseudo_emp == null) {
			if (other.pseudo_emp != null)
				return false;
		} else if (!pseudo_emp.equals(other.pseudo_emp))
			return false;
		if (son_poste == null) {
			if (other.son_poste != null)
				return false;
		} else if (!son_poste.equals(other.son_poste))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employe [id_employe=" + id_employe + ", son_poste=" + son_poste + ", pseudo_emp=" + pseudo_emp
				+ ", mdp_emp=" + mdp_emp + ", email_emp=" + email_emp + ", liste=" + liste + ", id_pers=" + id_pers
				+ ", nom=" + nom + ", prenom=" + prenom + ", date_naissance=" + date_naissance + ", adresse=" + adresse
				+ ", sa_ville=" + sa_ville + ", son_sexe=" + son_sexe + ", son_statut=" + son_statut + ", telephone="
				+ telephone + ", email=" + email + ", pseudo=" + pseudo + ", mdp=" + mdp + ", son_employe="
				+ son_employe + "]";
	}// c'est un toString qui va imprimer les attibuts de personne aussi

//	@Override
//	public String toString() {
//		return "Employe [id_employe=" + id_employe + ", son_poste=" + son_poste + ", pseudo_emp=" + pseudo_emp
//				+ ", mdp_emp=" + mdp_emp + ", email_emp=" + email_emp + ", liste=" + liste + "]";
//	}

}