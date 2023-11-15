
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="dominio.Cliente" %>
<%@ page import="dominio.Cuenta" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
<title>Alta cuentas</title>
</head>
<body>

<div class="encabezado">
<%@ include file="NavBarAdm.jsp" %> 
</div>

<div class="Formulario" >

<h1> Registro de cuentas</h1>

<form method="post" action="servletCuentas">
	<h3> Valide sus datos ingresando dni: </h3>
	<hr>
	  <p>  DNI: <input type="text" required name="dniCuenta" class="input-DNI"></input></p>
	   <p>  <input type="submit" name="validarDni" value="Validar DNI"></input></br></p>
	   <%	Cliente cliente = (Cliente) request.getAttribute("cliente");
if (cliente != null) {
%>
	   <%-- Verifica si el cliente existe --%>
	
    <h3>Información del cliente:</h3>
    <p>Nombre: <%= cliente.getNombre() %></p>
    <p>Apellido: <%= cliente.getApellido() %></p>
    <p>CUIL: <%= cliente.getCuil() %></p>
    <%} %>
    
	
	  	<p class="cuentas">
	  	
  		<a href="#" class="btnModUsuario" role="button" >Modificar datos</a>
		  <br>
		  <a href="#" class="btnGestionAlta" role="button" >Gestionar Alta</a>
		  <br>
  		<a href="#" class="btnGestionBaja" role="button" >Gestionar baja</a>
		</p>
	  <hr>
	  <h3> Asignacion: </h3>
	  <br>
	  <p> Tipo de cuenta:
  <select name="TipoCuenta" >
    <option value="">Selecciona un tipo de cuenta</option>
    <option value="Caja de ahorro">Caja de ahorro</option>
    <option value="Cuenta Corriente">Cuenta Corriente</option>
  </select>
</p>
	 <% 
        // Verifica si la nuevaCuenta existe en la solicitud
        Cuenta Cuenta = (Cuenta) request.getAttribute("Cuenta");
        if (Cuenta != null) { 
    %>
        <h3>Información de la cuenta creada:</h3>
        <p>Número de Cuenta: <%= Cuenta.getNroCuenta() %></p>
        <p>Tipo de cuenta: <%= Cuenta.getTipo() %></p>
        <p>CBU: <%= Cuenta.getCBU() %></p>
        <p>Monto asignado: <%= Cuenta.getSaldo() %></p>
    <% } %>
	   <p>  <input type="submit" name="btnCrearCuenta" value="Enviar"></input></br></p>
</form>



 </div>

</body>
</html>