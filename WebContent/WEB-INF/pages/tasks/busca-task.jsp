<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastra Task</title>
</head>
<body>
	<h2>Editar task - ${task.id}</h2>
	<form action="editatask" method="post">
		<input type="text" name="id" value="${task.id}" />
		<h3>Descrição</h3>
		Descrição: 
		<textarea name="descricao" rows="5" cols="100">${task.descricao}</textarea><br />
		Finalizada?
		<input name="finalizada" type="checkbox" value="true" ${task.finalizada? 'checked' : ''} /><br />
		Data de finalização:
		<input name="dataFinalizacao" type="text"
			value="<fmt:formatDate value="${task.dataFinalizacao.time}"
			pattern="dd/MM/yyyy"/>" /><br />
		<input type="submit" value="Editar" >
	</form>
</body>
</html>