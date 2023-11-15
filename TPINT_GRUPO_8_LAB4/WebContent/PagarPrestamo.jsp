<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
<title>Abonar prestamo</title>
</head>
<body>
	<div class="encabezado">
	<%@ include file="NavBar.jsp" %>
	</div>
<center>
	<h1>Pagar prestamo</h1>
</center>


    <div class="Formulario">
        <div id="listaPrestamos">
            <p>Seleccione un préstamo:</p>
            <label>
                <input type="radio" name="prestamo" value="prestamo1"> Préstamo 1
            </label>
            <br>
            <label>
                <input type="radio" name="prestamo" value="prestamo2"> Préstamo 2
            </label>
            <br>
            <label>
                <input type="radio" name="prestamo" value="prestamo3"> Préstamo 3
            </label>
        </div>
    </div>

<div class="Formulario">
    <p>Cuotas a pagar:</p>
    
    <label>
        <input type="checkbox" name="cuota1" value="cuota1"> Cuota 1/3
        - Monto: $50.00
    </label>
    <br>
    <label>
        <input type="checkbox" name="cuota2" value="cuota2"> Cuota 2/3
        - Monto: $75.00
    </label>
    <br>
    <label>
        <input type="checkbox" name="cuota3" value="cuota3"> Cuota 3/3
        - Monto: $100.00
    </label>
    <br>
    
    	<p>Cuenta a debitar:</p>
        
        <select name="cuentaADebitar">
            
            <option value="cuenta1">Cuenta 1234 - Saldo $2323</option>
            <option value="cuenta2">Cuenta 2232 - Saldo "</option>

        </select>
        
        <form action="/ruta-de-pago">
            <button type="submit">Pagar Préstamo</button>
        </form>
</div>



</body>
</html>