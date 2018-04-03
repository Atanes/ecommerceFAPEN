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
				</tr>
			</thead>
			<tbody>
			<%
				ContatoDAO dao = new ContatoDAO();
			                      List<Contato> contatos = dao.listar();

			                      for (Contato contato : contatos ) {
			%>
			<tr>
				<td><%=contato.getId() %></td>
				<td><%=contato.getNome() %></td>
				<td><%=contato.getEmail() %></td>
				<td><%=contato.getTelefone() %></td>
				<td><%=contato.getAssunto() %></td>
				<td><%=contato.getMensagem() %></td>
			</tr>
			<%
                      }
                      %>
           </tbody>
		</table>
	</div>
	
	<c:import url="rodape.jsp" />
	
</body>
</html>