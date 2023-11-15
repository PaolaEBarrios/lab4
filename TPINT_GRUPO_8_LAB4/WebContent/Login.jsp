<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
	.txtbox_label
	{
		padding:10px;
		margin:10px;
	}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
<title>Login de Usuario</title>
</head>
<body>
<center>
<h1>Inicio de Sesión</h1>
</center>

<div class="Formulario" >
	
	
	
	<form method="post" action="servletLogin">
	
		<p> Usuario <input type="text" name="Usuario" required></input>
		<p> Contraseña<input type="password" name="Contrasena" required> </input>
		
		<br>
		<br>
		<br>
		<br>
		<input type="submit" value="Login" name="btnLogin">
	
	</form>
</div>

	
</body>
</html>

