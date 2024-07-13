package br.com.fuctura.controller;

import br.com.fuctura.model.entidade.Loja;
import br.com.fuctura.repository.LojaRepository;

import java.util.List;

public class LojaController {

    private LojaRepository lojaRepository;

    public LojaController(LojaRepository lojaRepository) {
        this.lojaRepository = lojaRepository;
    }

    public LojaController() {
		
	}

	public void cadastrarLoja(Loja loja) {
        lojaRepository.inserir(loja);
    }

    public void atualizarLoja(Loja loja) {
        lojaRepository.atualizar(loja);
    }

    public void deletarLoja(int codigo) {
        lojaRepository.deletar(codigo);
    }

    public Loja buscarLojaPorCodigo(int codigo) {
        return lojaRepository.buscarPorCodigo(codigo);
    }

    public List<Loja> listarTodasLojas() {
        return lojaRepository.buscarTodos();
    }
}
