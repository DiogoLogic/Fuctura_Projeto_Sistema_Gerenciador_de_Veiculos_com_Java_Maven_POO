package br.com.fuctura.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.model.dao.ILojaDAO;
import br.com.fuctura.model.entidade.Loja;
import br.com.fuctura.model.util.DatabaseConnection;

public class LojaDAOImpl implements ILojaDAO {

    private Connection conn;

    public LojaDAOImpl() {
        this.conn = DatabaseConnection.getConnection();
    }

    @Override
    public void inserir(Loja loja) {
        String sql = "INSERT INTO loja (nome, tipo, endereco) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, loja.getNome());
            stmt.setInt(2, loja.getTipo().getCodigo());
            stmt.setInt(3, loja.getEndereco().getCodigo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir loja: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Loja loja) {
        String sql = "UPDATE loja SET nome = ?, tipo = ?, endereco = ? WHERE codigo = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, loja.getNome());
            stmt.setInt(2, loja.getTipo().getCodigo());
            stmt.setInt(3, loja.getEndereco().getCodigo());
            stmt.setInt(4, loja.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar loja: " + e.getMessage());
        }
    }

    @Override
    public void deletar(int codigo) {
        String sql = "DELETE FROM loja WHERE codigo = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar loja: " + e.getMessage());
        }
    }

    @Override
    public Loja buscarPorId(int codigo) {
        String sql = "SELECT * FROM loja WHERE codigo = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Loja loja = new Loja();
                loja.setCodigo(rs.getInt("codigo"));
                loja.setNome(rs.getString("nome"));
                // Buscar e setar tipo e endereco com seus respectivos DAOs
                return loja;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar loja por ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Loja> buscarTodos() {
        List<Loja> lojas = new ArrayList<>();
        String sql = "SELECT * FROM loja";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Loja loja = new Loja();
                loja.setCodigo(rs.getInt("codigo"));
                loja.setNome(rs.getString("nome"));
                // Buscar e setar tipo e endereco com seus respectivos DAOs
                lojas.add(loja);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todas as lojas: " + e.getMessage());
        }
        return lojas;
    }

    @Override
    public void persistir(Loja loja) {
        if (loja.getCodigo() != 0) {
            atualizar(loja);
        } else {
            inserir(loja);
        }
    }
}
