/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gato;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class AdicionarEventoSemanal extends javax.swing.JFrame {

    /**
     * Creates new form AdicionarEventoSemanal
     */
    public AdicionarEventoSemanal() {
        initComponents();
    }
    
    private void salvar(){
        String url = "jdbc:mysql://localhost/gato?useSSL=false", usuario = "root", senha = "root";
        Connection conexao;
        PreparedStatement pstm;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdicionarEventoSemanal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String titulo, horaIni, horaFin, minIni, minFin, diaSemana;
        titulo = textTitulo.getText();
        diaSemana = boxDiaDaSemana.getSelectedItem().toString();
        horaIni = boxHoraDeInicio.getSelectedItem().toString();
        minIni = boxMinDeInicio.getSelectedItem().toString();
        horaFin = boxHoraDeFim.getSelectedItem().toString();
        minFin = boxMinDeFim.getSelectedItem().toString();
        
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            pstm = conexao.prepareStatement("insert into Evento_Semanal values (null, ?, ?, ?, ?)");

            pstm.setString(1, titulo);
            pstm.setString(2, diaSemana);
            pstm.setString(3, horaIni +":"+ minIni);
            pstm.setString(4, horaFin +":"+ minFin);
            
            pstm.execute();
            pstm.close();
            conexao.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (HeadlessException | SQLException excp) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar.");
            System.err.println(excp);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textTitulo = new javax.swing.JTextField();
        labelTitulo = new javax.swing.JLabel();
        boxDiaDaSemana = new javax.swing.JComboBox<>();
        boxHoraDeInicio = new javax.swing.JComboBox<>();
        boxMinDeInicio = new javax.swing.JComboBox<>();
        boxHoraDeFim = new javax.swing.JComboBox<>();
        boxMinDeFim = new javax.swing.JComboBox<>();
        labelHorarioDeInicio = new javax.swing.JLabel();
        labelHorarioDeFim = new javax.swing.JLabel();
        botaoCancelar = new javax.swing.JButton();
        botaoAvancar = new javax.swing.JButton();
        label2PontosHI = new javax.swing.JLabel();
        label2PontosHF = new javax.swing.JLabel();
        labelDiaDaSemana = new javax.swing.JLabel();
        botaoApagarEvento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Evento Semanal");
        setPreferredSize(new java.awt.Dimension(640, 400));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(textTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 38, 567, 27));

        labelTitulo.setText("Título");
        getContentPane().add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 18, -1, -1));

        boxDiaDaSemana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado" }));
        getContentPane().add(boxDiaDaSemana, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 140, -1));

        boxHoraDeInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        getContentPane().add(boxHoraDeInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 58, -1));

        boxMinDeInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00" }));
        boxMinDeInicio.setEnabled(false);
        boxMinDeInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMinDeInicioActionPerformed(evt);
            }
        });
        getContentPane().add(boxMinDeInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 60, -1));

        boxHoraDeFim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        boxHoraDeFim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxHoraDeFimActionPerformed(evt);
            }
        });
        getContentPane().add(boxHoraDeFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 58, -1));

        boxMinDeFim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00" }));
        boxMinDeFim.setEnabled(false);
        boxMinDeFim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMinDeFimActionPerformed(evt);
            }
        });
        getContentPane().add(boxMinDeFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 60, -1));

        labelHorarioDeInicio.setText("Horário de inicio");
        getContentPane().add(labelHorarioDeInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        labelHorarioDeFim.setText("Horário de fim");
        getContentPane().add(labelHorarioDeFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, -1, -1));

        botaoAvancar.setText("Avançar");
        botaoAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAvancarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoAvancar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 100, -1));

        label2PontosHI.setText(":");
        getContentPane().add(label2PontosHI, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));

        label2PontosHF.setText(":");
        getContentPane().add(label2PontosHF, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));

        labelDiaDaSemana.setText("Dia da semana");
        getContentPane().add(labelDiaDaSemana, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        botaoApagarEvento.setText("Apagar Evento");
        botaoApagarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoApagarEventoActionPerformed(evt);
            }
        });
        getContentPane().add(botaoApagarEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** 
     * Fechar apenas a janela atual
     */
    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        AdicionarEventoSemanal.this.dispose(); 
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void boxHoraDeFimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxHoraDeFimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxHoraDeFimActionPerformed

    private void boxMinDeInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMinDeInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxMinDeInicioActionPerformed

    /** 
     * Gatilho do botão Avançar para chamar a função salvar()
     */
    private void botaoAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAvancarActionPerformed
        salvar();  
        AdicionarEventoSemanal.this.dispose(); 
    }//GEN-LAST:event_botaoAvancarActionPerformed

    private void botaoApagarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoApagarEventoActionPerformed
        AdicionarEventoSemanal.this.dispose(); 
        DeletarSemanal ds = new DeletarSemanal();
        ds.setVisible(true);
    }//GEN-LAST:event_botaoApagarEventoActionPerformed

    private void boxMinDeFimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMinDeFimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxMinDeFimActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionarEventoSemanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AdicionarEventoSemanal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoApagarEvento;
    private javax.swing.JButton botaoAvancar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JComboBox<String> boxDiaDaSemana;
    private javax.swing.JComboBox<String> boxHoraDeFim;
    private javax.swing.JComboBox<String> boxHoraDeInicio;
    private javax.swing.JComboBox<String> boxMinDeFim;
    private javax.swing.JComboBox<String> boxMinDeInicio;
    private javax.swing.JLabel label2PontosHF;
    private javax.swing.JLabel label2PontosHI;
    private javax.swing.JLabel labelDiaDaSemana;
    private javax.swing.JLabel labelHorarioDeFim;
    private javax.swing.JLabel labelHorarioDeInicio;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTextField textTitulo;
    // End of variables declaration//GEN-END:variables
}