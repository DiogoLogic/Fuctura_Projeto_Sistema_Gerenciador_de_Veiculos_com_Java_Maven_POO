package br.com.fuctura.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.model.dao.IVendaDAO;
import br.com.fuctura.model.entidade.Venda;
import br.com.fuctura.model.util.DatabaseConnection;


public class VendaDAOImpl implements IVendaDAO {

    private Connection connection;

    public VendaDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void inserir(Venda venda) {
        String sql = "INSERT INTO venda (valor, cliente, vendedor, veiculo, loja) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, venda.getValor());
            stmt.setInt(2, venda.getCliente().getCodigo());
            stmt.setInt(3, venda.getVendedor().getCodigo());
            stmt.setInt(4, venda.getVeiculo().getCodigo());
            stmt.setInt(5, venda.getLoja().getCodigo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir venda: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Venda venda) {
        String sql = "UPDATE venda SET valor = ?, cliente = ?, vendedor = ?, veiculo = ?, loja = ? WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, venda.getValor());
            stmt.setInt(2, venda.getCliente().getCodigo());
            stmt.setInt(3, venda.getVendedor().getCodigo());
            stmt.setInt(4, venda.getVeiculo().getCodigo());
            stmt.setInt(5, venda.getLoja().getCodigo());
            stmt.setInt(6, venda.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar venda: " + e.getMessage());
        }
    }

    @Override
    public void deletar(int codigo) {
        String sql = "DELETE FROM venda WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar venda: " + e.getMessage());
        }
    }

    @Override
    public Venda buscarPorId(int codigo) {
        String sql = "SELECT * FROM venda WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Venda venda = new Venda();
                venda.setCodigo(rs.getInt("codigo"));
                venda.setValor(rs.getDouble("valor"));

                ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
                venda.setCliente(clienteDAO.buscarPorId(rs.getInt("cliente")));

                VendedorDAOImpl vendedorDAO = new VendedorDAOImpl();
                venda.setVendedor(vendedorDAO.buscarPorId(rs.getInt("vendedor")));

                VeiculoDAOImpl veiculoDAO = new VeiculoDAOImpl();
                venda.setVeiculo(veiculoDAO.buscarPorId(rs.getInt("veiculo")));

                LojaDAOImpl lojaDAO = new LojaDAOImpl();
                venda.setLoja(lojaDAO.buscarPorId(rs.getInt("loja")));

                return venda;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar venda por ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Venda> buscarTodos() {
        List<Venda> vendas = new ArrayList<>();
        String sql = "SELECT * FROM venda";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Venda venda = new Venda();
                venda.setCodigo(rs.getInt("codigo"));
                venda.setValor(rs.getDouble("valor"));

                ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
                venda.setCliente(clienteDAO.buscarPorId(rs.getInt("cliente")));

                VendedorDAOImpl vendedorDAO = new VendedorDAOImpl();
                venda.setVendedor(vendedorDAO.buscarPorId(rs.getInt("vendedor")));

                VeiculoDAOImpl veiculoDAO = new VeiculoDAOImpl();
                venda.setVeiculo(veiculoDAO.buscarPorId(rs.getInt("veiculo")));

                LojaDAOImpl lojaDAO = new LojaDAOImpl();
                venda.setLoja(lojaDAO.buscarPorId(rs.getInt("loja")));

                vendas.add(venda);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todas as vendas: " + e.getMessage());
        }
        return vendas;
    }

    @Override
    public void persistir(Venda venda) {
        if (venda.getCodigo() != 0) {
            atualizar(venda);
        } else {
            inserir(venda);
        }
    }
}
