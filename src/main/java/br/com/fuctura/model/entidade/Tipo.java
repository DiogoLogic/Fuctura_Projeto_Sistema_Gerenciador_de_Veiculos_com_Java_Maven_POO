package br.com.fuctura.model.entidade;

import lombok.Getter;
import lombok.Setter;

public class Tipo {
	
	@Getter
	@Setter
	private Integer codigo;
	
	@Getter
	@Setter
	private String descricao;

	public Tipo() {
		
	}

	public Tipo(Integer codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Tipo [codigo=" + codigo + ", descricao=" + descricao + "]";
	}
	
	
	
	
}
