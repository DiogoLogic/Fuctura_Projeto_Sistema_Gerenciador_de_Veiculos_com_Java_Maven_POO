package br.com.fuctura.model.dao;

import java.util.List;


import br.com.fuctura.model.entidade.Tipo;

public interface ITipoDAO {
	void inserir(Tipo tipo);
    void atualizar(Tipo tipo);
    void deletar(int codigo);
    Tipo buscarPorId(int codigo);
    List<Tipo> buscarTodos();
    void persistir(Tipo tipo);
    
}
