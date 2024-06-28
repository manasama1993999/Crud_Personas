package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
	
	public static Conexion instance; //variable para el patrón singleton
	private Connection conexion;
	
	private final String USER = "root";
	private final String PASSWORD = "";
	private final String SERVER = "localhost:3306";
	private final String BBDD = "bd_personas";
	
	private Conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://" + SERVER + "/" + BBDD;
			conexion = DriverManager.getConnection(url, USER, PASSWORD);
		}
		catch(ClassNotFoundException | SQLException ex) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
	
	public synchronized static Conexion obtenerEstadoConexion() {
		if (instance == null) {
			instance = new Conexion();
		}
		return instance;
	}
	
	public Connection getConexion() {
		return conexion;
	}
	
	public void closeConexion() {
		instance = null;
	}
	
	
	

}
