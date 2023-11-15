<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList"%>
<%@ page import="dominio.Cliente"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="css/StyleSheet.css">
   
    <title>Administrador</title>
</head>
<body>
    <div class="encabezado">
       <%@ include file="NavBarAdm.jsp" %>
    </div>

    <div class="Formulario">
        <form method="get" action="servletCliente">
            <h2>Listado de Clientes</h2>
            <input type="submit" name="btnListarClientes" value="Mostrar Clientes">
            
    		<hr>
    		<br>
            
            <table border="1">
                <tr>
                    <th>DNI Cliente</th>
                    <th>Usuario</th>
                    <th>Contraseña</th>
                </tr>
                <% if (request.getAttribute("listaCliente") != null) {
                    ArrayList<Cliente> listaCliente = (ArrayList<Cliente>) request.getAttribute("listaCliente");
                    for (Cliente user : listaCliente) { %>
                        <tr>
                            <td><%=user.getDni()%></td>
                            <td><%=user.getEmail()%></td>
                            <td><%=user.getContrasenia()%></td>
                        </tr>
                    <% }
                } %>
            </table>

            <p>DNI Cliente <input type="number" name="dniClienteModificar"></input></p>
            <p>Establezca su contraseña (6 caracteres):  <input type="password" name="ContraseniaNueva" maxlength="6"></input>
            <input type="submit" name="btnModificarContrasenia" value="Aceptar">
            
            <%
           
			        
            
          if (request.getAttribute("modificoContrasenia") != null) {
%>
    <p>Se modifico la contraseña correctamente.</p>

<%
}
          else if  (request.getAttribute("noModifoContrasenia") != null) {
%>
    <p>No se puedo modificar la contaseña.</p>

<%
}
%>
   
<% if (request.getAttribute("contraseniaVacia") != null) { %>
    <div class="mensaje-error">La contraseña no puede estar vacía.</div>
<% } %>
   
<br>    	
</form>
<form method="get" action="servletReportes">
<input type="submit" name="btnListarExport" value="Reporte de clientes">
</form>
        
</div>
</body>
</html>

