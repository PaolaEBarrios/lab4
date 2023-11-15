<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dominio.Cuenta"%>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
<title>Prestamos</title>
</head>
<body>

<div class="encabezado">
<%@ include file="NavBar.jsp" %>
</div>

<div class="Formulario" >

<h2> Solicitar prestamo: </h2>

<form method="post" action="servletPrestamos">

	 DNI:  <input type="text" name="dniCliente" requiered></input>
	 
	 <br>
	
	 
	 
	 <select name="NroCuenta">
	
   	 </select>
	<hr>
	 
     <p>  Monto solicitado: <input type="text" name="MontoPrestamo"></input></p>
	
	 <p>Seleccionar cuotas:
        <input type="radio" id="doce" name="cuotas" value="cuotas">
        <label for="cuotas">12</label> 
        
        <input type="radio" id="veinticuatro" name="cuotas" value="cuotas">
        <label for="cuotas">24</label> 
        
        <input type="radio" id="treintayseis" name="cuotas" value="cuotas">
        <label for="cuotas">36</label> 
        
        <input type="radio" id="sesenta" name="cuotas" value="cuotas">
        <label for="cuotas">60</label> 
        
     </p> 
     <hr>
  	 <input type="submit" value="Solicitar" name="btnSolicitudPrestamo">
       
</form>

   



 </div>
</body>
</html>