package pojo;

import java.time.LocalDate;

public class Operation {
	private int id_op;// identifiant
	private Compte cpte_op_src;// cle etrangere
	private Compte cpte_op_but;// cle etrangere
	private Type_operation son_type_op;// cle etrangere
	private String lib_op;
	private double montant;
	private LocalDate date;
	private Etat_operation son_etat;// cle etrangere

	public Operation(int id_op, Compte cpte_op_src, Compte cpte_op_but, Type_operation son_type_op, String lib_op,
			double montant, LocalDate date, Etat_operation son_etat) {
		super();
		this.id_op = id_op;
		this.cpte_op_src = cpte_op_src;
		this.cpte_op_but = cpte_op_but;
		this.son_type_op = son_type_op;
		this.lib_op = lib_op;
		this.montant = montant;
		this.date = date;
		this.son_etat = son_etat;
	}

	public Operation(Compte cpte_op_src, Compte cpte_op_but, Type_operation son_type_op, String lib_op, double montant,
			LocalDate date, Etat_operation son_etat) {
		super();
		this.cpte_op_src = cpte_op_src;
		this.cpte_op_but = cpte_op_but;
		this.son_type_op = son_type_op;
		this.lib_op = lib_op;
		this.montant = montant;
		this.date = date;
		this.son_etat = son_etat;
	}

	public int getId_op() {
		return id_op;
	}

	public void setId_op(int id_op) {
		this.id_op = id_op;
	}

	public Compte getCpte_op_src() {
		return cpte_op_src;
	}

	public void setCpte_op_src(Compte cpte_op_src) {
		this.cpte_op_src = cpte_op_src;
	}

	public Compte getCpte_op_but() {
		return cpte_op_but;
	}

	public void setCpte_op_but(Compte cpte_op_but) {
		this.cpte_op_but = cpte_op_but;
	}

	public Type_operation getSon_type_op() {
		return son_type_op;
	}

	public void setSon_type_op(Type_operation son_type_op) {
		this.son_type_op = son_type_op;
	}

	public String getLib_op() {
		return lib_op;
	}

	public void setLib_op(String lib_op) {
		this.lib_op = lib_op;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Etat_operation getSon_etat() {
		return son_etat;
	}

	public void setSon_etat(Etat_operation son_etat) {
		this.son_etat = son_etat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpte_op_but == null) ? 0 : cpte_op_but.hashCode());
		result = prime * result + ((cpte_op_src == null) ? 0 : cpte_op_src.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id_op;
		result = prime * result + ((lib_op == null) ? 0 : lib_op.hashCode());
		long temp;
		temp = Double.doubleToLongBits(montant);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((son_etat == null) ? 0 : son_etat.hashCode());
		result = prime * result + ((son_type_op == null) ? 0 : son_type_op.hashCode());
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
		Operation other = (Operation) obj;
		if (cpte_op_but == null) {
			if (other.cpte_op_but != null)
				return false;
		} else if (!cpte_op_but.equals(other.cpte_op_but))
			return false;
		if (cpte_op_src == null) {
			if (other.cpte_op_src != null)
				return false;
		} else if (!cpte_op_src.equals(other.cpte_op_src))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id_op != other.id_op)
			return false;
		if (lib_op == null) {
			if (other.lib_op != null)
				return false;
		} else if (!lib_op.equals(other.lib_op))
			return false;
		if (Double.doubleToLongBits(montant) != Double.doubleToLongBits(other.montant))
			return false;
		if (son_etat == null) {
			if (other.son_etat != null)
				return false;
		} else if (!son_etat.equals(other.son_etat))
			return false;
		if (son_type_op == null) {
			if (other.son_type_op != null)
				return false;
		} else if (!son_type_op.equals(other.son_type_op))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Operation [id_op=" + id_op + ", cpte_op_src=" + cpte_op_src + ", cpte_op_but=" + cpte_op_but
				+ ", son_type_op=" + son_type_op + ", lib_op=" + lib_op + ", montant=" + montant + ", date=" + date
				+ ", son_etat=" + son_etat + "]";
	}

}
