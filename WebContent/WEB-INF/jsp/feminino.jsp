<%@ page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>T-Shirt - Feminino</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/estilo.css">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet">

<c:url value="/imagensProdutos" var="imgPath" />
<c:url value="template" var="templateURL" />
</head>
<body>
	<c:import url="${templateURL }/cabecalho.jsp" />

	<div class="container">
		<h4 class="titulo titulo_bloco">Camisas Femininas</h4>
        
        <div class="row text-center">
			<!-- percorre produtos exibindo cada produto na tela, sendo 4 por linha -->
			<c:forEach var="produto" items="${produtos}" varStatus="contador">

				<div class="col-md-3">
						<img class="rounded img_produto" src="${produto.url_imagem}" alt="${produto.genero }">
						<h3 class="desc_produto">${produto.descricao }</h3>
						 <div class="preco_produto">${produto.preco_atual}<p class="preco_produto preco_antigo">${produto.preco_antigo}</div>
				</div>

			</c:forEach>
		</div>
      </div>
	</div>

	<c:import url="${templateURL }/rodape.jsp" />

</body>
</html>
