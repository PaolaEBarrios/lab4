<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="css\StyleSheet.css"></jsp:include>
</style>
<title>Movimientos de Cuenta</title>
</head>
<body>
	<div class="encabezado">
	<%@ include file="NavBar.jsp" %>
	</div>

    <h1>Movimientos de Cuenta</h1>
    
    <div class="Formulario">
        <p><strong>CBU:</strong> 12345678901234567890</p>
        <p><strong>Cuenta:</strong> Cuenta de Ahorro</p>
        <p><strong>Saldo:</strong> $1,000.00</p>
    </div>
    
    <h2>Historial de Movimientos</h2>
    
    <div class="Formulario">
        <table>
            <tr>
                <th>Fecha</th>
                <th>Detalle o Concepto</th>
                <th>Importe</th>
                <th>Tipo de Movimiento</th>
            </tr>
            <tr>
                <td>2023-10-01</td>
                <td>Compra en tienda</td>
                <td>$100.00</td>
                <td>Crédito</td>
            </tr>
           
        </table>
    </div>
    <br></br>
    <a href="Inicio.jsp" class="boton-volver">Volver a Inicio</a>
</body>
</html>
