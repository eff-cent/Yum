package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Cliente;
import modelo.Persona;
import modelo.Conexion;

public class ClienteDAO {
	private Conexion con;
	private Connection connection;

	public ClienteDAO(String jdbcURL, String jdbcUsername, String jdbcPassword)throws SQLException{
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}




  //Crear Cliente
  public boolean crearCliente(Cliente cliente)throws SQLException {
    String sqlPersona = "INSERT INTO persona (nombre, apellidoPaterno, apellidoMaterno, correoElectronico) VALUES (?,?,?,?)";
  	String sqlCliente = "INSERT INTO cliente (password, telefono, idPersona) values (?,?,?)";
    con.conectar();
    connection = con.getJdbcConnection();
    PreparedStatement statement = connection.prepareStatement(sqlPersona, Statement.RETURN_GENERATED_KEYS);

    statement.setString(1, cliente.getNombre());
		statement.setString(2, cliente.getApellidoPaterno());
		statement.setString(3, cliente.getApellidoMaterno());
		statement.setString(4, cliente.getCorreoElectronico());

		boolean rowInserted = statement.executeUpdate() > 0;

		if (rowInserted == false) {
			 throw new SQLException("Persona no creado, no rows affected.");
     }else {
	    	System.out.println("Persona creada");
      }
      try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
          if (generatedKeys.next()) {
              cliente.setIdPersona(generatedKeys.getInt(1));
          }
          else {
              throw new SQLException("No ID obtained.");
          }
    statement = connection.prepareStatement(sqlCliente);
    statement.setString(1, cliente.getPassword());
    statement.setString(2, cliente.telefono());
    statement.setString(3, cliente.getIdPersona());

    rowInserted = statement.executeUpdate() > 0;

    if (rowInserted == false) {
			 throw new SQLException("Cliente no creado, no rows affected.");
     }else {
	    	System.out.println("Cliente creado con éxito");
      }
      statement.close();
  		con.desconectar();
  }

  //Editar cliente
  public boolean editarCliente(Cliente cliente) {
    System.out.println("editarCliente(Cliente cliente)");

		boolean rowActualizar = false;
		String sqlPersona = "UPDATE persona SET nombre=?,apellidoPaterno=?,apellidoMaterno=?,correoElectronico=? WHERE idPersona = ?";
    String sqlCliente = "UPDATE cliente SET userPassword=?,telefono=? WHERE idPersona = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sqlPersona);

		statement.setString(1, cliente.getNombre());
		statement.setString(2, cliente.getApellidoPaterno());
		statement.setString(3, cliente.getApellidoMaterno());
		statement.setString(4, cliente.getCorreoElectronico());
		statement.setDouble(5, cliente.getIdPersona());

		rowActualizar = statement.executeUpdate() > 0;
		if (rowActualizar == false) {
			 throw new SQLException("Persona no modificada, no rows affected.");
	    }else {
	    	System.out.println("Persona modificada");
	    }
    statement =  connection.prepareStatement(sqlCliente);
    statement.setString(1, cliente.getPassword());
    statement.setString(2, cliente.getTelefono());
    statement.setDouble(3, cliente.getIdPersona());
    rowActualizar = statement.executeUpdate() > 0;
    if (rowActualizar == false) {
       throw new SQLException("Cliente no modificado, no rows affected.");
      }else {
        System.out.println("Cliente modificado");
      }
		statement.close();
		con.desconectar();
		return rowActualizar;

  }

  public Repartidor obtenerPorId(int id) throws SQLException {
		System.out.println("obtenerporid");
    Cliente cliente = new Cliente();
		String sql = "SELECT * FROM Persona WHERE idPersona = " + id;

		con.conectar();
		connection = con.getJdbcConnection();


		Statement statement = connection.createStatement();
		ResultSet res = statement.executeQuery(sql);
		if (res.next()) {
			int idPersona = res.getInt("idPersona");

			cliente = new Cliente(res.getString("nombre"), res.getString("apellidoPaterno"), res.getString("apellidoMaterno"),res.getString("correoElectronico"), res.getString("password"), res.getString("telefono"));
			cliente.setIdPersona(idPersona);
			cliente.setIdCliente(idPersona);
		}

		res.close();
		con.desconectar();

		return repartidor;
	}

}
