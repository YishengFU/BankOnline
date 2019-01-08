package pojo;

public class Etat_operation {
	private int id_etat;// identifiant
	private String lib_etat;

	public Etat_operation(int id_etat, String lib_etat) {
		super();
		this.id_etat = id_etat;
		this.lib_etat = lib_etat;
	}

	public Etat_operation(String lib_etat) {
		super();
		this.lib_etat = lib_etat;
	}

	public int getId_etat() {
		return id_etat;
	}

	public void setId_etat(int id_etat) {
		this.id_etat = id_etat;
	}

	public String getLib_etat() {
		return lib_etat;
	}

	public void setLib_etat(String lib_etat) {
		this.lib_etat = lib_etat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_etat;
		result = prime * result + ((lib_etat == null) ? 0 : lib_etat.hashCode());
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
		Etat_operation other = (Etat_operation) obj;
		if (id_etat != other.id_etat)
			return false;
		if (lib_etat == null) {
			if (other.lib_etat != null)
				return false;
		} else if (!lib_etat.equals(other.lib_etat))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Etat_operation [id_etat=" + id_etat + ", lib_etat=" + lib_etat + "]";
	}

}
