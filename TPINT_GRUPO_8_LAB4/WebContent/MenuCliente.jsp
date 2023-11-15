<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
<title>Menu</title>
</head>
<body>

<center>
<h1>Menu</h1>
</center>
<div class="Formulario" >



 <div class="dropdown-menu">
 
<div class="dropdown-menu">
 <label>Cuentas</label>
    <a class="dropdown-item" href="MisCuentas.jsp">Mis Cuentas</a>
    <a class="dropdown-item" href="Movimientos.jsp">Movimientos</a>
     <a class="dropdown-item" href="Transferencias.jsp">Transferencias</a>
   
    </div>
 <div class="dropdown-menu">
 <label>Prestamos</label>
    <a class="dropdown-item" href="Prestamos.jsp">Solicitar</a>
      <a class="dropdown-item" href="PagarPrestamo.jsp">Abonar Prestamo</a>
      </div>
  
    <a class="dropdown-item" href="InformacionPersonal.jsp">Mis Datos</a>
      
 </div>
</body>
</html>
