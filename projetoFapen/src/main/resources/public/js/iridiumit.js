function preencher_cpf(el) {
	document.getElementById('senha').value = el.value.replace(/\D/g, '');
	document.getElementById('login').value = el.value.replace(/\D/g, '');
}

function validarSenha() {
	senha = document.getElementById('senha');
	senha2 = document.getElementById('confirmarSenha');

	if (senha.value !== senha2.value) {
		alert("Atenção, as senhas devem ser iguais!")
		senha2.focus();
		senha2.select();
		senha2.style.borderColor = "red";
		return false;
	} else {
		return true;
	}

}
