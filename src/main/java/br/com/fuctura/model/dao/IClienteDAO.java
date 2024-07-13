package br.com.fuctura.model.dao;

import java.util.List;

import br.com.fuctura.model.entidade.Cliente;

public interface IClienteDAO {
	
    void inserir(Cliente cliente);
    void atualizar(Cliente cliente);
    void deletar(String cpf);
    Cliente buscarPorCpf(String cpf);
    List<Cliente> buscarTodos();
	void persistir(Cliente cliente);
	
}
