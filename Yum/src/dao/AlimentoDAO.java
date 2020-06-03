package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Alimento;
import modelo.Conexion;

public class AlimentoDAO {
	private Conexion con;
	private Connection connection;
	//Nos dice si ya existe una categoria haciendo referencia al id de esa categor�a.
	private int categoriaId;

	public AlimentoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
		// Por defecto la categoria es 0, es decir, no existe.
		this.categoriaId = 0;
	}
	
	/*
	 * inserta un alimento en la base de datos.
	 */
	public boolean insertaAlimento(Alimento alimento) throws SQLException {
		// Primero vemos si ya existe la categoria del alimento, si no
		// la insertamos.
		existeCategoria(alimento.getNombreCategoria());
		
		String sql = "INSERT INTO alimento (nombre, precio, descripcion, idCategoria, path) VALUES (?,?,?,?,?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, alimento.getNombre());
		statement.setDouble(2, alimento.getPrecio());
		statement.setString(3, alimento.getDescripcion());
		statement.setInt(4, categoriaId);
		statement.setString(5, alimento.getPath());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}
	
	/* M�todo auxiliar que nos dice si ya existe una categor�a
	 * de alimentos en la BDD. Si ya existe, solo la almacenamos en
	 * la variable global, si no, entonces la insertamos a la BDD 
	 * y almacenamos en la variable global.
	 */
	public Boolean existeCategoria(String categoria) throws SQLException{
		//Consulta.
		String consulta = "SELECT idCategoria FROM categoria WHERE nombre= ? ";
		
		con.conectar();
		connection = con.getJdbcConnection();
		
		PreparedStatement statement = connection.prepareStatement(consulta);
		statement.setString(1, categoria);
		
		ResultSet res = statement.executeQuery();
		
		if(res.next()) {
			//res.beforeFirst();
			//Ya existe categoria, entonces almacenamos el id.
			categoriaId = res.getInt("idCategoria");
			con.desconectar();
			statement.close();
			return true;
		} else {
			//No existe la categor�a, entonces la insertamos.
			categoriaId = insertaCategoria(categoria);
			statement.close();
			return false;
		}
		
	}
	
	// M�todo auxiliar que inserta una cateogor�a en la BDD
	// y regresa el nuevo id de la categor�a.
	public int insertaCategoria(String nuevaCategoria) throws SQLException {
		
		String insert = "INSERT INTO categoria (nombre) VALUES (\'" + nuevaCategoria + "\')";
		Statement statement = connection.createStatement();
		//statement.setString(1, nuevaCategoria);
		int affectedRows = statement.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
		
		if(affectedRows == 0) {
			throw new SQLException("NO se pudo insertar categoria.");
		}
		
		ResultSet res = statement.getGeneratedKeys();
		
		if (res.next()) {
			//Almacenamos el id.
		    categoriaId = res.getInt(1);
		    con.desconectar();
		    statement.close();
		    return categoriaId;
		}
		return categoriaId;
	}
	
	/*
	 * M�todo que muestra todos los alimentos de la BDD y los regresa en una lista
	 * de alimentos.
	 */
	public List<Alimento> listarAlimentos() throws SQLException {
		List<Alimento> listaAlimentos = new ArrayList<Alimento>();
		
		//Consulta para obtener los alimentos con su categor�a.
		String sql = "SELECT idAlimento, a.Nombre Nombre, Precio, Descripcion, b.Nombre Catnombre, path FROM alimento a INNER JOIN categoria b ON a.idCategoria = b.idCategoria";
		
		con.conectar();
		connection = con.getJdbcConnection();
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) {
			int id = resultSet.getInt("idAlimento");
			String nombre = resultSet.getString("Nombre");
			double precio = resultSet.getDouble("Precio");
			String descripcion = resultSet.getString("Descripcion");
			String categoria = resultSet.getString("Catnombre");
			String path = resultSet.getString("path");
			
			Alimento alimento = new Alimento(id, nombre, precio, 
					descripcion,0, path, categoria);
			listaAlimentos.add(alimento);
		}
		con.desconectar();
		return listaAlimentos;
	}
	
	/* 
	 * Método que actualiza un alimento de la BDD.
	 */
	public boolean actualizaAlimento(Alimento alimento) throws SQLException {
		boolean rowActualizar = false;
		//Obtenemos el id de la categoria.
		existeCategoria(alimento.getNombreCategoria());
		
		String sql = "UPDATE alimento SET idAlimento=?, nombre=?, precio=?, descripcion=?, idcategoria=?, path=? WHERE idalimento=?";
		con.conectar();
		connection=con.getJdbcConnection();
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, alimento.getId());
		statement.setString(2, alimento.getNombre());
		statement.setDouble(3, alimento.getPrecio());
		statement.setString(4, alimento.getDescripcion());
		statement.setInt(5, categoriaId);
		statement.setString(6, alimento.getPath());
		statement.setInt(7, alimento.getId());

		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//Método auxiliar que nos dice si un alimento ya tiene imágen.
	public String tieneImagen(int idAlimento) throws SQLException {
		String path = "";
		String sql = "SELECT path FROM alimento WHERE idAlimento=?";
		
		con.conectar();
		connection = con.getJdbcConnection();
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idAlimento);
		
		ResultSet res = statement.executeQuery();
		
		if(res.next()) {
			//Ya existe path del alimento.
			path = res.getString("path");
			con.desconectar();
			statement.close();
			return path;
		} else {
			//No existe imagen.
			con.desconectar();
			statement.close();
			return path;
		}
	}
	
	//eliminar
	public boolean eliminaAlimento(int idAlimento) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM alimento WHERE idalimento=?";
		con.conectar();
		connection = con.getJdbcConnection();
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idAlimento);

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
}
