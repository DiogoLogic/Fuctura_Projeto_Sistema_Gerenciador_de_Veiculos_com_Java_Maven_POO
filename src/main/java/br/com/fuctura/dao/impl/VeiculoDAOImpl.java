package br.com.fuctura.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.model.dao.IVeiculoDAO;
import br.com.fuctura.model.entidade.Veiculo;
import br.com.fuctura.model.util.DatabaseConnection;

public class VeiculoDAOImpl implements IVeiculoDAO {

    private Connection connection;

    public VeiculoDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void inserir(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo (placa, modelo, ano, valor) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setInt(3, veiculo.getAno());
            stmt.setDouble(4, veiculo.getValor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir veículo: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Veiculo veiculo) {
        String sql = "UPDATE veiculo SET placa = ?, modelo = ?, ano = ?, valor = ? WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setInt(3, veiculo.getAno());
            stmt.setDouble(4, veiculo.getValor());
            stmt.setInt(5, veiculo.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar veículo: " + e.getMessage());
        }
    }

    @Override
    public void deletar(int codigo) {
        String sql = "DELETE FROM veiculo WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar veículo: " + e.getMessage());
        }
    }

    @Override
    public Veiculo buscarPorId(int codigo) {
        String sql = "SELECT * FROM veiculo WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setCodigo(rs.getInt("codigo"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setAno(rs.getInt("ano"));
                veiculo.setValor(rs.getDouble("valor"));
                return veiculo;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar veículo por ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Veiculo> buscarTodos() {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM veiculo";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setCodigo(rs.getInt("codigo"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setAno(rs.getInt("ano"));
                veiculo.setValor(rs.getDouble("valor"));
                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todos os veículos: " + e.getMessage());
        }
        return veiculos;
    }

    @Override
    public void persistir(Veiculo veiculo) {
        if (veiculo.getCodigo() != 0) {
            atualizar(veiculo);
        } else {
            inserir(veiculo);
        }
    }
}
