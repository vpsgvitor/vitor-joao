<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Definir placar</title>

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
					    <a class="nav-link" href="/your.groupid/partida/pontuacao">Pontua��o</a>
					  </li>
					</ul>
				</div>
			</nav>
		</div>
	</header>
	<div class="row justify-content-sm-center">
		<div class="col-sm-4">
			<h3 class="display-4" style=" margin-top: 12px;">Definir resultado</h3>
			<form action="/your.groupid/partida/ajusta/placar" method="post">
				<input type="hidden" value="${partida.id}" name="partida.id">
				<div class="form-group">
					<input type="hidden" name="partida.equipe1.id" value="${partida.equipe1.id}" />
					<label for="eq1" class="lead">${partida.equipe1.nome}</label>
					<input class="form-control" id="eq1" name="partida.equipe1.golsNaPartida" placeholder="Gols marcados equipe 1" />
				</div>
				<div class="form-group">
					<input type="hidden" name="partida.equipe2.id" value="${partida.equipe2.id}" />
					<label for="eq2" class="lead">${partida.equipe2.nome}</label>
					<input class="form-control" id="eq2" name="partida.equipe2.golsNaPartida" placeholder="Gols marcados equipe 2" />
				</div>
				<button type="submit" class="btn btn-primary float-right">Salvar</button>
			</form>
		</div>
	</div>

</body>
</html>