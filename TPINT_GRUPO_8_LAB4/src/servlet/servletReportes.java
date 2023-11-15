package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletReportes
 */
@WebServlet("/servletReportes")
public class servletReportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletReportes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"ReporteClientes.csv\"");

        try (PrintWriter writer = response.getWriter()) {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_banco", "root", "root");

           
            String query = "SELECT Nombre, Apellido, Dni, Email, Contrasenia FROM db_banco.clientes";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                
                writer.println("Nombre,Apellido,Dni,Email,Contrasenia");
                while (resultSet.next()) {
                	String nombre = resultSet.getString("Nombre");
                	String apellido = resultSet.getString("Apellido");
                    int dni = resultSet.getInt("Dni");
                    String email = resultSet.getString("Email");
                    String contra = resultSet.getString("Contrasenia");

                    writer.println(nombre + "," + apellido + "," + dni + "," + email + "," + contra);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
