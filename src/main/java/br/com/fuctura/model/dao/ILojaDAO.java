package br.com.fuctura.model.dao;

import java.util.List;

import br.com.fuctura.model.entidade.Loja;

public interface ILojaDAO {
	
    void inserir(Loja loja);
    void atualizar(Loja loja);
    void deletar(int codigo);
    Loja buscarPorId(int codigo);
    public List<Loja> buscarTodos();
    void persistir(Loja loja);
}
