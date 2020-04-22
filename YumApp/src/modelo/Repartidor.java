package modelo;

public class Repartidor extends Persona {
	private int idRepartidor;

	/**
	* Default empty Repartidor constructor
	*/
	public Repartidor() {
		super();
	}

	/**
	* Default Repartidor constructor
	*/
	public Repartidor(String nombre, String apellidoPaterno, String apellidoMaterno, String correoElectronico) {
		super(nombre, apellidoPaterno, apellidoMaterno, correoElectronico);
		
	}
	

	/**
	* Returns value of idRepartidor
	* @return
	*/
	public int getIdRepartidor() {
		return this.idRepartidor;
	}

	/**
	* Sets new value of idRepartidor
	* @param
	*/
	public void setIdRepartidor(int idRepartidor) {
		this.idRepartidor = idRepartidor;
	}
}
