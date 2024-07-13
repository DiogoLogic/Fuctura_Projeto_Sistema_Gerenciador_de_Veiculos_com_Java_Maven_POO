package br.com.fuctura.model.dao;

import java.util.List;

import br.com.fuctura.model.entidade.Endereco;

public interface IEnderecoDAO {
	
	    void inserir(Endereco endereco);
	    void atualizar(Endereco endereco);
	    void deletar(int codigo);
	    Endereco buscarPorId(int codigo);
	    List<Endereco> buscarTodos();
		void persistir(Endereco endereco);
}
