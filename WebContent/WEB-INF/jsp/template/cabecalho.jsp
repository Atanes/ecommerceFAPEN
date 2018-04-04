		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<c:url value="resources/img/asset0.png" var="imagem"/>
		<c:url value="<%=request.getContextPath() %>" var="contexto"/>
		
		<div class="row texto_endereco">
			<div class="col-md-6">
				<p>Avenida Ramiro Corleone, 151 - Vila Dora - Santo André</p>
			</div>
			<div class="col-md-6 text-right">
				<p>
					Telefones: <span class="grif">11 2381-4000 / 11 2381-4001</span>
				</p>
			</div>
		</div>
		<nav
			class="navbar navbar-light navbar-expand-sm bg-light navbar-light justify-content-center">
			<a class="navbar-brand d-flex w-50 mr-auto" href="index.html"><img
				class="img_logo" src="${imagem}"
				alt="Logo da loja camiseta"></a>
			<div class="navbar-collapse collapse w-100" id="collapsingNavbar3">
				<ul class="navbar-nav mx-auto w-100 justify-content-center">
					<li class="nav-item"><a class="nav-link"
						href="index.html">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="sobrenos.html">Sobre
							Nós</a></li>
					<li class="nav-item"><a class="nav-link" href="feminino.html">Feminino</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="masculino.html">Masculino</a>
					</li>
				</ul>
				<ul class="nav navbar-nav ml-auto w-100 justify-content-end">
					<li class="nav-item active"><a class="nav-link" href="adicionaContato">Contato</a>
					</li>
				</ul>
			</div>
		</nav>
