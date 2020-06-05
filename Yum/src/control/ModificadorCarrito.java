package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import dao.ClienteDAO;
import dao.CarritoDAO;
import dao.OrdenRepartidorDAO;
import modelo.Cliente;
import modelo.Direccion;
import modelo.Carrito;
import modelo.Categoria;
import modelo.AlimentoCarrito;
/**
 * Servlet implementation class ModificadorCliente
 */
@WebServlet("/verCarrito")
public class ModificadorCarrito extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	// Data access object para carrito.
	CarritoDAO carritoDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificadorCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			carritoDAO = new CarritoDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch(Exception e) {
			System.out.println("Ocurrio un error al entrar a la BDD: " + e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtenemos la acci�n que quiere realizar el usuario.
		String action = request.getParameter("action");
		
		try {
			switch(action) {
			case "verCarrito": 
				verCarrito(request, response);
				break;
			case "vaciarCarrito": 
				vaciarCarrito(request, response);
				break;
			case "editarCarrito":
				editarCarrito(request, response);
				break;
			case "confirmarOrden":
				confirmarOrden(request, response);
				break;
			default: 
				break;
			}
		}catch(SQLException e) {
			e.getStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	private void verCarrito(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Vista/Cliente/VerCarritoIH.jsp");
		HttpSession session = request.getSession(false); 
		if(session!= null) {
			System.out.println(session.getAttribute("cliente"));
			List<AlimentoCarrito> alimentos= null; 
			alimentos = carritoDAO.getAlimentos(); 
			if (alimentos == null) {
				request.setAttribute("Mensaje", "No hay algun producto aún");
				System.out.println("yeiii");
			}
			request.setAttribute("lista", alimentos);
			dispatcher.forward(request,response);
		}else {
			PrintWriter out = response.getWriter();
			out.print("Por favor ingresa primero"); 
			request.getRequestDispatcher("index.jsp").include(request, response);
			
		}
		
	}
	
	private void vaciarCarrito(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		carritoDAO.vaciarCarrito(Integer.parseInt(request.getParameter("idCarrito")));
		
		verCarrito(request, response);
	}
	
	
	
	/*
	 * Obtiene las �rdenes con estado 1, 2 y 3 para que el administrador
	 * las vea.
	 */
	private void confirmarOrden(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		// Obtenemos las �rdenes en estado 2 (Sin repartidor asignado).
		//List<OrdenRepartidor> ordenesListas = ordenRepartidorDAO.getOrdenesListas();
		System.out.println("confirmo la orden");
		
		//Mandamos las �rdenes al jsp.
		//request.setAttribute("ordenesListas", ordenesListas);
		
		//Mostramos vista.
		request.getRequestDispatcher("/Vista/Cliente/ConfirmarPedidoIH.jsp").forward(request, response);
	}

}
