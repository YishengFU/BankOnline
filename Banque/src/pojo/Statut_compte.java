package pojo;

public class Statut_compte {
	private int id_statut_cpte;// identifiant
	private String lib_statut_cpte;

	public Statut_compte(int id_statut_cpte, String lib_statut_cpte) {
		super();
		this.id_statut_cpte = id_statut_cpte;
		this.lib_statut_cpte = lib_statut_cpte;
	}

	public Statut_compte(String lib_statut_cpte) {
		super();
		this.lib_statut_cpte = lib_statut_cpte;
	}

	public int getId_statut_cpte() {
		return id_statut_cpte;
	}

	public void setId_statut_cpte(int id_statut_cpte) {
		this.id_statut_cpte = id_statut_cpte;
	}

	public String getLib_statut_cpte() {
		return lib_statut_cpte;
	}

	public void setLib_statut_cpte(String lib_statut_cpte) {
		this.lib_statut_cpte = lib_statut_cpte;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_statut_cpte;
		result = prime * result + ((lib_statut_cpte == null) ? 0 : lib_statut_cpte.hashCode());
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
		Statut_compte other = (Statut_compte) obj;
		if (id_statut_cpte != other.id_statut_cpte)
			return false;
		if (lib_statut_cpte == null) {
			if (other.lib_statut_cpte != null)
				return false;
		} else if (!lib_statut_cpte.equals(other.lib_statut_cpte))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Statut_compte [id_statut_cpte=" + id_statut_cpte + ", lib_statut_cpte=" + lib_statut_cpte + "]";
	}

}
