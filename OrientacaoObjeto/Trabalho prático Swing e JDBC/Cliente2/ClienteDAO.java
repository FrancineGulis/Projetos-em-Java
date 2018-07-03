
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author francine
 */
public class ClienteDAO {

    private final String stmtInserir = "INSERT INTO cliente(nome, sobrenome, RG, CPF, Endereco) VALUES(?,?,?,?,?)";
    private final String stmtConsultar = "SELECT * FROM cliente WHERE id = ?";
    private final String stmtListar = "SELECT * FROM cliente";
    //private final String stmtAtualizar = "SELECT * FROM cliente";
    private final String stmtExcluir = "DELETE * FROM cliente WHERE id = ?";

    public void inserirCliente(Cliente cliente) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtInserir, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getRG());
            stmt.setString(4, cliente.getCPF());
            stmt.setString(5, cliente.getEndereco());
            stmt.executeUpdate();
            cliente.setId(lerIdCliente(stmt));
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um autor no banco de dados. Origem=" + ex.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
    }

    private int lerIdCliente(PreparedStatement stmt) throws SQLException {
        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    public Cliente consultarCliente(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente clienteLido;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtConsultar);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                clienteLido = new Cliente(rs.getString("nome"));
                clienteLido.setId(rs.getInt("id"));
                return clienteLido;
            } else {
                throw new RuntimeException("Não existe cliente com este id. Id=" + id);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao consultar um cliente no banco de dados. Origem=" + ex.getMessage());
        } finally {
            try {
                rs.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar result set. Ex=" + ex.getMessage());
            };
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();;
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }

    }

    public List<Cliente> listarClientes() throws Exception {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> lista = new ArrayList();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtListar);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getString("nome"));
                cliente.setId(rs.getInt("id"));
                lista.add(cliente);
            }
            return lista;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao consultar uma lista de clientes. Origem=" + ex.getMessage());
        } finally {
            try {
                rs.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar result set. Ex=" + ex.getMessage());
            };
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();;
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }

    }

    public void excluirCliente(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente clienteLido;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtExcluir);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                clienteLido = new Cliente(rs.getString("nome"));
                clienteLido.setId(rs.getInt("id"));
            } else {
                throw new RuntimeException("Não existe cliente com este id. Id=" + id);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao consultar um cliente no banco de dados. Origem=" + ex.getMessage());
        } finally {
            try {
                rs.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar result set. Ex=" + ex.getMessage());
            };
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();;
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }

    }
    
    public void atualizarCliente(Cliente cliente) {

    }
}
