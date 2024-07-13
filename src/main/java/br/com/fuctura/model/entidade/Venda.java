package br.com.fuctura.model.entidade;

import lombok.Getter;
import lombok.Setter;

public class Venda {
	
	@Getter
	@Setter
    private int codigo;
	
	@Getter
	@Setter
    private double valor;
	
	public Venda() {
		
	}

	public Venda(int codigo, double valor) {
		super();
		this.codigo = codigo;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Venda [codigo=" + codigo + ", valor=" + valor + "]";
	}
	
	
}
