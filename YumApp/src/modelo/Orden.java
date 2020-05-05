package modelo;
import java.util.*;

public class Orden{
	  private int idOrden;
	  private String fecha;
	  private int estado;
	  private int calificacion;
	  private int idCliente;
	  private int idCarrito;
	  private int idRepartidor;

	  

		/**
		* Default empty Orden constructor
		*/
		public Orden() {
			super();
		}

		/**
		* Default Orden constructor
		*/
		public Orden(int idOrden, String fecha, int estado, int calificacion, int idCliente, int idCarrito, int idRepartidor) {
			super();
			this.idOrden = idOrden;
			this.fecha = fecha;
			this.estado = 1;
			this.calificacion = calificacion;
			this.idCliente = idCliente;
			this.idCarrito = idCarrito;
			this.idRepartidor = idRepartidor;
		}



		/**
		* Returns value of idOrden
		* @return
		*/
		public int getIdOrden() {
			return this.idOrden;
		}

		/**
		* Returns value of fecha
		* @return
		*/
		public String getFecha() {
			return this.fecha;
		}

		/**
		* Returns value of estado
		* @return
		*/
		public int getEstado() {
			return this.estado;
		}

		/**
		* Returns value of calificacion
		* @return
		*/
		public int getCalificacion() {
			return this.calificacion;
		}

		/**
		* Returns value of idCliente
		* @return
		*/
		public int getIdCliente() {
			return this.idCliente;
		}

		/**
		* Returns value of idCarrito
		* @return
		*/
		public int getIdCarrito() {
			return this.idCarrito;
		}

		/**
		* Returns value of idRepartidor
		* @return
		*/
		public int getIdRepartidor() {
			return this.idRepartidor;
		}

		/**
		* Sets new value of idOrden
		* @param
		*/
		public void setIdOrden(int idOrden) {
			this.idOrden = idOrden;
		}

		/**
		* Sets new value of fecha
		* @param
		*/
		public void setFecha(String fecha) {
			this.fecha = fecha;
		}

		/**
		* Sets new value of estado
		* @param
		*/
		public void setEstado(int estado) {
			this.estado = estado;
		}

		/**
		* Sets new value of calificacion
		* @param
		*/
		public void setCalificacion(int calificacion) {
			this.calificacion = calificacion;
		}

		/**
		* Sets new value of idCliente
		* @param
		*/
		public void setIdCliente(int idCliente) {
			this.idCliente = idCliente;
		}

		/**
		* Sets new value of idCarrito
		* @param
		*/
		public void setIdCarrito(int idCarrito) {
			this.idCarrito = idCarrito;
		}

		/**
		* Sets new value of idRepartidor
		* @param
		*/
		public void setIdRepartidor(int idRepartidor) {
			this.idRepartidor = idRepartidor;
		}
		
		public int estadoPosible() {
			switch(estado) {
			case 3:
				return estado;
				
			case 1:
				return 2;
			
			case 2:
				return 3;
			}
			
			return estado;
		}
	}