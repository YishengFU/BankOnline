package pojo;

public class Type_compte {
	private int id_type_cpte;// identifiant
	private String lib_type_cpte;

	public Type_compte(int id_type_cpte, String lib_type_cpte) {
		super();
		this.id_type_cpte = id_type_cpte;
		this.lib_type_cpte = lib_type_cpte;
	}
	
	public Type_compte(String lib_type_cpte) {
		super();
		this.lib_type_cpte = lib_type_cpte;
	}

	public int getId_type_cpte() {
		return id_type_cpte;
	}

	public void setId_type_cpte(int id_type_cpte) {
		this.id_type_cpte = id_type_cpte;
	}

	public String getLib_type_cpte() {
		return lib_type_cpte;
	}

	public void setLib_type_cpte(String lib_type_cpte) {
		this.lib_type_cpte = lib_type_cpte;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_type_cpte;
		result = prime * result + ((lib_type_cpte == null) ? 0 : lib_type_cpte.hashCode());
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
		Type_compte other = (Type_compte) obj;
		if (id_type_cpte != other.id_type_cpte)
			return false;
		if (lib_type_cpte == null) {
			if (other.lib_type_cpte != null)
				return false;
		} else if (!lib_type_cpte.equals(other.lib_type_cpte))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Type_compte [id_type_cpte=" + id_type_cpte + ", lib_type_cpte=" + lib_type_cpte + "]";
	}

}
