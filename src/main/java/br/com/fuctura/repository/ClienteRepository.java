package br.com.fuctura.repository;

import java.util.List;

import br.com.fuctura.model.entidade.Cliente;

public interface ClienteRepository {

	void inserir(Cliente cliente);

	void atualizar(Cliente cliente);

	void deletar(String cpf);

	Cliente buscarClientePorCpf(String cpf);
	
	List<Cliente> buscarTodos();

}
