<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
<title>Menu Administrador</title>
</head>
<body>

<center>
<h1>Menu Administrador</h1>
</center>
<div class="Formulario" >



 <div class="dropdown-menu">
 <label>Cliente</label>
 <form method="post" action="servletCliente"  >
 
     <input type="submit" name="btnLinkAlta" value="Alta nuevo cliente"></input>
 
 </form>

    <a class="dropdown-item" href="ListadoClientes.jsp">Modificar Clave Cliente</a>
    <a class="dropdown-item" href="BajaCliente.jsp">Baja</a>
  </div>
<div class="dropdown-menu">
 <label>Cuenta</label>
    <a class="dropdown-item" href="Cuentas.jsp">Alta</a>
    <a class="dropdown-item" href="BajaCuenta.jsp">Baja</a>
    </div>
 <div class="dropdown-menu">
 <label>Prestamos</label>
    <a class="dropdown-item" href="ListadoPrestamos.jsp">Autorizados</a>
      </div>
  
    <a class="dropdown-item" href="InformesyReportes.jsp">Informes y Reportes</a>
      
 </div>
</body>
</html>