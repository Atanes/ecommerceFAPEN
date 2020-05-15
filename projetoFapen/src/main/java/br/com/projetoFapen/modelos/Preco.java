package br.com.projetoFapen.modelos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.persistence.Embeddable;

@Embeddable
public class Preco implements Serializable, Comparable<Preco>{

	private static final long serialVersionUID = -2058192870777069227L;
	
	private BigDecimal valor;
    private TipoPreco tipo;
    
    public Preco() {
    	
    }

	public Preco(TipoPreco tipoPreco) {
		this.tipo = tipoPreco;
	}

	public BigDecimal getValor() {
        return valor;
    }
    
    public boolean getValorNull() {
    	if(this.valor == null) {
    		return true;
    	}else {
    		return false;
    	}
    }

	/*
	 * public void setValor(BigDecimal valor) { this.valor = valor; }
	 */
    
    public void setValor(String valor) {
    	try {
    		if(!valor.isEmpty()) {
    			this.valor = new BigDecimal(converte(valor));
    		}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public TipoPreco getTipo() {
        return tipo;
    }

    public void setTipo(TipoPreco tipo) {
        this.tipo = tipo;
    }
    
    public static double converte(String arg) throws ParseException{
		
		if(arg.startsWith("R$")) {
			arg = arg.substring(3);
		}
	    //obtem um NumberFormat para o Locale default (BR)
	    NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));	    
	    String n = arg.replace(".", ",");
	    //converte um número com vírgulas ex: 2,56 para double
	    double number = nf.parse(n).doubleValue();
	    return number;
	}
    
    public String valorMoeda(){
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		if(this.valor != null){
			return nf.format(valor);
		}
		return "";
	}

	@Override
	public int compareTo(Preco p) {
        return this.tipo.compareTo(p.tipo);
      }
  }
  
