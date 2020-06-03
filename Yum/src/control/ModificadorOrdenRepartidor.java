package control;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrdenRepartidorDAO;


/**
 * Servlet implementation class ModificadorOrdenRepartidor
 */
@WebServlet("/ordenRepartidor")
public class ModificadorOrdenRepartidor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Data access object para orden.
	OrdenRepartidorDAO ordenRepartidorDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificadorOrdenRepartidor() {
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
			ordenRepartidorDAO = new OrdenRepartidorDAO(jdbcURL, jdbcUsername, jdbcPassword);
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
			case "mostrarOrdenes": 
				mostrarOrdenes(request, response);
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
	
	/*
	 * Obtiene las �rdenes con estado 1, 2 y 3 para que el administrador
	 * las vea.
	 */
	private void mostrarOrdenes(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		// Obtenemos las �rdenes en estado 2 (Sin repartidor asignado).
		//List<OrdenRepartidor> ordenesListas = ordenRepartidorDAO.getOrdenesListas();
		System.out.println("obtengo Ordenes");
		
		//Mandamos las �rdenes al jsp.
		//request.setAttribute("ordenesListas", ordenesListas);
		
		//Mostramos vista.
		request.getRequestDispatcher("/Vista/Repartidor/MostrarOrdenesRepartidorIH.jsp").forward(request, response);
	}

}
