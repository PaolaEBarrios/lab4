package servlet;
import java.util.List;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

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

		
		
		ClienteNegocio clienteNegocio = new ClienteNegocio();

	    
	    ArrayList<Cliente> listaCompleta = (ArrayList<Cliente>) clienteNegocio.obtenerClientes();
	    System.out.println(listaCompleta.toString());
	  
	    int pageSize = 10; 
	    int currentPage = 1; 

	    if (request.getParameter("page") != null) {
	        currentPage = Integer.parseInt(request.getParameter("page"));
	    }

	   
	    int totalPages = (int) Math.ceil((double) listaCompleta.size() / pageSize);

	    
	    if (currentPage < 1) {
	        currentPage = 1;
	    } else if (currentPage > totalPages) {
	        currentPage = totalPages;
	    }

	    // sublista para la página actual
	    List<Cliente> listaPaginada = new ArrayList<>();
	    int start = (currentPage - 1) * pageSize;
	    int end = Math.min(start + pageSize, listaCompleta.size());
	    if (start < end) {
	        listaPaginada = listaCompleta.subList(start, end);
	    }

	    
	    request.setAttribute("listaCliente", listaPaginada);
	    request.setAttribute("currentPage", currentPage);
	    request.setAttribute("totalPages", totalPages);

	  
	    request.getRequestDispatcher("ListadoClientes.jsp").forward(request, response);
	    
	   

		
		
			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getParameter("btnBuscarCliente")!=null) {
	    	ClienteNegocio clienteNegocio2 = new ClienteNegocio();
	    	String dni = request.getParameter("dniClienteModificar");
	    	 Cliente clienteEncontrado = clienteNegocio2.obtenerCliente(dni);
	    	 if (clienteEncontrado != null) {
	    		 System.out.println("Cliente encontrado: " + clienteEncontrado.toString());
	    	        List<Cliente> listaPaginada1 = new ArrayList<>();
	    	        listaPaginada1.add(clienteEncontrado);

	    	        
	    	        request.setAttribute("listaCliente", Arrays.asList(clienteEncontrado));
	    	        request.setAttribute("currentPage", 1);
	    	        request.setAttribute("totalPages", 1);
	    	        request.getRequestDispatcher("ListadoClientes.jsp").forward(request,response);
	    	        return;
	    	    } else {
	    	        
	    	        request.setAttribute("mensajeError", "No se encontró un cliente con el DNI ingresado.");
	    	    }

	    	    
	    	    //request.getRequestDispatcher("ListadoClientes.jsp").forward(request,response);
	    	 
	    	 return;
	    }
		
			if (request.getParameter("btnModificarContrasenia") != null) {
				ClienteNegocio clienteNegocio1 = new ClienteNegocio();
						
						
				String Dni = request.getParameter("dniClienteModificar");
				
				String NuevaContrasenia = request.getParameter("ContraseniaNueva");

				System.out.println("boton modificar contrasenia");
				
				if(!NuevaContrasenia.isEmpty())
				{
					
					
					boolean clienteModificado = clienteNegocio1.modificarPass(Dni,NuevaContrasenia);
					Cliente cliente = clienteNegocio1.obtenerCliente(Dni);
					System.out.println("RESULT BOOL " +clienteModificado);
					if (clienteModificado) {
						List<Cliente> listaPaginada2 = new ArrayList<>();
		    	        listaPaginada2.add(cliente);

		    	        
		    	        request.setAttribute("listaCliente", Arrays.asList(cliente));
		    	        request.setAttribute("currentPage", 1);
		    	        request.setAttribute("totalPages", 1);
		    	        
						request.setAttribute("modificoContrasenia", true);
					    request.setAttribute("nuevaContrasenia", NuevaContrasenia);
						request.getRequestDispatcher("ListadoClientes.jsp").forward(request, response);
						return;
						
					} else {
						request.setAttribute("noModifoContrasenia", true);
						return;

					}
				}
				else
				{
					System.out.println("Esta vacia");
					request.setAttribute("contraseniaVacia", true);
					request.getRequestDispatcher("ListadoClientes.jsp").forward(request, response);
					return;
				}
				
			}


		
		
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