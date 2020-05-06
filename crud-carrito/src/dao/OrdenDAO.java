package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Orden;

import modelo.ConexionBD;

public class OrdenDAO {
	private ConexionBD con;
	private Connection connection;
	
	public OrdenDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		con = new ConexionBD(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	public List<Orden> listarOrdenes() throws SQLException {
		System.out.println("Listando ordenes");
		List<Orden> ordenes = new ArrayList<Orden>();
		String sql = "SELECT * FROM orden ";
		 con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int idOrden = resulSet.getInt("idOrden");
			String fecha = resulSet.getString("fecha");
			int estado = resulSet.getInt("estado");
			int calificacion = resulSet.getInt("calificacion");
			int idCliente = resulSet.getInt("idCliente");
			int idCarrito = resulSet.getInt("idCarrito");
			int idRepartidor = resulSet.getInt("idRepartidor");
		
			Orden orden = new Orden(idOrden, fecha,  estado,  calificacion, idCliente , idCarrito, idRepartidor );
			orden.setIdCliente(idOrden);
			orden.setIdCarrito(idOrden);
			orden.setIdOrden(idOrden);
			orden.setIdRepartidor(idOrden);
			System.out.println(idOrden + " , " + fecha + " , "  + estado +  " , " + calificacion +  " , " + idCliente +  " , " + idCarrito +  " , " + idRepartidor);
			ordenes.add(orden);
			
		}
		con.desconectar();
		return ordenes;
	}
	
	
	
}
