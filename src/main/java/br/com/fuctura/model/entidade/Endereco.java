package br.com.fuctura.model.entidade;

import lombok.Getter;
import lombok.Setter;


public class Endereco {

	@Getter
	@Setter
	private Integer codigo;
	
	@Getter
	@Setter
	private String cep;
	
	@Getter
	@Setter
	private String logradouro;
	
	@Getter
	@Setter
	private String complemento;
	
	@Getter
	@Setter
	private Integer numero;

	public Endereco() {
		
	}
	
	public Endereco(Integer codigo, String cep, String logradouro, String complemento, Integer numero) {
		super();
		this.codigo = codigo;
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.numero = numero;
	}



	@Override
	public String toString() {
		return "Endereco [codigo=" + codigo + ", cep=" + cep + ", logradouro=" + logradouro + ", complemento="
				+ complemento + ", numero" +numero+ "]";
	}
	
	
	
}
