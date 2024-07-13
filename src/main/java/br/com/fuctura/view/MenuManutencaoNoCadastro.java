package br.com.fuctura.view;

import java.util.List;
import java.util.Scanner;

import br.com.fuctura.controller.ClienteController;
import br.com.fuctura.controller.LojaController;
import br.com.fuctura.controller.VeiculoController;
import br.com.fuctura.controller.VendaController;
import br.com.fuctura.controller.VendedorController;
import br.com.fuctura.model.entidade.Cliente;
import br.com.fuctura.model.util.ScannerSingleton;

public class MenuManutencaoNoCadastro {

	private VeiculoController veiculoController;
	private LojaController lojaController;
	private VendedorController vendedorController;
	private ClienteController clienteController;
	private VendaController vendaController;

	public MenuManutencaoNoCadastro() {
		this.veiculoController = new VeiculoController();
		this.lojaController = new LojaController();
		this.vendedorController = new VendedorController();
		this.clienteController = new ClienteController();
		this.vendaController = new VendaController();
	}

	public void exibirManutencaoCadastro() {
		Scanner scan = ScannerSingleton.getInstance();
		int opcao1;
		try {
			do {
				System.out.println("______________________________________");
				System.out.println("==== MANUTENÇÃO NO CADASTRO ====");
				System.out.println("1. Gerenciar Veículo");
				System.out.println("2. Gerenciar Loja");
				System.out.println("3. Gerenciar Vendedor");
				System.out.println("4. Gerenciar Cliente");
				System.out.println("5. Gerenciar Venda");
				System.out.println("6. Voltar para o menu principal");
				System.out.print("Escolha uma opção: ");
				opcao1 = scan.nextInt();
				scan.nextLine(); 

				switch (opcao1) {
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
			} while (opcao1 != 6);
		} catch (Exception erro) {
			System.out.println("Entrada inválida. Por favor, insira um número válido de acordo com o menu.");
			scan.nextLine(); // Limpar buffer
		} finally {
			exibirManutencaoCadastro();
			scan.close();
		}
	}

	private void menuGerenciarVeiculo(Scanner scan) {
		int opcao2;
		do {
			System.out.println("______________________________________");
			System.out.println("==== GERENCIAR VEÍCULO ====");
			System.out.println("1. Cadastrar Veículo");
			System.out.println("2. Excluir Veículo");
			System.out.println("3. Alterar dados do veículo");
			System.out.println("4. Voltar para o menu superior");
			System.out.print("Escolha uma opção: ");
			opcao2 = scan.nextInt();
			scan.nextLine(); // Consumir a nova linha

			switch (opcao2) {
			case 1:
				veiculoController.cadastrarVeiculo();
				break;
			case 2:
				veiculoController.excluirVeiculo();
				break;
			case 3:
				veiculoController.alterarDadosVeiculo();
				break;
			case 4:
				return;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		} while (opcao2 != 4);
	}

	private void menuGerenciarLoja(Scanner scan) {
		int opcao3;
		do {
			System.out.println("______________________________________");
			System.out.println("==== GERENCIAR LOJA ====");
			System.out.println("1. Cadastrar Loja");
			System.out.println("2. Excluir Loja");
			System.out.println("3. Alterar dados da Loja");
			System.out.println("4. Voltar para o menu superior");
			System.out.print("Escolha uma opção: ");
			opcao3 = scan.nextInt();
			scan.nextLine(); // Consumir a nova linha

			switch (opcao3) {
			case 1:
			//	lojaController.cadastrarLoja();
				break;
			case 2:
			//	lojaController.excluirLoja();
				break;
			case 3:
			//	lojaController.alterarDadosLoja();
				break;
			case 4:
				return;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		} while (opcao3 != 4);
	}

	private void menuGerenciarVendedor(Scanner scan) {
		int opcao4;
		do {
			System.out.println("______________________________________");
			System.out.println("==== GERENCIAR VENDEDOR ====");
			System.out.println("1. Cadastrar Vendedor");
			System.out.println("2. Excluir Vendedor");
			System.out.println("3. Alterar dados do Vendedor");
			System.out.println("4. Voltar para o menu superior");
			System.out.print("Escolha uma opção: ");
			opcao4 = scan.nextInt();
			scan.nextLine(); // Consumir a nova linha

			switch (opcao4) {
			case 1:
			//	vendedorController.cadastrarVendedor();
				break;
			case 2:
			//	vendedorController.excluirVendedor();
				break;
			case 3:
			//	vendedorController.alterarDadosVendedor();
				break;
			case 4:
				return;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		} while (opcao4 != 4);
	}

	private void menuGerenciarCliente(Scanner scan) {
		int opcao5;
		do {
			System.out.println("______________________________________");
			System.out.println("==== GERENCIAR CLIENTE ====");
			System.out.println("1. Cadastrar Cliente");
			System.out.println("2. Atualizar Cliente (por CPF)");
			System.out.println("3. Deletar Cliente (por CPF)");
			System.out.println("4. Buscar Cliente (por CPF)");
			System.out.println("5. Listar Todos os Clientes");
			System.out.println("6. Voltar");
			System.out.print("Escolha uma opção: ");
			opcao5 = scan.nextInt();
			scan.nextLine();

			switch (opcao5) {
			case 1:
				System.out.println("\n==== CADASTRAR CLIENTE ====");
				System.out.print("Nome: ");
				String nome = scan.nextLine();
				System.out.print("CPF: ");
				String cpf = scan.nextLine();
				System.out.print("Celular: ");
				String celular = scan.nextLine();

				Cliente cliente = new Cliente();
				cliente.setNome(nome);
				cliente.setCpf(cpf);
				cliente.setCelular(celular);

				clienteController.cadastrarCliente(cliente);
				break;

			case 2:
				System.out.println("\n==== ATUALIZAR CLIENTE ====");
				System.out.print("CPF do cliente a ser atualizado: ");
				String cpfExistente = scan.nextLine();

				Cliente clienteExistente = clienteController.buscarClientePorCpf(cpfExistente); // Busca o cliente pelo
																								// CPF
				if (clienteExistente != null) {
					System.out.print("Novo Nome: ");
					String novoNome = scan.nextLine();
					if (!novoNome.isEmpty()) {
						clienteExistente.setNome(novoNome);
					}

					System.out.print("Novo Celular: ");
					String novoCelular = scan.nextLine();
					if (!novoCelular.isEmpty()) {
						clienteExistente.setCelular(novoCelular);
					}

					try {
						clienteController.atualizarCliente(clienteExistente);
						System.out.println("Cliente atualizado com sucesso!");
					} catch (IllegalArgumentException e) {
						System.out.println("Erro ao atualizar cliente: " + e.getMessage());
					}
				} else {
					System.out.println("Cliente não encontrado.");
				}
				break;

			case 3:
				System.out.println("\n==== DELETAR CLIENTE ====");
				System.out.print("CPF do cliente a ser deletado: ");
				String cpfDelete = scan.nextLine();

				try {
					clienteController.deletarCliente(cpfDelete);
					System.out.println("Cliente deletado com sucesso!");

				} catch (Exception e) {
					System.out.println("Erro ao deletar cliente: " + e.getMessage()); // Mensagem genérica para outros
																						// erros
				}
				break;

			case 4:
				System.out.println("\n==== BUSCAR CLIENTE POR CPF ====");
				System.out.print("CPF: ");
				String cpfBuscar = scan.nextLine();

				try {
					Cliente buscarCliente = clienteController.buscarClientePorCpf(cpfBuscar);
					if (buscarCliente != null) {
						System.out.println("Cliente encontrado:");
						System.out.println(buscarCliente);
					} else {
						System.out.println("Cliente não encontrado.");
					}
				} catch (Exception e) {
					System.out.println("Erro ao buscar cliente: " + e.getMessage());
				}
				break;

			case 5:
				try {
					List<Cliente> clientes = clienteController.listarTodosClientes();
					if (clientes.isEmpty()) {
						System.out.println("Nenhum cliente cadastrado.");
					} else {
						System.out.println("\n==== LISTA DE CLIENTES ====");
						for (Cliente clienteLista : clientes) {
							System.out.println(clienteLista);
						}
					}
				} catch (Exception e) {
					System.out.println("Erro ao listar clientes: " + e.getMessage());
				}
				break;
			case 6:
				exibirManutencaoCadastro();

				break;

			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		} while (opcao5 != 6);
	}

	private void menuGerenciarVenda(Scanner scan) {
		int opcao6;
		do {
			System.out.println("______________________________________");
			System.out.println("==== GERENCIAR VENDA ====");
			System.out.println("1. Cadastrar Venda");
			System.out.println("2. Excluir Venda");
			System.out.println("3. Voltar para o menu superior");
			System.out.print("Escolha uma opção: ");
			opcao6 = scan.nextInt();
			scan.nextLine(); // Consumir a nova linha

			switch (opcao6) {
			case 1:
			//	vendaController.cadastrarVenda();
				break;
			case 2:
				//vendaController.excluirVenda();
				break;
			case 3:
				return;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		} while (opcao6 != 4);
	}
}
