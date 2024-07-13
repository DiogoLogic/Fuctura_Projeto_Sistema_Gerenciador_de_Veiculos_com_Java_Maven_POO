package br.com.fuctura.view;


import java.util.Scanner;

public class MenuPrincipal {

	public void exibirMenu() {
		Scanner scan = new Scanner(System.in);
		int opcao = 0;
		try {
			do {
				System.out.println("______________________________________");
				System.out.println("==== MENU PRINCIPAL ====");
				System.out.println("1. Frente de Loja");
				System.out.println("2. Manutenção no Cadastro");
				System.out.println("3. Sair");
				System.out.print("Escolha uma opção: ");

				opcao = scan.nextInt();

				switch (opcao) {
				case 1:
					MenuFrenteDeLoja frenteDeLoja = new MenuFrenteDeLoja();
					frenteDeLoja.exibirFrenteDeLoja();
					break;
				case 2:
					MenuManutencaoNoCadastro menuManutencaoNoCadastro = new MenuManutencaoNoCadastro();
					menuManutencaoNoCadastro.exibirManutencaoCadastro();
					break;
				case 3:
					System.out.println("Encerrando o Sistema Gerenciador de Veículos...");
					System.exit(0);
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
					break;
				}

			} while (opcao != 3);

		} catch (Exception erro) {

			System.out.println("Entrada inválida. Por favor, insira um número válido de acordo com o menu.");
		} finally {
			exibirMenu();
			scan.close();

		}

	}
}
