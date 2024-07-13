package br.com.fuctura.controller;

import br.com.fuctura.model.entidade.Veiculo;
import br.com.fuctura.repository.VeiculoRepository;
import br.com.fuctura.repository.impl.VeiculoRepositoryImpl;

import java.util.List;
import java.util.Scanner;

public class VeiculoController {

    private VeiculoRepository veiculoRepository;

    public VeiculoController() {
        this.veiculoRepository = new VeiculoRepositoryImpl();
    }

    public void cadastrarVeiculo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
        System.out.print("Digite o modelo do veículo: ");
        String modelo = scanner.nextLine();
        System.out.print("Digite o ano do veículo: ");
        int ano = scanner.nextInt();
        System.out.print("Digite o valor do veículo: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha

        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(placa);
        veiculo.setModelo(modelo);
        veiculo.setAno(ano);
        veiculo.setValor(valor);

        veiculoRepository.salvar(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
    }

    public void excluirVeiculo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a placa do veículo a ser excluído: ");
        String placa = scanner.nextLine();

        Veiculo veiculo = veiculoRepository.buscarPorPlaca(placa);
        if (veiculo != null) {
            veiculoRepository.deletar(veiculo.getCodigo());
            System.out.println("Veículo excluído com sucesso!");
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    public void alterarDadosVeiculo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a placa do veículo a ser alterado: ");
        String placa = scanner.nextLine();

        Veiculo veiculo = veiculoRepository.buscarPorPlaca(placa);
        if (veiculo != null) {
            System.out.print("Digite o novo modelo do veículo: ");
            String modelo = scanner.nextLine();
            System.out.print("Digite o novo ano do veículo: ");
            int ano = scanner.nextInt();
            System.out.print("Digite o novo valor do veículo: ");
            double valor = scanner.nextDouble();
            scanner.nextLine(); // Consumir a nova linha

            veiculo.setModelo(modelo);
            veiculo.setAno(ano);
            veiculo.setValor(valor);

            veiculoRepository.atualizar(veiculo);
            System.out.println("Dados do veículo alterados com sucesso!");
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    public Veiculo buscarVeiculoPorPlaca(String placa) {
        return veiculoRepository.buscarPorPlaca(placa);
    }

    public List<Veiculo> listarTodosVeiculos() {
        return veiculoRepository.buscarTodos();
    }
}
