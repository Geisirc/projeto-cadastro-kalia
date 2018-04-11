<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">


<title>Login</title>


<link href="estilo/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="estilo/style.css" rel="stylesheet">
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
				<li><a href="login.jsp">Início <span
						class="glyphicon glyphicon-home"></span>
				</a></li>

			</ul>
		</div>
	</div>
	</nav>
	
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<div id="login-overlay" class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
				<div class="row">
					<div class="col-md-10">
					<div class="well">
                          <form id="loginForm" method="POST" action="/CadastroKalia/Cadastro">
							 <p class="lead">Não tem cadastro?</p>
		                      <ul class="list-unstyled" style="line-height: 3">
		                          
		                      </ul>
		                      <div class="col-md-2">
		                      <p><a href="./cadastro.jsp" class="btn btn-info btn-block">Cadastre-se agora</a></p>
		                      </div>
		             	</form>
		           </div>	         
				</div>
				</div>
			</div>
		</div>
	</div>
	
	<br>
	<br>

	<c:if test="${mensagem == 'undefined'}">
		<script>
			alert("Login ou senha estão errados!");
		</script>
	</c:if>
	<footer>
	<p>Todos os direitos reservados - Copyright 2018</p>
	</footer>

</body>
</html>