<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

<form method="post" action="ServletHTML">

<label>Buscar préstamos por número de cuenta o DNI</label>
    <input type="text" name="filtro" placeholder="Ingrese número de cuenta o DNI">
    <input type="submit" value="Buscar" name="btnBuscar">
<h2> Listado de Prestamos</h2>

<table border="1" style="width: 550px; height: 70px">
<tr><th style="width: 90px; height: 25px; ">Numero Prestamo</th> <th>Numero Cuenta</th> <th> DNI Cliente</th> <th> Importe Solicitado </th> <th> Cantidad Cuotas </th></table>       
<p> Numero Prestamo <input type="text" name="idPrestamo" required style="width: 200px; "></input>
<input type="submit" value="Buscar" name="btnBuscarxNro">
		
		<br>
		<br>
		<br>
		<br>
		<input type="submit" value="Aprobar" >
		<input type="submit" value="Rechazar" >



    
    
</form>



 </div>
</body>
</html>