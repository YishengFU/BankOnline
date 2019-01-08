package pojo;

import java.time.LocalDate;

public class Compte_courant extends Compte {
	private double montant_decouvert;// a modifier

	public Compte_courant(int id_cpte, Personne son_hote, Type_compte son_type_cpte, Statut_compte son_statut_cpte,
			double solde, LocalDate date_creation, double montant_decouvert) {
		super(id_cpte, son_hote, son_type_cpte, son_statut_cpte, solde, date_creation);
		this.montant_decouvert = montant_decouvert;
	}

	public Compte_courant(Personne son_hote, Type_compte son_type_cpte, Statut_compte son_statut_cpte,
			double solde, LocalDate date_creation, double montant_decouvert) {
		super(son_hote, son_type_cpte, son_statut_cpte, solde, date_creation);
		this.montant_decouvert = montant_decouvert;
	}

	public double getMontant_decouvert() {
		return montant_decouvert;
	}

	public void setMontant_decouvert(double montant_decouvert) {
		this.montant_decouvert = montant_decouvert;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(montant_decouvert);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Compte_courant other = (Compte_courant) obj;
		if (Double.doubleToLongBits(montant_decouvert) != Double.doubleToLongBits(other.montant_decouvert))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Compte_courant [montant_decouvert=" + montant_decouvert + ", id_cpte=" + id_cpte + ", son_hote="
				+ son_hote + ", son_type_cpte=" + son_type_cpte + ", son_statut_cpte=" + son_statut_cpte + ", solde="
				+ solde + ", date_creation=" + date_creation + "]";
	}

}
