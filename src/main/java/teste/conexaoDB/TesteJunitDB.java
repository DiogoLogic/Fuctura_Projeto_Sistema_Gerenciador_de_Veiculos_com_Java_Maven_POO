package teste.conexaoDB;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.fuctura.dao.impl.ClienteDAOImpl;
import br.com.fuctura.model.dao.IClienteDAO;
import br.com.fuctura.model.entidade.Cliente;
import br.com.fuctura.model.util.DatabaseConnection;



public class TesteJunitDB {
	
	private IClienteDAO clienteDAO;
	
	   @BeforeEach // Executa antes de cada método de teste
	    public void setup() {
	        clienteDAO = new ClienteDAOImpl(); // Cria uma instância do DAO
	    }

	
	  @Test
	    void testConnection() throws SQLException { // Declara que o método pode lançar SQLException
	        // O try-with-resources garante o fechamento da conexão automaticamente
	        try (Connection connection = DatabaseConnection.getConnection()) {
	            assertNotNull(connection, "A conexão não deve ser nula."); // Mensagem mais clara
	        } 
	    }
	  
	  @Test
	  void testeInserirCliente() throws SQLException{
		  Cliente cliente =  new Cliente();
		   cliente.setNome("DiogoFleipe");
		   cliente.setCpf("12345678901");
	       cliente.setCelular("987654321");
	       clienteDAO.inserir(cliente);
	       
	       System.out.println("Cliente encontrado: "+ cliente);
		  
	  }
	
}
