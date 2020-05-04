package modelo;

public class Persona {
	private int idPersona;
  private String nombre;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private String correoElectronico;



	/**
	* Default empty Persona constructor
	*/
	public Persona() {
		super();
	}

	/**
	* Default Persona constructor
	*/
	public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, String correoElectronico) {
		super();

		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.correoElectronico = correoElectronico;
	}




	/**
	* Returns value of idPersona
	* @return
	*/
	public int getId() {
		return this.id;
	}

	/**
	* Returns value of nombre
	* @return
	*/
	public String getNombre() {
		return this.nombre;
	}

	/**
	* Returns value of apellidoPaterno
	* @return
	*/
	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	/**
	* Returns value of apellidoMaterno
	* @return
	*/
	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}

	/**
	* Returns value of correoElectronico
	* @return
	*/
	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	/**
	* Sets new value of idPersona
	* @param
	*/
	public void setId(int id) {
		this.id = id;
	}

	/**
	* Sets new value of nombre
	* @param
	*/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	* Sets new value of apellidoPaterno
	* @param
	*/
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	* Sets new value of apellidoMaterno
	* @param
	*/
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	* Sets new value of correoElectronico
	* @param
	*/
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
}
