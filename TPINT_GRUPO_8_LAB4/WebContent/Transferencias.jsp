<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
<title>Transferencias</title>
</head>
<body>
<div class="encabezado">
<%@ include file="NavBar.jsp" %>
</div>


<div class="Formulario" >

<h2> Transferencias</h2>

<form method="post" action="ServletHTML">


<label>
	Seleccionar cuenta origen:
</label>

<select>
	<option>Cuenta 123123123</option>
</select>

<p> Dinero disponible:</input></p>
       <p>  Monto a transferir: <input type="text" name="MontonTransferencia" required></input></p>
	 <p>Cuenta:
        <input type="radio" id="propia" name="cuenta" value="propia">
        <label for="propia">Propia</label>
        <input type="radio" id="terceros" name="cuenta" value="terceros">
        <label for="terceros">Terceros</label>
      
     </p> CBU cuenta destino:  <input type="text" name="CuentaPropia"></input>
       
</select>
       
      
      <p>  <input type="submit" name="btnEnviarControles" value="Enviar"></input></br></p>
</form>



 </div>
</body>
</html>