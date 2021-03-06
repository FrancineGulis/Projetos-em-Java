/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author franca
 */
public class ClienteTelaConsulta extends javax.swing.JFrame {

    private ClienteTableModel tab;

    /**
     * Creates new form TelaConsultaCliente
     *
     */
    public ClienteTelaConsulta() {
        initComponents();
        centralizeFrame();
        listarClientes();
    }

    public void centralizeFrame() {
        int x, y;
        Rectangle scr = this.getGraphicsConfiguration().getBounds();
        Rectangle form = this.getBounds();
        x = (int) (scr.getWidth() - form.getWidth()) / 2;
        y = (int) (scr.getHeight() - form.getHeight()) / 2;
        this.setLocation(x, y);
    }

    public void listarClientes() {
        tab = new ClienteTableModel();
        tabelaListaClientes.setModel(tab);
        List<Cliente> listarClientes = new ArrayList<Cliente>();
        listarClientes = ClienteDAO.obterInstancia().listarTodos();
        tab.addList(listarClientes);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaListaClientes = new javax.swing.JTable();
        botaoIncluir = new javax.swing.JButton();
        botaoAlterar = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();
        rotuloClientes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(640, 480));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tabelaListaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaListaClientes);

        botaoIncluir.setText("Incluir");
        botaoIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoIncluirActionPerformed(evt);
            }
        });

        botaoAlterar.setText("Alterar");
        botaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarActionPerformed(evt);
            }
        });

        botaoRemover.setText("Remover");
        botaoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverActionPerformed(evt);
            }
        });

        rotuloClientes.setText("Clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rotuloClientes)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(botaoIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rotuloClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoIncluir)
                    .addComponent(botaoAlterar)
                    .addComponent(botaoRemover))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoIncluirActionPerformed
        ClienteTelaIncluir incluir = new ClienteTelaIncluir();
        incluir.incluirModelo(tabelaListaClientes);
        incluir.setVisible(true);
    }//GEN-LAST:event_botaoIncluirActionPerformed

    private void botaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarActionPerformed
        int idx = this.tabelaListaClientes.getSelectedRow();
        if (idx == -1) {
            JOptionPane.showMessageDialog(null, "nenhum Cliente Selecionado");
            return;
        }
        ClienteTableModel tab = (ClienteTableModel) tabelaListaClientes.getModel();
        Cliente cliente = new Cliente();
        cliente.setId((int) tab.getValueAt(idx, 0));
        cliente.setNome((String) tab.getValueAt(idx, 1));
        cliente.setSobrenome((String) tab.getValueAt(idx, 2));
        cliente.setRg((String) tab.getValueAt(idx, 3));
        cliente.setCpf((String) tab.getValueAt(idx, 4));
        cliente.setEndereco((String) tab.getValueAt(idx, 5));
        ClienteTelaAlterar alteracao = new ClienteTelaAlterar(cliente);
        alteracao.incluirModelo(tabelaListaClientes, idx);
        alteracao.setVisible(true);
    }//GEN-LAST:event_botaoAlterarActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        int idx = this.tabelaListaClientes.getSelectedRow();
        if (idx == -1) {
            JOptionPane.showMessageDialog(null, "nenhum Cliente Selecionado");
            return;
        }
        ClienteTableModel tab = (ClienteTableModel) this.tabelaListaClientes.getModel();
        Cliente cliente = new Cliente();
        cliente.setId((int) tab.getValueAt(idx, 0));
        cliente.setNome((String) tab.getValueAt(idx, 1));
        cliente.setSobrenome((String) tab.getValueAt(idx, 2));
        cliente.setRg((String) tab.getValueAt(idx, 3));
        cliente.setCpf((String) tab.getValueAt(idx, 4));
        cliente.setEndereco((String) tab.getValueAt(idx, 5));
        int answer = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do Cliente:\n" + cliente.getNome() + "\nCPF: " + cliente.getCpf());
        if (answer == JOptionPane.YES_OPTION) {
            try {
                ClienteDAO.obterInstancia().remover(cliente);
                tab.removeRow(idx);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_botaoRemoverActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.dispose();
        new TelaInicial().setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteTelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteTelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteTelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteTelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ClienteTelaConsulta().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoIncluir;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel rotuloClientes;
    private javax.swing.JTable tabelaListaClientes;
    // End of variables declaration//GEN-END:variables
}
