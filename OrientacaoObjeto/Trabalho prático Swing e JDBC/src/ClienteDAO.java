/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author franca
 */
public class ClienteDAO {

    private List<Cliente> lista;
    private static ClienteDAO instanciaRep;
    private final String stmtListarClientes = "SELECT * FROM CLIENTE";
    private final String stmtIncluirCliente = "INSERT INTO CLIENTE (nome, sobrenome, rg, cpf, endereco) VALUES (?,?,?,?,?)";
    private final String stmtAtualizarCliente = "UPDATE CLIENTE SET nome = ?, sobrenome = ?, rg = ?, cpf = ?, endereco = ? WHERE id = ? ";
    private final String stmtRemoverCliente = "DELETE FROM CLIENTE WHERE id = ?";

    public ClienteDAO() {
        lista = new ArrayList<Cliente>();
    }

    public static ClienteDAO obterInstancia() {
        if (instanciaRep == null) {
            instanciaRep = new ClienteDAO();
        }
        return instanciaRep;
    }

    public List<Cliente> listarTodos() {
        if(lista.size()>0){
            lista.clear();
        }
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtListarClientes);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setSobrenome(rs.getString(3));
                cliente.setRg(rs.getString(4));
                cliente.setCpf(rs.getString(5));
                cliente.setEndereco(rs.getString(6));
                lista.add(cliente);
            }
            Collections.sort(lista, new Comparator<Cliente>() {
                @Override
                public int compare(Cliente arg0, Cliente arg1) {
                    return arg0.getNome().compareToIgnoreCase(arg1.getNome());
                }
            });

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            try {
                con.close();
                stmt.close();
                rs.close();
            } catch (SQLException c) {
                JOptionPane.showMessageDialog(null, c);
            }
        }
        return lista;
    }

    public void inserir(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("O cliente não foi instanciado");
        }
        if (cliente.getNome() == null) {
            throw new Exception("Informar o Nome do cliente");
        }
        if (cliente.getNome().trim().equals("")) {
            throw new Exception("Informar o Nome do cliente");
        }
        if (cliente.getSobrenome() == null) {
            throw new Exception("Informar o Sobrenome do cliente");
        }
        if (cliente.getSobrenome().trim().equals("")) {
            throw new Exception("Informar o Sobrenome do cliente");
        }
        if (cliente.getRg() == null) {
            throw new Exception("Informar o RG do cliente");
        }
        if (cliente.getRg().trim().equals("")) {
            throw new Exception("Informar o RG do cliente");
        }
        if (cliente.getCpf() == null) {
            throw new Exception("Informar o CPF do cliente");
        }
        if (cliente.getCpf().trim().equals("")) {
            throw new Exception("Informar o CPF do cliente");
        }
        if (cliente.getEndereco() == null) {
            throw new Exception("Informar o Endereco do cliente");
        }
        if (cliente.getEndereco().trim().equals("")) {
            throw new Exception("Informar o Endereco do cliente");
        }
        if (this.verificarExistencia(cliente) >= 0) {
            throw new Exception("O referido Cliente já se encontra cadastrado");
        }
        this.incluirClienteBD(cliente);
    }

    private void incluirClienteBD(Cliente cliente) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            stmt = con.prepareStatement(stmtIncluirCliente, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getRg());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getEndereco());
            stmt.execute();
            con.commit();
            cliente.setId(lerIdCliente(stmt));
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar rollback. " + e1.getMessage());
            }
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            try {
                con.close();
                stmt.close();
            } catch (SQLException c) {
                JOptionPane.showMessageDialog(null, c);
            }
        }
    }

    private int lerIdCliente(PreparedStatement stmt) throws SQLException {
        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    public void atualizar(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("O cliente não foi instanciado");
        }
        if (cliente.getNome() == null) {
            throw new Exception("Informar o Nome do cliente");
        }
        if (cliente.getNome().trim().equals("")) {
            throw new Exception("Informar o Nome do cliente");
        }
        if (cliente.getSobrenome() == null) {
            throw new Exception("Informar o Sobrenome do cliente");
        }
        if (cliente.getSobrenome().trim().equals("")) {
            throw new Exception("Informar o Sobrenome do cliente");
        }
        if (cliente.getRg() == null) {
            throw new Exception("Informar o RG do cliente");
        }
        if (cliente.getRg().trim().equals("")) {
            throw new Exception("Informar o RG do cliente");
        }
        if (cliente.getCpf() == null) {
            throw new Exception("Informar o CPF do cliente");
        }
        if (cliente.getCpf().trim().equals("")) {
            throw new Exception("Informar o CPF do cliente");
        }
        if (cliente.getEndereco() == null) {
            throw new Exception("Informar o Endereço do cliente");
        }
        if (cliente.getEndereco().trim().equals("")) {
            throw new Exception("Informar o Endereço do cliente");
        }

        if (this.verificarExistencia(cliente) == -1) {
            throw new Exception("O referido Cliente não se encontra cadastrado");
        }
        if (this.verificarExistencia(cliente) != -1) {
            atualizarClienteBD(cliente);
        }
    }

    public void remover(Cliente cliente) throws Exception {
        removerClienteBD(cliente);
    }

    private void removerClienteBD(Cliente cliente) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            stmt = con.prepareStatement(stmtRemoverCliente);
            stmt.setInt(1, cliente.getId());
            stmt.execute();
            con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar rollback. " + e1.getMessage());
            }
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            try {
                con.close();
                stmt.close();
            } catch (SQLException c) {
                JOptionPane.showMessageDialog(null, c);
            }
        }
    }

    private void atualizarClienteBD(Cliente cliente) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            stmt = con.prepareStatement(stmtAtualizarCliente);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getRg());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getEndereco());
            stmt.setInt(6, cliente.getId());
            stmt.execute();
            con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar rollback. " + e1.getMessage());
            }
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            try {
                con.close();
                stmt.close();
            } catch (SQLException c) {
                JOptionPane.showMessageDialog(null, c);
            }
        }
    }

    public int verificarExistencia(Cliente cliente) {
        int retorno = -1;
        listarTodos();
        for (int i = 0; i < lista.size(); i++) {
            if (cliente.getCpf().trim().equals(lista.get(i).getCpf().trim())) {
                retorno = i;
                break;
            }
        }
        return retorno;
    }
}
