<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="es.indra.formacion.pr.persistence.model.Persona" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Personas</title>
</head>
<body>
	<h1>Personas</h1>
	
	<form action="Agregar" method="post">
		<table>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre"/></td>
			</tr>
			<tr>
				<td>Apellido:</td>
				<td><input type="text" name="apellido"/></td>
			</tr>
			<tr>
				<td>Fecha de Nacimiento:</td>
				<td><input type="text" name="fechaNacimiento"/></td>
			</tr>
			<tr>
				<td>Altura:</td>
				<td><input type="text" name="altura"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Agregar"/></td>
			</tr>
		</table>
	</form>
	
	<br/>
	
	<table>
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Fecha de Nacimiento</th>
			<th>Altura</th>
		</tr>
	<%
	List<Persona> personas = (List<Persona>)request.getAttribute("personas");
	if (personas != null) for (Persona p : personas) {
	%>
		<tr>
			<td><%= p.getNombre() %></td>
			<td><%= p.getApellido() %></td>
			<td><%= p.getFechaNacimiento() %></td>
			<td><%= p.getAltura() %></td>
		</tr>
	<%
	}
	%>
	</table>
</body>
</html>