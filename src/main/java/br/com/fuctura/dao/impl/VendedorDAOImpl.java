package br.com.fuctura.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.model.dao.IVendedorDAO;
import br.com.fuctura.model.entidade.Vendedor;
import br.com.fuctura.model.util.DatabaseConnection;


public class VendedorDAOImpl implements IVendedorDAO {

    private Connection connection;

    public VendedorDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void inserir(Vendedor vendedor) {
        String sql = "INSERT INTO vendedor (nome, cpf, telefone) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, vendedor.getNome());
            stmt.setString(2, vendedor.getCpf());
            stmt.setString(3, vendedor.getTelefone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir vendedor: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Vendedor vendedor) {
        String sql = "UPDATE vendedor SET nome = ?, cpf = ?, telefone = ? WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, vendedor.getNome());
            stmt.setString(2, vendedor.getCpf());
            stmt.setString(3, vendedor.getTelefone());
            stmt.setInt(4, vendedor.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar vendedor: " + e.getMessage());
        }
    }

    @Override
    public void deletar(int codigo) {
        String sql = "DELETE FROM vendedor WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar vendedor: " + e.getMessage());
        }
    }

    @Override
    public Vendedor buscarPorId(int codigo) {
        String sql = "SELECT * FROM vendedor WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setCodigo(rs.getInt("codigo"));
                vendedor.setNome(rs.getString("nome"));
                vendedor.setCpf(rs.getString("cpf"));
                vendedor.setTelefone(rs.getString("telefone"));
                return vendedor;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar vendedor por ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Vendedor> buscarTodos() {
        List<Vendedor> vendedores = new ArrayList<>();
        String sql = "SELECT * FROM vendedor";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setCodigo(rs.getInt("codigo"));
                vendedor.setNome(rs.getString("nome"));
                vendedor.setCpf(rs.getString("cpf"));
                vendedor.setTelefone(rs.getString("telefone"));
                vendedores.add(vendedor);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todos os vendedores: " + e.getMessage());
        }
        return vendedores;
    }

    @Override
    public void persistir(Vendedor vendedor) {
        if (vendedor.getCodigo() != 0) {
            atualizar(vendedor);
        } else {
            inserir(vendedor);
        }
    }
}
