package pojo;

import java.time.LocalDate;

public class Personne {
	protected int id_pers;// identifiant
	protected String nom, prenom;
	protected LocalDate date_naissance;
	protected String adresse;
	protected Ville sa_ville;// cle etrangere
	protected Sexe son_sexe;// cle etrangere
	protected Statut son_statut;// cle etrangere
	protected String telephone, email, pseudo, mdp;
	protected Employe son_employe;// cle etrangere

	public Personne(int id_pers, String nom, String prenom, LocalDate date_naissance, String adresse, Ville sa_ville,
			Sexe son_sexe, Statut son_statut, String telephone, String email, String pseudo, String mdp,
			Employe son_employe) {
		super();
		this.id_pers = id_pers;
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
		this.adresse = adresse;
		this.sa_ville = sa_ville;
		this.son_sexe = son_sexe;
		this.son_statut = son_statut;
		this.telephone = telephone;
		this.email = email;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.son_employe = son_employe;
	}

	public Personne(String nom, String prenom, LocalDate date_naissance, String adresse, Ville sa_ville, Sexe son_sexe,
			Statut son_statut, String telephone, String email, String pseudo, String mdp, Employe son_employe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
		this.adresse = adresse;
		this.sa_ville = sa_ville;
		this.son_sexe = son_sexe;
		this.son_statut = son_statut;
		this.telephone = telephone;
		this.email = email;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.son_employe = son_employe;
	}

	public Personne() {
		// TODO Auto-generated constructor stub
	}

	public int getId_pers() {
		return id_pers;
	}

	public void setId_pers(int id_pers) {
		this.id_pers = id_pers;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(LocalDate date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Ville getSa_ville() {
		return sa_ville;
	}

	public void setSa_ville(Ville sa_ville) {
		this.sa_ville = sa_ville;
	}

	public Sexe getSon_sexe() {
		return son_sexe;
	}

	public void setSon_sexe(Sexe son_sexe) {
		this.son_sexe = son_sexe;
	}

	public Statut getSon_statut() {
		return son_statut;
	}

	public void setSon_statut(Statut son_statut) {
		this.son_statut = son_statut;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Employe getSon_employe() {
		return son_employe;
	}

	public void setSon_employe(Employe son_employe) {
		this.son_employe = son_employe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((date_naissance == null) ? 0 : date_naissance.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id_pers;
		result = prime * result + ((mdp == null) ? 0 : mdp.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((pseudo == null) ? 0 : pseudo.hashCode());
		result = prime * result + ((sa_ville == null) ? 0 : sa_ville.hashCode());
		result = prime * result + ((son_employe == null) ? 0 : son_employe.hashCode());
		result = prime * result + ((son_sexe == null) ? 0 : son_sexe.hashCode());
		result = prime * result + ((son_statut == null) ? 0 : son_statut.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (date_naissance == null) {
			if (other.date_naissance != null)
				return false;
		} else if (!date_naissance.equals(other.date_naissance))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id_pers != other.id_pers)
			return false;
		if (mdp == null) {
			if (other.mdp != null)
				return false;
		} else if (!mdp.equals(other.mdp))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (pseudo == null) {
			if (other.pseudo != null)
				return false;
		} else if (!pseudo.equals(other.pseudo))
			return false;
		if (sa_ville == null) {
			if (other.sa_ville != null)
				return false;
		} else if (!sa_ville.equals(other.sa_ville))
			return false;
		if (son_employe == null) {
			if (other.son_employe != null)
				return false;
		} else if (!son_employe.equals(other.son_employe))
			return false;
		if (son_sexe == null) {
			if (other.son_sexe != null)
				return false;
		} else if (!son_sexe.equals(other.son_sexe))
			return false;
		if (son_statut == null) {
			if (other.son_statut != null)
				return false;
		} else if (!son_statut.equals(other.son_statut))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Personne [id_pers=" + id_pers + ", nom=" + nom + ", prenom=" + prenom + ", date_naissance="
				+ date_naissance + ", adresse=" + adresse + ", sa_ville=" + sa_ville + ", son_sexe=" + son_sexe
				+ ", son_statut=" + son_statut + ", telephone=" + telephone + ", email=" + email + ", pseudo=" + pseudo
				+ ", mdp=" + mdp + ", son_employe=" + son_employe + "]";
	}

}
