<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="dominio.Cliente" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
<title>Administrador</title>
</head>
<body>
<div class="encabezado">
<%@ include file="NavBarAdm.jsp" %>
</div>


<div class="Formulario" >

<h2> Cuenta de Administrador</h2>

<form method="post" action="servletBaja">

<h2> Dar de Baja un Cliente</h2>

<table border="1">
      
<p> DNI Usuario <input type="number" name="dniCliente" ></input>
		<input type="submit" name="btnBuscarCliente" value="Buscar" >
		
		<br>
		<div class="Formulario">
<%
	Cliente cliente = (Cliente) request.getAttribute("cliente");
if (cliente != null) {
%>
    <p><strong>Nombre:</strong> <%= cliente.getNombre() %></p>
    <p><strong>Apellido:</strong> <%= cliente.getApellido() %></p>
    <p><strong>DNI:</strong> <%= cliente.getDni() %></p>
    <p><strong>CUIL:</strong> <%= cliente.getCuil() %></p>
    <p><strong>Fecha de Nacimiento:</strong> <%= cliente.getFechaNacimiento() %></p>
    <p><strong>Email:</strong> <%= cliente.getEmail() %></p>
    <p><strong>Sexo:</strong> <%= cliente.getSexo() %></p>
    <p><strong>Telefono:</strong> <%= cliente.getTelefono() %></p>
    <p><strong>Dirección:</strong> <%= cliente.getDireccion() %></p>
    <p><strong>Provincia:</strong> <%= cliente.getProvincia() %></p>
    <p><strong>Localidad:</strong> <%= cliente.getLocalidad() %></p>
<%
} else if (request.getAttribute("noexiste") != null) {
%>
    <p>No se encontró un cliente con el DNI proporcionado.</p>

<%
}
 if (request.getAttribute("noactivo") != null) {
%>
    <p>El cliente ya se encuentra dado de baja.</p>

<%
}
%>
    

<% if (cliente != null) { %>
    <input type="hidden" name="dniClienteSeleccionado" value="<%= cliente != null ? cliente.getDni() : "" %>">
    	<input type="submit" name="btnDarBajaCliente" value="Aceptar">
    </div>
<% } %>




    
    
</form>

    
    <a href="BajaCliente.jsp" class="boton-cerrar">Cancelar</a>

 </div>
</body>
</html>