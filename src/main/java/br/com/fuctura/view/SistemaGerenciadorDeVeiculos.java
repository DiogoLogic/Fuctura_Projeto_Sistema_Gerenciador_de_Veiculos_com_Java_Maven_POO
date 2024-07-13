package br.com.fuctura.view;


import br.com.fuctura.model.util.DatabaseConnection;

public class SistemaGerenciadorDeVeiculos {

    public static void main(String[] args) {

    	System.out.println("                                  _______");
    	System.out.println("                             ____//__|__\\\\______");
    	System.out.println("                            |     _        _    |");
    	System.out.println("                           -|----(_)------(_)---|-");
    	System.out.println("=========================================================================");
    	System.out.println(" =                 Projeto Sistema Gerenciador de Veículos               =");
    	System.out.println("=========================================================================");
    	System.out.println("");
    	System.out.println("           =________________=PROJETO 2º MÓDULO FUCTURA=_________________=");
    	System.out.println("");


        try {
            // Inicializando a conexão com o banco de dados
            DatabaseConnection.getConnection();
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");

            MenuPrincipal menuPrincipal = new MenuPrincipal();
            menuPrincipal.exibirMenu();

        } catch (Exception e) {
            System.err.println("Erro na conexão com o banco de dados: " + e.getMessage());
    
        } finally {
            // Fechar a conexão com o banco de dados
            DatabaseConnection.closeConnection();
            System.out.println("Conexão com o banco de dados encerrada.");
        }
    }
}
