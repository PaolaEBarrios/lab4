package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDaoImpl;
import dao.CuentaDao;
import dao.CuentaDaoImpl;
import dominio.Cliente;
import dominio.Cuenta;

import java.awt.List;

/**
 * Servlet implementation class serveltCuentas
 */
@WebServlet("/servletCuentas")
public class servletCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletCuentas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getAttribute("clienteLogueado") != null) {
			CuentaDaoImpl cuentasDao = new CuentaDaoImpl();
			Cliente clienteLogueado = new Cliente();
			clienteLogueado = (Cliente) request.getAttribute("clienteLogueado");
			ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>();
			listaCuentas = (ArrayList<dominio.Cuenta>) cuentasDao.listaCuentaXdni(clienteLogueado.getDni());
			request.setAttribute("cuentasClienteLogueado", listaCuentas);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Servlet doPost ejecutado.");

		if (request.getParameter("validarDni") != null) {

			String dniCuenta = request.getParameter("dniCuenta");
			System.out.println(dniCuenta);
			ClienteDaoImpl clienteDao = new ClienteDaoImpl();

			Cliente cliente = clienteDao.obtenerClienteXdni(dniCuenta);

			String CBU = request.getParameter("CBU");
			cliente.setCbu(CBU);

			request.setAttribute("cliente", cliente);
			request.getRequestDispatcher("Cuentas.jsp").forward(request, response);

			clienteDao.update(cliente, dniCuenta);

		}

		String dniCuenta = request.getParameter("dniCuenta");
		// double MontoAsignado = 0.0;
		CuentaDaoImpl cuentaDao = new CuentaDaoImpl();
		String NroCuenta = request.getParameter("NroCuenta");
		// String CBU = request.getParameter("CBU");
		String TipoCuenta = request.getParameter("TipoCuenta");
		// String montoAsignadoStr = request.getParameter("MontoAsignado");
		String FechaCreacion = "FechaDeHoy";
		Boolean Activa = true;

		// MontoAsignado = Double.parseDouble(montoAsignadoStr);

		Cuenta Cuenta = new Cuenta(dniCuenta, TipoCuenta, FechaCreacion, Activa);
		request.setAttribute("Cuenta", Cuenta);

		// Redireccionar a la página JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("Cuentas.jsp");
		dispatcher.forward(request, response);
		System.out.println(Cuenta.toString());

		cuentaDao.insert(Cuenta);

	}

}
