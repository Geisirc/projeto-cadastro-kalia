<%@page import="br.com.kalia.dao.UsuarioDAO"%>
<%@page import="br.com.kalia.dao.CadastroDAO"%>
<%@page import="br.com.kalia.model.Cadastro"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" type="image/png" href="favicon.png" />
<link href="estilo/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="estilo/style.css" rel="stylesheet">
<title>Cadastro</title>
</head>
<body>

	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			</button>
			<a class="navbar-brand" href="./dashboard.jsp"><img
				src="./img/bioidade.jpeg" width="50" height="28" /></a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="#">Inicio <span
						class="glyphicon glyphicon-home"></span>
				</a></li>
				<li class="active"><a href="./cadastro.jsp">Cadastre-se <span
						class="glyphicon glyphicon-plus-sign"></span>
				</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">

			</ul>
		</div>
		<!-- /.navbar-collapse-->
	</div>
	<!-- /.container-fluid --> </nav>


	<%
		String id = request.getParameter("id_usuario");
		CadastroDAO excluiUser = new CadastroDAO();
		excluiUser.excluirUsuario(id);
	%>

	<script type="text/javascript">
		window.location.href = "http://localhost:8080/CadastroKalia/cadastro.jsp"
	</script>



	<br>
	<br>
	<br>
	<br>
	<br>
	<footer>
	<p>Todos os direitos reservados - Copyright 2018</p>
	</footer>


</body>
</html>