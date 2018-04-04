<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Listagem dos Contatos</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/estilo.css">
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<div class="container">
	
		<h1 class="titulo titulo_form">Lista dos Contatos</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Nome</th>
					<th scope="col">Email</th>
					<th scope="col">Telefone</th>
					<th scope="col">Assunto</th>
					<th scope="col">Mensagem</th>
					<th scope="col" colspan="2">Ações</th>
				</tr>
			</thead>
			<tbody>
			<!-- percorre contatos montando as linhas da tabela -->
              <c:forEach var="contato" items="${contatos}">
			<tr>
				<td>${contato.id}</td>
				<td>${contato.nome}</td>
				<td>
					<c:if test="${not empty contato.email}">
	                    <a href="mailto:${contato.email}">${contato.email}</a>
	                </c:if>
                </td>
				<td>
				<c:choose>
					<c:when test="${not empty contato.telefone}">
						${contato.telefone}
					</c:when>
						<c:otherwise>
	            			Telefone não informado
	        			</c:otherwise>
					</c:choose>
				</td>
				<td>${contato.assunto}</td>
				<td>${contato.mensagem}</td>
				<td>
		         	<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">
		         		<img class="img-responsive img_acoes" src="resources/img/Delete_Icon.png" title="Excluir"/>
					</a>
				</td>
				<td>
					<a href="editarContato?id=${contato.id}">
         				<img class="img-responsive img_acoes" src="resources/img/editar.png" title="Editar"/>
					</a>
       			</td>
			</tr>
			</c:forEach>
           </tbody>
		</table>
	</div>
	<c:import url="rodape.jsp" />
</body>
</html>