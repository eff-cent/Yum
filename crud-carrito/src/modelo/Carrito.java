package modelo;
import java.util.*;

public class Carrito{
	  private int idCarrito;
	  private int idCliente;
	  private int idAlimento;
	  private int cantidad;



		/**
		* Default empty Orden constructor
		*/
		public Carrito() {
			super();
		}

		/**
		* Default Orden constructor
		*/
		public Orden(int idCliente, int idCarrito, int idAlimento, int cantidad) {
			super();
			this.idCliente = idCliente;
			this.idCarrito = idCarrito;
			this.idAlimento = idAlimento;
      this.cantidad = cantidad;
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
    * Returns value of idAlimento
    * @return
    */
    public int getIdAlimento() {
      return this.idAlimento;
    }

    /**
    * Returns value of cantidad
    * @return
    */
    public int getCantidad() {
      return this.cantidad;
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
		* Sets new value of idAlimento
		* @param
		*/
		public void setIdAlimento(int idAlimento) {
			this.idAlimento = idAlimento;
		}

    /**
		* Sets new value of cantidad
		* @param
		*/
		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

	}
