package pojo;

import java.util.HashMap;

public class Critere {
	private int id_critere;// identifiant
	private Personne son_hote;// cle etrangere
	private String valeur, operateur, lib_critere;
	private HashMap<String, String> map;// a modifier

	public Critere(int id_critere, Personne son_hote, String valeur, String operateur, String lib_critere) {
		super();
		this.id_critere = id_critere;
		this.son_hote = son_hote;
		this.valeur = valeur;
		this.operateur = operateur;
		this.lib_critere = lib_critere;
		this.map = new HashMap<String, String>();// a modifier
	}

	public Critere(Personne son_hote, String valeur, String operateur, String lib_critere) {
		super();
		this.son_hote = son_hote;
		this.valeur = valeur;
		this.operateur = operateur;
		this.lib_critere = lib_critere;
		this.map = new HashMap<String, String>();
	}

	public int getId_critere() {
		return id_critere;
	}

	public void setId_critere(int id_critere) {
		this.id_critere = id_critere;
	}

	public Personne getSon_hote() {
		return son_hote;
	}

	public void setSon_hote(Personne son_hote) {
		this.son_hote = son_hote;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public String getOperateur() {
		return operateur;
	}

	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}

	public String getLib_critere() {
		return lib_critere;
	}

	public void setLib_critere(String lib_critere) {
		this.lib_critere = lib_critere;
	}

	public HashMap<String, String> getMap() {
		return map;
	}

	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_critere;
		result = prime * result + ((lib_critere == null) ? 0 : lib_critere.hashCode());
		result = prime * result + ((map == null) ? 0 : map.hashCode());
		result = prime * result + ((operateur == null) ? 0 : operateur.hashCode());
		result = prime * result + ((son_hote == null) ? 0 : son_hote.hashCode());
		result = prime * result + ((valeur == null) ? 0 : valeur.hashCode());
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
		Critere other = (Critere) obj;
		if (id_critere != other.id_critere)
			return false;
		if (lib_critere == null) {
			if (other.lib_critere != null)
				return false;
		} else if (!lib_critere.equals(other.lib_critere))
			return false;
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		if (operateur == null) {
			if (other.operateur != null)
				return false;
		} else if (!operateur.equals(other.operateur))
			return false;
		if (son_hote == null) {
			if (other.son_hote != null)
				return false;
		} else if (!son_hote.equals(other.son_hote))
			return false;
		if (valeur == null) {
			if (other.valeur != null)
				return false;
		} else if (!valeur.equals(other.valeur))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Critere [id_critere=" + id_critere + ", son_hote=" + son_hote + ", valeur=" + valeur + ", operateur="
				+ operateur + ", lib_critere=" + lib_critere + ", map=" + map + "]";
	}

}
