/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author franca
 */
public class ClienteTelaIncluir extends javax.swing.JFrame {

    private ClienteTableModel tab;

    /**
     * Creates new form ClienteTelaIncluir
     */
    public ClienteTelaIncluir() {
        initComponents();
        centralizeFrame();
    }

    public void incluirModelo(JTable modelo) {
        tab = (ClienteTableModel) modelo.getModel();
    }

    public void centralizeFrame() {
        int x, y;
        Rectangle scr = this.getGraphicsConfiguration().getBounds();
        Rectangle form = this.getBounds();
        x = (int) (scr.getWidth() - form.getWidth()) / 2;
        y = (int) (scr.getHeight() - form.getHeight()) / 2;
        this.setLocation(x, y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelCadastroClientes = new javax.swing.JPanel();
        rotuloNome = new javax.swing.JLabel();
        campoTextoNome = new javax.swing.JTextField();
        rotuloSobrenome = new javax.swing.JLabel();
        campoTextoSobrenome = new javax.swing.JTextField();
        rotuloRG = new javax.swing.JLabel();
        campoTextoRG = new javax.swing.JTextField();
        rotuloCPF = new javax.swing.JLabel();
        campoTextoCPF = new javax.swing.JTextField();
        rotuloEndereco = new javax.swing.JLabel();
        campoTextoEndereco = new javax.swing.JTextField();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelCadastroClientes.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de clientes"));

        rotuloNome.setText("Nome");

        rotuloSobrenome.setText("Sobrenome");

        rotuloRG.setText("RG");

        rotuloCPF.setText("CPF");

        rotuloEndereco.setText("Endereço");

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelCadastroClientesLayout = new javax.swing.GroupLayout(painelCadastroClientes);
        painelCadastroClientes.setLayout(painelCadastroClientesLayout);
        painelCadastroClientesLayout.setHorizontalGroup(
            painelCadastroClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCadastroClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rotuloNome)
                    .addComponent(rotuloSobrenome)
                    .addComponent(rotuloRG)
                    .addComponent(rotuloCPF)
                    .addComponent(rotuloEndereco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCadastroClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoTextoNome)
                    .addComponent(campoTextoSobrenome)
                    .addComponent(campoTextoRG)
                    .addComponent(campoTextoCPF)
                    .addComponent(campoTextoEndereco)
                    .addGroup(painelCadastroClientesLayout.createSequentialGroup()
                        .addComponent(botaoSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(botaoCancelar)
                        .addGap(0, 248, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelCadastroClientesLayout.setVerticalGroup(
            painelCadastroClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroClientesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelCadastroClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloNome)
                    .addComponent(campoTextoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCadastroClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rotuloSobrenome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCadastroClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rotuloRG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCadastroClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rotuloCPF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCadastroClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rotuloEndereco))
                .addGap(18, 18, 18)
                .addGroup(painelCadastroClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoCancelar)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(painelCadastroClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(painelCadastroClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        try {
            Cliente cliente = new Cliente();
            cliente.setNome(campoTextoNome.getText());
            cliente.setSobrenome(campoTextoSobrenome.getText());
            cliente.setRg(campoTextoRG.getText());
            cliente.setCpf(campoTextoCPF.getText());
            cliente.setEndereco(campoTextoEndereco.getText());
            ClienteDAO.obterInstancia().inserir(cliente);
            tab.addRow(cliente);
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado com sucesso");
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(ClienteTelaIncluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteTelaIncluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteTelaIncluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteTelaIncluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ClienteTelaIncluir().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoTextoCPF;
    private javax.swing.JTextField campoTextoEndereco;
    private javax.swing.JTextField campoTextoNome;
    private javax.swing.JTextField campoTextoRG;
    private javax.swing.JTextField campoTextoSobrenome;
    private javax.swing.JPanel painelCadastroClientes;
    private javax.swing.JLabel rotuloCPF;
    private javax.swing.JLabel rotuloEndereco;
    private javax.swing.JLabel rotuloNome;
    private javax.swing.JLabel rotuloRG;
    private javax.swing.JLabel rotuloSobrenome;
    // End of variables declaration//GEN-END:variables
}
