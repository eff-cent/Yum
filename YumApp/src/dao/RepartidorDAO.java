package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

import modelo.Repartidor;
import modelo.ConexionBD;


public class RepartidorDAO {
	private ConexionBD con;
	private Connection connection;

	public RepartidorDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		con = new ConexionBD(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	public boolean insertar(Repartidor repartidor) throws SQLException {
		System.out.println("insertar(repartidor)");
		String sqlPersona = "INSERT INTO persona (nombre, apellidoPaterno, apellidoMaterno, correoElectronico, password) VALUES (?,?,?,?,?)";
		String sqlRepartidor = "INSERT INTO repartidor (idPersona) values (?)";
		
		con.conectar();
		connection = con.getJdbcConnection();
		
		PreparedStatement statement = connection.prepareStatement(sqlPersona, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, repartidor.getNombre());
		statement.setString(2, repartidor.getApellidoPaterno());
		statement.setString(3, repartidor.getApellidoMaterno());
		statement.setString(4, repartidor.getCorreoElectronico());
		statement.setString(5, repartidor.getPassword());
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
		
		
		statement = connection.prepareStatement(sqlRepartidor, Statement.RETURN_GENERATED_KEYS);
		
		
	
		System.out.println(repartidor.toString());			
		statement.setInt(1, repartidor.getIdPersona());
		rowInserted = statement.executeUpdate() > 0;
		
		if (rowInserted == false) {
			 throw new SQLException("Repartidor no creado, no rows affected");
	    }else {
	    	System.out.println("Repartidor creado");
	    }
		
		try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                repartidor.setIdRepartidor(generatedKeys.getInt(1));
                System.out.println(repartidor.toString());
        		
            }
            else {
                throw new SQLException("No ID obtained.");
            }
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
		String sql = "SELECT * FROM persona INNER JOIN repartidor ON persona.idPersona = repartidor.idPersona";
		 con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int idPersona = resulSet.getInt("idPersona");
			int idRepartidor = resulSet.getInt("idRepartidor");
			String nombre = resulSet.getString("nombre");
			String apellidoPaterno = resulSet.getString("apellidoPaterno");
			String apellidoMaterno = resulSet.getString("apellidoMaterno");
			String correoElectronico = resulSet.getString("correoElectronico");
		
			Repartidor repartidor = new Repartidor(nombre, apellidoPaterno,  apellidoMaterno,  correoElectronico);
			repartidor.setIdPersona(idPersona);
			repartidor.setIdRepartidor(idRepartidor);
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
			String password = res.getString("password");
			repartidor = new Repartidor(res.getString("nombre"), res.getString("apellidoPaterno"), res.getString("apellidoMaterno"),res.getString("correoElectronico"));
			repartidor.setIdPersona(idPersona);
			repartidor.setIdRepartidor(idPersona);
			repartidor.setPassword(password);
		}
			
		res.close();
		con.desconectar();
		
		return repartidor;
	}
	
	/*public Boolean validarCorreoElectronico(String correo) throws SQLException{
		String sql = "SELECT * FROM Persona WHERE correoElectronico = " + correo;

		Statement statement = connection.createStatement();
		ResultSet res = statement.executeQuery(sql);
		if (res.next() == false) {
			return false;
		}
			
		res.close();
		con.desconectar();
		return true;
	}*/
	
	public boolean actualizar(Repartidor repartidor) throws SQLException {
		
		System.out.println("actualizar(Repartidor repartidor)");
		System.out.println(repartidor.toString());
		
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
		String sqlRep = "DELETE FROM repartidor WHERE idRepartidor=?";
		String sqlPer = "DELETE FROM persona WHERE idPersona=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sqlRep);
		statement.setInt(1, repartidor.getIdRepartidor());

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
	
	public void enviarRegistroRepartidor(Repartidor repartidor) {
		
		final String username = "efficientyum@gmail.com";
		final String password = "Yum2020IS";
		
		Properties prop = new Properties();

		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("efficientyum@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(repartidor.getCorreoElectronico())
            );
            message.setSubject("Registro como repartidor en Yum");
            message.setText("Hola, " + repartidor.getNombre() 
                    + ".\n\n Tu registro como repartidor ha sido un éxito. "
                    + "Este es tu usuario y contraseña para acceder a la aplicación de Yum.\n    Usuario: " 
                    + repartidor.getCorreoElectronico() 
                    + "\n   Contraseña: "  + repartidor.getPassword() + "\n\n ¡Bienvenido!" );

            Transport.send(message);

            System.out.println("Correo enviado");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}



}
