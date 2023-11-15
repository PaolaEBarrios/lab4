package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDaoImpl;
import dominio.Cuenta;
import negocio.CuentaNegocio;

/**
 * Servlet implementation class servletPrestamos
 */
@WebServlet("/servletPrestamos")
public class servletPrestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletPrestamos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String dni = request.getParameter("dniCliente");
			
			CuentaNegocio cntNeg = new CuentaNegocio();
			
			List<Cuenta> listado = new ArrayList<Cuenta>();
			
			listado = cntNeg.listaCuentaXdni(dni);
			
			request.setAttribute("Cuentas", listado);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Prestamos.jsp");
	        dispatcher.forward(request, response);
		
		}

}
