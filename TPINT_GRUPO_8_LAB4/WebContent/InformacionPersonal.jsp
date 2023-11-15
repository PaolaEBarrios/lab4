<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ include file="NavBar.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   
    <style type="text/css">
        	<jsp:include page="css\StyleSheet.css"></jsp:include>
    </style>
    <title>Mi Perfil</title>
</head>
<body>
    <div class="encabezado"></div>
    <div class="parteDer">
        <h1>Mi perfil</h1>
        <div class="Formulario">
            <p><strong>Nombre:</strong> </p>
            <p><strong>Apellido:</strong> </p>
            <p><strong>DNI:</strong> </p>
            <p><strong>CUIL:</strong> </p>
            <p><strong>Fecha de Nacimiento:</strong> </p>
            <p><strong>Email:</strong> </p>
            <p><strong>Sexo:</strong> </p>
            <p><strong>Telefono:</strong> </p>
            <p><strong>Dirección:</strong></p>
            <p><strong>Provincia:</strong> </p>
            <p><strong>Localidad:</strong> </p>
           <a href="ModificarDatos.jsp" class="boton-modificar">Modificar Datos</a>
        </div>
        <a href="CerrarSesion.jsp" class="boton-cerrar">Cerrar Sesión</a>
    </div>
</body>
</html>

