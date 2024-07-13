package br.com.fuctura.model.dao;

import java.util.List;

import br.com.fuctura.model.entidade.Vendedor;

public interface IVendedorDAO {
	
	void inserir(Vendedor vendedor);
    void atualizar(Vendedor vendedor);
    void deletar(int codigo);
    Vendedor buscarPorId(int codigo);
    List<Vendedor> buscarTodos();
    void persistir(Vendedor vendedor);
    
}
