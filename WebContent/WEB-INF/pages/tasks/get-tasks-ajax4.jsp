<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="resources/js/jquery.js"></script>
<link type="text/css" href="resources/css/tasks.css" rel="stylesheet" >
<meta charset="ISO-8859-1">
<title>Listar Tasks</title>
</head>
<body>
	<script type="text/javascript">
		function finalizr(id) {
			$.post( "finalizatask",
					{'id':id},
					function(response) {
						console.log(response)
						$("#task_"+id).html(response)
					}
			);
		}
	</script>
<a href="novatask">Inserir nova task</a><br /><br />
<table border="1">
	<tr>
		<th>Id</th>
		<th>Descrição</th>
		<th>Finalizada</th>
		<th>Data da Finalização</th>
		<th>excluir</th>
		<th>alterar</th>
	</tr>
	<c:forEach items="${tasks}" var="task" >
		<tr id="task_${task.id}" bgcolor="#${task.id % 2 ==0 ? 'ffffff' : 'F0F8FF' }">
			<td>${task.id}</td>
			<td>${task.descricao}</td>
			<c:if test="${task.finalizada eq false}">
				<td><a href="#" onclick="finalizr(${task.id})" >Finalizar</a></td>
			</c:if>
			<c:if test="${task.finalizada eq true}">
				<td>Finalizada</td>
			</c:if>
			<td>
				<fmt:formatDate value="${task.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>
			</td>
			<td><a href="excluitask?id=${task.id}" >excluir</a></td>
			<td><a href="buscatask?id=${task.id}" >alterar</a></td>
		</tr>
	</c:forEach>
</table>
<c:import url="logout.jsp" />
</body>
</html>