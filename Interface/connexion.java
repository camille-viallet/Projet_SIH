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
 * Interface de connexion. Permet d'obtenir un accés sécurisé et proposer une
 * interface adaptée selon les personnels
 *
 * @author Groupe 8
 */
public class connexion extends javax.swing.JFrame {

    /**
     * Creates new form connexion
     */
    private static PersonnelHopital persHopital;

    public connexion() {
        initComponents();

        LectureXMLPersonnel personnel = new LectureXMLPersonnel("personnels.xml"); //lit le fichier XML du personnel
        persHopital = personnel.getPersonnel();
        if (persHopital == null) {
            //Indique un message d'erreur si le XML ne peut etre lu
            this.jLabelErreur.setVisible(true);
            this.jLabelErreur.setText("Chemin d'accés au fichier 'personnels.xml' incorrect");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPassword = new javax.swing.JPasswordField();
        jLabelUtilisateur = new javax.swing.JLabel();
        ImageLogoHopital = new javax.swing.JLabel();
        jTextFieldUtilisateur = new javax.swing.JTextField();
        jLabelMotPasse = new javax.swing.JLabel();
        jButtonValiderConnexion = new javax.swing.JButton();
        jLabelErreur = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Connexion");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jPassword.setToolTipText("");

        jLabelUtilisateur.setFont(new java.awt.Font("Arial Nova", 1, 14)); // NOI18N
        jLabelUtilisateur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUtilisateur.setText("Utilisateur :");

        ImageLogoHopital.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/logoPrinceton.png"))); // NOI18N

        jTextFieldUtilisateur.setToolTipText("");

        jLabelMotPasse.setFont(new java.awt.Font("Arial Nova", 1, 14)); // NOI18N
        jLabelMotPasse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMotPasse.setText("Mot de passe : ");

        jButtonValiderConnexion.setText("Valider");
        jButtonValiderConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderConnexionActionPerformed(evt);
            }
        });

        jLabelErreur.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErreur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelErreur.setText("Erreur");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonValiderConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMotPasse, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelUtilisateur, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelErreur, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImageLogoHopital, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addComponent(jPassword)
                    .addComponent(jTextFieldUtilisateur))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImageLogoHopital, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(56, 56, 56)
                .addComponent(jLabelUtilisateur)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabelMotPasse)
                .addGap(18, 18, 18)
                .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabelErreur)
                .addGap(42, 42, 42)
                .addComponent(jButtonValiderConnexion)
                .addContainerGap())
        );

        jLabelErreur.setVisible(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/hopitalConnexion.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exécuté au clic sur le bouton " Valider"
     *
     * @param evt
     */
    private void jButtonValiderConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderConnexionActionPerformed
        //Récupére la valeur des champs
        String utilisateur = this.jTextFieldUtilisateur.getText();
        String motDePasse = new String(this.jPassword.getPassword());

        Personnel personnel;
        //Parcours le personnel afin de trouver la personne correspondante
        int i = 0;
        while (!utilisateur.equals(persHopital.getListePersonnel().get(i).getUsername()) && (i < persHopital.getListePersonnel().size() - 1)) {
            i++;
        }
        if (i < persHopital.getListePersonnel().size() - 1) {
            personnel = persHopital.getListePersonnel().get(i);

            if (motDePasse.equals(personnel.getMotDePasse())) { // Vérifie le mot de passe
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new connexion().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImageLogoHopital;
    private javax.swing.JButton jButtonValiderConnexion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelErreur;
    private javax.swing.JLabel jLabelMotPasse;
    private javax.swing.JLabel jLabelUtilisateur;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jTextFieldUtilisateur;
    // End of variables declaration//GEN-END:variables
}
