/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Luis Felipe Franco Candeo Tomazini
 * Date: Oct 21, 2015
 * Time: 2:00:34 PM
 *
 * Project: csci205
 * Package: lab13
 * File: MainView
 * Description: Swing
 *
 * ****************************************
 */
package lab13;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author lftomazini
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.ButtonGroup buttonGroupTemp = new javax.swing.ButtonGroup();
        javax.swing.JPanel panelTempUnits = new javax.swing.JPanel();
        rdbtnFahTemp = new javax.swing.JRadioButton();
        rdbtnCelTemp = new javax.swing.JRadioButton();
        javax.swing.JPanel panelTempSelector = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        sliderTemp = new javax.swing.JSlider();
        javax.swing.JPanel panelTempRange = new javax.swing.JPanel();
        textMinTemp = new javax.swing.JTextField();
        lblCurTemp = new javax.swing.JLabel();
        textMaxTemp = new javax.swing.JTextField();
        javax.swing.JPanel panelTempKelvin = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        textTempKelvin = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kelvin Converter");
        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));

        panelTempUnits.setBorder(javax.swing.BorderFactory.createTitledBorder("Temperature"));
        panelTempUnits.setLayout(new java.awt.GridLayout(0, 1));

        buttonGroupTemp.add(rdbtnFahTemp);
        rdbtnFahTemp.setSelected(true);
        rdbtnFahTemp.setText("Fahrenheit");
        rdbtnFahTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnFahTempActionPerformed(evt);
            }
        });
        panelTempUnits.add(rdbtnFahTemp);

        buttonGroupTemp.add(rdbtnCelTemp);
        rdbtnCelTemp.setText("Celsius");
        rdbtnCelTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnCelTempActionPerformed(evt);
            }
        });
        panelTempUnits.add(rdbtnCelTemp);

        getContentPane().add(panelTempUnits, java.awt.BorderLayout.LINE_START);

        panelTempSelector.setLayout(new java.awt.GridLayout(0, 1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html>Use the slider to<br/>adjust the temperature</html>");
        panelTempSelector.add(jLabel1);
        panelTempSelector.add(sliderTemp);

        textMinTemp.setColumns(5);
        textMinTemp.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        panelTempRange.add(textMinTemp);

        lblCurTemp.setText("0.0");
        panelTempRange.add(lblCurTemp);

        textMaxTemp.setColumns(5);
        textMaxTemp.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textMaxTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMaxTempActionPerformed(evt);
            }
        });
        panelTempRange.add(textMaxTemp);

        panelTempSelector.add(panelTempRange);

        getContentPane().add(panelTempSelector, java.awt.BorderLayout.CENTER);

        jLabel2.setText("Temperature in Kelvin:");
        panelTempKelvin.add(jLabel2);

        textTempKelvin.setEditable(false);
        textTempKelvin.setBackground(new java.awt.Color(0, 0, 0));
        textTempKelvin.setColumns(10);
        textTempKelvin.setForeground(new java.awt.Color(255, 255, 0));
        textTempKelvin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textTempKelvin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTempKelvinActionPerformed(evt);
            }
        });
        panelTempKelvin.add(textTempKelvin);

        getContentPane().add(panelTempKelvin, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdbtnCelTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnCelTempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbtnCelTempActionPerformed

    private void rdbtnFahTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnFahTempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbtnFahTempActionPerformed

    private void textMaxTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMaxTempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMaxTempActionPerformed

    private void textTempKelvinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTempKelvinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTempKelvinActionPerformed

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
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCurTemp;
    private javax.swing.JRadioButton rdbtnCelTemp;
    private javax.swing.JRadioButton rdbtnFahTemp;
    private javax.swing.JSlider sliderTemp;
    private javax.swing.JTextField textMaxTemp;
    private javax.swing.JTextField textMinTemp;
    private javax.swing.JTextField textTempKelvin;
    // End of variables declaration//GEN-END:variables

    public JLabel getLblCurTemp() {
        return lblCurTemp;
    }

    public JRadioButton getRdbtnCelTemp() {
        return rdbtnCelTemp;
    }

    public JRadioButton getRdbtnFahTemp() {
        return rdbtnFahTemp;
    }

    public JSlider getSliderTemp() {
        return sliderTemp;
    }

    public JTextField getTextMaxTemp() {
        return textMaxTemp;
    }

    public JTextField getTextMinTemp() {
        return textMinTemp;
    }

    public JTextField getTextTempKelvin() {
        return textTempKelvin;
    }
}