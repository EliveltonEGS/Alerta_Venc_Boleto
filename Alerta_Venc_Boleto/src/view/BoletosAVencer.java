/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.BoletosDAO;
import domain.Boletos;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elivelton Silva
 */
public class BoletosAVencer extends javax.swing.JFrame {

    /**
     * Creates new form BoletosAVender
     */
    public BoletosAVencer() {
        initComponents();

        BoletosDAO bdao = new BoletosDAO();
        //formata data para salvar no banco

        Date dataHj = new Date();
        SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy");
        String datafinal = formato1.format(dataHj);

        String data = datafinal;
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);

        String dataSalva = ano + "-" + mes + "-" + dia;
        Date dataVenc = new Date();
        SimpleDateFormat dtFormatada = new SimpleDateFormat("yyyy-MM-dd");

        try {
            dataVenc = dtFormatada.parse(dataSalva);
        } catch (ParseException ex) {
            Logger.getLogger(CadBoletos.class.getName()).log(Level.SEVERE, null, ex);
        }

        String boletos = "";

        for (Boletos b : bdao.buscarPorData(dataVenc, "NÃO")) {
            Double valor = new Double(b.getValor());
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            String formatado = nf.format(valor);

            boletos += "-> Beneficiário: " + b.getBeneficiario() + " - " + " Valor: " + formatado + " - " + " Data de Vencimento: "
                    + data + " - " + " Status: " + b.getStatus() + "\n\n";

            edBoletosAVencer.setText(boletos);

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

        jScrollPane1 = new javax.swing.JScrollPane();
        edBoletosAVencer = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Boletos a Vencer");
        setResizable(false);
        getContentPane().setLayout(null);

        edBoletosAVencer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane1.setViewportView(edBoletosAVencer);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 860, 440);

        setSize(new java.awt.Dimension(871, 470));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(BoletosAVencer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BoletosAVencer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BoletosAVencer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoletosAVencer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BoletosAVencer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane edBoletosAVencer;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
