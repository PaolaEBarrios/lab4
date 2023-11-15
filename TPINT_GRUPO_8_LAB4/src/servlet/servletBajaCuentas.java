package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDaoImpl;
import dao.CuentaDaoImpl;
import dominio.Cliente;
import dominio.Cuenta;
import negocio.CuentaNegocio;

/**
 * Servlet implementation class servletBajaCuentas
 */
@WebServlet("/servletBajaCuentas")
public class servletBajaCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletBajaCuentas() {
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
		
		
		if (request.getParameter("btnBuscarCBU") != null) {
			String CBU = request.getParameter("CBUCuenta");
			
			
			if (CBU != null) {
			
				
				//CuentaDaoImpl cuentaDaoImpl = new CuentaDaoImpl();
				//

				CuentaNegocio cuentaNegocio = new CuentaNegocio();
				Cuenta cuenta = cuentaNegocio.obtenerCuentaXNroCbu(CBU);
				
				
				System.out.println("cuenta: "+ cuenta);
				if (cuenta != null) {
					if (cuenta.getActiva()==true)
					{
						request.setAttribute("cuenta", cuenta);
						request.getRequestDispatcher("BajaCuenta.jsp").forward(request, response);
					}
					else {
						request.setAttribute("noactivo", true);
						request.getRequestDispatcher("BajaCuenta.jsp").forward(request, response);
						
					}
				}
				else {
					request.setAttribute("noexiste", true);
					request.getRequestDispatcher("BajaCuenta.jsp").forward(request, response);
				}

				}
}
		if (request.getParameter("btnDarBajaCuenta") != null) {
			
			CuentaNegocio cuentaNegocio = new CuentaNegocio();
			
			String cbuCuenta = request.getParameter("CBUSeleccionado");
			

			
			boolean resultado = cuentaNegocio.darBajaCuenta(cbuCuenta);
			//boolean resultado = daoCuenta.deleteLogico(cbuCuenta);

			
			System.out.println("RESULTADO: " + resultado);
			if (resultado == true) {
				response.sendRedirect("BajaCuentaExitosa.jsp");

			}
		} else {
			System.out.println("No es aceptar");
			request.getRequestDispatcher("BajaCuenta.jsp").forward(request, response);
		}
		}
	}

