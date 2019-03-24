<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova Partida</title>
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
	<div class="row justify-content-sm-center">
		<div class="col-sm-10">
			<h2>Nova Partida</h2>
			<form action="/your.groupid/partida/novo" method="post">
				<div class="form-group">
					<select class="custom-select" name="idEquipe01"
						placeholder="Equipe 1">
						<c:forEach items="${equipes}" var="equipe">
							<option selected value="${equipe.getId()}">${equipe.getNome()}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<select class="custom-select" name="idEquipe02"
						placeholder="Equipe 2">
						<c:forEach items="${equipes}" var="equipe">
							<option selected value="${equipe.getId()}">${equipe.getNome()}</option>
						</c:forEach>
					</select>
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</div>
</body>
</html>