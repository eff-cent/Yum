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
		System.out.println(jdbcURL);
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


}
