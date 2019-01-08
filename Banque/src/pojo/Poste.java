package pojo;

public class Poste {
	private int id_poste;// identifiant
	private String lib_poste;
	private int droit;// a modifier

	public Poste(int id_poste, String lib_poste, int droit) {
		super();
		this.id_poste = id_poste;
		this.lib_poste = lib_poste;
		this.droit = droit;
	}

	public Poste(String lib_poste, int droit) {
		super();
		this.lib_poste = lib_poste;
		this.droit = droit;
	}

	public int getId_poste() {
		return id_poste;
	}

	public void setId_poste(int id_poste) {
		this.id_poste = id_poste;
	}

	public String getLib_poste() {
		return lib_poste;
	}

	public void setLib_poste(String lib_poste) {
		this.lib_poste = lib_poste;
	}

	public int getDroit() {
		return droit;
	}

	public void setDroit(int droit) {
		this.droit = droit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + droit;
		result = prime * result + id_poste;
		result = prime * result + ((lib_poste == null) ? 0 : lib_poste.hashCode());
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
		Poste other = (Poste) obj;
		if (droit != other.droit)
			return false;
		if (id_poste != other.id_poste)
			return false;
		if (lib_poste == null) {
			if (other.lib_poste != null)
				return false;
		} else if (!lib_poste.equals(other.lib_poste))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Poste [id_poste=" + id_poste + ", lib_poste=" + lib_poste + ", droit=" + droit + "]";
	}

}
