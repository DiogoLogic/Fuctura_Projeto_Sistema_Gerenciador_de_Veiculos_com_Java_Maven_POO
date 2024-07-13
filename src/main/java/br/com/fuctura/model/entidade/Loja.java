package br.com.fuctura.model.entidade;

import lombok.Getter;
import lombok.Setter;

public class Loja {
	
 @Getter
 @Setter
 private Integer codigo;
 
 @Getter
 @Setter
 private String nome;
 
 @Getter
 @Setter
 private String cnpj;
 
 @Getter
 @Setter
 private Endereco endereco;
 
 public Loja() {
	 
 }

public Loja(Integer codigo, String nome, String cnpj, Endereco endereco) {
	super();
	this.codigo = codigo;
	this.nome = nome;
	this.cnpj = cnpj;
	this.endereco = endereco;
}

@Override
public String toString() {
	return "Loja [codigo=" + codigo + ", nome=" + nome + ", cnpj=" + cnpj + ", endereco=" + endereco + "]";
}
 

 
}
		

