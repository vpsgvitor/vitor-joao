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
<body>
<header>
		<div>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="navbar-nav">
					<ul class="nav">
					  <li class="nav-item"style="margin-right: 10px">
					    <a class="nav-link text-dark"  href="/your.groupid/partida/">Partidas</a>
					  </li>
					  <li class="nav-item"style="margin-right: 10px">
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
		<div class="col-sm-8">
			<h3 class="display-4" style=" margin-top: 12px;">Partidas</h3>
			<button class="btn btn-primary" onclick="location.href='/your.groupid/partida/novo'" style="margin-bottom: 12px; margin-top: 12px;">Nova Partida</button>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th class="text-center">Equipe 1</th>
						<th class="text-center">x</th>
						<th class="text-center">Equipe 2</th>
						<th class="text-center">#</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
					<c:when test="${not empty partidaList}">
							<c:forEach items="${partidaList}" var="partida">
								<tr>
									<td scope="row" class="text-center">${partida.equipe1.nome}</td>
									<td class="text-center">${partida.equipe1.golsNaPartida} x ${partida.equipe2.golsNaPartida}</td>
									<td class="text-center">${partida.equipe2.nome}</td>
									<td class="text-center"><a href="/your.groupid/partida/editar/${partida.id}" class="text-info">Definir Resultado</a></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<td colspan="4" class="text-center">Nenhuma partida cadastrada</td>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
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