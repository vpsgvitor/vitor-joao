<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>

<h3>Partidas</h3>

<table class="table table-bordered table-striped">
  <thead>
    <tr>
      <th scope="col">Equipe 1</th>
      <th scope="col-sm-1">x</th>
      <th scope="col-sm-1">x</th>
      <th scope="col">Equipe 2</th>
      <th scope="col">#</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${partidaList}" var="partida">
	    <tr>
	      <th scope="row">${partida.equipe1.nome}</th>
	      <td>${partida.equipe1.golsNaPartida}</td>
	      <td>${partida.equipe2.golsNaPartida}</td>
	      <td>${partida.equipe2.nome}</td>
	      <td>###</td>
	    </tr>
    </c:forEach>
  </tbody>
</table>

</body>
</html>