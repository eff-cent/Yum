package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Conexion;
import modelo.AlimentoCarrito;
import modelo.Carrito;

public class CarritoDAO {
	private Conexion con;
	private Connection connection;
	
	public CarritoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	/*
	* Obtiene los alimentos que están en el carrito.
	*/
	public List<AlimentoCarrito> getAlimentos() throws SQLException {
		ResultSet res = null;
		
		// La lista que contiene los alimentos en el carrito.
		List<AlimentoCarrito> listaAlimentos = new ArrayList<AlimentoCarrito>();
		
		String consultaAlimentos = 	
				"SELECT a.idAlimento, nombre, precio, path, cantidad\r\n"+
				"FROM alimentoscarrito a\r\n"+
				"INNER JOIN carrito c\r\n"+
				"ON a.idCarrito = c.idCarrito\r\n"+
				"INNER JOIN alimento al\r\n"+
				"ON al.idAlimento = a.idAlimento\r\n"+
				"WHERE a.idCarrito = ?";
		
		con.conectar();
		connection = con.getJdbcConnection();
		
		PreparedStatement statement = connection.prepareStatement(consultaAlimentos);
		
		statement.setInt(1, 2);
		
		try {
			res = statement.executeQuery();
		} catch(Exception e) {
			System.out.println("ERRROR: " + e);
		}
		
		while(res.next()) {
			int id = res.getInt("idAlimento");
			int cantidad = res.getInt("cantidad");
			int precio = res.getInt("precio");
			String nombre= res.getString("nombre");
			String path = res.getString("path");
			AlimentoCarrito alimentoCarrito = new AlimentoCarrito(id, nombre, cantidad, precio, path);
			
			listaAlimentos.add(alimentoCarrito);
		}
		
		return listaAlimentos;
	}
	
	/*
	* Obtiene la suma total de los alimentos del carrito..
	*/
	public int totalCarrito(int idCarrito) throws SQLException {
		int total = 0;
		
		// Consulta para obtener el total del carrito.
		String consultaTotal = 
				"SELECT SUM(precio * cantidad) total \r\n" +
				"FROM carrito o inner join \r\n" +
				"alimentoscarrito a  \r\n" +
				"on o.idCarrito = a.idCarrito inner join\r\n" +
				"alimento c on a.idAlimento = c.idAlimento\r\n" +
				"where a.idCarrito = ?  \r\n" +
				"group by a.idCarrito";
		
		con.conectar();
		connection = con.getJdbcConnection();
		
		PreparedStatement statement = connection.prepareStatement(consultaTotal);
		
		statement.setInt(1, idCarrito);
		
		ResultSet res = statement.executeQuery();
		
		// Obtenemos el resultado.
		if(res.next()) {
			total = res.getInt("total");
			return total;
		}
		
		statement.close();
		con.desconectar();
		
		return total;
	}
	
	//Editar cantidad
		public boolean editarCantidad(AlimentoCarrito alimentoCarrito)throws SQLException {
			boolean rowEditar = false; 
			String sql = "UPDATE alimentoscarrito SET cantidad = ? WHERE idAlimento = ? ";			
			con.conectar();
			connection = con.getJdbcConnection(); 
			
			PreparedStatement statement = connection.prepareStatement(sql); 
			statement.setInt(1, alimentoCarrito.getCantidad());
			statement.setInt(2, alimentoCarrito.getId());
			 
			rowEditar = statement.executeUpdate()> 0; 
			statement.close();
			con.desconectar();
			
			return rowEditar;
		}
		
	//Eliminar alimento del carrito		
		public boolean eliminarAlimentoCarrito(int idAlimento)throws SQLException{
			boolean rowActualizar = false;
			String sql = "DELETE FROM alimentoscarrito WHERE idAlimento = ? ";
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idAlimento);
			rowActualizar = statement.executeUpdate()>0;
			statement.close();
			con.desconectar();
			return rowActualizar;
		}
		
	//Vaciar carrito
		public boolean vaciarCarrito(int idCarrito)throws SQLException{
			boolean rowActualizar = false;
			String sql = "DELETE FROM alimentoscarrito WHERE idCarrito = ? ";
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idCarrito);
			rowActualizar = statement.executeUpdate()>0;
			statement.close();
			con.desconectar();
			return rowActualizar;
		}
	
}
