<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" href="resources/css/tasks.css" rel="stylesheet" >
<meta charset="ISO-8859-1">
<title>Cadastra Task</title>
</head>
<body>
	<h2>Formulário de cadastros das <i>tasks</i></h2>
	<form action="cadastratask" method="post">
		<h3>Descrição</h3>
		<h4><form:errors path="task.descricao" cssStyle="color:red" ></form:errors></h4>
		<fmt:message key="teste.mensagem" /><br />
		Descrição: 
		<textarea name="descricao" rows="5" cols="100"></textarea><br />
<!-- 		Tarefa finalizada?
		<input name="finalizada" type="checkbox" /><br />
		Data de finalização:
		<input name="dataFinalizacao" type="datetime-local" /><br /> -->
		<input type="submit" value="Cadastrar" >
	</form>
</body>
</html>