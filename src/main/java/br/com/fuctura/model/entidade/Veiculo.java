package br.com.fuctura.model.entidade;

import lombok.Getter;
import lombok.Setter;

public class Veiculo {
	

		@Getter
		@Setter
	    private Integer codigo;
		
		@Getter
		@Setter
	    private String placa;
		
		@Getter
		@Setter
	    private String modelo;
		
		@Getter
		@Setter
	    private int ano;
		
		@Getter
		@Setter
	    private double valor;

		
		public Veiculo() {
			
		}
		
		public Veiculo(int codigo, String placa, String modelo, int ano, double valor) {
			super();
			this.codigo = codigo;
			this.placa = placa;
			this.modelo = modelo;
			this.ano = ano;
			this.valor = valor;
		}

		@Override
		public String toString() {
			return "Veiculo [codigo=" + codigo + ", placa=" + placa + ", modelo=" + modelo + ", ano=" + ano + ", valor="
					+ valor + "]";
		}
		
		


}
