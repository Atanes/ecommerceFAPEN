<%@ page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>T-Shirt - Masculino</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/estilo.css">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet">

<c:url value="/imagensProdutos" var="imgPath" />
<c:url value="WEB-INF/jsp/template" var="templateURL" />
</head>
<body>
	<c:import url="${templateURL }/cabecalho.jsp" />

	<div class="container">
		<section id="anuncios-1" class="box-12">
			<h4 class="titulo-cam">Feminino</h4>

			<article id="img-esquerda-1" class="box-3">
				<img class="tam-camiseta" src="img/asset32.png"
					alt="camiseta minnie">
				<h3 class="name-an">Minnie</h3>
				<div class="preco-cam">
					<p>R$ 50,00</p>
				</div>
			</article>

			<article class="box-3 img-direita">
				<img class="tam-camiseta" src="img/asset33.png"
					alt="camiseta capitão america feminina">
				<h3 class="name-an">Team Rogers</h3>
				<div class="preco-cam">
					<p>R$ 55,00</p>
					<p class="preco-cam-tachado">R$ 65,00</p>
				</div>
			</article>

			<article class="box-3 img-direita">
				<img class="tam-camiseta" src="img/asset34.png"
					alt="camiseta princesas">
				<h3 class="name-an">Caveira e Coração</h3>
				<div class="preco-cam">
					<p>R$ 55,00</p>
				</div>
			</article>

			<article class="box-3 img-direita">
				<img class="tam-camiseta" src="img/asset35.png"
					alt="camiseta game of thrones feminina">
				<h3 class="name-an">Game Of Thrones</h3>
				<div class="preco-cam">
					<p>R$ 75,00</p>
				</div>
			</article>
		</section>

		<section id="anuncios-2" class="box-12">
			<article id="img-esquerda-2" class="box-3">
				<img class="tam-camiseta" src="img/asset36.png"
					alt="camiseta harry potter feminina">
				<h3 class="name-an">Harry Potter</h3>
				<div class="preco-cam">
					<p>R$ 55,00</p>
				</div>
			</article>

			<article class="box-3 img-direita">
				<img class="tam-camiseta" src="img/asset37.png"
					alt="camiseta legue of legends feminina">
				<h3 class="name-an">Legue of Legends</h3>
				<div class="preco-cam">
					<p>R$ 75,00
					<p class="preco-cam-tachado">R$ 85,00</p>
				</div>
			</article>

			<article class="box-3 img-direita">
				<img class="tam-camiseta" src="img/asset38.png"
					alt="camiseta ac/dc feminina">
				<h3 class="name-an">AC/DC</h3>
				<div class="preco-cam">
					<p>R$ 75,00</p>
				</div>
			</article>

			<article class="box-3 img-direita">
				<img class="tam-camiseta" src="img/asset39.png"
					alt="camiseta doctor whoo">
				<h3 class="name-an">Doctor Whoo</h3>
				<div class="preco-cam">
					<p>R$ 85,00</p>
				</div>
			</article>
		</section>

		<section id="anuncios-3" class="box-12">
			<article id="img-esquerda-3" class="box-3">
				<img class="tam-camiseta" src="img/asset40.png"
					alt="camiseta mulher maravilha">
				<h3 class="name-an">Mulher Maravilha</h3>
				<div class="preco-cam">
					<p>R$ 55,00</p>
				</div>
			</article>

			<article class="box-3 img-direita">
				<img class="tam-camiseta" src="img/asset41.png"
					alt="camiseta one piece feminina">
				<h3 class="name-an">One Piece Luffy</h3>
				<div class="preco-cam">
					<p>R$ 70,00</p>
				</div>
			</article>

			<article class="box-3 box-3 img-direita">
				<img class="tam-camiseta" src="img/asset42.png"
					alt="camiseta dva overwatch feminina">
				<h3 class="name-an">Dva Overwatch</h3>
				<div class="preco-cam">
					<p>R$ 80,00</p>
				</div>
			</article>

			<article class="box-3 img-direita">
				<img class="tam-camiseta" src="img/asset43.png"
					alt="camiseta i love rock n roll">
				<h3 class="name-an">I Love Rock n Roll</h3>
				<div class="preco-cam">
					<p>R$ 65,00</p>
				</div>
			</article>
		</section>
	</div>

	<c:import url="${templateURL }/rodape.jsp" />

</body>
</html>
