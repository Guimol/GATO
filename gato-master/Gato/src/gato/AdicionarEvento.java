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
public class AdicionarEvento extends javax.swing.JFrame {

    /**
     * Creates new form AdicionarEvento
     */
    public AdicionarEvento() {
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
        
        String titulo, horaIni, horaFin, minIni, minFin, descricao, ano, mes, dia;
        int favorito, escolar, feriado;
        titulo = textTitulo.getText();
        descricao = textDescricao.getText();
        ano = boxAnoData.getSelectedItem().toString();
        mes = boxMesData.getSelectedItem().toString();
        dia = boxDiaData.getSelectedItem().toString();
        horaIni = boxHoraInicio.getSelectedItem().toString();
        minIni = boxMinInicio.getSelectedItem().toString();
        horaFin = boxHoraFim.getSelectedItem().toString();
        minFin = boxMinFim.getSelectedItem().toString();
        if (botaoBooleanoFavoito.isSelected())
            favorito = 1;
        else
            favorito = 0;
        
        if (botaoBooleanoEscolar.isSelected())
            escolar = 1;
        else
            escolar = 0;
        
        if (botaoBooleanoFeriado.isSelected())
            feriado = 1;
        else
            feriado = 0;
        
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            pstm = conexao.prepareStatement("insert into Evento values (null, ?, ?, ?, ?, ?, ?, ?, ?)");

            pstm.setString(1, titulo);
            pstm.setString(2, ano +"-"+ mes +"-"+ dia);
            pstm.setString(3, horaIni +":"+ minIni);
            pstm.setString(4, horaFin +":"+ minFin);
            pstm.setString(5, descricao);
            pstm.setInt(6, escolar);
            pstm.setInt(7, feriado);
            pstm.setInt(8, favorito);
            
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

        jButton1 = new javax.swing.JButton();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        botaoAvancar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        textTitulo = new javax.swing.JTextField();
        textDescricao = new javax.swing.JTextField();
        labelTitulo = new javax.swing.JLabel();
        labelDescricao = new javax.swing.JLabel();
        boxAnoData = new javax.swing.JComboBox<>();
        boxHoraInicio = new javax.swing.JComboBox<>();
        boxHoraFim = new javax.swing.JComboBox<>();
        labelData = new javax.swing.JLabel();
        labelHorarioDeInicio = new javax.swing.JLabel();
        labelHorarioDeFim = new javax.swing.JLabel();
        boxMinInicio = new javax.swing.JComboBox<>();
        boxMinFim = new javax.swing.JComboBox<>();
        label2PontosHI = new javax.swing.JLabel();
        label2PontosHF = new javax.swing.JLabel();
        boxMesData = new javax.swing.JComboBox<>();
        boxDiaData = new javax.swing.JComboBox<>();
        labelMarcarEvento = new javax.swing.JLabel();
        botaoBooleanoFavoito = new javax.swing.JRadioButton();
        botaoBooleanoEscolar = new javax.swing.JRadioButton();
        botaoBooleanoFeriado = new javax.swing.JRadioButton();
        labelBarraData1 = new javax.swing.JLabel();
        labelBarraData2 = new javax.swing.JLabel();

        jButton1.setText("avançar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Evento");
        setPreferredSize(new java.awt.Dimension(640, 400));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botaoAvancar.setText("Avançar");
        botaoAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAvancarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoAvancar, new org.netbeans.lib.awtextra.AbsoluteConstraints(533, 321, -1, -1));

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 321, -1, -1));

        textTitulo.setToolTipText("informe o nome do evento");
        textTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTituloActionPerformed(evt);
            }
        });
        getContentPane().add(textTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 35, 567, 27));

        textDescricao.setToolTipText("informe algo sobre esse evento");
        textDescricao.setPreferredSize(new java.awt.Dimension(79, 20));
        textDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDescricaoActionPerformed(evt);
            }
        });
        getContentPane().add(textDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 89, 567, 27));

        labelTitulo.setText("Título");
        getContentPane().add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 15, -1, -1));

        labelDescricao.setText("Descrição");
        getContentPane().add(labelDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 68, -1, 15));

        boxAnoData.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));
        boxAnoData.setPreferredSize(new java.awt.Dimension(57, 29));
        boxAnoData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxAnoDataActionPerformed(evt);
            }
        });
        getContentPane().add(boxAnoData, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 70, 23));

        boxHoraInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        boxHoraInicio.setPreferredSize(new java.awt.Dimension(57, 29));
        getContentPane().add(boxHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 231, 57, 23));

        boxHoraFim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        getContentPane().add(boxHoraFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 311, 57, 22));

        labelData.setText("Data");
        getContentPane().add(labelData, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 134, -1, -1));

        labelHorarioDeInicio.setText("Horário de inicio");
        getContentPane().add(labelHorarioDeInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 202, -1, -1));

        labelHorarioDeFim.setText("Horário de fim");
        getContentPane().add(labelHorarioDeFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 286, -1, -1));

        boxMinInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        getContentPane().add(boxMinInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 231, 57, 23));

        boxMinFim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        getContentPane().add(boxMinFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 311, 57, 22));

        label2PontosHI.setText(":");
        getContentPane().add(label2PontosHI, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 237, -1, -1));

        label2PontosHF.setText(":");
        getContentPane().add(label2PontosHF, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 311, 10, -1));

        boxMesData.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        getContentPane().add(boxMesData, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 57, 23));

        boxDiaData.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        boxDiaData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxDiaDataActionPerformed(evt);
            }
        });
        getContentPane().add(boxDiaData, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 57, 23));

        labelMarcarEvento.setText("Marcar Evento como : ");
        getContentPane().add(labelMarcarEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 134, -1, -1));

        botaoBooleanoFavoito.setText("Favorito");
        getContentPane().add(botaoBooleanoFavoito, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 161, -1, -1));

        botaoBooleanoEscolar.setText("Escolar");
        getContentPane().add(botaoBooleanoEscolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 201, -1, -1));

        botaoBooleanoFeriado.setText("Feriado");
        getContentPane().add(botaoBooleanoFeriado, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 241, -1, -1));

        labelBarraData1.setText("/");
        getContentPane().add(labelBarraData1, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 165, -1, -1));

        labelBarraData2.setText("/");
        getContentPane().add(labelBarraData2, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 165, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    /** 
     * Fechar apenas a janela atual
     */
    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        AdicionarEvento.this.dispose(); 
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void textDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDescricaoActionPerformed

    private void boxDiaDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxDiaDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxDiaDataActionPerformed

    private void boxAnoDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxAnoDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxAnoDataActionPerformed
    
    /** 
     * Gatilho do botão Avançar para chamar a função salvar()
     */
    private void botaoAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAvancarActionPerformed
       salvar();
       AdicionarEvento.this.dispose(); 
    }//GEN-LAST:event_botaoAvancarActionPerformed

    private void textTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTituloActionPerformed

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
            java.util.logging.Logger.getLogger(AdicionarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AdicionarEvento().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAvancar;
    private javax.swing.JRadioButton botaoBooleanoEscolar;
    private javax.swing.JRadioButton botaoBooleanoFavoito;
    private javax.swing.JRadioButton botaoBooleanoFeriado;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JComboBox<String> boxAnoData;
    private javax.swing.JComboBox<String> boxDiaData;
    private javax.swing.JComboBox<String> boxHoraFim;
    private javax.swing.JComboBox<String> boxHoraInicio;
    private javax.swing.JComboBox<String> boxMesData;
    private javax.swing.JComboBox<String> boxMinFim;
    private javax.swing.JComboBox<String> boxMinInicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JLabel label2PontosHF;
    private javax.swing.JLabel label2PontosHI;
    private javax.swing.JLabel labelBarraData1;
    private javax.swing.JLabel labelBarraData2;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelHorarioDeFim;
    private javax.swing.JLabel labelHorarioDeInicio;
    private javax.swing.JLabel labelMarcarEvento;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTextField textDescricao;
    private javax.swing.JTextField textTitulo;
    // End of variables declaration//GEN-END:variables
}