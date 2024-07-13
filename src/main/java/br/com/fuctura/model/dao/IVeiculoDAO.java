package br.com.fuctura.model.dao;

import java.util.List;


import br.com.fuctura.model.entidade.Veiculo;

public interface IVeiculoDAO {

    void inserir(Veiculo veiculo);
    void atualizar(Veiculo veiculo);
    void deletar(int codigo);
    Veiculo buscarPorId(int codigo);
    List<Veiculo> buscarTodos();
    void persistir(Veiculo veiculo);
    
}
