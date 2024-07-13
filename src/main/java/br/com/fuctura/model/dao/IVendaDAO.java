package br.com.fuctura.model.dao;

import java.util.List;


import br.com.fuctura.model.entidade.Venda;

public interface IVendaDAO {
	
    void inserir(Venda venda);
    void atualizar(Venda venda);
    void deletar(int codigo);
    Venda buscarPorId(int codigo);
    List<Venda> buscarTodos();
    void persistir(Venda venda);
    
}
