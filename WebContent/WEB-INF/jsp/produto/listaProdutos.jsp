<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Listagem dos Produtos</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/estilo.css">

<c:url value="/imagensProdutos" var="imgPath" />
</head>
<body>
	<c:import url="../template/cabecalho.jsp" />
	<div class="container">
	
		<h1 class="titulo titulo_form">Lista dos Produtos cadastrados</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Descrição</th>
					<th scope="col">Imagem</th>
					<th scope="col">Preço Atual</th>
					<th scope="col">Preço Antigo</th>
					<th scope="col" colspan="2">Ações</th>
				</tr>
			</thead>
			<tbody>
			<!-- percorre contatos montando as linhas da tabela -->
              <c:forEach var="produto" items="${produtos}">
			<tr>
				<td>${produto.id}</td>
				<td>${produto.descricao}</td>
				<td>
					<img class="img_produto_lista" src="${produto.url_imagem}"/>
				</td>
				<td>${produto.valorMoeda(produto.preco_atual)}</td>
				<td>
				<c:choose>
					<c:when test="${not empty produto.preco_antigo}">
						${produto.valorMoeda(produto.preco_antigo)}
					</c:when>
						<c:otherwise>
	            			-
	        			</c:otherwise>
					</c:choose>
				</td>
				<td>
		         	<a href="mvc?logica=RemoveProdutoLogic&id=${produto.id}">
		         		<img class="img-responsive img_acoes" src="resources/img/Delete_Icon.png" title="Excluir"/>
					</a>
				</td>
				<td>
					<a href="mvc?logica=EditarProdutoLogic&id=${produto.id}">
         				<img class="img-responsive img_acoes" src="resources/img/editar.png" title="Editar"/>
					</a>
       			</td>
			</tr>
			</c:forEach>
           </tbody>
		</table>
	</div>
	<c:import url="../template/rodape.jsp" />
</body>
</html>