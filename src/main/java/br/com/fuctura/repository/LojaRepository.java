package br.com.fuctura.repository;

import br.com.fuctura.model.entidade.Loja;

import java.util.List;

public interface LojaRepository {

    void inserir(Loja loja);

    void atualizar(Loja loja);

    void deletar(int codigo);

    Loja buscarPorCodigo(int codigo);

    List<Loja> buscarTodos();
}
