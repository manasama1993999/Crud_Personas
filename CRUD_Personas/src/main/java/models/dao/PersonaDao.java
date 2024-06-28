package models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import models.dto.Persona;

public class PersonaDao implements iRepositoryCrud<Persona> {
	
	//Generar la conexión a la BBDD
	private static final Conexion conexion = Conexion.obtenerEstadoConexion();
	
	//Generar las consultas en SQL que la clase va a manejar
	private final String SQL_INSERT = "INSERT INTO PERSONAS VALUES (?,?,?,?,?,?)";
	private final String SQL_READ = "SELECT * FROM PERSONAS WHERE RUT = ?";
	private final String SQL_UPDATE = "UPDATE PERSONAS SET NOMBRE = ?, APELLIDO = ?, EMAIL = ?, EDAD = ?, PAIS = ? WHERE RUT = ?";
	private final String SQL_DELETE = "DELETE FROM PERSONAS WHERE RUT = ?";
	private final String SQL_READ_ALL = "SELECT * FROM PERSONAS ORDER BY RUT ASC";
	private final String SQL_READ_BY_EMAIL = "SELECT * FROM PERSONAS WHERE EMAIL = ?";
	private final String SQL_READ_BY_EDAD = "SELECT * FROM PERSONAS WHERE EDAD BETWEEN ? AND ?";
	
	//Crear los objetos que nos permitar manipular las consultas y obtener resultados
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public int create(Persona t) {
		try {
			ps = conexion.getConexion().prepareStatement(SQL_INSERT);
			ps.setString(1, t.getRut());
			ps.setString(2, t.getNombre());
			ps.setString(3, t.getApellido());
			ps.setString(4, t.getEmail());
			ps.setInt(5, t.getEdad());
			ps.setString(6, t.getPais());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			return e.getErrorCode();
		} finally {
			conexion.closeConexion();
		}		
		
	}

	@Override
	public Persona read(Object key) {
		try {
			Persona p = null;
			ps = conexion.getConexion().prepareStatement(SQL_READ);
			ps.setString(1, (String) key);
			rs = ps.executeQuery();
			while(rs.next()) {
				p = new Persona(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
			}
			return p;
		} catch (SQLException e) {
			return null;
		} finally {
			conexion.closeConexion();
		}
	}

	@Override
	public boolean update(Persona t) {
		try {
			ps = conexion.getConexion().prepareStatement(SQL_UPDATE);			
			ps.setString(1, t.getNombre());
			ps.setString(2, t.getApellido());
			ps.setString(3, t.getEmail());
			ps.setInt(4, t.getEdad());
			ps.setString(5, t.getPais());
			ps.setString(6, t.getRut());
			
			if(ps.executeUpdate() > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			return false;
		} finally {
			conexion.closeConexion();
		}		
		
	}

	@Override
	public boolean delete(Object key) {
		try {
			ps = conexion.getConexion().prepareStatement(SQL_DELETE);			
			ps.setString(1, (String) key);
			
			if(ps.executeUpdate() > 0) {
				return true;
			}
			return false;			
		} catch (SQLException e) {
			return false;
		} finally {
			conexion.closeConexion();
		}		
		
	}

	@Override
	public ArrayList<Persona> readAll() {
		try {
			ArrayList<Persona> personas = new ArrayList<Persona>();
			ps = conexion.getConexion().prepareStatement(SQL_READ_ALL);
			rs = ps.executeQuery();
			while(rs.next()) {
				personas.add(new Persona(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
			}
			return personas;
		} catch (SQLException e) {
			return null;
		} finally {
			conexion.closeConexion();
		}
	}
	
	public Persona findByEmail(String email) {
		try {
			Persona p = null;
			ps = conexion.getConexion().prepareStatement(SQL_READ_BY_EMAIL);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while(rs.next()) {
				p = new Persona(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
			}
			return p;
		} catch (SQLException e) {
			return null;
		} finally {
			conexion.closeConexion();
		}
	}
	
	public ArrayList<Persona> findByEdad(int inicio, int fin){
		return null;
	}
	
	
	

}
