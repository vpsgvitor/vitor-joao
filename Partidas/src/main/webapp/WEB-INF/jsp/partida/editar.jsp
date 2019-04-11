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
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="navbar-nav">
					<ul class="nav">
					  <li class="nav-item" style="margin-right: 10px">
					    <a class="nav-link text-dark"  href="/your.groupid/partida/">Partidas</a>
					  </li>
					  <li class="nav-item" style="margin-right: 10px">
					    <a class="nav-link text-dark" href="/your.groupid/equipe/lista">Equipes</a>
					  </li>
					  <li class="nav-item">
					    <a class="nav-link text-dark" href="/your.groupid/partida/pontuacao">Pontuação</a>
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
					<input class="form-control" id="eq1" name="partida.golsEquipe1" placeholder="Gols marcados equipe 1" />
				</div>
				<div class="form-group">
					<input type="hidden" name="partida.equipe2.id" value="${partida.equipe2.id}" />
					<label for="eq2" class="lead">${partida.equipe2.nome}</label>
					<input class="form-control" id="eq2" name="partida.golsEquipe2" placeholder="Gols marcados equipe 2" />
				</div>
				<button type="submit" class="btn btn-primary float-right">Salvar</button>
			</form>
		</div>
	</div>
		<footer>
			<div class="row">
				<div class="col-sm-4">
					<ul class="nav fixed-bottom justify-content-center" style="margin-bottom: 30px">
						<li style="margin-right:10px "><a href="https://www.facebook.com/victhor.baesso" class="nav-link">J. Victor Baesso ®</a></li>
						<li style="margin-right:10px "><a href="https://www.facebook.com/mateus.beltrame.1" class="nav-link">Mateus Deividi ®</a></li>
						<li><a href="https://www.facebook.com/vitor.paulo.353" class="nav-link">Vitor Paulo ®</a></li>
					</ul>
				</div>
			</div>
		</footer>
</body>
</html>