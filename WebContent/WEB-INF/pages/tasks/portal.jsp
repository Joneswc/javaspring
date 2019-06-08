<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link type="text/css" href="resources/css/tasks.css" rel="stylesheet" >
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Seja bem vindo ao portal: ${usuariologado.login}</h2>
<a href="gettasks" >Clique para exibir a lista de Tasks</a>
<br /><br /><br /><br />
<c:import url="logout.jsp" />
</body>
</html>