<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="dominio.Cliente" %>
<%@ page import="dominio.Cuenta" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

<form method="post" action="servletBajaCuentas">
 <table border="1">
 
      <h2> Dar de Baja la cuenta de un Cliente</h2>
      
<p> CBU de la cuenta <input type="number" name="CBUCuenta" ></input>
		<input type="submit" name="btnBuscarCBU" value="Buscar" > 
		<br>
		<div class="Formulario">
<%
	Cuenta cuenta = (Cuenta) request.getAttribute("cuenta");
if (cuenta != null) {
%>
<p><strong>DNI cliente: </strong><%=cuenta.getDniCliente() %></p>
<p><strong>Numero de cuenta:</strong> <%=cuenta.getNroCuenta() %></p>
<p><strong>CBU:</strong> <%=cuenta.getCBU() %></p>
<p><strong>Tipo de cuenta:</strong> <%=cuenta.getTipo() %></p>
<p><strong>Saldo:</strong> <%=cuenta.getSaldo() %></p>

<%
}
else if (request.getAttribute("noexiste") != null) {
%>

<p>No se encontro una cuenta con el CBU especificado.</p>

<%
}
 if (request.getAttribute("noactivo") != null) {
%>
    <p>La cuenta ya se encuentra dada de baja.</p>
    
<%
}
%>
       <% if (cuenta != null) { %>
    <input type="hidden" name="CBUSeleccionado" value="<%= cuenta != null ? cuenta.getCBU() : "" %>">
    	<input type="submit" name="btnDarBajaCuenta" value="Aceptar">
    </div>
<% } %>
        
        <a href="BajaCuenta.jsp" class="boton-cerrar">Cancelar</a>

 </div>
</form>

</body>
</html>