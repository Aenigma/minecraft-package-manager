/*
 * Copyright 2017 Russell Gilmore.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package space.ruru.minecraftdownloader.gui;

import java.io.File;
import javax.swing.JFileChooser;
import space.ruru.minecraftdownloader.ConfigSingleton;

/**
 *
 * @author Russell Gilmore
 */
public class JDownloader extends javax.swing.JFrame {

    private final ConfigSingleton config = ConfigSingleton.getInstance();

    /**
     * Creates new form JDownloader
     */
    public JDownloader() {
        initComponents();

        String lastInputDir = config.getMinecraftDirectory();
        String lastInputURL = config.getUrlBase();

        this.jTextFieldDestinationDir.setText(lastInputDir);
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
        final JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(this.jTextFieldDestinationDir
                .getText()));
        //chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File p = chooser.getSelectedFile()
                    .getAbsoluteFile();
            this.jTextFieldDestinationDir.setText(chooser.getSelectedFile()
                    .getAbsoluteFile()
                    .toString());
            String absolutePath = p.getAbsolutePath();
            config.setMinecraftDirectory(absolutePath);
        }
    }//GEN-LAST:event_JButtonDestinationDirActionPerformed

    private void jTextFieldDestinationDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDestinationDirActionPerformed

    }//GEN-LAST:event_jTextFieldDestinationDirActionPerformed

    private void jButtonBuildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuildActionPerformed

    }//GEN-LAST:event_jButtonBuildActionPerformed

    private void jTextFieldSourceURLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSourceURLActionPerformed

    }//GEN-LAST:event_jTextFieldSourceURLActionPerformed

    private void jButtonSourceURLConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSourceURLConfirmActionPerformed
        config.setUrlBase(this.jTextFieldSourceURL.getText());
    }//GEN-LAST:event_jButtonSourceURLConfirmActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new JDownloader().setVisible(true);
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
