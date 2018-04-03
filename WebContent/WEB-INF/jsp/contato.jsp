<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>T-Shirt - Contato</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/estilo.css">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet">
</head>
<body>
	
	<c:import url="cabecalho.jsp" />
		
	<div class="container">
	  <h1 class="titulo titulo_form">Contato</h1>

	  <form action="mvc?logica=AdicionaContatoLogic" method="post">
			<div class="form-group row">
				<label class="col-2 col-form-label" for="nome">Nome:</label> <input
					class="form-control col-10" type="text" name="nome"
					placeholder="Digite seu nome completo" required>
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label" for="email">E-mail:</label> <input
					class="form-control col-10" type="email" name="email"
					placeholder="Digite um e-mail vÃ¡lido" required>
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label" for="telefone">Telefone</label>
				<input class="form-control col-4" type="text" pattern="\(\d{2}\)\d{5}-\d{4}" name="telefone"
					placeholder="(DDD) + NÃºmero de telefone" /> <label
					class="col-2 col-form-label" for="assunto">Assunto</label> <select
					class="form-control col-4" name="assunto" required>
					<option value="selecione">Selecione</option>
					<option value="camisetas-masculinas">Camisetas Masculinas</option>
					<option value="camisetas-femininas">Camisetas Femininas</option>
					<option value="duvidas">Duvidas</option>
				</select>
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label" for="mensagem">Mensagem</label>
				<textarea class="form-control col-10" name="mensagem" required></textarea>
			</div>
			<div class="form-group row">
				<div class="offset-sm-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Enviar</button>
				</div>
			</div>
	   </form>
	</div>
	
	<c:import url="rodape.jsp" />
	
</body>
</html>
