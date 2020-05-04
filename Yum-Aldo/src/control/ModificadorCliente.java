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


import dao.ClienteDAO;
import modelo.Cliente;
import modelo.Persona;

/**
 * Servlet implementation class AdminArticulo
 */
@WebServlet("/modificadorCliente")
public class ModificadorCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteDAO clienteDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {

			clienteDAO = new ClienteDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificadorCliente() {
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
			case "showedit":
				System.out.println("yendo a la página de editar");
				showModificadorCliente(request, response);
				break;
			case "editar":
				editar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
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
			Cliente cliente = new client(request.getParameter("nombre"), request.getParameter("apellidoPaterno"), request.getParameter("apellidoMaterno"), request.getParameter("correoElectronico"), request.getParameter("password"), request.getParameter("telefono"));
			clienteDAO.crearCliente(cliente);

	//TODO: poner bien mis jsp			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/RegistroRepartidorIH.jsp");
			dispatcher.forward(request, response);
		}

		private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/index.jsp");
			dispatcher.forward(request, response);
		}


		private void showModificadorCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			System.out.println("entra a show Modificador de cliente");
			System.out.println(Integer.parseInt(request.getParameter("idCliente")));
			Cliente cliente = clienteDAO.obtenerPorId(Integer.parseInt(request.getParameter("idCliente")));
			request.setAttribute("cliente", cliente);

	//TODO: poner bien mis jsp		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/EditorRepartidorIH.jsp");
			dispatcher.forward(request, response);
		}


		private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
			Repartidor repartidor = new Cliente(request.getParameter("nombre"), request.getParameter("apellidoPaterno"), request.getParameter("apellidoMaterno"), request.getParameter("correoElectronico"), request.getParameter("password"), request.getParameter("telefono"));
			int idPersona = Integer.parseInt(request.getParameter("idPersona"));
			cliente.setId(idPersona);
			cliente.setIdPersona(idPersona);
			clienteDAO.editarCliente(cliente);
		}


}
