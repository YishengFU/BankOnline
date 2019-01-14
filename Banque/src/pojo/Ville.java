package pojo;

public class Ville {
	private int id_ville;// identifiant
	private String lib_ville, pays;

	public Ville(int id_ville, String lib_ville, String pays) {
		super();
		this.id_ville = id_ville;
		this.lib_ville = lib_ville;
		this.pays = pays;
	}

	public Ville(String lib_ville, String pays) {
		super();
		this.lib_ville = lib_ville;
		this.pays = pays;
	}

	public Ville() {
		// TODO Auto-generated constructor stub
	}

	public int getId_ville() {
		return id_ville;
	}

	public void setId_ville(int id_ville) {
		this.id_ville = id_ville;
	}

	public String getLib_ville() {
		return lib_ville;
	}

	public void setLib_ville(String lib_ville) {
		this.lib_ville = lib_ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_ville;
		result = prime * result + ((lib_ville == null) ? 0 : lib_ville.hashCode());
		result = prime * result + ((pays == null) ? 0 : pays.hashCode());
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
		Ville other = (Ville) obj;
		if (id_ville != other.id_ville)
			return false;
		if (lib_ville == null) {
			if (other.lib_ville != null)
				return false;
		} else if (!lib_ville.equals(other.lib_ville))
			return false;
		if (pays == null) {
			if (other.pays != null)
				return false;
		} else if (!pays.equals(other.pays))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ville [id_ville=" + id_ville + ", lib_ville=" + lib_ville + ", pays=" + pays + "]";
	}

}
