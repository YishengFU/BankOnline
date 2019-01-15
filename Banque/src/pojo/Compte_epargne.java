package pojo;

import java.time.LocalDate;

public class Compte_epargne extends Compte {
	private double prime;// a modifier
	private int periode;// a modifier

	public Compte_epargne(int id_cpte, Personne son_hote, Type_compte son_type_cpte, Statut_compte son_statut_cpte,
			double solde, LocalDate date_creation, double prime, int periode) {
		super(id_cpte, son_hote, son_type_cpte, son_statut_cpte, solde, date_creation);
		this.prime = prime;
		this.periode = periode;
	}
	public Compte_epargne(Personne son_hote, Type_compte son_type_cpte, Statut_compte son_statut_cpte,
			double solde, LocalDate date_creation, double prime, int periode) {
		super(son_hote, son_type_cpte, son_statut_cpte, solde, date_creation);
		this.prime = prime;
		this.periode = periode;
	}

	public Compte_epargne() {
		// TODO Auto-generated constructor stub
	}
	public double getPrime() {
		return prime;
	}

	public void setPrime(double prime) {
		this.prime = prime;
	}

	public int getPeriode() {
		return periode;
	}

	public void setPeriode(int periode) {
		this.periode = periode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + periode;
		long temp;
		temp = Double.doubleToLongBits(this.prime);
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
		Compte_epargne other = (Compte_epargne) obj;
		if (periode != other.periode)
			return false;
		if (Double.doubleToLongBits(prime) != Double.doubleToLongBits(other.prime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Compte_epargne [prime=" + prime + ", periode=" + periode + ", id_cpte=" + id_cpte + ", son_hote="
				+ son_hote + ", son_type_cpte=" + son_type_cpte + ", son_statut_cpte=" + son_statut_cpte + ", solde="
				+ solde + ", date_creation=" + date_creation + "]";
	}

}
