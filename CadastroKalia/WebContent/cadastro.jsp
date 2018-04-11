<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
               <a class="navbar-brand" href="./dashboard.jsp"><img src="./img/bioidade.jpeg" width="50" height="28" /></a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
               <ul class="nav navbar-nav">
                  <li><a href="#">Inicio <span class="glyphicon glyphicon-home"></span> </a></li>
				  <li class="active"><a href="./cadastro.jsp">Cadastre-se <span class="glyphicon glyphicon-plus-sign"></span> </a></li>
               </ul>
               <ul class="nav navbar-nav navbar-right">
                  
               </ul>
            </div>
            <!-- /.navbar-collapse -->
         </div>
         <!-- /.container-fluid -->
      </nav>
      <br>
      <br>
      <br>
      <div class="col-md-4 col-md-offset-4">
      <form class="form-horizontal" method="POST" action="/fametrodevweb/CadastroPaciente">
         <div class="form-group">
            <label class="col-md-4 control-label">Objeto</label>  
            <div class="col-md-5"><!--inputCadNome-->
               <input id="inputCadObjeto" name="inputCadObjeto" type="text" placeholder="Ex: Livro, CD, DVD, Revista." class="form-control input-md" required>
            </div>
         </div>
         <div class="form-group">
            <label class="col-md-4 control-label">Tipo</label>  
            <div class="col-md-5"><!--inputCadAltura-->
                <input id="inputCadTipo" name="inputCadAltura" type="text" placeholder="Ex: Impresso, Mídia" class="form-control input-md" required>           
            </div>
         </div>
         <div class="form-group">
            <label class="col-md-4 control-label">Para quem emprestou:</label>  
            <div class="col-md-5"><!--inputCadPeso-->
               <input id="inputCadRequisitante" name="inputCadPeso" type="text" placeholder="Informe o nome do requisitante" class="form-control input-md" required> 
            </div>
         </div>
         <div class="form-group">
            <label class="col-md-4 control-label">Data de devolução</label>  
            <div class="col-md-5"><!--inputCadIdade-->
            	<input id="inputCadDevolucao" name="inputCadIdade" type="date" placeholder="Informe a data de devolução" class="form-control input-md" required>
            </div>
         </div>
          <div class="form-group">
            <label class="col-md-4 control-label">Contato</label>  
            <div class="col-md-5"><!--inputCadAltura-->
                <input id="inputCadContato" name="inputCadAltura" type="text" placeholder="Ex: 85988990088" class="form-control input-md" required>           
            </div>
         </div>
         
         <div class="form-group">
            <label class="col-md-4 control-label" for="button1id"></label>
            <div class="col-md-8">
               <button type="submit" id="buttonCadCadastrar" name="buttonCadCadastrar" class="btn btn-success">Cadastrar</button>
               <button type="reset" id="buttonCadCancelar" name="buttonCadCancelar" class="btn btn-danger">Cancelar</button>
            </div>
         </div>
      </form>
      <br>
      <br>
      <footer>
         <p>Todos os direitos reservados - Copyright 2018</p>
      </footer>


</body>
</html>