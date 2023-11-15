<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
<title>Registro Nuevo Usuario</title>


<script type="text/javascript">

    function validarContrasenias() {
        var contrasenia = document.getElementById("Contrasenia").value;
        var contraseniaRep = document.getElementById("Contraseniarep").value;

        if (contrasenia !== contraseniaRep) {
            alert("Las contraseñas no coinciden. Por favor, vuelva a ingresarlas.");
            return false; 
        }

        return true;
    }
</script>
</head>
<body>


    <div class="encabezado">
       <%@ include file="NavBarAdm.jsp" %>
    </div>


<div class="Formulario" >

<h2> Registro de nuevo usuario</h2>

<form method="post" action="servletCliente" onsubmit="return validarContrasenias()">

	  <p>  Nombre:  <input type="text" name="Nombre" required></input>
	  	   Apellido:  <input type="text" name="Apellido"required>
	  <p>  DNI: <input type="number" required name="Dni"></input>
	  <p>  CUIL: <input type="number" placeholder="Sólo números sin guión"  required name="Cuil"></input>
      <p>  Fecha de Nacimiento: <input type="date" name="FechaNacimiento"></input>
      <p>  Email: <input type="email" placeholder="Este será su nombre de usuario" required name="Email"></input>
       <p>Sexo:
        <input type="radio" id="femenino" name="Sexo" value="Femenino">
        <label for="femenino">Femenino</label>
        <input type="radio" id="masculino" name="Sexo" value="Masculino">
        <label for="masculino">Masculino</label>
        <input type="radio" id="indefinido" name="Sexo" value="Indefinido">
        <label for="indefinido">Indefinido</label>
      
     </p> Telefono: <input type="tel" name="Telefono"></input></p>
       <p>  Dirección:  <input type="text" name="Direccion"></input>
  <p>Provincia:
   <select name="provincias">
        <% 
            List<String> provincias = (List<String>) request.getAttribute("provincias");
            if (provincias != null) {
                for (String provincia : provincias) { 
        %>
                    <option value="<%= provincia %>"><%= provincia %></option>
        <% 
                }
            }
        %>
    </select>
      
    
</p>

<p>Localidad:
    <select name="localidades">
        <% 
            List<String> localidades = (List<String>) request.getAttribute("localidades");
            if (provincias != null) {
                for (String localidad : localidades) { 
        %>
                    <option value="<%= localidad %>"><%= localidad %></option>
        <% 
                }
            }
        %>
    </select>
</p>

<p>Nacionalidad:
    <select name="nacionalidades">
         <% 
            List<String> nacionalidades = (List<String>) request.getAttribute("nacionalidades");
            if (provincias != null) {
                for (String nacionalidad : nacionalidades) { 
        %>
                    <option value="<%= nacionalidad %>"><%= nacionalidad %></option>
        <% 
                }
            }
        %>
    </select>
</p>
  
    
       
     	
        <p> Establezca su contraseña (6 caracteres)*:  <input type="password" name="Contrasenia" maxlength="6" required id="Contrasenia"></input>
        <p> Repita su contraseña (6 caracteres)*:  <input type="password" name="Contraseniarep" placeholder="Repita la contraseña" maxlength="6" required id="Contraseniarep" ></input>
     
      <p>  <input type="submit" name="btnEnviarControles" value="Enviar"></input></br></p>
</form>



 </div>

</body>
</html>