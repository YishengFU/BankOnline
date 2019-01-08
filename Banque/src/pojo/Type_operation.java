package pojo;

public class Type_operation {
	private int id_type_op;// identifiant
	private String lib_type_op;

	public Type_operation(int id_type_op, String lib_type_op) {
		super();
		this.id_type_op = id_type_op;
		this.lib_type_op = lib_type_op;
	}

	public Type_operation(String lib_type_op) {
		super();
		this.lib_type_op = lib_type_op;
	}

	public int getId_type_op() {
		return id_type_op;
	}

	public void setId_type_op(int id_type_op) {
		this.id_type_op = id_type_op;
	}

	public String getLib_type_op() {
		return lib_type_op;
	}

	public void setLib_type_op(String lib_type_op) {
		this.lib_type_op = lib_type_op;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_type_op;
		result = prime * result + ((lib_type_op == null) ? 0 : lib_type_op.hashCode());
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
		Type_operation other = (Type_operation) obj;
		if (id_type_op != other.id_type_op)
			return false;
		if (lib_type_op == null) {
			if (other.lib_type_op != null)
				return false;
		} else if (!lib_type_op.equals(other.lib_type_op))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Type_operation [id_type_op=" + id_type_op + ", lib_type_op=" + lib_type_op + "]";
	}

}
