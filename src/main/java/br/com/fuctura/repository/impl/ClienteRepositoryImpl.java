package br.com.fuctura.repository.impl;

import java.util.List;


import br.com.fuctura.model.dao.IClienteDAO;
import br.com.fuctura.model.entidade.Cliente;
import br.com.fuctura.repository.ClienteRepository;


public class ClienteRepositoryImpl implements ClienteRepository {

    private IClienteDAO clienteDAO;

    public ClienteRepositoryImpl(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public void inserir(Cliente cliente) {
        validarCliente(cliente);
        try {
            clienteDAO.inserir(cliente);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar cliente: " + e.getMessage(), e);
        }
    }

    @Override
    public void atualizar(Cliente cliente) {
        validarCliente(cliente);
        try {
            clienteDAO.atualizar(cliente);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar cliente: " + e.getMessage(), e);
        }
    }

    @Override
    public void deletar(String cpf) {
        try {
            if (clienteDAO.buscarPorCpf(cpf) == null) {
                System.out.println("Cliente não encontrado com o CPF: " + cpf);
            }
            clienteDAO.deletar(cpf);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar cliente: " + e.getMessage(), e);
        }
    }

    @Override
    public Cliente buscarClientePorCpf(String cpf) {
        try {
            return clienteDAO.buscarPorCpf(cpf);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar cliente por CPF: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Cliente> buscarTodos() {
        try {
            return clienteDAO.buscarTodos();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar todos os clientes: " + e.getMessage(), e);
        }
    }

    private void validarCliente(Cliente cliente) {
        validarNome(cliente);
        validarCpf(cliente);
        validarCpfExistente(cliente);
    }

    private void validarNome(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente é obrigatório.");
        }
    }

    private void validarCpf(Cliente cliente) {
        if (cliente.getCpf() == null) {
            throw new IllegalArgumentException("O CPF do cliente é inválido.");
        }
    }

    private void validarCpfExistente(Cliente cliente) {
        if (clienteDAO.buscarPorCpf(cliente.getCpf()) != null) {
            throw new IllegalArgumentException("Já existe um cliente com este CPF.");
        }
    }

    
}
