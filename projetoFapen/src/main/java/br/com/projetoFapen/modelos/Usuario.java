package br.com.projetoFapen.modelos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long codigo;

	@NotBlank(message = "Nome é obrigatório!")
	private String nome;

	@NotBlank(message = "E-mail é obrigatório!")
	@Email(message = "Endereço de e-mail inválido!")
	private String email;

	@NotBlank(message = "Senha é obrigatória!")
	private String senha;
	
	private Boolean ativo;

	@NotNull(message = "Data de nascimento é obrigatória!")
	@Column(name = "data_nascimento", columnDefinition = "DATE")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataNascimento;

	@Size(min = 1, message = "Selecione pelo menos um grupo!")
	@ManyToMany
	@JoinTable(name = "usuario_grupo", joinColumns = @JoinColumn(name = "codigo_usuario")
			, inverseJoinColumns = @JoinColumn(name = "codigo_grupo"))
	private List<Grupo> grupos;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getDataFormatada() {
		LocalDate d = this.dataNascimento;  
		return d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

}
