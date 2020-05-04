package modelo;

public class Cliente extends Persona {
	private int id;
  private String password;
  private int salt;
  private String telefono;
  private int idPersona;

  public Cliente() {
		super();
	}

	public Cliente(int id, String nombre, String apellidoPaterno, String apellidoMaterno, String correoElectronico, String password, int salt, String telefono, int idPersona) {
    super(nombre, apellidoPaterno, apellidoMaterno, correoElectronico);
  	this.id = id;
    this.password = password;
    this.salt = salt;
    this.telefono = telefono;
    this.idPersona = idPersona;
	}

	/**
	* Returns value of id
	* @return
	*/
	public int getId() {
		return this.id;
	}

  /**
	* Returns value of password
	* @return
	*/
	public int getPassword() {
		return this.password;
	}

  /**
	* Returns value of salt
	* @return
	*/
	public int getSalt() {
		return this.salt;
	}

  /**
	* Returns value of telefono
	* @return
	*/
	public int getTelefono() {
		return this.telefono;
	}

  /**
	* Returns value of idPersona
	* @return
	*/
	public int getIdPersona() {
		return this.idPersona;
	}

	/**
	* Sets new value of idCliente
	* @param
	*/
	public void setId(int id) {
		this.id = id;
	}

  /**
	* Sets new value of password
	* @param
	*/
	public void setPassword(String password) {
		this.password = password;
	}

  /**
	* Sets new value of salt
	* @param
	*/
	public void setSalt(int salt) {
		this.salt = salt;
	}

  /**
	* Sets new value of telefono
	* @param
	*/
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

  /**
	* Sets new value of idCliente
	* @param
	*/
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
}
