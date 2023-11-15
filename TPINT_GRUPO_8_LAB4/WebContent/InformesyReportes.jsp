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
<br>
 <select name="Informes">
    <option value="CantidadTransferencia">Cantidad Transferencia</option>
    <option value="CantidadPrestamos">Cantidad de Prestamos</option>
   
</select>
   Desde: <input type="date" name="InformeDesde"></input>
     Hasta: <input type="date" name="InformeHasta"></input>
     
<input type="submit" value="Buscar" >	
	     
</body>
</html>