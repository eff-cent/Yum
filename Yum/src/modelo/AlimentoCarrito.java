package modelo;

/*
 * Clase auxiliar de modelo que sirve para representar
 * un alimento con información necesaria para el cliente.
 */
public class AlimentoCarrito {
	String nombre;
	int cantidad;
	double precio;
	String path;
	
	public AlimentoCarrito(String nombre, int cantidad, double precio, String path) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.path = path;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public double getPrecio() {
		return precio;
	}

	public String getPath() {
		return path;
	}
}