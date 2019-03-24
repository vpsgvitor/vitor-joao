<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Equipes</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<header>
	<div>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="navbar-nav">
				<a class="nav-link opcoes text-white h5"
					href="/your.groupid/partida/">Partidas</a> <a
					class="nav-link opcoes text-white h5"
					href="/your.groupid/equipe/lista">Equipes</a> <a
					class="nav-link opcoes text-white h5"
					href="/your.groupid/equipe/pontuacao">Pontuação</a>
			</div>
		</nav>
	</div>
</header>
<body>
	<a href="/your.groupid/equipe/novo">NOVO</a>
	<h3>Equipes</h3>
	<table class="table table-bordered table-striped">
		<thead>
			<tr>
				<th scope="col">Nome</th>
				<th scope="col-sm-1">#</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${equipeList}" var="equipe">
				<tr>
					<th scope="row"><a
						href="/your.groupid/equipe/editar/${equipe.id}">${equipe.nome}</a></th>
					<td>Ver</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>