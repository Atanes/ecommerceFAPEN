<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Listagem dos Produtos</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/estilo.css">

<c:url value="/imagensProdutos" var="imgPath" />
<c:url value="WEB-INF/jsp/template" var="templateURL" />
</head>
<body>
	<c:import url="${templateURL }/cabecalho.jsp" />
	<div class="container">
		<div id="fundo" class="jumbotron text-center">
			<h1>O que você veste</h1>
			<h2>é o que você é</h2>
		</div>
		<div class="row">
			<div class="col">
				<div class="img_texto">
					<a class="" href="#"> <img class="rounded mx-auto d-block"
						src="resources/img/slide01.jpg" alt="Liquida" />
						<div class="link">
							Liquida Verão <span>Todas as peças com até 60% OFF</span>
						</div>
					</a>
				</div>
				<div class="row caixa_imgs">
					<div class="col">
						<div class="img_texto">
							<a class="" href="feminino.html"> <img
								class="rounded mx-auto d-block" src="resources/img/asset1.jpeg"
								alt="Liquida" />
								<div class="link">Para Ela</div>
							</a>
						</div>
					</div>
					<div class="col">
						<div class="img_texto">
							<a class="" href="masculino.html"> <img
								class="rounded mx-auto d-block" src="resources/img/asset2.jpeg"
								alt="Liquida" />
								<div class="link">Para Ele</div>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="img_texto">
					<a class="" href="#"> <img class="rounded mx-auto d-block"
						src="resources/img/slide02.jpg" alt="Coleção Outono">
						<div class="link">Outono Inverno 2018</div>
					</a>
				</div>
			</div>
		</div>
		<h4 class="titulo titulo_bloco">Produtos em destaque</h4>
		<div class="row text-center">
			<div class="col-md-3">
				<img class="rounded img_produto" src="resources/img/asset3.png"
					alt="camiseta de arma">
				<h3 class="desc_produto">Ar-15 nature grass and animals</h3>
				<div class="preco_produto">R$ 95,00</div>
			</div>
			<div class="col-md-3">
				<img class="rounded img_produto" src="resources/img/asset5.png"
					alt="camiseta de cafeteira">
				<h3 class="desc_produto">Coffe Potheads</h3>
				<div class="preco_produto">
					R$ 70,00
					<p class="preco_produto preco_antigo">R$ 80,00
				</div>
			</div>
			<div class="col-md-3">
				<img class="rounded img_produto" src="resources/img/asset6.png"
					alt="camiseta com texto em inglÃªs">
				<h3 class="desc_produto">Thursday's</h3>
				<div class="preco_produto">R$ 80,00</div>
			</div>
			<div class="col-md-3">
				<img class="rounded img_produto" src="resources/img/asset7.png"
					alt="camiseta de coraÃ§Ã£o">
				<h3 class="desc_produto">Junk food ladies get friendly</h3>
				<div class="preco_produto">R$ 65,00</div>
			</div>
		</div>
		<div class="row text-center">
			<div class="col-md-3">
				<img class="rounded img_produto" src="resources/img/asset8.png"
					alt="camiseta com gota d'Ã¡gua com caveira">
				<h3 class="desc_produto">Fluoride there is poison in the tap
					water</h3>
				<div class="preco_produto">
					R$ 80,00
					<p class="preco_produto preco_antigo">R$ 95,00
				</div>
			</div>
			<div class="col-md-3">
				<img class="rounded img_produto" src="resources/img/asset9.png"
					alt="camiseta com imagem religiosa">
				<h3 class="desc_produto">Tarot card</h3>
				<div class="preco_produto">R$ 85,00</div>
			</div>
			<div class="col-md-3">
				<img class="rounded img_produto" src="resources/img/asset10.png"
					alt="camiseta de havard">
				<h3 class="desc_produto">Havard</h3>
				<div class="preco_produto">R$ 90,00</div>
			</div>
			<div class="col-md-3">
				<img class="rounded img_produto" src="resources/img/asset11.png"
					alt="camiseta com bacon">
				<h3 class="desc_produto">Bacon hand trophy</h3>
				<div class="preco_produto">R$ 105,00</div>
			</div>
		</div>
		<a href="#" class="btn btn-primary btn-lg botao_padrao">Veja mais
			produtos!!</a>
	</div>

	<c:import url="${templateURL }/rodape.jsp" />
</body>
</html>