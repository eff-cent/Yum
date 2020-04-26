package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Repartidor;
import modelo.ConexionBD;


public class RepartidorDAO {
	private ConexionBD con;
	private Connection connection;

	public RepartidorDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		con = new ConexionBD(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	public boolean insertar(Repartidor repartidor) throws SQLException {
	
		String sqlPersona = "INSERT INTO persona (nombre, apellidoPaterno, apellidoMaterno, correoElectronico) VALUES (?,?,?,?)";
		String sqlRepartidor = "INSERT INTO repartidor (idPersona) values (?)";
		
		con.conectar();
		connection = con.getJdbcConnection();
		
		PreparedStatement statement = connection.prepareStatement(sqlPersona, Statement.RETURN_GENERATED_KEYS);
		
		statement.setString(1, repartidor.getNombre());
		statement.setString(2, repartidor.getApellidoPaterno());
		statement.setString(3, repartidor.getApellidoMaterno());
		statement.setString(4, repartidor.getCorreoElectronico());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		
		if (rowInserted == false) {
			 throw new SQLException("Persona no creado, no rows affected.");
	    }else {
	    	System.out.println("Persona creada");
	    }
		
		
		try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                repartidor.setIdPersona(generatedKeys.getInt(1));
            }
            else {
                throw new SQLException("No ID obtained.");
            }
        }
		
		

		statement = connection.prepareStatement(sqlRepartidor);
		statement.setInt(1, repartidor.getIdPersona());
		rowInserted = statement.executeUpdate() > 0;
		
		if (rowInserted == false) {
			 throw new SQLException("Repartidor no creado, no rows affected");
	    }else {
	    	System.out.println("Repartidor creado");
	    }
		
		statement.close();
		con.desconectar();
		
		return rowInserted;
	}
	
	// listar todos los repartidores
	//hay que hacer un join para mostrar a los repartidores con las personas
	
	public List<Repartidor> listarRepartidores() throws SQLException {
		System.out.println("Estoy en listar repartidores");
		List<Repartidor> listaRepartidor = new ArrayList<Repartidor>();
		String sql = "SELECT persona.idPersona ,persona.nombre, persona.apellidoPaterno, persona.apellidoMaterno, persona.correoElectronico FROM persona INNER JOIN repartidor ON persona.idPersona = repartidor.idRepartidor";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int idPersona = resulSet.getInt("idPersona");
			String nombre = resulSet.getString("nombre");
			String apellidoPaterno = resulSet.getString("apellidoPaterno");
			String apellidoMaterno = resulSet.getString("apellidoMaterno");
			String correoElectronico = resulSet.getString("correoElectronico");
		
			Repartidor repartidor = new Repartidor(nombre, apellidoPaterno,  apellidoMaterno,  correoElectronico);
			repartidor.setIdPersona(idPersona);
			repartidor.setIdRepartidor(idPersona);
			listaRepartidor.add(repartidor);
			
		}
		con.desconectar();
		return listaRepartidor;
	}
	
	public Repartidor obtenerPorId(int id) throws SQLException {
		System.out.println("obtenerporid");
		Repartidor repartidor = new Repartidor();

		String sql = "SELECT * FROM Persona WHERE idPersona = " + id;
		
		con.conectar();
		connection = con.getJdbcConnection();
		
		
		Statement statement = connection.createStatement();
		ResultSet res = statement.executeQuery(sql);
		if (res.next()) {
			int idPersona = res.getInt("idPersona");
		
			repartidor = new Repartidor(res.getString("nombre"), res.getString("apellidoPaterno"), res.getString("apellidoMaterno"),res.getString("correoElectronico"));
			repartidor.setIdPersona(idPersona);
			repartidor.setIdRepartidor(idPersona);
		}
			
		res.close();
		con.desconectar();
		
		return repartidor;
	}
	
	public boolean actualizar(Repartidor repartidor) throws SQLException {
		
		System.out.println("actualizar(Repartidor repartidor)");
		
		boolean rowActualizar = false;
		String sql = "UPDATE persona SET nombre=?,apellidoPaterno=?,apellidoMaterno=?,correoElectronico=? WHERE idPersona = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
	
		statement.setString(1, repartidor.getNombre());
		statement.setString(2, repartidor.getApellidoPaterno());
		statement.setString(3, repartidor.getApellidoMaterno());
		statement.setString(4, repartidor.getCorreoElectronico());
		statement.setDouble(5, repartidor.getIdPersona());

		rowActualizar = statement.executeUpdate() > 0;
		if (rowActualizar == false) {
			 throw new SQLException("Persona no creado, no rows affected.");
	    }else {
	    	System.out.println("Persona creada");
	    }
		
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	public boolean eliminar(Repartidor repartidor) throws SQLException {
		boolean rowEliminar = false;
		String sqlRep = "DELETE FROM repartidor WHERE idPersona=?";
		String sqlPer = "DELETE FROM persona WHERE idPersona=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sqlRep);
		statement.setInt(1, repartidor.getIdPersona());

		rowEliminar = statement.executeUpdate() > 0;
		if (rowEliminar == false) {
			 throw new SQLException("Repartidor no eliminado, no rows affected.");
	    }else {
	    	System.out.println("Repartidor eliminado");
	    }
		statement = connection.prepareStatement(sqlPer);
		statement.setInt(1, repartidor.getIdPersona());
		
		rowEliminar = statement.executeUpdate() > 0;
		if (rowEliminar == false) {
			 throw new SQLException("Persona no eliminado, no rows affected.");
	    }else {
	    	System.out.println("Persona eliminado");
	    }
		
		statement.close();
		con.desconectar();

		return rowEliminar;
	}



}
