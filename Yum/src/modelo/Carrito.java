package modelo;

import java.util.List;

public class Carrito {

	int idCarrito;	
	String cliente;
	List<AlimentoCarrito> alimentos;	int total;
	
	public Carrito(int idCarrito, String cliente, List<AlimentoCarrito> alimentos) {
		this.idCarrito = idCarrito;
		this.cliente = cliente;
		this.alimentos = alimentos;
	}
	
	public int getId() {
		return idCarrito;
	}

	
	public String getCliente() {
		return cliente;
	}
	
	public List<AlimentoCarrito>  getAlimentos() {
		return alimentos;
	}

	public float calcularTotal() {
    	if(this.alimentos.isEmpty()) return 0;
    	float total = 0f;
        AlimentoCarrito a;
    	for(int i = 0; i< this.alimentos.size(); ++i) {
            a = this.alimentos.get(i);
    		total += a.getPrecio()*a.getCantidad();
    	}
        return total;
    }
}
