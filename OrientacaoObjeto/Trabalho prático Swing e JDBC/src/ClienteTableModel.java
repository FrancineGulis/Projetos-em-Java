/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author franca
 */
class ClienteTableModel extends AbstractTableModel {

    private List<Cliente> dados;
    private String[] colunas = {"Id", "Nome", "Sobrenome", "RG", "CPF", "Endereco"};

    public ClienteTableModel() {
        dados = new ArrayList<Cliente>();
    }
  
    public void updateRow(int linha, Cliente cliente){
        dados.set(linha, cliente);
        fireTableDataChanged();
    }
    
    public void addList(List<Cliente> lista){
        dados.addAll(lista);      
        fireTableDataChanged();
    }

    public void addRow(Cliente cliente) throws Exception {
        dados.add(cliente);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int num) {
        return colunas[num];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dados.get(linha).getId();
            case 1:
                return dados.get(linha).getNome();
            case 2:
                return dados.get(linha).getSobrenome();
            case 3:
                return dados.get(linha).getRg();
            case 4:
                return dados.get(linha).getCpf();
            case 5:
                return dados.get(linha).getEndereco();

        }
        return null;
    }

    public void removeRow(int linha) {
        dados.remove(linha);
        fireTableRowsDeleted(linha, linha);
    }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        return false;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        if (valor == null) {
            return;
        }
        switch (coluna) {
            case 0:
                dados.get(linha).setId((int) valor);
                break;
            case 1:
                dados.get(linha).setNome((String) valor);
                break;
            case 2:
                dados.get(linha).setSobrenome((String) valor);
                break;
            case 3:
                dados.get(linha).setRg((String) valor);
                break;
            case 4:
                dados.get(linha).setCpf((String) valor);
                break;
            case 5:
                dados.get(linha).setEndereco((String) valor);
                break;
        }
        fireTableRowsUpdated(linha, linha);
    }

    public void setNumRows(int rowCount) {
        int old = getRowCount();
        if (old == rowCount) {
            return;
        }
        for (int i = old - 1; i >= 0; i--) {
            removeRow(i);
        }
    }
}
