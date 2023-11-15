<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
	
	.menu_admin{
		display:flex;
		padding:20px;
		
		border-radius:10px;
		background-color:#6495ED;
		align-items: center;
    	justify-content: center;
		height:50vh;
	}
	
	.label_menu
	{
		font-size:16px;
		font-weight:bold;
		padding-bottom:10px;
	}
	
	
	.dropdown-menu{
		
		display:flex;
		flex-direction:column;
		padding:25px;
		background-color: #f2f2f2;
		margin:10px;
		border-radius:10px;
		width:200px;
		height:150px;
		box-shadow: 0px 0px 10px #888;
	}
	
	
	.dropdown-menu input[type="submit"] {
		padding:10px;
	    background: none;
	    border: none;

	    color: #00000; 
	    text-decoration: none; 
	    cursor: pointer;
}
	
	.dropdown-menu input[type="submit"]:hover {
    
    	color:  yellow;
	
	}
	
</style>
<title>Menu Administrador</title>
</head>
<body>

<center>
<h1>Menu Administrador</h1>
</center>
<div class="menu_admin" >



 <div class="dropdown-menu">
 
 <label class="label_menu">Administrar clientes</label>
 
 <form method="post" action="servletCliente"  >
 
     <input type="submit" name="btnLinkAlta" value="Alta nuevo cliente"></input>
 
 </form>

    <a class="dropdown-item" href="ListadoClientes.jsp">Modificar Clave Cliente</a>
 
    <a class="dropdown-item" href="BajaCliente.jsp">Baja cliente</a>
</div>

<div class="dropdown-menu">
 <label class="label_menu">Administrar cuentas</label>

    <a class="dropdown-item" href="Cuentas.jsp">Alta</a>

    <a class="dropdown-item" href="BajaCuenta.jsp">Baja</a>
</div>
<div class="dropdown-menu">
 <label class="label_menu">Prestamos</label>

    <a class="dropdown-item" href="ListadoPrestamos.jsp">Autorizar</a>
</div>

<div class="dropdown-menu">
 <label class="label_menu">Informes y reportes</label>
 <br>
    <a class="dropdown-item" href="InformesyReportes.jsp">Informes y Reportes</a>

</div> 

      
 </div>
</body>
</html>