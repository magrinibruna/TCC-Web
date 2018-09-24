<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3> Bem vindo, Aluno! </h3> 
	
	<c:forEach var="evento" items="${listaEvento}">
		<tr>
			<td>${evento.dataEvento}</td>
			<td>${evento.tituloEvento}</td>
			<td>${evento.descricaoEvento}</td>
		</tr> <br/>
	</c:forEach>
	
	<br/> <br/>
	
	<form method="POST" action="nota">
		<input type="submit" value="Notas"/>
	</form> 
	
	<form method="GET" action="sugestao">
		<input type="submit" value="sugestao"/>
	</form>
	
	<form method="GET" action="horario">
		<input type="submit" value="horario"/>
	</form>
	
	


</body>
</html>