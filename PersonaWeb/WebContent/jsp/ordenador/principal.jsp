<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="es.indra.formacion.pr.persistence.model.Persona" %>
<%@ page import="es.indra.formacion.pr.persistence.model.Ordenador" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ordenadores</title>
</head>
<body>
	<h1>Ordenadores</h1>
	
	<form action="Agregar" method="post">
		<table>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre"/></td>
			</tr>
			<tr>
				<td>Serial:</td>
				<td><input type="text" name="serial"/></td>
			</tr>
			<tr>
				<td>Propietario:</td>
				<td>
					<select name="personaId">
						<%
						List<Persona> personas = (List<Persona>)request.getAttribute("personas");
						if (personas != null) for (Persona p : personas) {
						%>
							<option value="<%= p.getId() %>"><%= p.getNombre() + " " + p.getApellido() %></option>
						<%
						}
						%>
					</select>
				</td>
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
			<th>Serial</th>
			<th>Propietario</th>
		</tr>
			
		<%
		List<Ordenador> ordenadores = (List<Ordenador>)request.getAttribute("ordenadores");
		if (ordenadores != null) for (Ordenador o : ordenadores) {
			String propietario = "";
			Persona p = o.getPersona();
			if (p != null)
				propietario = p.getNombre() + " " + p.getApellido();
		%>
			<tr>
				<td><%= o.getNombre() %></td>
				<td><%= o.getSerial() %></td>
				<td><%= propietario %></td>
			</tr>
		<%
		}
		%>
			
	</table>
</body>
</html>