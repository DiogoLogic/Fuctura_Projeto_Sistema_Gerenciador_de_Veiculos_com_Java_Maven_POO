package br.com.fuctura.controller;

import java.util.List;

import br.com.fuctura.model.entidade.Cliente;
import br.com.fuctura.repository.ClienteRepository;

public class ClienteController {

	private ClienteRepository clienteRepository;

	public ClienteController() {

	}

	public ClienteController(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public void cadastrarCliente(Cliente cliente) {
	
		clienteRepository.inserir(cliente);
	}

	public void atualizarCliente(Cliente cliente) {
		clienteRepository.atualizar(cliente);
	}

	public void deletarCliente(String cpf) {
		clienteRepository.deletar(cpf);
	}

	public Cliente buscarClientePorCpf(String cpf) {
		return clienteRepository.buscarClientePorCpf(cpf);
	}

	public List<Cliente> listarTodosClientes() {
		return clienteRepository.buscarTodos();
	}
}
