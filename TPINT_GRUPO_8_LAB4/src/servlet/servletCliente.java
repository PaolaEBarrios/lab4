package servlet;
import java.util.List;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ClienteDaoImpl;
import dominio.Cliente;
import negocio.ClienteNegocio;

@WebServlet("/servletCliente")
public class servletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @return
	 * @see HttpServlet#HttpServlet()
	 */
	public void servletCliente() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		if (request.getParameter("btnListarClientes") != null) {
			ClienteNegocio clienteNegocio = new ClienteNegocio();
			
			ArrayList<Cliente> listaCliente = (ArrayList<Cliente>) clienteNegocio.obtenerClientes();
			
			request.setAttribute("listaCliente", listaCliente);
			request.getRequestDispatcher("ListadoClientes.jsp").forward(request, response);
		}
		
		
		
			if (request.getParameter("btnModificarContrasenia") != null) {
				ClienteNegocio clienteNegocio = new ClienteNegocio();
						
						
				String Dni = request.getParameter("dniClienteModificar");
				// Cliente clienteModificar = daoCliente.obtenerClienteXdni(Dni);
				String NuevaContrasenia = request.getParameter("ContraseniaNueva");

				
				
				if(!NuevaContrasenia.isEmpty())
				{
					
					
					boolean clienteModificado = clienteNegocio.modificarPass(Dni,NuevaContrasenia);
					
					System.out.println("RESULT BOOL " +clienteModificado);
					if (clienteModificado) {
						request.setAttribute("modificoContrasenia", true);
						request.getRequestDispatcher("ListadoClientes.jsp").forward(request, response);

					} else {
						request.setAttribute("noModifoContrasenia", true);
	

					}
				}
				else
				{
					System.out.println("Esta vacia");
					request.setAttribute("contraseniaVacia", true);
					request.getRequestDispatcher("ListadoClientes.jsp").forward(request, response);
				}
				
			}


		
		
			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		  ClienteNegocio clienteNegocio = new ClienteNegocio();


		  if (request.getParameter("btnLinkAlta") != null) {
		    // Obtener datos desde la capa de negocio
		    List provincias = (List) clienteNegocio.obtenerProvincias();
		    List localidades = (List) clienteNegocio.obtenerLocalidades();
		    List nacionalidades = (List) clienteNegocio.obtenerNacionalidades();

		    
		    request.setAttribute("provincias", provincias);
		    request.setAttribute("localidades", localidades);
		    request.setAttribute("nacionalidades", nacionalidades);

		    
		    RequestDispatcher dispatcher = request.getRequestDispatcher("RegistroNuevoUsuario.jsp");
		    dispatcher.forward(request, response);
		
		    
		  }
		if (request.getParameter("btnEnviarControles") != null) {

			String Nombre = request.getParameter("Nombre");
			String Apellido = request.getParameter("Apellido");
			String Dni = request.getParameter("Dni");
			String Cuil = request.getParameter("Cuil");
			String FechaNacimiento = request.getParameter("FechaNacimiento");
			String Email = request.getParameter("Email");
			String Sexo = request.getParameter("Sexo");
			String Nacionalidad = request.getParameter("nacionalidades");
			String Telefono = request.getParameter("Telefono");
			String Direccion = request.getParameter("Direccion");
			String Provincia = request.getParameter("provincias");
			String Localidad = request.getParameter("localidades");
			String Contrasenia = request.getParameter("Contrasenia");
			String Contrasenia2 = request.getParameter("Contraseniarep");
			String CBU = "Sin CBU";
			boolean activo = true;
			boolean administrador = false;

			Cliente cliente = new Cliente(Dni, Cuil, CBU, Nombre, Apellido, FechaNacimiento, Sexo, Nacionalidad, Email,
					Telefono, Direccion, Provincia, Localidad, activo, administrador, Contrasenia);

			System.out.println(cliente.toString());

			ClienteDaoImpl clientDao = new ClienteDaoImpl();
			if (clientDao.obtenerClienteXdni(Dni) == null) {// si el cliente no exite en la bd se carga
				if (Contrasenia.equals(Contrasenia2)) {
					boolean insercionExitosa = clientDao.insert(cliente);

					System.out.println("Insersion: " + insercionExitosa);

					if (insercionExitosa) {

						response.sendRedirect("RegistroExitoso.jsp");

					} else {

						response.sendRedirect("Error.jsp");

					}
				} else {
					System.out.println("LAS CONTRASEÑAS NO COINCIDEN");
				}

			} else {
				System.out.println("El CLIENTE YA ESTA DADO DE ALTA");
			}
		}

		if (request.getParameter("btnListarExport") != null) {
			response.setContentType("text/csv");
			response.setHeader("Content-Disposition", "attachment; filename=\"clientes.csv\"");

			try (PrintWriter writer = response.getWriter()) {
				writer.println("Email,Dni,Contraseña");

				ClienteDaoImpl clienteDao = new ClienteDaoImpl();

				ArrayList<Cliente> clientes = (ArrayList<Cliente>) clienteDao.readAll();

				for (Cliente cliente : clientes) {
					writer.println(cliente.getEmail() + "," + cliente.getDni() + "," + cliente.getContrasenia());
				}

			}

		}

	}
}