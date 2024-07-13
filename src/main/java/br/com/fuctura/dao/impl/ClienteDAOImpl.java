package br.com.fuctura.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.model.dao.IClienteDAO;
import br.com.fuctura.model.entidade.Cliente;
import br.com.fuctura.model.util.DatabaseConnection;

public class ClienteDAOImpl implements IClienteDAO {
	
	private Connection conn;
	
	
	public ClienteDAOImpl() {
		this.conn = DatabaseConnection.getConnection();
		
	}

	@Override
	public void inserir(Cliente cliente) {
		String sql = "INSERT INTO Cliente (nome, cpf, celular) VALUES(?, ?, ?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getCelular());
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

	@Override
	public void atualizar(Cliente cliente) {
		String sql = "UPDATE cliente SET nome = ?, cpf =?, celular = ?, codigo WHERE codigo = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getCelular());
			stmt.setInt(4, cliente.getCodigo());
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletar(String cpf) {
		String sql = "DELETE from cliente WHERE cpf = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

	@Override
	public Cliente buscarPorCpf(String cpf) {
		String sql = "SELECT * FROM cliente WHERE cpf = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet resultado = stmt.executeQuery();
			if(resultado.next()) {
				Cliente cliente = new Cliente();
				cliente.setCodigo(resultado.getInt("codigo"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setCpf(resultado.getString("cpf"));
				cliente.setCelular(resultado.getString("celular"));
				return cliente;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Cliente> buscarTodos() {
		String sql = "SELECT * FROM cliente";
		List<Cliente> clientes = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigo(resultado.getInt("codigo"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setCelular(resultado.getString("celular"));
                clientes.add(cliente);
            }
			
			return clientes;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void persistir(Cliente cliente) {
		try (Connection conn = DatabaseConnection.getConnection()) {
			if (cliente.getCodigo() > 0) {
				atualizar(cliente);
			} else {
				inserir(cliente);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao persistir cliente: " + e.getMessage(), e);
		}
	}

}
