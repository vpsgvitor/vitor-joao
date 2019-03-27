<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova Equipe</title>
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
		<div class="col-sm-5">
			<h2 class="display-4" style="margin-bottom: 12px; margin-top: 12px;">Nova Equipe</h2>
			<form action="/your.groupid/equipe/salvar" method="post">
			  <div class="form-group">
				<input type="hidden" name="equipe.id" value="${equipe.id}"> 
				<input type="text" class="form-control" value="${equipe.nome}" name="equipe.nome" placeholder="Nome">
			  </div>
			  
			  <button type="submit" class="btn btn-success float-right">Salvar</button>
			</form>
		</div>
	</div>
</body>
</html>