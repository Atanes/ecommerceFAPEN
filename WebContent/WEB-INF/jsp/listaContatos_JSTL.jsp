<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="br.com.iridiumit.ecommerceServlet.DAOs.*"  %>
    <%@ page import="br.com.iridiumit.ecommerceServlet.modelos.*" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem dos Contatos</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/estilo.css">
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<div class="container">
	<!-- cria o DAO -->
          <jsp:useBean id="dao" class="br.com.iridiumit.ecommerceServlet.DAOs.ContatoDAO"/>
	
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
					<th scope="col">Ações</th>
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
         				<img class="img_acoes" src="resources/img/Delete_Icon.png" title="Excluir"/>
					</a>
					
					<a href="mvc?logica=EditarContatoLogic&id=${contato.id}">
         				<img class="img_acoes" src="resources/img/editar.png" title="Editar"/>
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