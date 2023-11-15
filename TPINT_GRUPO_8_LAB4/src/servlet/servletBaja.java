package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDaoImpl;
import dao.UsuarioDaoImpl;
import dominio.Cliente;
import dominio.Usuario;
import negocio.ClienteNegocio;

/**
 * Servlet implementation class servletBaja
 */
@WebServlet("/servletBaja")
public class servletBaja extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletBaja() {
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
		
		///////////se busca el cliente que se desea dar de baja 
		if (request.getParameter("btnBuscarCliente") != null) {
			String dniCliente = request.getParameter("dniCliente");
			if (dniCliente != null) {
				
				ClienteNegocio clienteNegocio = new ClienteNegocio();
				
//				ClienteDaoImpl clienteDaoImpl = new ClienteDaoImpl();
				Cliente cliente = clienteNegocio.obtenerCliente(dniCliente);

				if (cliente != null) {
					if (cliente.getactivo())
					{
					request.setAttribute("cliente", cliente);
					request.getRequestDispatcher("BajaCliente.jsp").forward(request, response);
				}
					else {
						request.setAttribute("noactivo", true);
						request.getRequestDispatcher("BajaCliente.jsp").forward(request, response);
						
					}
					}
				else {
					request.setAttribute("noexiste", true);
					request.getRequestDispatcher("BajaCliente.jsp").forward(request, response);
				}

			}
		}
		//////si confirma que desea dar de baja el cliente
		if (request.getParameter("btnDarBajaCliente") != null) {
			
			ClienteNegocio clienteNegocio = new ClienteNegocio();
			//ClienteDaoImpl daoCliente = new ClienteDaoImpl();
			String dniCliente = request.getParameter("dniClienteSeleccionado");
			
			boolean resultado = clienteNegocio.darBajaCliente(dniCliente);
			//boolean resultado = daoCliente.deleteLogico(dniCliente); // Usa el DNI del cliente

			
			System.out.println("RESULTADO: " + resultado);
			if (resultado == true) {
				response.sendRedirect("BajaClienteExitosa.jsp");

			}
		} else {
			System.out.println("No es aceptar");
			request.getRequestDispatcher("BajaCliente.jsp").forward(request, response);
		}

	}

}
