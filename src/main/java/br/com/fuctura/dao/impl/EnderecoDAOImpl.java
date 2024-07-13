package br.com.fuctura.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.model.dao.IEnderecoDAO;
import br.com.fuctura.model.entidade.Endereco;
import br.com.fuctura.model.util.DatabaseConnection;

public class EnderecoDAOImpl implements IEnderecoDAO {
	
	private Connection conn;

    public EnderecoDAOImpl() {
    	this.conn = DatabaseConnection.getConnection();
    }

    @Override
    public void inserir(Endereco endereco) {
        String sql = "INSERT INTO endereco (logradouro, numero, complemento, cep) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, endereco.getLogradouro());
            stmt.setInt(2, endereco.getNumero());
            stmt.setString(3, endereco.getComplemento());
            stmt.setString(4, endereco.getCep());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir endereço: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Endereco endereco) {
        String sql = "UPDATE endereco SET logradouro = ?, numero = ?, complemento = ? cep = ? WHERE codigo = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, endereco.getLogradouro());
            stmt.setInt(2, endereco.getNumero());
            stmt.setString(3, endereco.getComplemento());
            stmt.setString(4, endereco.getCep());
            stmt.setInt(5, endereco.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar endereço: " + e.getMessage());
        }
    }

    @Override
    public void deletar(int codigo) {
        String sql = "DELETE FROM endereco WHERE codigo = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar endereço: " + e.getMessage());
        }
    }

    @Override
    public Endereco buscarPorId(int codigo) {
        String sql = "SELECT * FROM endereco WHERE codigo = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setCodigo(rs.getInt("codigo"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setCep(rs.getString("cep"));
                return endereco;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar endereço por ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Endereco> buscarTodos() {
        List<Endereco> enderecos = new ArrayList<>();
        String sql = "SELECT * FROM endereco";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setCodigo(rs.getInt("codigo"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setCep(rs.getString("cep"));
                enderecos.add(endereco);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todos os endereços: " + e.getMessage());
        }
        return enderecos;
    }

    @Override
    public void persistir(Endereco endereco) {
        if (endereco.getCodigo() != 0) {
            atualizar(endereco);
        } else {
            inserir(endereco);
        }
    }
}
