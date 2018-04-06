package br.com.iridiumit.ecommerceServlet.modelos;

import java.io.Serializable;
import java.math.BigDecimal;

public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String descricao;
	private BigDecimal preco_atual;
	private BigDecimal preco_antigo;
	private String url_imagem;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco_atual() {
		return preco_atual;
	}
	public void setPreco_atual(BigDecimal preco_atual) {
		this.preco_atual = preco_atual;
	}
	public BigDecimal getPreco_antigo() {
		return preco_antigo;
	}
	public void setPreco_antigo(BigDecimal preco_antigo) {
		this.preco_antigo = preco_antigo;
	}
	public String getUrl_imagem() {
		return url_imagem;
	}
	public void setUrl_imagem(String url_imagem) {
		this.url_imagem = url_imagem;
	}
}
