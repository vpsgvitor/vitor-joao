<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pontuação</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<body>
	<header>
		<div>
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
				<div class="navbar-nav">
					<ul class="nav">
					  <li class="nav-item">
					    <a class="nav-link"  href="/your.groupid/partida/">Partidas</a>
					  </li>
					  <li class="nav-item">
					    <a class="nav-link" href="/your.groupid/equipe/lista">Equipes</a>
					  </li>
					  <li class="nav-item">
					    <a class="nav-link" href="/your.groupid/partida/pontuacao">Pontuação</a>
					  </li>
					</ul>
				</div>
			</nav>
		</div>
	</header>
	
	<div class="row justify-content-sm-center">
		<div class="col-sm-8">
			<h3 class="display-4" style=" margin-top: 12px;">Pontuação</h3>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th scope="col">Nome</th>
						<th scope="col">Pontuacao</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty equipeList}">
							<c:forEach items="${equipeList}" var="equipe">
								<tr>
									<td scope="row">${equipe.nome}</td>
									<td scope="row">${equipe.pontuacao}</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="2" class="text-center">Sem registros</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>