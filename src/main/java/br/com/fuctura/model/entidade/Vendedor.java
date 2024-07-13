package br.com.fuctura.model.entidade;

import lombok.Getter;
import lombok.Setter;

public class Vendedor {
		
	
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
	    private Tipo tipo;
		
		public Vendedor() {
			
		}

		public Vendedor(int codigo, String nome, Tipo tipo) {
			super();
			this.codigo = codigo;
			this.nome = nome;
			this.tipo = tipo;
		}

		@Override
		public String toString() {
			return "Vendedor [codigo=" + codigo + ", nome=" + nome + ", tipo=" + tipo + "]";
		}
		
		

}
