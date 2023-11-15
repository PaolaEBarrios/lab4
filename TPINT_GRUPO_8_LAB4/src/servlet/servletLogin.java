package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDaoImpl;
import dominio.Cliente;

/**
 * Servlet implementation class servletLogin
 */
@WebServlet("/servletLogin")
public class servletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("Usuario");
		String pass = request.getParameter("Contrasena");

		ClienteDaoImpl clienteDao = new ClienteDaoImpl();
		boolean loginExitoso = clienteDao.loginExitoso(user, pass);
		if (loginExitoso) {
			boolean esAdmin = clienteDao.validarAdmin(user, pass);
			request.setAttribute("loginExitoso", true);
			if (esAdmin) {
				response.sendRedirect("MenuAdmin.jsp");
			} else {
				Cliente clienteLogueado= clienteDao.buscarXusuario(user);
				request.setAttribute("clienteLogueado", clienteLogueado);
				response.sendRedirect("MenuCliente.jsp");
			}
		} else {

			request.setAttribute("usuarioNoEncontrado", true);
			request.getRequestDispatcher("Error.jsp").forward(request, response);

		}
	}

}