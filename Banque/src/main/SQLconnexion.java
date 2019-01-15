package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class SQLconnexion {
	private static SQLconnexion instance;
	private String url, login, pwd;
	private static Connection maConnexion;

	public static SQLconnexion getInstance() {
		if (instance == null) {
			instance = new SQLconnexion();
		}
		return instance;
	}

	public SQLconnexion() {
		//litFichier();
		creeConnexion();
	}
//
//	public void litFichier() {
//		try {
//			Properties accesBdd = new Properties();
//			File fBdd = new File("Properties.xml");
//			FileInputStream source = new FileInputStream(fBdd);
//			accesBdd.loadFromXML(source);
//			this.url = "jdbc:mysql://" + accesBdd.getProperty("adresse_ip") + ":" 
//					+ accesBdd.getProperty("port") + "/"
//					+ accesBdd.getProperty("bdd") + "?serverTimezone=Europe/Paris";// utiliser a IUT
//			this.url= "jdbc:mysql://localhost:8000/dahlem12u_banque";
//			this.login = accesBdd.getProperty("login");
//			this.pwd = accesBdd.getProperty("pass");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (InvalidPropertiesFormatException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public Connection creeConnexion() {
		try {
			if (maConnexion == null || maConnexion.isClosed()) {
				maConnexion = DriverManager.getConnection("jdbc:mysql://localhost:8000/dahlem12u_banque", "dahlem12u_appli", "31706372");
				//maConnexion = DriverManager.getConnection(this.url,this.login,this.pwd);
				System.out.println("MySQL Connected");
			}
		} catch (SQLException sqle) {
			System.out.println("Error connecion" + sqle.getMessage());
		}
		return maConnexion;
	}
}
