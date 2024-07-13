package br.com.fuctura.view;

import br.com.fuctura.controller.ClienteController;
import br.com.fuctura.controller.LojaController;
import br.com.fuctura.controller.VeiculoController;
import br.com.fuctura.controller.VendaController;
import br.com.fuctura.controller.VendedorController;

import java.util.Scanner;

public class MenuFrenteDeLoja {

    private VeiculoController veiculoController;
    private LojaController lojaController;
    private VendedorController vendedorController;
    private ClienteController clienteController;
    private VendaController vendaController;

    public MenuFrenteDeLoja() {
        this.veiculoController = new VeiculoController();
        this.lojaController = new LojaController();
        this.vendedorController = new VendedorController();
        this.clienteController = new ClienteController();
        this.vendaController = new VendaController();
    }

    public void exibirFrenteDeLoja() {
        Scanner scan = new Scanner(System.in);
        int opcao;
        try {
            do {
                System.out.println("______________________________________");
                System.out.println("==== FRENTE DE LOJA ====");
                System.out.println("1. Gerenciar Veículo");
                System.out.println("2. Gerenciar Loja");
                System.out.println("3. Gerenciar Vendedor");
                System.out.println("4. Gerenciar Cliente");
                System.out.println("5. Gerenciar Venda");
                System.out.println("6. Voltar para o menu superior");
                System.out.print("Escolha uma opção: ");

                opcao = scan.nextInt();
                scan.nextLine(); // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        menuGerenciarVeiculo(scan);
                        break;
                    case 2:
                        menuGerenciarLoja(scan);
                        break;
                    case 3:
                        menuGerenciarVendedor(scan);
                        break;
                    case 4:
                        menuGerenciarCliente(scan);
                        break;
                    case 5:
                        menuGerenciarVenda(scan);
                        break;
                    case 6:
                        System.out.println("Voltando para o menu principal...");
                        MenuPrincipal menuPrincipal = new MenuPrincipal();
                        menuPrincipal.exibirMenu();
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } while (opcao != 6);
        } catch (Exception erro) {
            System.out.println("Entrada inválida. Por favor, insira um número válido de acordo com o menu.");
            scan.nextLine(); 
        } finally {
            scan.close();
        }
    }

    private void menuGerenciarVeiculo(Scanner scan) {
        int opcao1;
        do {
            System.out.println("______________________________________");
            System.out.println("==== GERENCIAR VEÍCULO ====");
            System.out.println("1. Consultar Veículo por Placa");
            System.out.println("2. Voltar para o menu superior");
            System.out.print("Escolha uma opção: ");
            opcao1 = scan.nextInt();
            scan.nextLine(); // Consumir a nova linha

            switch (opcao1) {
                case 1:
                    System.out.print("Digite a placa do veículo: ");
                    String placa = scan.nextLine();
                    veiculoController.buscarVeiculoPorPlaca(placa);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao1 != 2);
    }

    private void menuGerenciarLoja(Scanner scan) {
        int opcao2;
        do {
            System.out.println("______________________________________");
            System.out.println("==== GERENCIAR LOJA ====");
            System.out.println("1. Listar todas as Lojas");
            System.out.println("2. Voltar para o menu superior");
            System.out.print("Escolha uma opção: ");
            opcao2 = scan.nextInt();
            scan.nextLine(); // Consumir a nova linha

            switch (opcao2) {
                case 1:
                  //  lojaController.listarTodasLojas();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao2 != 2);
    }

    private void menuGerenciarVendedor(Scanner scan) {
        int opcao3;
        do {
            System.out.println("______________________________________");
            System.out.println("==== GERENCIAR VENDEDOR ====");
            System.out.println("1. Consultar Vendedor por Nome");
            System.out.println("2. Voltar para o menu superior");
            System.out.print("Escolha uma opção: ");
            opcao3 = scan.nextInt();
            scan.nextLine(); // Consumir a nova linha

            switch (opcao3) {
                case 1:
                    System.out.print("Digite o nome do vendedor: ");
                    String nome = scan.nextLine();
                  //  vendedorController.buscarVendedorPorNome(nome);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao3 != 2);
    }

    private void menuGerenciarCliente(Scanner scan) {
        int opcao4;
        do {
            System.out.println("______________________________________");
            System.out.println("==== GERENCIAR CLIENTE ====");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Consultar Cliente por CPF");
            System.out.println("3. Voltar para o menu superior");
            System.out.print("Escolha uma opção: ");
            opcao4 = scan.nextInt();
            scan.nextLine(); // Consumir a nova linha

            switch (opcao4) {
                case 1:
                    //clienteController.cadastrarCliente();
                    break;
                case 2:
                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = scan.nextLine();
                    clienteController.buscarClientePorCpf(cpf);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao4 != 3);
    }

    private void menuGerenciarVenda(Scanner scan) {
        int opcao5;
        do {
            System.out.println("______________________________________");
            System.out.println("==== GERENCIAR VENDA ====");
            System.out.println("1. Cadastrar Venda");
            System.out.println("2. Voltar para o menu superior");
            System.out.print("Escolha uma opção: ");
            opcao5 = scan.nextInt();
            scan.nextLine(); // Consumir a nova linha

            switch (opcao5) {
                case 1:
                   // vendaController.cadastrarVenda();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao5 != 2);
    }
}
