<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList" %>
<%@ page import="dominio.Cliente" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Clientes</title>
    <link rel="stylesheet" type="text/css" href="css/StyleSheet.css">
</head>
<body>

    <div class="encabezado">
        <%@ include file="NavBarAdm.jsp" %>
    </div>

    <div class="Formulario">
        <form method="get" action="servletCliente">
            <h2>Listado de Clientes</h2>
            <input type="submit" name="btnListarClientes" value="Mostrar Clientes">
            <br></br>
        </form>

        <table border="1">
            <tr>
                <th>DNI Cliente</th>
                <th>Usuario</th>
                <th>Contraseña</th>
            </tr>

            <% if (request.getAttribute("listaCliente") != null) {
                List<Cliente> listaCliente = (List<Cliente>) request.getAttribute("listaCliente");

                for (Cliente user : listaCliente) { %>
                    <tr>
                        <td><%=user.getDni()%></td>
                        <td><%=user.getEmail()%></td>
                        <td><%=user.getContrasenia()%></td>
                    </tr>
                <% }
            } %>
        </table>

       
        <div>
           <% if (request.getAttribute("currentPage") != null && request.getAttribute("totalPages") != null) {
        int currentPage = (int) request.getAttribute("currentPage");
        int totalPages = (int) request.getAttribute("totalPages");

        for (int i = 1; i <= totalPages; i++) { %>
            <a href="servletCliente?page=<%= i %>"><%= i %></a>
        <% }
    } %>
        </div>

      
        <form method="get" action="servletCliente">
           
            <input type="hidden" name="page" value="<%= request.getAttribute("currentPage") %>">
            
            
        </form >
		 <form method="post" action="servletCliente">
        <p>DNI Cliente <input type="number" name="dniClienteModificar"></p>
        <input type="submit" name="btnBuscarCliente" value="Buscar">
        
        <p>Establezca su contraseña (6 caracteres):  <input type="password" name="ContraseniaNueva" maxlength="6"></p>
        <br></br>
       
        <br></br>
        <input type="submit" name="btnModificarContrasenia" value="Aceptar">

        <% if (request.getAttribute("modificoContrasenia") != null) { %>
            <p>Se modificó la contraseña correctamente.</p>
        <% } else if (request.getAttribute("noModifoContrasenia") != null) { %>
            <p>No se pudo modificar la contraseña.</p>
        <% } %>

        <% if (request.getAttribute("contraseniaVacia") != null) { %>
            <div class="mensaje-error">La contraseña no puede estar vacía.</div>
        <% } %>
         </form>
        <form method="get" action="servletReportes">
        <br></br>
        <input type="submit" name="btnListarExport" value="Reporte de clientes">
    </form>
        
    </div>
</body>
</html>


