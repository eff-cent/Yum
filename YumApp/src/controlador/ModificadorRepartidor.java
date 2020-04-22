package controlador;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.RepartidorDAO;
import modelo.Repartidor;

/**
 * Servlet implementation class AdminArticulo
 */
@WebServlet("/modificadorRepartidor")
public class ModificadorRepartidor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RepartidorDAO repartidorDAO;
	
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {

			repartidorDAO = new RepartidorDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificadorRepartidor() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "nuevo":
				nuevo(request, response);
				break;
			case "register":
				System.out.println("registrar");
				registrar(request, response);
				break;
			case "mostrar":
				//mostrar(request, response);
				break;
			case "showedit":
				//showEditar(request, response);
				break;	
			case "editar":
				//editar(request, response);
				break;
			case "eliminar":
				//eliminar(request, response);
				break;
			default:
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}
		
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			System.out.println("Hola Servlet..");
			doGet(request, response);
		}
		
		private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
			//mostrar(request, response);
			RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
		private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			Repartidor repartidor = new Repartidor(request.getParameter("nombre"), request.getParameter("apellidoPaterno"), request.getParameter("apellidoMaterno"),request.getParameter("correoElectronico"));
			repartidorDAO.insertar(repartidor);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
		private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/index.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		
	
	
	



}
