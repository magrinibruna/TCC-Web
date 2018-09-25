<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Portal do Aluno</title>
</head>
<body>

	<p id="demo"></p>

	<script>
	/*
	var obj = {};
	
	
	var notas = [];
	
	notas.append({"rm":"28999","nota":"10"});
	
	obj.notas = notas;
	
	vai no data
	JSON.stringyif(obj);
	*/
	var text = '{ "notas" : ['
		+ '{ "rm":"28923" , "nota":"7" },'
		+ '{ "rm":"20106" , "nota":"10" }] }';
		
	
		var config = {
			"method":"POST",
			"url":"nota",
			"data":text
		}
	
		var request = $.ajax(config);
	
		request.done(function(resp){
				
		});
	</script>

	<h3>Notas</h3>

	<form method="POST" action="cadastrarNota">
		<input type="hidden" name="notas"> 
		<input type="submit" value="Enviar" />
	</form>

	<form method="POST" action="http://localhost:8080/portalzinho">
		<input type="submit" value="Voltar" />
	</form>

</body>
</html>