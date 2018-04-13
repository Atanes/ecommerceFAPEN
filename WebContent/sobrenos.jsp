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
		<section class="box-9">
			<h1 class="titulo-cam">Sobre Nós</h1>
			<p>Nossa loja é mais do que apenas uma loja de camisetas. Nós vendemos não só produtos de alta qualidade, mas sim queremos dar aos nossos clientes uma experiência positiva de atendimento e alta qualidade em nossos produtos.</p>
			<h3 class="subtitulo-cam">O Designer</h3>
			<p>Gustavo Jones é um designer gráfico e ilustrador. O seu grande hobby é o design e ele vem trabalhando ao longo dos anos em inúmeras estampas de camisetas e hoje é o nosso principal design criativo.</p>
		</section>
		<section id="imgdesigner" class="box-1">
		 <img src="resources/img/asset15.jpeg">
		</section>
	</div>

	<c:import url="${templateURL }/rodape.jsp" />
	
 </body>
</html>
