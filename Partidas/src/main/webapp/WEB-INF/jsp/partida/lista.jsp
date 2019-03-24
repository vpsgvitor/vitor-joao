<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Partida</title>
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
					href="/your.groupid/equipe/lista">Equipes</a><a
					class="nav-link opcoes text-white h5"
					href="/your.groupid/equipe/pontuacao">Pontuação</a>
			</div>
		</nav>
	</div>
</header>
<body>
	<a href="/your.groupid/partida/novo">NOVO</a>
	<div class="row justify-content-sm-center">
		<div class="col-sm-10">
			<h3>Partidas</h3>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Equipe 1</th>
						<th>x</th>
						<th>Equipe 2</th>
						<th>#</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${partidaList}" var="partida">
						<tr>
							<th scope="row">${partida.equipe1.nome}</th>
							<td>${partida.equipe1.golsNaPartida}x
								${partida.equipe2.golsNaPartida}</td>
							<td>${partida.equipe2.nome}</td>
							<td><a href="/your.groupid/partida/editar/${partida.id}">Definir
									Resultado</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>