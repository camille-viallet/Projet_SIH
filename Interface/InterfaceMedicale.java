/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Color;
import java.util.Vector;
import princetonPlainsboro.Date;
import princetonPlainsboro.DossierMedical;
import princetonPlainsboro.LectureXML;
import princetonPlainsboro.Medecin;
import princetonPlainsboro.Patient;
import princetonPlainsboro.FicheDeSoins;
import princetonPlainsboro.Acte;
import princetonPlainsboro.Code;
import princetonPlainsboro.ModificationXMLDossierMedical;
import princetonPlainsboro.MetierCHU;
import princetonPlainsboro.Personnel;

/**
 * Interface destinée au corps médical
 *
 * @author Camille
 */
public class InterfaceMedicale extends javax.swing.JFrame {

    Personnel personnel;
    DossierMedical dossierMedical;
    Patient patient;
    Vector<Patient> listePatient;
    ModificationXMLDossierMedical modifXML;
    LectureXML lectureXML;

    /**
     * Construit une nouvelle interface
     *
     * @param personnel personnel connecté
     */
    public InterfaceMedicale(Personnel personnel) {
        initComponents();

        modifXML = new ModificationXMLDossierMedical();

        this.personnel = personnel;
        //Affiche un message personnalisé selon le métier (medecin ou secrétaire médicale)
        if (personnel.getMetier() == MetierCHU.MEDECIN) {
            Medecin medecin = (Medecin) personnel;
            this.jLabelBonjour.setText("Bonjour Dr " + medecin.getNom().toUpperCase() + " " + medecin.getPrenom() + " - " + medecin.getSpecialite());
        } else {
            this.jLabelBonjour.setText("Bonjour " + personnel.getNom().toUpperCase() + " " + personnel.getPrenom() + " - Secrétaire Médicale");
        }

        lectureXML = new LectureXML("dossiers.xml"); // Lit le fichier XML contenant les dossiers
        dossierMedical = lectureXML.getDossier();
        listePatient = dossierMedical.getListeTousPatients();

        if (personnel.getMetier() == MetierCHU.MEDECIN) {
            Medecin medecin = (Medecin) personnel;
            this.jListPatients.setListData(dossierMedical.getListePatients(medecin));
            this.jComboBoxMedecin.addItem(medecin.getNom() + " " + medecin.getPrenom() + " - " + medecin.getSpecialite().toString());
            this.jComboBoxMedecin.setSelectedIndex(0);
            this.jComboBoxMedecin.setEnabled(false);
        } else {
            for (int i = 0; i < dossierMedical.getListeMedecins().size(); i++) {
                this.jComboBoxMedecin.addItem(dossierMedical.getListeMedecins().get(i).getNom() + " " + dossierMedical.getListeMedecins().get(i).getPrenom() + " - " + dossierMedical.getListeMedecins().get(i).getSpecialite());
                this.jComboBoxMedecin.setEnabled(true);
                this.jRadioButtonMespatients.setVisible(false);
                this.jRadioButtonAllPatients.setSelected(true);
                this.jListPatients.setListData(dossierMedical.getListeTousPatients());
            }
        }

        //Initialise la valeur des labels
        this.jLabelErreurAM.setVisible(false);
        this.jLabelErreurCP.setVisible(false);
        this.jTabbedPane1.setEnabledAt(2, false);
        this.jLabelTel.setText(personnel.getTelephone());
        this.jLabelnumRPPS.setText(personnel.getUsername());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPatients = new javax.swing.JList();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDossierMed = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabelPrenomNomDM = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabelDateNaissanceDM = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabelSecuDM = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabelPoidsDM = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabelTailleDM = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabelAdresseDM = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabelNomAM = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelPrenomAM = new javax.swing.JLabel();
        jButtonNouveauPatient = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxMedecin = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jComboBoxCode = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldCoef = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jComboBoxjourAM = new javax.swing.JComboBox();
        jComboBoxMoisAM = new javax.swing.JComboBox();
        jComboBoxMinAM = new javax.swing.JComboBox();
        jComboBoxHeureAM = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaCommentaireAM = new javax.swing.JTextArea();
        jLabelErreurAM = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jComboBoxType = new javax.swing.JComboBox();
        jLabel35 = new javax.swing.JLabel();
        jTextFieldNomActe = new javax.swing.JTextField();
        jCheckBoxNouvelleFiche = new javax.swing.JCheckBox();
        jTextFieldAnneeAM = new javax.swing.JTextField();
        jButtonValiderActe = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPrenomCP = new javax.swing.JTextField();
        jTextFieldNomCP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        PoidsCP = new javax.swing.JTextField();
        jTextFieldTailleCP = new javax.swing.JTextField();
        jButtonValiderCP = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldNumeroSS_CP = new javax.swing.JTextField();
        jComboBoxMoisNaissance = new javax.swing.JComboBox();
        jComboBoxJourNaissance = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextFieldAnneeCP = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldAdresse = new javax.swing.JTextField();
        jLabelErreurCP = new javax.swing.JLabel();
        jRadioButtonAllPatients = new javax.swing.JRadioButton();
        jRadioButtonMespatients = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jLabelTel = new javax.swing.JLabel();
        jLabelnumRPPS = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButtonDeconnexion = new javax.swing.JButton();
        jLabelBonjour = new javax.swing.JLabel();
        jLabelImage = new javax.swing.JLabel();
        jLabelBonjour1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hôpital  Princeton Plainsboro");

        jListPatients.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListPatients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListPatientsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListPatients);

