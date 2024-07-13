package br.com.fuctura.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.model.dao.ITipoDAO;
import br.com.fuctura.model.entidade.Tipo;
import br.com.fuctura.model.util.DatabaseConnection;


public class TipoDAOImpl implements ITipoDAO {

    private Connection connection;

    public TipoDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void inserir(Tipo tipo) {
        String sql = "INSERT INTO tipo (descricao) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tipo.getDescricao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir tipo: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Tipo tipo) {
        String sql = "UPDATE tipo SET descricao = ? WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tipo.getDescricao());
            stmt.setInt(2, tipo.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar tipo: " + e.getMessage());
        }
    }

    @Override
    public void deletar(int codigo) {
        String sql = "DELETE FROM tipo WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar tipo: " + e.getMessage());
        }
    }

    @Override
    public Tipo buscarPorId(int codigo) {
        String sql = "SELECT * FROM tipo WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Tipo tipo = new Tipo();
                tipo.setCodigo(rs.getInt("codigo"));
                tipo.setDescricao(rs.getString("descricao"));
                return tipo;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar tipo por ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Tipo> buscarTodos() {
        List<Tipo> tipos = new ArrayList<>();
        String sql = "SELECT * FROM tipo";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Tipo tipo = new Tipo();
                tipo.setCodigo(rs.getInt("codigo"));
                tipo.setDescricao(rs.getString("descricao"));
                tipos.add(tipo);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todos os tipos: " + e.getMessage());
        }
        return tipos;
    }

    @Override
    public void persistir(Tipo tipo) {
        if (tipo.getCodigo() != 0) {
            atualizar(tipo);
        } else {
            inserir(tipo);
        }
    }
}
