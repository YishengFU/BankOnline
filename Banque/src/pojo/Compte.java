package pojo;

import java.time.LocalDate;

public abstract class Compte {
	protected int id_cpte;// identifiant
	protected Personne son_hote;// cle etrangere
	protected Type_compte son_type_cpte;// cle etrangere
	protected Statut_compte son_statut_cpte;// cle etrangere
	protected double solde;// a modifier, attribut "taux_interet"
	protected LocalDate date_creation;

	public Compte(int id_cpte, Personne son_hote, Type_compte son_type_cpte, Statut_compte son_statut_cpte,
			double solde, LocalDate date_creation) {
		super();
		this.id_cpte = id_cpte;
		this.son_hote = son_hote;
		this.son_type_cpte = son_type_cpte;
		this.son_statut_cpte = son_statut_cpte;
		this.solde = solde;
		this.date_creation = date_creation;
	}

	public Compte(Personne son_hote, Type_compte son_type_cpte, Statut_compte son_statut_cpte, double solde,
			LocalDate date_creation) {
		super();
		this.son_hote = son_hote;
		this.son_type_cpte = son_type_cpte;
		this.son_statut_cpte = son_statut_cpte;
		this.solde = solde;
		this.date_creation = date_creation;
	}
	public Compte() {
		
	}
	public int getId_cpte() {
		return id_cpte;
	}

	public void setId_cpte(int id_cpte) {
		this.id_cpte = id_cpte;
	}

	public Personne getSon_hote() {
		return son_hote;
	}

	public void setSon_hote(Personne son_hote) {
		this.son_hote = son_hote;
	}

	public Type_compte getSon_type_cpte() {
		return son_type_cpte;
	}

	public void setSon_type_cpte(Type_compte son_type_cpte) {
		this.son_type_cpte = son_type_cpte;
	}

	public Statut_compte getSon_statut_cpte() {
		return son_statut_cpte;
	}

	public void setSon_statut_cpte(Statut_compte son_statut_cpte) {
		this.son_statut_cpte = son_statut_cpte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public LocalDate getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(LocalDate date_creation) {
		this.date_creation = date_creation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_creation == null) ? 0 : date_creation.hashCode());
		result = prime * result + id_cpte;
		long temp;
		temp = Double.doubleToLongBits(solde);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((son_hote == null) ? 0 : son_hote.hashCode());
		result = prime * result + ((son_statut_cpte == null) ? 0 : son_statut_cpte.hashCode());
		result = prime * result + ((son_type_cpte == null) ? 0 : son_type_cpte.hashCode());
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
		Compte other = (Compte) obj;
		if (date_creation == null) {
			if (other.date_creation != null)
				return false;
		} else if (!date_creation.equals(other.date_creation))
			return false;
		if (id_cpte != other.id_cpte)
			return false;
		if (Double.doubleToLongBits(solde) != Double.doubleToLongBits(other.solde))
			return false;
		if (son_hote == null) {
			if (other.son_hote != null)
				return false;
		} else if (!son_hote.equals(other.son_hote))
			return false;
		if (son_statut_cpte == null) {
			if (other.son_statut_cpte != null)
				return false;
		} else if (!son_statut_cpte.equals(other.son_statut_cpte))
			return false;
		if (son_type_cpte == null) {
			if (other.son_type_cpte != null)
				return false;
		} else if (!son_type_cpte.equals(other.son_type_cpte))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Compte [id_cpte=" + id_cpte + ", son_hote=" + son_hote + ", son_type_cpte=" + son_type_cpte
				+ ", son_statut_cpte=" + son_statut_cpte + ", solde=" + solde + ", date_creation=" + date_creation
				+ "]";
	}

}
