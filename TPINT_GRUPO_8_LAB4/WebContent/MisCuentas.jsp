<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList"%>
<%@ page import="dominio.Cuenta"%>
<%@ page import="dominio.Cliente"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="css/StyleSheet.css">
   
    <title>Mis Cuentas</title>
</head>
<body>
    <div class="encabezado">
       <%@ include file="NavBar.jsp" %>
    </div>

    <div class="Formulario">
		<form method="get" action="servletCuentas">

			<table border="1">
				<tr>
					<th>Cuenta</th>
					<th>Tipo de Cuenta</th>
					<th>CBU</th>
					<th>Saldo</th>
				</tr>
				<%
					if (request.getAttribute("clienteLogueado") != null) {
						Cliente cliente=(Cliente) request.getAttribute("clienteLogueado");
						System.out.println(cliente.toString());
						ArrayList<Cuenta> listaCuenta = (ArrayList<Cuenta>) request.getAttribute("cuentasClienteLogueado");
						for (Cuenta user : listaCuenta) {
				%>
				<tr>
					<td><%=user.getNroCuenta()%></td>
					<td><%=user.getTipo()%></td>
					<td><%=user.getCBU()%></td>
					<td><%=user.getSaldo()%></td>
				</tr>
				<%
					}
					}
				%>
			</table>




			<p>Seleccionar Cuenta</p>
			<p>
				<strong>Cuenta:</strong>
			</p>



		</form>
	</div>
	<input type="submit" value="Aceptar" name="btnAceptarMisCuentas">

	<br></br>
	
</body>
</html>
