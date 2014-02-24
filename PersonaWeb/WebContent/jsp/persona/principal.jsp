<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="es.indra.formacion.pr.persistence.model.Persona" %>
<%@ page import="es.indra.formacion.pr.persistence.model.Ordenador" %>

<!DOCTYPE html>
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
				<td>
					Ordenadores:<br/>
					<table>
						<tr>
							<td>Nombre:</td>
							<td><input type="text" name="ordenadorNombre"/></td>
						</tr>
						<tr>
							<td>Serial:</td>
							<td><input type="text" name="ordenadorSerial"/></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Agregar"/></td>
			</tr>
		</table>
	</form>
	
	<br/>
	
	<table border="1">
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Fecha de Nacimiento</th>
			<th>Altura</th>
			<th>Ordenadores</th>
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
			<td>
				<ul>
					<% 
					if (p.getOrdenadores() != null) for (Ordenador o : p.getOrdenadores()) {
					%>
						<li><%= o.getNombre() + " " + o.getSerial() %></li>
					<%
					}
					%>
				</ul>
			</td>
		</tr>
	<%
	}
	%>
	</table>
</body>
</html>