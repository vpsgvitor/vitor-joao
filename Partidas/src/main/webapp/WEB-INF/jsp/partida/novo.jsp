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
	<div class="row  justify-content-sm-center">
		<div class="col-sm-5 ">
			<h2 class="display-4" style="text-align: center;">Nova Partida</h2>
			<form action="/your.groupid/partida/salvar" method="post">
				<div class="form-group">
					<select class="custom-select" name="partida.equipe1.id" placeholder="Equipe 1">
						<c:choose>
							<c:when test="${not empty equipes}">
								<c:forEach items="${equipes}" var="equipe1">
									<option selected value="${equipe1.id}">${equipe1.nome}</option>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<option>Nenhuma equipe cadastrada !!!</option>
							</c:otherwise>
						</c:choose>
					</select>
				</div>
				<div class="form-group">
					<select class="custom-select" name="partida.equipe2.id" placeholder="Equipe 2">
						<c:choose>
							<c:when test="${not empty equipes}">
								<c:forEach items="${equipes}" var="equipe2">
									<option selected value="${equipe2.id}">${equipe2.nome}</option>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<option>Nenhuma equipe cadastrada !!!</option>
							</c:otherwise>
						</c:choose>
					</select>
				</div>
				<button type="submit" class="btn btn-success">Salvar</button>
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