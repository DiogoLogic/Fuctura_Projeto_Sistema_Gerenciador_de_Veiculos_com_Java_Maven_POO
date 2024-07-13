package br.com.fuctura.repository;

import br.com.fuctura.model.entidade.Veiculo;

import java.util.List;

public interface VeiculoRepository {
    void salvar(Veiculo veiculo);
    void atualizar(Veiculo veiculo);
    void deletar(int codigo);
    Veiculo buscarPorPlaca(String placa);
    Veiculo buscarPorId(int codigo);
    List<Veiculo> buscarTodos();
}
