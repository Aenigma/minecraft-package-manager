/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.ruru.minecraftdownloader.gui;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;

/**
 *
 * @author Russe
 */
public class JDownloader extends javax.swing.JFrame {

    private final Preferences minecraftDestinationPref;
    private final Preferences URLSourcePref;

    private File p;
    private URL source;

    /**
     * Creates new form JDownloader
     */
    public JDownloader() {

        initComponents();
        this.minecraftDestinationPref = Preferences.userNodeForPackage(this.getClass());
        String lastInputDir = this.minecraftDestinationPref.get("LAST_OUTPUT_DIR", "");
        this.jTextFieldDestinationDir.setText(lastInputDir);

        this.URLSourcePref = Preferences.userNodeForPackage(this.getClass());
        String lastInputURL = this.URLSourcePref.get("LAST_OUTPUT_URL", "");
        this.jTextFieldSourceURL.setText(lastInputURL);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JButtonDestinationDir = new javax.swing.JButton();
        jTextFieldDestinationDir = new javax.swing.JTextField();
        jButtonSourceURLConfirm = new javax.swing.JButton();
        jTextFieldSourceURL = new javax.swing.JTextField();
        jButtonBuild = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        JButtonDestinationDir.setText("Minecraft Directory");
        JButtonDestinationDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonDestinationDirActionPerformed(evt);
            }
        });

        jTextFieldDestinationDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDestinationDirActionPerformed(evt);
            }
        });

        jButtonSourceURLConfirm.setText("Confirm Source");
        jButtonSourceURLConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSourceURLConfirmActionPerformed(evt);
            }
        });

        jTextFieldSourceURL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSourceURLActionPerformed(evt);
            }
        });

        jButtonBuild.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonBuild.setText("Build");
        jButtonBuild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuildActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSourceURLConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JButtonDestinationDir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDestinationDir)
                    .addComponent(jTextFieldSourceURL))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(279, Short.MAX_VALUE)
                .addComponent(jButtonBuild, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(256, 256, 256))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JButtonDestinationDir)
                    .addComponent(jTextFieldDestinationDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSourceURLConfirm)
                    .addComponent(jTextFieldSourceURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBuild)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonDestinationDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonDestinationDirActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        //chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            p = chooser.getSelectedFile().getAbsoluteFile();
            this.jTextFieldDestinationDir.setText(chooser.getSelectedFile().getAbsoluteFile().toString());
            this.minecraftDestinationPref.put("LAST_OUTPUT_DIR", this.p.getAbsolutePath());

        } else {
            this.jTextFieldDestinationDir.setText("No Selection");
        }


    }//GEN-LAST:event_JButtonDestinationDirActionPerformed

    private void jTextFieldDestinationDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDestinationDirActionPerformed

    }//GEN-LAST:event_jTextFieldDestinationDirActionPerformed

    private void jButtonBuildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuildActionPerformed

    }//GEN-LAST:event_jButtonBuildActionPerformed

    private void jTextFieldSourceURLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSourceURLActionPerformed

    }//GEN-LAST:event_jTextFieldSourceURLActionPerformed

    private void jButtonSourceURLConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSourceURLConfirmActionPerformed
        this.URLSourcePref.put("LAST_OUTPUT_URL", this.jTextFieldSourceURL.getText());
    }//GEN-LAST:event_jButtonSourceURLConfirmActionPerformed

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
            java.util.logging.Logger.getLogger(JDownloader.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDownloader.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDownloader.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDownloader.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JDownloader().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonDestinationDir;
    private javax.swing.JButton jButtonBuild;
    private javax.swing.JButton jButtonSourceURLConfirm;
    private javax.swing.JTextField jTextFieldDestinationDir;
    private javax.swing.JTextField jTextFieldSourceURL;
    // End of variables declaration//GEN-END:variables
}
