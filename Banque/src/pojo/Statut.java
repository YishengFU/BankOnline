package pojo;

public class Statut {
	private int id_statut;// identifiant, statut d'une personne
	private String lib_statut;

	public Statut(int id_statut, String lib_statut) {
		super();
		this.id_statut = id_statut;
		this.lib_statut = lib_statut;
	}

	public Statut(String lib_statut) {
		super();
		this.lib_statut = lib_statut;
	}

	public Statut() {
		// TODO Auto-generated constructor stub
	}


	public int getId_statut() {
		return id_statut;
	}

	public void setId_statut(int id_statut) {
		this.id_statut = id_statut;
	}

	public String getLib_statut() {
		return lib_statut;
	}

	public void setLib_statut(String lib_statut) {
		this.lib_statut = lib_statut;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_statut;
		result = prime * result + ((lib_statut == null) ? 0 : lib_statut.hashCode());
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
		Statut other = (Statut) obj;
		if (id_statut != other.id_statut)
			return false;
		if (lib_statut == null) {
			if (other.lib_statut != null)
				return false;
		} else if (!lib_statut.equals(other.lib_statut))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Statut [id_statut=" + id_statut + ", lib_statut=" + lib_statut + "]";
	}

}
