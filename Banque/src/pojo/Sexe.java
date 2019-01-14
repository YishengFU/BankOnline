package pojo;

public class Sexe {
	private int id_sexe;// 1 masculin, 2 feminin
	private String libelle;

	public Sexe(int id_sexe) {
		super();
		if (id_sexe == 1) {
			this.id_sexe = id_sexe;
			this.libelle = "Masculin";
		} else if (id_sexe == 2) {
			this.id_sexe = id_sexe;
			this.libelle = "F��minin";
		}
	}

	public Sexe() {
		// TODO Auto-generated constructor stub
	}

	public int getId_sexe() {
		return id_sexe;
	}

	public void setId_sexe(int id_sexe) {
		this.id_sexe = id_sexe;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Sexe [id_sexe=" + id_sexe + ", libelle=" + libelle + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_sexe;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
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
		Sexe other = (Sexe) obj;
		if (id_sexe != other.id_sexe)
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}

}
