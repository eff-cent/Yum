package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Conexion;
import modelo.OrdenRepartidor;

public class CarritoDAO {
	private Conexion con;
	private Connection connection;
	
	public CarritoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	/*
	* Obtiene las �rdenes que ya est�n listas para el repartidor.
	*/
	public List<OrdenRepartidor> getOrdenesListas() throws SQLException {
		ResultSet res = null;
		
		// La lista que contiene las ordenes.
		List<OrdenRepartidor> listaOrdenes = new ArrayList<OrdenRepartidor>();
		
		String consultaOrdenes = "SELECT o.idOrden,p.nombre nombrecliente, calle, delegacion, colonia, num_interior, num_exterior\r\n" + 
				"FROM orden o INNER JOIN direccionescliente d\r\n" + 
				"ON o.idDireccionCliente = d.idDireccionCliente\r\n" + 
				"INNER JOIN direccion dc\r\n" + 
				"ON d.idDireccion = dc.idDireccion\r\n" + 
				"INNER JOIN cliente c \r\n" + 
				"ON c.idCliente = o.idCliente\r\n" + 
				"INNER JOIN persona p\r\n" + 
				"ON c.idPersona = p.idPersona \r\n" +
				"WHERE o.estado = ?";
		
		con.conectar();
		connection = con.getJdbcConnection();
		
		PreparedStatement statement = connection.prepareStatement(consultaOrdenes);
		
		statement.setInt(1, 2);
		
		try {
			res = statement.executeQuery();
		} catch(Exception e) {
			System.out.println("ERRROR: " + e);
		}
		
		while(res.next()) {
			int idOrden = res.getInt("idOrden");
			int estado = res.getInt("estado");
			String nombreCliente = res.getString("nombrecliente");
			String direccion = res.getString("calle") + " " + res.getString("delegacion") + " " +
					res.getString("colonia") + " " + Integer.toString(res.getInt("num_interior")) + " " 
					+ Integer.toString(res.getInt("num_exterior"));
			
			OrdenRepartidor ordenRepartidor = new OrdenRepartidor(idOrden, estado, nombreCliente, direccion);
			
			listaOrdenes.add(ordenRepartidor);
		}
		
		return listaOrdenes;
	}
}