        jTabbedPane1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DOSSIER MEDICAL");

        jTextAreaDossierMed.setEditable(false);
        jTextAreaDossierMed.setColumns(20);
        jTextAreaDossierMed.setFont(new java.awt.Font("Arial Nova", 0, 13)); // NOI18N
        jTextAreaDossierMed.setRows(5);
        jTextAreaDossierMed.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jScrollPane2.setViewportView(jTextAreaDossierMed);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PATIENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Nova", 0, 12))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText(" Identité : ");

        jLabelPrenomNomDM.setText("-");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Date de naissance : ");

        jLabelDateNaissanceDM.setText("-");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Numéro de sécurité sociale :");

        jLabelSecuDM.setText("-");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Poids : ");

        jLabelPoidsDM.setText("-");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Taille : ");

        jLabelTailleDM.setText("-");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Adresse : ");

        jLabelAdresseDM.setText("-");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPoidsDM, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSecuDM, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPrenomNomDM, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTailleDM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAdresseDM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDateNaissanceDM, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabelPrenomNomDM)
                    .addComponent(jLabel32)
                    .addComponent(jLabelDateNaissanceDM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSecuDM)
                    .addComponent(jLabel34)
                    .addComponent(jLabel33)
                    .addComponent(jLabelAdresseDM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelPoidsDM)
                        .addComponent(jLabel38)
                        .addComponent(jLabelTailleDM))
                    .addComponent(jLabel36))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel9.setText("Selectionner un patient dans la liste ou créer un nouveau patient");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dossier Medical", jPanel2);

        jLabel8.setText("Selectionnez un patient dans la liste ou créez un nouveau patient");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Patient"));
        jPanel4.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Nom : ");

        jLabelNomAM.setText("-");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Prenom : ");

        jLabelPrenomAM.setText("-");

        jButtonNouveauPatient.setText("Créer un nouveau patient");
        jButtonNouveauPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNouveauPatientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelNomAM, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelPrenomAM, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonNouveauPatient)
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabelNomAM)
                    .addComponent(jLabel10)
                    .addComponent(jLabelPrenomAM)
                    .addComponent(jButtonNouveauPatient))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Medecin"));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Docteur : ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxMedecin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBoxMedecin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Acte"));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Code : ");

        jComboBoxCode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CS - consultation au cabinet", "CSC - consultation cardiologie", "FP - forfait pediatrique", "KC - actes de chirurgie et de specialite", "KE - actes d'echographie, de doppler", "K - autres actes de specialite", "KFB - forfait B", "ORT - orthodontie", "PRO - prothese dentaire" }));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Coefficient : ");

        jTextFieldCoef.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCoef.setToolTipText("");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Date : ");

        jComboBoxjourAM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jComboBoxMoisAM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jComboBoxMinAM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "56", "57", "58", "59" }));

        jComboBoxHeureAM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", " " }));

        jLabel24.setText("/");

        jLabel25.setText("/");

        jLabel26.setText("h");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Commentaire :");

        jTextAreaCommentaireAM.setColumns(20);
        jTextAreaCommentaireAM.setFont(new java.awt.Font("Arial Nova", 0, 13)); // NOI18N
        jTextAreaCommentaireAM.setRows(5);
        jTextAreaCommentaireAM.setText("RAS");
        jScrollPane3.setViewportView(jTextAreaCommentaireAM);

        jLabelErreurAM.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErreurAM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelErreurAM.setText("Erreur : Un ou plusieurs champs sont invalides");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Type : ");

        jComboBoxType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Diagnostique", "Thérapeutique" }));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Nom de l'acte :");

        jTextFieldNomActe.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jCheckBoxNouvelleFiche.setText("Nouvelle fiche de soins");

        jTextFieldAnneeAM.setText("2020");

        jButtonValiderActe.setText("Valider");
        jButtonValiderActe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jCheckBoxNouvelleFiche)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonValiderActe))
                    .addComponent(jScrollPane3))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabelErreurAM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel21)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel31)
                        .addComponent(jLabel23)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jComboBoxCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jComboBoxjourAM, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxMoisAM, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldAnneeAM, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
                            .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jComboBoxHeureAM, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxMinAM, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCoef, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomActe, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jComboBoxCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jTextFieldCoef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jComboBoxjourAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jComboBoxMoisAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jComboBoxHeureAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jComboBoxMinAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAnneeAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(jTextFieldNomActe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelErreurAM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jCheckBoxNouvelleFiche)
                        .addContainerGap())
                    .addComponent(jButtonValiderActe, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(222, 585, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ajouter Acte Médical", jPanel1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nom : ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Prenom :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Date de naissance :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Poids (en kg) :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Taille (en m) : ");

        jButtonValiderCP.setText("Valider");
        jButtonValiderCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderCPActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Numéro Sécurité Sociale : ");

        jComboBoxMoisNaissance.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));

        jComboBoxJourNaissance.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jLabel28.setText("/");

        jLabel29.setText("/");

        jTextFieldAnneeCP.setText("2020");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Adresse : ");

        jLabelErreurCP.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErreurCP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelErreurCP.setText("Erreur : Un ou plusieurs champs sont invalides");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PoidsCP, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
                            .addComponent(jTextFieldTailleCP)
                            .addComponent(jTextFieldPrenomCP)
                            .addComponent(jTextFieldNumeroSS_CP)
                            .addComponent(jTextFieldAdresse)
                            .addComponent(jTextFieldNomCP)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(166, 166, 166)
                            .addComponent(jComboBoxJourNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel28)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxMoisNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel29)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldAnneeCP, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabelErreurCP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonValiderCP)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldPrenomCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxMoisNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxJourNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28)
                        .addComponent(jLabel29)
                        .addComponent(jTextFieldAnneeCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTailleCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(PoidsCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldNumeroSS_CP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabelErreurCP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonValiderCP)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Créer Patient", jPanel3);

        buttonGroup1.add(jRadioButtonAllPatients);
        jRadioButtonAllPatients.setText("Tous les patients");
        jRadioButtonAllPatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAllPatientsActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonMespatients);
        jRadioButtonMespatients.setSelected(true);
        jRadioButtonMespatients.setText("Mes Patients");
        jRadioButtonMespatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMespatientsActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabelTel.setFont(new java.awt.Font("Arial Nova", 0, 11)); // NOI18N
        jLabelTel.setText("-");

        jLabelnumRPPS.setFont(new java.awt.Font("Arial Nova", 0, 11)); // NOI18N
        jLabelnumRPPS.setText("-");

        jLabel15.setFont(new java.awt.Font("Arial Nova", 1, 11)); // NOI18N
        jLabel15.setText("n° RPPS :");

        jLabel11.setFont(new java.awt.Font("Arial Nova", 1, 11)); // NOI18N
        jLabel11.setText("Telephone : ");

        jButtonDeconnexion.setText("Deconnexion");
        jButtonDeconnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeconnexionActionPerformed(evt);
            }
        });

        jLabelBonjour.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelBonjour.setText("Bonjour Docteur ");

        jLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/medecin.png"))); // NOI18N

        jLabelBonjour1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Arial Nova", 1, 18)); // NOI18N
        jLabel16.setText("PORTAIL MEDICAL");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabelnumRPPS, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonDeconnexion))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabelTel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelBonjour1))
                    .addComponent(jLabelBonjour))
                .addGap(23, 23, 23))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabelTel, jLabelnumRPPS});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelImage)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabelBonjour)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelBonjour1)
                                .addComponent(jLabel16))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabelTel))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonDeconnexion)
                            .addComponent(jLabelnumRPPS)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButtonAllPatients)
                                .addGap(8, 8, 8)
                                .addComponent(jRadioButtonMespatients)))
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonAllPatients)
                            .addComponent(jRadioButtonMespatients))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Exécuté lors d'un clic dans la liste des patients
     *
     * @param evt
     */
    private void jListPatientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPatientsMouseClicked
        int index = 0;
        index = this.jListPatients.getSelectedIndex(); // récupére l'index de la selection

        //Selon la selection affiche les patients du medecin ou tous les patients
        if (this.jRadioButtonAllPatients.isSelected()) {
       
        } else {
            patient = dossierMedical.getListePatients((Medecin) personnel).get(index);
        }
        this.miseAJourAffichage();
    }//GEN-LAST:event_jListPatientsMouseClicked
    /**
     * Exécuté au clic sur le radio bouton " Tous les patients"
     *
     * @param evt
     */
    private void jRadioButtonAllPatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAllPatientsActionPerformed
        this.jListPatients.setListData(dossierMedical.getListeTousPatients());
    }//GEN-LAST:event_jRadioButtonAllPatientsActionPerformed
    /**
     * Exécuté au clic sur le radio bouton " Mes patients"
     *
     * @param evt
     */
    private void jRadioButtonMespatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMespatientsActionPerformed
        this.jListPatients.setListData(dossierMedical.getListePatients((Medecin) personnel));
    }//GEN-LAST:event_jRadioButtonMespatientsActionPerformed
    /**
     * Exécuté au clic sur le bouton "Valider" pour ajouter un acte medical
     *
     * @param evt
     */
    private void jButtonValiderActeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActeActionPerformed

        int annee = 2020;
        int coef = 1;
        boolean erreur = false;

        //Teste si l'année et le coef sont bien des nombres
        try {
            annee = Integer.parseInt(this.jTextFieldAnneeAM.getText());
            coef = Integer.parseInt(this.jTextFieldCoef.getText());
        } catch (Exception e) {
            erreur = true;
        }

        if (!this.jListPatients.isSelectionEmpty() && !erreur && !this.jTextFieldNomActe.getText().isEmpty()) {
            erreur = false;

            // Récupére la date
            Date date = new Date(Integer.parseInt(this.jComboBoxjourAM.getSelectedItem().toString()),
                    Integer.parseInt(this.jComboBoxMoisAM.getSelectedItem().toString()),
                    annee,
                    Integer.parseInt(this.jComboBoxHeureAM.getSelectedItem().toString()),
                    Integer.parseInt(this.jComboBoxMinAM.getSelectedItem().toString()));

            //Cherche le medecin correspondant à la sélection
            int index = this.jComboBoxMedecin.getSelectedIndex();
            Medecin medecinChoisi = null;
            if (this.personnel.getMetier() == MetierCHU.MEDECIN) {
                medecinChoisi = (Medecin) personnel;
            } else {
                medecinChoisi = dossierMedical.getListeMedecins().get(index);
            }

            String code = this.jComboBoxCode.getSelectedItem().toString().substring(0, this.jComboBoxCode.getSelectedItem().toString().lastIndexOf(" -"));

            //Récupére le type
            princetonPlainsboro.Type type;
            if (this.jComboBoxType.getSelectedItem() == "Diagnostique") {
                type = princetonPlainsboro.Type.DIAG;
            } else {
                type = princetonPlainsboro.Type.THERA;
            }
            //Récupére le commentaire
            String commentaire = "RAS";
            if (!this.jTextAreaCommentaireAM.getText().isEmpty()) {
                commentaire = this.jTextAreaCommentaireAM.getText();
            }
            Acte acte = new Acte(Code.valueOf(code), coef, this.jTextFieldNomActe.getText(), medecinChoisi, date, type, commentaire);

            //Ajoute l'acte à la derniére fiche ou en créer ue nouvelle
            dossierMedical.trieListeDate();
            FicheDeSoins fiche = null;
            if (this.jCheckBoxNouvelleFiche.isSelected()) {

                fiche = new FicheDeSoins(patient, medecinChoisi, date, dossierMedical.dernierNumeroFiche() + 1);
                // fiche.ajouterActe(acte);
                modifXML.nouvelleFicheDeSoins(fiche);
            } else {
                fiche = dossierMedical.getFichesDeSoinsPatient(patient).get(0);
            }
            modifXML.ajouterActeDansFicheDeSoins(fiche, acte);
            dossierMedical = lectureXML.getDossier();

            //Indique que la création est effectuée
            this.jLabelErreurAM.setText("Créé avec succès !");
            this.jLabelErreurAM.setForeground(Color.GREEN);
            this.jLabelErreurAM.setVisible(true);
            reinitialiseChampActe();
            this.jTabbedPane1.setSelectedIndex(0);

        } else {
            //Indique une erreur
            this.jLabelErreurAM.setText("Erreur : Un ou plusieurs champs sont invalides");
            this.jLabelErreurAM.setForeground(Color.red);
            this.jLabelErreurAM.setVisible(true);
        }
    }//GEN-LAST:event_jButtonValiderActeActionPerformed

    /**
     * Exécuté au clic sur le bouton "Valider" pour ajouter un patient
     *
     * @param evt
     */
    private void jButtonValiderCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderCPActionPerformed
        boolean error = false;
        //Test si le format attendu est fourni
        try {
            Integer.parseInt(this.jTextFieldAnneeAM.getText());
            Double.parseDouble(this.jTextFieldAnneeCP.getText());
            Double.parseDouble(this.jTextFieldTailleCP.getText());
        } catch (Exception e) {
            error = true;
        }
        if (!this.jTextFieldNomCP.getText().isEmpty() && !this.jTextFieldPrenomCP.getText().isEmpty()
                && !this.jTextFieldTailleCP.getText().isEmpty() && !this.jTextFieldAnneeCP.getText().isEmpty()
                && !this.jTextFieldNumeroSS_CP.getText().isEmpty() && !this.jTextFieldAdresse.getText().isEmpty()
                && !this.PoidsCP.getText().isEmpty()
                && !error
                && Patient.verifierSecu(this.jTextFieldNumeroSS_CP.getText())) {

            Date date = new Date(Integer.parseInt(this.jComboBoxJourNaissance.getSelectedItem().toString()),
                    Integer.parseInt(this.jComboBoxMoisNaissance.getSelectedItem().toString()),
                    Integer.parseInt(this.jTextFieldAnneeCP.getText()),
                    0, 0);

            Patient p = new Patient(this.jTextFieldPrenomCP.getText(),
                    this.jTextFieldNomCP.getText(),
                    this.jTextFieldAdresse.getText(),
                    date,
                    this.jTextFieldNumeroSS_CP.getText(),
                    Double.parseDouble(this.PoidsCP.getText()),
                    Double.parseDouble(this.jTextFieldTailleCP.getText()));

            this.jRadioButtonAllPatients.setSelected(true); // Selectionne le bouton tous les patients, car à ce stade le patient crée n'appartient à aucun medecin

            listePatient.add(p);
            this.jListPatients.setListData(listePatient);

            //Indique le succés
            this.jLabelErreurCP.setText("Créé avec succés");
            this.jLabelErreurCP.setForeground(Color.GREEN);
            this.jLabelErreurCP.setVisible(true);
            reinitialiseChampPatient();
            this.jListPatients.setSelectedIndex(listePatient.size() - 1);
            this.jTabbedPane1.setSelectedIndex(1);
            this.jTabbedPane1.setEnabledAt(2, false);
            this.patient = p;
            miseAJourAffichage();

        } else {
            //Indique une erreur
            this.jLabelErreurCP.setText("Erreur : Un ou plusieurs champs sont invalides");
            this.jLabelErreurCP.setForeground(Color.red);
            this.jLabelErreurCP.setVisible(true);
        }
    }//GEN-LAST:event_jButtonValiderCPActionPerformed

    /**
     * Au clic sur "Nouveau patient" dans la fenetre de création d'un acte
     *
     * @param evt
     */
    private void jButtonNouveauPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNouveauPatientActionPerformed
        this.jTabbedPane1.setEnabledAt(2, true);
        this.jTabbedPane1.setSelectedIndex(2); //Selectionne l'onglet de création d'un acte

    }//GEN-LAST:event_jButtonNouveauPatientActionPerformed

    /**
     * Exécuté au clic sur le bouton déconnexion
     *
     * @param evt
     */
    private void jButtonDeconnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeconnexionActionPerformed
        this.dispose();
        new connexion().setVisible(true); // lance la fenetre connexion

    }//GEN-LAST:event_jButtonDeconnexionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PoidsCP;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonDeconnexion;
    private javax.swing.JButton jButtonNouveauPatient;
    private javax.swing.JButton jButtonValiderActe;
    private javax.swing.JButton jButtonValiderCP;
    private javax.swing.JCheckBox jCheckBoxNouvelleFiche;
    private javax.swing.JComboBox jComboBoxCode;
    private javax.swing.JComboBox jComboBoxHeureAM;
    private javax.swing.JComboBox jComboBoxJourNaissance;
    private javax.swing.JComboBox jComboBoxMedecin;
    private javax.swing.JComboBox jComboBoxMinAM;
    private javax.swing.JComboBox jComboBoxMoisAM;
    private javax.swing.JComboBox jComboBoxMoisNaissance;
    private javax.swing.JComboBox jComboBoxType;
    private javax.swing.JComboBox jComboBoxjourAM;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAdresseDM;
    private javax.swing.JLabel jLabelBonjour;
    private javax.swing.JLabel jLabelBonjour1;
    private javax.swing.JLabel jLabelDateNaissanceDM;
    private javax.swing.JLabel jLabelErreurAM;
    private javax.swing.JLabel jLabelErreurCP;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JLabel jLabelNomAM;
    private javax.swing.JLabel jLabelPoidsDM;
    private javax.swing.JLabel jLabelPrenomAM;
    private javax.swing.JLabel jLabelPrenomNomDM;
    private javax.swing.JLabel jLabelSecuDM;
    private javax.swing.JLabel jLabelTailleDM;
    private javax.swing.JLabel jLabelTel;
    private javax.swing.JLabel jLabelnumRPPS;
    private javax.swing.JList jListPatients;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButtonAllPatients;
    private javax.swing.JRadioButton jRadioButtonMespatients;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextAreaCommentaireAM;
    private javax.swing.JTextArea jTextAreaDossierMed;
    private javax.swing.JTextField jTextFieldAdresse;
    private javax.swing.JTextField jTextFieldAnneeAM;
    private javax.swing.JTextField jTextFieldAnneeCP;
    private javax.swing.JTextField jTextFieldCoef;
    private javax.swing.JTextField jTextFieldNomActe;
    private javax.swing.JTextField jTextFieldNomCP;
    private javax.swing.JTextField jTextFieldNumeroSS_CP;
    private javax.swing.JTextField jTextFieldPrenomCP;
    private javax.swing.JTextField jTextFieldTailleCP;
    // End of variables declaration//GEN-END:variables

    /**
     * Met a jour l'affichage des élements
     */
    private void miseAJourAffichage() {
        //Dossier médical
        this.jLabelPrenomNomDM.setText(patient.getNom().toUpperCase() + " " + patient.getPrenom());
        this.jLabelSecuDM.setText(patient.getNumeroSecuriteSociale());
        this.jLabelTailleDM.setText(patient.getTaille() + " m");
        this.jLabelPoidsDM.setText(patient.getPoids() + " kg");
        this.jLabelDateNaissanceDM.setText(patient.getDateDeNaissance().toStringDate());
        this.jLabelAdresseDM.setText(patient.getAdresse());
        this.jTextAreaDossierMed.setText(dossierMedical.getFichesPatient(patient));
        if (dossierMedical.getFichesPatient(patient).isEmpty()) {
            this.jCheckBoxNouvelleFiche.setSelected(true);
            this.jCheckBoxNouvelleFiche.setEnabled(false);
        } else {
            this.jCheckBoxNouvelleFiche.setEnabled(true);
        }

        //Nouvel acte
        this.jLabelNomAM.setText(patient.getNom().toUpperCase());
        this.jLabelPrenomAM.setText(patient.getPrenom());

    }

    /**
     * Vide les champs dans l'onglet acte
     */
    private void reinitialiseChampActe() {
        this.jComboBoxCode.setSelectedIndex(0);
        this.jComboBoxHeureAM.setSelectedIndex(0);
        this.jComboBoxMinAM.setSelectedIndex(0);
        this.jComboBoxjourAM.setSelectedIndex(0);
        this.jTextAreaCommentaireAM.setText("RAS");
        this.jTextFieldCoef.setText("");
        this.jTextFieldNomActe.setText("");
        this.jCheckBoxNouvelleFiche.setSelected(false);

        miseAJourAffichage();
    }

    /**
     * Vide les champs dans l'onglet création patient
     */
    private void reinitialiseChampPatient() {
        this.jTextFieldNomCP.setText("");
        this.jTextFieldPrenomCP.setText("");
        this.jTextFieldTailleCP.setText("");
        this.jTextFieldAnneeCP.setText("");
        this.jTextFieldNumeroSS_CP.setText("");
        this.jTextFieldAdresse.setText("");
        this.PoidsCP.setText("");
        this.jTextFieldAnneeAM.setText("2020");
        this.jComboBoxJourNaissance.setSelectedIndex(0);
        this.jComboBoxMoisNaissance.setSelectedIndex(0);
    }

}
