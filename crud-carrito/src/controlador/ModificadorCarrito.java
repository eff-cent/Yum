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

import dao.OrdenDAO;
import dao.CarritoDAO;
import modelo.Orden;
import modelo.Carrito;


@WebServlet("/modificadorCarrito")
public class ModificadorCarrito extends HttpServlet{
	private static final long serialVersionUID = 1L;
	CarritoDAO carritoDAO;


	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {

			carritoDAO = new CarritoDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificadorOrden() {
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
			case "mostrar":
				//System.out.println("mostrando carrito");
				mostrar(request, response);
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

	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		System.out.println("carrito mostrandose");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Carrito.jsp");
		List<Orden> ordenes= ordenDAO.listarOrdenes();
		request.setAttribute("lista", ordenes);
		dispatcher.forward(request, response);
	}
}
