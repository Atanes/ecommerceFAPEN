<%@ page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>T-Shirt - Produtos</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/estilo.css">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet">
</head>
<body>

	<c:import url="../template/cabecalho.jsp" />

	<div class="container">
		<h1 class="titulo titulo_form">Cadastro de Produtos</h1>
		
		<form action="mvc?logica=AdicionaProdutoLogic" method="post" enctype="multipart/form-data">
		
		<input type="hidden" name="id" value="${produto.id }"/>
			<div class="form-group row">
				<label class="col-2 col-form-label" for="descricao">Descrição:</label> <input
					class="form-control col-10" type="text" name="descricao"
					placeholder="Digite uma descrição para o produto" value="${produto.descricao }" required />
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label" for="genero">Gênero</label> <select
					class="form-control col-4" name="genero" required>
					<option value="selecione">Selecione...</option>
					<option value="masculino" <c:if test="${produto.genero == 'masculino'}">selected="true"</c:if>>Masculino</option>
					<option value="feminino" <c:if test="${produto.genero == 'feminino'}">selected="true"</c:if>>Feminino</option>
					<option value="unissex" <c:if test="${produto.genero == 'unissex'}">selected="true"</c:if>>Unissex</option>
				</select>
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label" for="url_imagem">Imagem:</label> <input
					class="form-control col-10" type="file" name="url_imagem"
					value="${produto.url_imagem }" required />
			</div>
			
			<div class="form-group row">
				<label class="col-2 col-form-label" for="preco_atual">Preço atual:</label> <input
					class="form-control col-10" type="text" name="preco_atual"
					value="${produto.valorMoeda(produto.preco_atual)}" required />
			</div>
			
			<div class="form-group row">
				<label class="col-2 col-form-label" for="preco_antigo">Preço antigo:</label> <input
					class="form-control col-10" type="text" name="preco_antigo"
					value="${produto.preco_antigo }" />
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label" for="estoque">Estoque:</label>
				<input class="form-control col-1" type="number" name="estoque"
					value="${produto.estoque }" />
			</div>

			<div class="checkbox">
				<label for="promocao"> 
					<input type="checkbox" name="promocao" <c:if test="${produto.promocao == true}">checked</c:if>/> Promoção
				</label>
			</div>
			
			
			<div class="form-group row">
				<div class="offset-sm-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Enviar</button>
				</div>
			</div>
		</form>
		<label>${message}</label>
	</div>

	<c:import url="../template/rodape.jsp" />
	
</body>
</html>