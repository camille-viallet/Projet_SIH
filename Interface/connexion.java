/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;


import princetonPlainsboro.LectureXMLPersonnel;
import princetonPlainsboro.MetierCHU;
import princetonPlainsboro.Personnel;
import princetonPlainsboro.PersonnelHopital;

/**
 *
 * @author Camille
 */
public class connexion extends javax.swing.JFrame {

    /**
     * Creates new form connexion
     */
    private static PersonnelHopital persHopital;

    public connexion() {
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

        ImageLogoHopital = new javax.swing.JLabel();
        jLabelConnexion = new javax.swing.JLabel();
        jLabelUtilisateur = new javax.swing.JLabel();
        jTextFieldUtilisateur = new javax.swing.JTextField();
        jLabelMotPasse = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jButtonValiderConnexion = new javax.swing.JButton();
        jLabelErreur = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Connexion");

        ImageLogoHopital.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/logo.jpg"))); // NOI18N

        jLabelConnexion.setFont(new java.awt.Font("Verdana Pro Cond", 1, 24)); // NOI18N
        jLabelConnexion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelConnexion.setText("Connexion");
        jLabelConnexion.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabelUtilisateur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUtilisateur.setText("Utilisateur :");

        jTextFieldUtilisateur.setToolTipText("");

        jLabelMotPasse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMotPasse.setText("Mot de passe : ");

        jPassword.setToolTipText("");

        jButtonValiderConnexion.setText("Valider");
        jButtonValiderConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderConnexionActionPerformed(evt);
            }
        });

        jLabelErreur.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErreur.setText("Erreur");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImageLogoHopital)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jPassword)
                            .addComponent(jLabelMotPasse, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                            .addComponent(jTextFieldUtilisateur)
                            .addComponent(jLabelUtilisateur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(jButtonValiderConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(156, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabelConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jLabelErreur, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ImageLogoHopital)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelConnexion)
                        .addGap(53, 53, 53)))
                .addComponent(jLabelUtilisateur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelMotPasse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelErreur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButtonValiderConnexion)
                .addContainerGap())
        );

        jLabelErreur.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonValiderConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderConnexionActionPerformed
        String utilisateur = this.jTextFieldUtilisateur.getText();
        String motDePasse = new String(this.jPassword.getPassword());

        int i = 0;

        Personnel personnel;

        while (!utilisateur.equals(persHopital.getListePersonnel().get(i).getUsername()) && (i < persHopital.getListePersonnel().size() - 1)) {
            i++;
        }
        if (i < persHopital.getListePersonnel().size() - 1) {
            personnel = persHopital.getListePersonnel().get(i);

            if (motDePasse.equals(personnel.getMdp())) {
                if (personnel.getMetier() == MetierCHU.MEDECIN || personnel.getMetier() == MetierCHU.SECRETAIRE_MEDICALE) {
                    new InterfaceMedicale(personnel).setVisible(true);
                    this.dispose();
                } else if (personnel.getMetier() == MetierCHU.SECRETAIRE_ADMINISTRATIVE) {
                    new InterfaceSecretaireAdmin(personnel).setVisible(true);
                    this.dispose();
                }
            } else {
                this.jLabelErreur.setVisible(true);
                this.jLabelErreur.setText("Mot de passe incorrect");
            }
        } else {
            this.jLabelErreur.setVisible(true);
            this.jLabelErreur.setText("Utilisateur inconnu");
        }
    }//GEN-LAST:event_jButtonValiderConnexionActionPerformed

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
            java.util.logging.Logger.getLogger(connexion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(connexion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(connexion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(connexion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        LectureXMLPersonnel personnel = new LectureXMLPersonnel("personnels.xml");
        persHopital = personnel.getPersonnel();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new connexion().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImageLogoHopital;
    private javax.swing.JButton jButtonValiderConnexion;
    private javax.swing.JLabel jLabelConnexion;
    private javax.swing.JLabel jLabelErreur;
    private javax.swing.JLabel jLabelMotPasse;
    private javax.swing.JLabel jLabelUtilisateur;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jTextFieldUtilisateur;
    // End of variables declaration//GEN-END:variables
}
