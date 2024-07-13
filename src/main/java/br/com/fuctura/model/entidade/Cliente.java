package br.com.fuctura.model.entidade;

import lombok.Getter;
import lombok.Setter;


public class Cliente {
	
	@Getter
	@Setter
	private Integer codigo;
	
	@Getter
	@Setter
	private String nome;
	

	@Getter
	@Setter
	private String cpf;
	

	@Getter
	@Setter
	private String celular;



	public Cliente() {
		
	}
	
	public Cliente(Integer codigo, String nome, String cpf, String celular, Endereco endereco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
	}




	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", celular=" + celular + "]";
	}
	
	
	
	
}
