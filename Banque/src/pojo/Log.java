package pojo;

import java.time.LocalDate;

public class Log {
	private int id_log;// identifiant
	private Personne son_hote;// cle etrangere
	private LocalDate date_connexion;

	public Log(int id_log, Personne son_hote, LocalDate date_connexion) {
		super();
		this.id_log = id_log;
		this.son_hote = son_hote;
		this.date_connexion = date_connexion;
	}

	public Log(Personne son_hote, LocalDate date_connexion) {
		super();
		this.son_hote = son_hote;
		this.date_connexion = date_connexion;
	}

	public int getId_log() {
		return id_log;
	}

	public void setId_log(int id_log) {
		this.id_log = id_log;
	}

	public Personne getSon_hote() {
		return son_hote;
	}

	public void setSon_hote(Personne son_hote) {
		this.son_hote = son_hote;
	}

	public LocalDate getDate_connexion() {
		return date_connexion;
	}

	public void setDate_connexion(LocalDate date_connexion) {
		this.date_connexion = date_connexion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_connexion == null) ? 0 : date_connexion.hashCode());
		result = prime * result + id_log;
		result = prime * result + ((son_hote == null) ? 0 : son_hote.hashCode());
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
		Log other = (Log) obj;
		if (date_connexion == null) {
			if (other.date_connexion != null)
				return false;
		} else if (!date_connexion.equals(other.date_connexion))
			return false;
		if (id_log != other.id_log)
			return false;
		if (son_hote == null) {
			if (other.son_hote != null)
				return false;
		} else if (!son_hote.equals(other.son_hote))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Log [id_log=" + id_log + ", son_hote=" + son_hote + ", date_connexion=" + date_connexion + "]";
	}

}
