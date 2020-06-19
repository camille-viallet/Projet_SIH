/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import princetonPlainsboro.Acte;
import princetonPlainsboro.Code;
import princetonPlainsboro.ComparaisonFichesCouts;
import princetonPlainsboro.ComparaisonFichesDates;
import princetonPlainsboro.ComparaisonFichesNumero;
import princetonPlainsboro.Date;
import princetonPlainsboro.DossierMedical;
import princetonPlainsboro.FicheDeSoins;
import princetonPlainsboro.LectureXML;
import princetonPlainsboro.LectureXMLPersonnel;
import princetonPlainsboro.Medecin;
import princetonPlainsboro.MetierCHU;
import princetonPlainsboro.ModificationXMLPersonnel;
import princetonPlainsboro.Patient;
import princetonPlainsboro.Personnel;
import princetonPlainsboro.PersonnelHopital;
import princetonPlainsboro.SecretaireAdmin;
import princetonPlainsboro.SecretaireMed;
import princetonPlainsboro.Specialite;

/**
 * Interface destinée aux secrétaires administratives
 *
 * @author Groupe 8
 */
public class InterfaceSecretaireAdmin extends javax.swing.JFrame {

    DossierMedical dossierMedical;
    PersonnelHopital persHopital;
    DefaultTableModel model;
    LectureXML LectureXMLDossierMedical;
    List<FicheDeSoins> ListeFicheDeSoins;
    LectureXMLPersonnel fichierXMLPersonnel;

    /**
     * Créer l'interface administrative
     *
     * @param p
     */
    public InterfaceSecretaireAdmin(Personnel p) {
        initComponents();

        //Lecture du XML Dossier Medical
        LectureXMLDossierMedical = new LectureXML("dossiers.xml");
        dossierMedical = LectureXMLDossierMedical.getDossier();

        //Lecture du fichier XML personnel
        fichierXMLPersonnel = new LectureXMLPersonnel("personnels.xml");
        persHopital = fichierXMLPersonnel.getPersonnel();

        ListeFicheDeSoins = dossierMedical.getFicheDeSoins();

        this.jLabelBonjour.setText("Bonjour " + p.getNom().toUpperCase() + " " + p.getPrenom());

        //Initialise la valeur du comboBox avec les valeurs de Code
        for (Code code : Code.values()) {
            this.jComboBoxActe1.addItem(code);
        }

        model = (DefaultTableModel) this.jTable.getModel();

        //Initialise les élements graphiques
        this.jTabbedPane1.setEnabledAt(1, false);
        initialiseCoutActe();
        remplirPersonnel();
        this.initialiseMedecin();
        this.jLabelErreurDate.setVisible(false);
        this.jPanelCreationEmploye.setVisible(false);
        for (Specialite spe : Specialite.values()) {
            this.jComboBoxSpecialite.addItem(spe);
        }
        for (MetierCHU metier : MetierCHU.values()) {
            this.jComboBoxFonction.addItem(metier);
        }
        this.jComboBoxSpecialite.setVisible(false);
        this.jLabelSpe.setVisible(false);
        this.jComboBoxFonction.setSelectedIndex(1);
        this.jLabelErreurEmploye.setVisible(false);
        this.jLabelTel.setText(p.getTelephone());
        this.jLabelMatricule.setText(p.getUsername());
        
        this.setExtendedState(InterfaceSecretaireAdmin.MAXIMIZED_BOTH);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jRadioButtonMedecin = new javax.swing.JRadioButton();
        jRadioButtonPatient = new javax.swing.JRadioButton();
        jRadioButtonSpecialite = new javax.swing.JRadioButton();
        jRadioButtonActe = new javax.swing.JRadioButton();
        jRadioButtonFicheSoins = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxActe1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCoef1 = new javax.swing.JTextField();
        jButtonCalculerCout = new javax.swing.JButton();
        jLabelErreurActe = new javax.swing.JLabel();
        jLabelCout3 = new javax.swing.JLabel();
        jLabelCoutGras = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jRadioButtonTriDate = new javax.swing.JRadioButton();
        jRadioButtonTriCout = new javax.swing.JRadioButton();
        jRadioButtonTriNumero = new javax.swing.JRadioButton();
        jComboBoxJourD = new javax.swing.JComboBox();
        jComboBoxMoisD = new javax.swing.JComboBox();
        jTextFieldAnneeD = new javax.swing.JTextField();
        jComboJourF = new javax.swing.JComboBox();
        jComboMoisF = new javax.swing.JComboBox();
        jTextFieldAnneeF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelErreurDate = new javax.swing.JLabel();
        jButtonValider2Dates = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jCheckBoxEntre2Dates = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelNomPatient = new javax.swing.JLabel();
        jLabelPrenomPatient = new javax.swing.JLabel();
        jLabelDateNaissance = new javax.swing.JLabel();
        jLabelINSEE = new javax.swing.JLabel();
        jLabelAdresse = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabelNomMedecin = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabelPrenomMedecin = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabelSpecialite = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabelTelephoneMed = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabelRPPS = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jLabelFiche = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButtonCreerEmploye = new javax.swing.JButton();
        jPanelCreationEmploye = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldNom = new javax.swing.JTextField();
        jTextFieldPrenom = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldIdentifiant = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldTelephone = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabelSpe = new javax.swing.JLabel();
        jComboBoxFonction = new javax.swing.JComboBox();
        jComboBoxSpecialite = new javax.swing.JComboBox();
        jButtonValiderCreation = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPasswordFieldPassWord = new javax.swing.JPasswordField();
        jLabelErreurEmploye = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabelBonjour = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabelMatricule = new javax.swing.JLabel();
        jLabelImage = new javax.swing.JLabel();
        jLabelTel = new javax.swing.JLabel();
        jButtonDeconnexion = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hopital princeton plainsboro - Administration");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Visualisation des coûts :"));

        buttonGroup2.add(jRadioButtonMedecin);
        jRadioButtonMedecin.setSelected(true);
        jRadioButtonMedecin.setText("Medecin");
        jRadioButtonMedecin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMedecinActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButtonPatient);
        jRadioButtonPatient.setText("Patient");
        jRadioButtonPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPatientActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButtonSpecialite);
        jRadioButtonSpecialite.setText("Spécialité");
        jRadioButtonSpecialite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSpecialiteActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButtonActe);
        jRadioButtonActe.setText("Acte");
        jRadioButtonActe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonActeActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButtonFicheSoins);
        jRadioButtonFicheSoins.setText("Fiche de soins");
        jRadioButtonFicheSoins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFicheSoinsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonMedecin, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addGap(71, 71, 71)
                .addComponent(jRadioButtonSpecialite)
                .addGap(91, 91, 91)
                .addComponent(jRadioButtonPatient)
                .addGap(97, 97, 97)
                .addComponent(jRadioButtonActe)
                .addGap(64, 64, 64)
                .addComponent(jRadioButtonFicheSoins)
                .addGap(49, 49, 49))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jRadioButtonActe, jRadioButtonPatient, jRadioButtonSpecialite});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonMedecin)
                    .addComponent(jRadioButtonSpecialite)
                    .addComponent(jRadioButtonPatient)
                    .addComponent(jRadioButtonActe)
                    .addComponent(jRadioButtonFicheSoins))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setRowHeight(20);
        jTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Calculer le coût d'un acte"));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Acte :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Coefficient : ");

        jButtonCalculerCout.setText("Calculer");
        jButtonCalculerCout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalculerCoutActionPerformed(evt);
            }
        });

        jLabelErreurActe.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErreurActe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelErreurActe.setText("jLabel1");

        jLabelCout3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelCout3.setText("x");

        jLabelCoutGras.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelCoutGras.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCoutGras.setText("Coût :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCalculerCout)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldCoef1)
                    .addComponent(jComboBoxActe1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabelCoutGras, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelCout3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelErreurActe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxActe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldCoef1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jButtonCalculerCout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelErreurActe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCoutGras)
                    .addComponent(jLabelCout3))
                .addGap(36, 36, 36))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Tri des fiches de soins"));

        buttonGroup1.add(jRadioButtonTriDate);
        jRadioButtonTriDate.setText("Selon la date (décroissante)");
        jRadioButtonTriDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTriDateActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonTriCout);
        jRadioButtonTriCout.setText("Selon le coût (décroissant)");
        jRadioButtonTriCout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTriCoutActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonTriNumero);
        jRadioButtonTriNumero.setSelected(true);
        jRadioButtonTriNumero.setText("Selon le numero ( croissant )");
        jRadioButtonTriNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTriNumeroActionPerformed(evt);
            }
        });

        jComboBoxJourD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jComboBoxMoisD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));

        jTextFieldAnneeD.setText("2020");

        jComboJourF.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jComboMoisF.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));

        jTextFieldAnneeF.setText("2020");

        jLabel2.setText("Fin :");

        jLabel10.setText("Début :");

        jLabelErreurDate.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErreurDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelErreurDate.setText("Année saisie invalide");

        jButtonValider2Dates.setText("OK");
        jButtonValider2Dates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValider2DatesActionPerformed(evt);
            }
        });

        jCheckBoxEntre2Dates.setText("Entre deux dates :");
        jCheckBoxEntre2Dates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxEntre2DatesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboJourF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxJourD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jComboBoxMoisD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldAnneeD, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jComboMoisF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldAnneeF, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonValider2Dates))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonTriNumero)
                            .addComponent(jRadioButtonTriCout)
                            .addComponent(jRadioButtonTriDate))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jCheckBoxEntre2Dates)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelErreurDate, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator1))))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jRadioButtonTriDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonTriCout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonTriNumero)
                .addGap(15, 15, 15)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxEntre2Dates)
                    .addComponent(jLabelErreurDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBoxJourD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMoisD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAnneeD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jComboJourF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboMoisF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldAnneeF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButtonValider2Dates))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 20, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Tableau de bord", jPanel4);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PATIENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Nova", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nom : ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Prenom : ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Date de naissance : ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("N°INSEE :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Adresse : ");

        jLabelNomPatient.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabelINSEE, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel9))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabelNomPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabelAdresse, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                        .addGap(260, 260, 260))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabelPrenomPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabelDateNaissance, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabelNomPatient)
                    .addComponent(jLabelPrenomPatient)
                    .addComponent(jLabelDateNaissance))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabelAdresse)
                    .addComponent(jLabel8)
                    .addComponent(jLabelINSEE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MEDECIN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Nova", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Nom : ");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Prenom : ");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Spécialité : ");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Telephone : ");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Identifiant RPPS:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNomMedecin, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTelephoneMed, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabelPrenomMedecin, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                        .addComponent(jLabel19)
                        .addGap(70, 70, 70)
                        .addComponent(jLabelSpecialite, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabelRPPS, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabelPrenomMedecin, jLabelRPPS});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabelNomMedecin)
                    .addComponent(jLabel17)
                    .addComponent(jLabelPrenomMedecin)
                    .addComponent(jLabel19)
                    .addComponent(jLabelSpecialite))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabelTelephoneMed)
                    .addComponent(jLabel23)
                    .addComponent(jLabelRPPS))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ACTES EFFECTUES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Nova", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Code de l'acte", "Description", "Cout unitaire", "Coefficient", "Prix"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(227, 227, 227));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PAIEMENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Nova", 1, 12), new java.awt.Color(0, 51, 102))); // NOI18N

        jLabel25.setFont(new java.awt.Font("Arial Nova", 1, 12)); // NOI18N
        jLabel25.setText("COUT TOTAL :");

        jLabelTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabelTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelFiche.setFont(new java.awt.Font("Arial Nova", 1, 18)); // NOI18N
        jLabelFiche.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFiche.setText("FEUILLE DE SOINS");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelFiche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelFiche, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Facturation - Feuilles de soins", jPanel5);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Prenom", "Identifiant", "Telephone", "Fonction", "Spécialité"
            }
        ));
        jTable2.setRowHeight(30);
        jScrollPane3.setViewportView(jTable2);

        jButtonCreerEmploye.setText("Créer un nouvel employé");
        jButtonCreerEmploye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreerEmployeActionPerformed(evt);
            }
        });

        jPanelCreationEmploye.setBackground(new java.awt.Color(227, 227, 227));
        jPanelCreationEmploye.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CREATION EMPLOYE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Nova", 1, 14))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Nom : ");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Prénom : ");

        jTextFieldIdentifiant.setToolTipText("");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Identifiant : ");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Telephone : ");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Fonction : ");

        jLabelSpe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelSpe.setText("Spécialité : ");

        jComboBoxFonction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFonctionActionPerformed(evt);
            }
        });

        jButtonValiderCreation.setText("Valider");
        jButtonValiderCreation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderCreationActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Mot de passe  : ");

        javax.swing.GroupLayout jPanelCreationEmployeLayout = new javax.swing.GroupLayout(jPanelCreationEmploye);
        jPanelCreationEmploye.setLayout(jPanelCreationEmployeLayout);
        jPanelCreationEmployeLayout.setHorizontalGroup(
            jPanelCreationEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCreationEmployeLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanelCreationEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelCreationEmployeLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldIdentifiant, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCreationEmployeLayout.createSequentialGroup()
                        .addComponent(jLabelSpe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxSpecialite, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCreationEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCreationEmployeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonValiderCreation))
                    .addGroup(jPanelCreationEmployeLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxFonction, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jPasswordFieldPassWord, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelCreationEmployeLayout.setVerticalGroup(
            jPanelCreationEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCreationEmployeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelCreationEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldIdentifiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jComboBoxFonction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jPasswordFieldPassWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(13, 13, 13)
                .addGroup(jPanelCreationEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSpe)
                    .addComponent(jComboBoxSpecialite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonValiderCreation))
                .addGap(62, 62, 62))
        );

        jLabelErreurEmploye.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelErreurEmploye.setText("jLabel20");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonCreerEmploye)
                    .addComponent(jLabelErreurEmploye, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1147, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCreationEmploye, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelErreurEmploye)
                .addGap(4, 4, 4)
                .addComponent(jButtonCreerEmploye)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCreationEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Gestion du personnel", jPanel3);

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));

        jLabel22.setFont(new java.awt.Font("Arial Nova", 1, 11)); // NOI18N
        jLabel22.setText("Matricule : ");
        jLabel22.setToolTipText("");

        jLabelBonjour.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelBonjour.setText("Bonjour ");

        jLabel20.setFont(new java.awt.Font("Arial Nova", 1, 11)); // NOI18N
        jLabel20.setText("Telephone : ");
        jLabel20.setToolTipText("");

        jLabelMatricule.setFont(new java.awt.Font("Arial Nova", 0, 11)); // NOI18N
        jLabelMatricule.setText(" - ");
        jLabelMatricule.setToolTipText("");

        jLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/dossier.png"))); // NOI18N

        jLabelTel.setFont(new java.awt.Font("Arial Nova", 0, 11)); // NOI18N
        jLabelTel.setText(" - ");
        jLabelTel.setToolTipText("");

        jButtonDeconnexion.setText("Deconnexion");
        jButtonDeconnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeconnexionActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Arial Nova", 1, 18)); // NOI18N
        jLabel24.setText("PORTAIL ADMINISTRATIF");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImage)
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabelTel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel24))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabelMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonDeconnexion))))
                    .addComponent(jLabelBonjour))
                .addGap(18, 18, 18))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelImage)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabelBonjour)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabelTel)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel24)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jLabelMatricule)
                            .addComponent(jButtonDeconnexion))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Exécuté au clic sur le bouton "Calculer" ppour calculer le cout d'un acte
     *
     * @param evt
     */
    private void jButtonCalculerCoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalculerCoutActionPerformed
        boolean erreur = false;
        //Teste si le coefficient est bien un entier
        try {
            Integer.parseInt(this.jTextFieldCoef1.getText());
        } catch (Exception e) {
            erreur = true;
        }

        if (!this.jTextFieldCoef1.getText().isEmpty() && !erreur) {
            Code codeSelectionne = Code.valueOf(this.jComboBoxActe1.getSelectedItem().toString());
            int coeff = Integer.parseInt(this.jTextFieldCoef1.getText());
            double cout = codeSelectionne.calculerCout(coeff);
            this.jLabelCoutGras.setText("Coût de " + codeSelectionne.name() + "" + coeff);
            this.jLabelCout3.setText(cout + " €");
            this.jLabelCout3.setVisible(true);
            this.jLabelCoutGras.setVisible(true);
            

        } else {
            this.jLabelErreurActe.setBackground(Color.red);
            this.jLabelErreurActe.setText("Erreur : Coefficient incorrect");
            this.jLabelErreurActe.setVisible(true);

        }
    }//GEN-LAST:event_jButtonCalculerCoutActionPerformed
    /**
     * Executé au clic dans la JTable
     *
     * @param evt
     */
    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        JTable source = (JTable) evt.getSource();
        int ligneSelectionnee = source.rowAtPoint(evt.getPoint());
        int colonneSelectionnee = source.columnAtPoint(evt.getPoint());

        model = (DefaultTableModel) this.jTable.getModel();
        if (this.jRadioButtonFicheSoins.isSelected()) { /* Si le radio button est selectionne , au clic on 
             affiche direct la fiche de soins dans l'onglet facture*/

            FicheDeSoins f = this.trouveFiche(model.getValueAt(ligneSelectionnee, 0).toString());
            remplirChampFeuilleDeSoins(f);
        } else if (!model.getValueAt(ligneSelectionnee, 0).equals("")) { //Si la premiére colonne est vide on supprime les lignes
            if (this.jRadioButtonMedecin.isSelected()) {
                Medecin m = Medecin.trouveMedecin(model.getValueAt(ligneSelectionnee, 1).toString());
                int nbrLignes = model.getRowCount();
                //Définit les colonnes
                model.setColumnIdentifiers(new Object[]{"Medecin", "n° RPPS", "", "n° de fiche", "Date", "Prix"});
                //Supprime les lignes
                if (model.getValueAt(ligneSelectionnee + 1, 0).equals("") && ligneSelectionnee < nbrLignes - 2) {
                    while (model.getValueAt(ligneSelectionnee + 1, 0).equals("") && ligneSelectionnee < model.getRowCount() - 2) {
                        model.removeRow(ligneSelectionnee + 1);
                    }
                } else { //Ajoute des élements
                    int i = 0;
                    for (FicheDeSoins fiche : ListeFicheDeSoins) {
                        if (fiche.getMedecin().equals(m)) {
                            DecimalFormat df = new DecimalFormat("####.##");
                            model.addRow(new Object[]{"", "", "Fiche de soins", fiche.getNumero(), fiche.getDate().toStringDate(), df.format(fiche.coutTotal()) + " €"});
                            i++;
                        }
                    }
                    model.addRow(new Object[]{"", "", "", ""});
                    model.moveRow(nbrLignes, nbrLignes + i, ligneSelectionnee + 1);

                }
            } else if (this.jRadioButtonPatient.isSelected()) {
                Patient p = trouvePatient(model.getValueAt(ligneSelectionnee, 1).toString());
                int nbrLignes = model.getRowCount();
                model.setColumnIdentifiers(new Object[]{"Patient", "n° INSEE", "", "n° de fiche", "Date", "Prix"});

                if (model.getValueAt(ligneSelectionnee + 1, 0).equals("") && ligneSelectionnee < nbrLignes - 2) {
                    while (model.getValueAt(ligneSelectionnee + 1, 0).equals("") && ligneSelectionnee < model.getRowCount() - 2) {
                        model.removeRow(ligneSelectionnee + 1);
                    }
                } else {
                    int i = 0;
                    for (FicheDeSoins fiche : ListeFicheDeSoins) {
                        if (fiche.getPatient().equals(p)) {
                            DecimalFormat df = new DecimalFormat("####.##");
                            model.addRow(new Object[]{"", "", "Fiche de soins", fiche.getNumero(), fiche.getDate().toStringDate(), df.format(fiche.coutTotal()) + " €"});
                            i++;

                        }
                    }
                    model.addRow(new Object[]{"", "", "", ""});
                    model.moveRow(nbrLignes, nbrLignes + i, ligneSelectionnee + 1);
                }
            } else if (this.jRadioButtonSpecialite.isSelected()) {
                int i2 = 0;
                Specialite s = Specialite.valueOf(model.getValueAt(ligneSelectionnee, 0).toString());
                int nbrLignes = model.getRowCount();
                model.setColumnIdentifiers(new Object[]{"Spécialité", "", "n° de fiche", "Date", "Prix"});

                System.out.println(ligneSelectionnee);
                if (model.getValueAt(ligneSelectionnee + 1, 0).equals("") && ligneSelectionnee < nbrLignes - 2) {
                    while (model.getValueAt(ligneSelectionnee + 1, 0).equals("") && ligneSelectionnee < model.getRowCount() - 2) {
                        model.removeRow(ligneSelectionnee + 1);
                    }
                } else {
                    int i = 0;
                    for (FicheDeSoins fiche : ListeFicheDeSoins) {
                        if (fiche.getMedecin().getSpecialite().compareTo(s) == 0) {
                            DecimalFormat df = new DecimalFormat("####.##");
                            model.addRow(new Object[]{"", "Fiche de soins", fiche.getNumero(), fiche.getDate().toStringDate(), df.format(fiche.coutTotal()) + " €"});
                            i++;
                        }

                    }
                    model.addRow(new Object[]{"", "", "", ""});
                    model.moveRow(nbrLignes, nbrLignes + i, ligneSelectionnee + 1);
                }

            } else if (this.jRadioButtonActe.isSelected()) {
                int i2 = 0;
                Code c = Code.valueOf(model.getValueAt(ligneSelectionnee, 0).toString());

                int nbrLignes = model.getRowCount();
                model.setColumnIdentifiers(new Object[]{"Code", "Acte", "Date", "Cout unitaire", "Coefficient ", "Prix"});

                if (model.getValueAt(ligneSelectionnee + 1, 0).equals("") && ligneSelectionnee < nbrLignes - 2) {
                    while (model.getValueAt(ligneSelectionnee + 1, 0).equals("") && ligneSelectionnee < model.getRowCount() - 2) {
                        model.removeRow(ligneSelectionnee + 1);
                    }
                } else {
                    int i = 0;

                    for (FicheDeSoins fiche : ListeFicheDeSoins) {
                        for (Acte a : fiche.getActes()) {
                            if (a.getCode().compareTo(c) == 0) {
                                DecimalFormat df = new DecimalFormat("####.##");
                                model.addRow(new Object[]{"", a.getCode().toStringSansUnitaire(a.getCoefficient()), a.getDate().toStringDate(), a.getCode().getCoutUnitaire(), a.getCoefficient(), df.format(a.calculeCout()) + " €"});
                                i++;
                            }
                        }
                    }
                    model.addRow(new Object[]{"", "", "", "", ""});
                    model.moveRow(nbrLignes, nbrLignes + i, ligneSelectionnee + 1);
                }
            }
            //Au clique sur les fiches de soins affiche la facture
        } else if (model.getValueAt(ligneSelectionnee, 2).equals("Fiche de soins") && !this.jRadioButtonActe.isSelected()) {

            FicheDeSoins f = this.trouveFiche(model.getValueAt(ligneSelectionnee, 3).toString());
            remplirChampFeuilleDeSoins(f);
        } else if (model.getValueAt(ligneSelectionnee, 1).equals("Fiche de soins") && this.jRadioButtonSpecialite.isSelected()) {

            FicheDeSoins f = this.trouveFiche(model.getValueAt(ligneSelectionnee, 2).toString());
            remplirChampFeuilleDeSoins(f);
        }


    }//GEN-LAST:event_jTableMouseClicked

    /**
     * Exécuté au clic sur le radio button medecin
     *
     * @param evt
     */
    private void jRadioButtonMedecinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMedecinActionPerformed
        this.initialiseMedecin();
    }//GEN-LAST:event_jRadioButtonMedecinActionPerformed
    /**
     * Exécuté au clic sur le radio button patient
     *
     * @param evt
     */
    private void jRadioButtonPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPatientActionPerformed
        this.initialisePatient();
    }//GEN-LAST:event_jRadioButtonPatientActionPerformed
    /**
     * Exécuté au clic sur le radio button spécialité
     *
     * @param evt
     */
    private void jRadioButtonSpecialiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSpecialiteActionPerformed
        this.initialiseSpecialite();
    }//GEN-LAST:event_jRadioButtonSpecialiteActionPerformed
    /**
     * Exécuté au clic sur le radio button acte
     *
     * @param evt
     */
    private void jRadioButtonActeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonActeActionPerformed
        DefaultTableModel model = (DefaultTableModel) this.jTable.getModel();
        model.setRowCount(0);
        model.setColumnCount(6);
        model.setColumnIdentifiers(new Object[]{"Code", "", "", "Cout unitaire", "Coefficient ", "Prix"});
        for (Code code : Code.values()) {
            DecimalFormat df = new DecimalFormat("####.##");
            model.addRow(new Object[]{code.toString(), "", "", "", "", df.format(dossierMedical.coutCode(code, ListeFicheDeSoins)) + " €"});
        }
        model.addRow(new Object[]{"", "", "", "", ""});
    }//GEN-LAST:event_jRadioButtonActeActionPerformed

    /**
     * Exécuté au clic sur le radio button tri date
     *
     * @param evt
     */
    private void jRadioButtonTriDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTriDateActionPerformed
        ListeFicheDeSoins = DossierMedical.trierDecroissant(new ComparaisonFichesDates(), ListeFicheDeSoins);
        intialiseSelonSelection();
    }//GEN-LAST:event_jRadioButtonTriDateActionPerformed

    /**
     * Exécuté au clic sur le radio button tri couts
     *
     * @param evt
     */
    private void jRadioButtonTriCoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTriCoutActionPerformed
        ListeFicheDeSoins = DossierMedical.trierDecroissant(new ComparaisonFichesCouts(), ListeFicheDeSoins);
        intialiseSelonSelection();
    }//GEN-LAST:event_jRadioButtonTriCoutActionPerformed
    /**
     * Exécuté au clic sur le bouton deconnexion
     */
    private void jButtonDeconnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeconnexionActionPerformed
        this.dispose();
        new connexion().setVisible(true);
    }//GEN-LAST:event_jButtonDeconnexionActionPerformed
    /**
     * Exécuté au clic sur le radio button fiches de soins
     *
     * @param evt
     */
    private void jRadioButtonFicheSoinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFicheSoinsActionPerformed
        this.initaliseFiches();
    }//GEN-LAST:event_jRadioButtonFicheSoinsActionPerformed

    /**
     * Exécuté au clic sur le bouton tri numero
     *
     * @param evt
     */
    private void jRadioButtonTriNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTriNumeroActionPerformed
        ListeFicheDeSoins = DossierMedical.trierDecroissant(new ComparaisonFichesNumero(), ListeFicheDeSoins);
        intialiseSelonSelection();
    }//GEN-LAST:event_jRadioButtonTriNumeroActionPerformed

    /**
     * Exécuté au clic sur le bouton entre deux dates
     *
     * @param evt
     */
    private void jButtonValider2DatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValider2DatesActionPerformed
        this.jCheckBoxEntre2Dates.setSelected(true);
        afficheEntreDeuxDates();
        
    }//GEN-LAST:event_jButtonValider2DatesActionPerformed

    /**
     * Exécuté lors de changements sur l'état du checkbox
     *
     * @param evt
     */
    private void jCheckBoxEntre2DatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxEntre2DatesActionPerformed
        if (!this.jCheckBoxEntre2Dates.isSelected()) {
            ListeFicheDeSoins = dossierMedical.getFicheDeSoins();
            this.intialiseSelonSelection();
        }
    }//GEN-LAST:event_jCheckBoxEntre2DatesActionPerformed
    /**
     * Exécuté au clic sur le bouton créer un employé
     *
     * @param evt
     */
    private void jButtonCreerEmployeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreerEmployeActionPerformed
        this.jPanelCreationEmploye.setVisible(true);
    }//GEN-LAST:event_jButtonCreerEmployeActionPerformed
    /**
     * Exécuté lors dans changement dans la selection du comboBox
     */

    private void jComboBoxFonctionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFonctionActionPerformed
        if (this.jComboBoxFonction.getSelectedItem().toString().equals(MetierCHU.MEDECIN.toString())) {
            this.jComboBoxSpecialite.setVisible(true);
            this.jLabelSpe.setVisible(true);
        } else {
            this.jComboBoxSpecialite.setVisible(false);
            this.jLabelSpe.setVisible(false);
        }
    }//GEN-LAST:event_jComboBoxFonctionActionPerformed
    /**
     * Exécuté au clic sur le bouton valider la création de l'employé
     *
     * @param evt
     */
    private void jButtonValiderCreationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderCreationActionPerformed
        String nom = this.jTextFieldNom.getText();
        String prenom = this.jTextFieldPrenom.getText();
        String tel = this.jTextFieldTelephone.getText();
        String id = this.jTextFieldIdentifiant.getText();
        String mdp = new String(this.jPasswordFieldPassWord.getPassword());
        if (nom.isEmpty() || prenom.isEmpty() || tel.isEmpty() || id.isEmpty() || mdp.isEmpty()) {
            this.jLabelErreurEmploye.setVisible(true);
            this.jLabelErreurEmploye.setBackground(Color.red);
            this.jLabelErreurEmploye.setText("Veuillez remplir tous les champs");
        } else {
            boolean estOk = true;

            this.jLabelErreurEmploye.setVisible(false);
            ModificationXMLPersonnel modif = new ModificationXMLPersonnel();
            switch (this.jComboBoxFonction.getSelectedItem().toString()) {

                case "MEDECIN":
                    Medecin m = new Medecin(prenom, nom, id, mdp, tel, Specialite.valueOf(this.jComboBoxSpecialite.getSelectedItem().toString()));
                    estOk = modif.ajouterPersonnel(m);
                    break;
                case "SECRETAIRE_ADMINISTRATIVE":
                    SecretaireAdmin s = new SecretaireAdmin(prenom, nom, id, mdp, tel);
                    estOk = modif.ajouterPersonnel(s);
                    break;
                case "SECRETAIRE_MEDICALE":
                    SecretaireMed sMed = new SecretaireMed(prenom, nom, id, mdp, tel);
                    estOk = modif.ajouterPersonnel(sMed);
                    break;

            }
            persHopital = fichierXMLPersonnel.getPersonnel();
            remplirPersonnel();
            this.jLabelErreurEmploye.setVisible(true);
            this.jLabelErreurEmploye.setForeground(Color.green);
            this.jLabelErreurEmploye.setText("Créé avec succès !");
            viderChampPersonnel();
            if (!estOk) {
                this.jLabelErreurEmploye.setVisible(true);
                this.jLabelErreurEmploye.setForeground(Color.RED);
                this.jLabelErreurEmploye.setText("Erreur : le personnel demandé n'a pas été ajouté");
            }

        }
    }//GEN-LAST:event_jButtonValiderCreationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButtonCalculerCout;
    private javax.swing.JButton jButtonCreerEmploye;
    private javax.swing.JButton jButtonDeconnexion;
    private javax.swing.JButton jButtonValider2Dates;
    private javax.swing.JButton jButtonValiderCreation;
    private javax.swing.JCheckBox jCheckBoxEntre2Dates;
    private javax.swing.JComboBox jComboBoxActe1;
    private javax.swing.JComboBox jComboBoxFonction;
    private javax.swing.JComboBox jComboBoxJourD;
    private javax.swing.JComboBox jComboBoxMoisD;
    private javax.swing.JComboBox jComboBoxSpecialite;
    private javax.swing.JComboBox jComboJourF;
    private javax.swing.JComboBox jComboMoisF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAdresse;
    private javax.swing.JLabel jLabelBonjour;
    private javax.swing.JLabel jLabelCout3;
    private javax.swing.JLabel jLabelCoutGras;
    private javax.swing.JLabel jLabelDateNaissance;
    private javax.swing.JLabel jLabelErreurActe;
    private javax.swing.JLabel jLabelErreurDate;
    private javax.swing.JLabel jLabelErreurEmploye;
    private javax.swing.JLabel jLabelFiche;
    private javax.swing.JLabel jLabelINSEE;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JLabel jLabelMatricule;
    private javax.swing.JLabel jLabelNomMedecin;
    private javax.swing.JLabel jLabelNomPatient;
    private javax.swing.JLabel jLabelPrenomMedecin;
    private javax.swing.JLabel jLabelPrenomPatient;
    private javax.swing.JLabel jLabelRPPS;
    private javax.swing.JLabel jLabelSpe;
    private javax.swing.JLabel jLabelSpecialite;
    private javax.swing.JLabel jLabelTel;
    private javax.swing.JLabel jLabelTelephoneMed;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelCreationEmploye;
    private javax.swing.JPasswordField jPasswordFieldPassWord;
    private javax.swing.JRadioButton jRadioButtonActe;
    private javax.swing.JRadioButton jRadioButtonFicheSoins;
    private javax.swing.JRadioButton jRadioButtonMedecin;
    private javax.swing.JRadioButton jRadioButtonPatient;
    private javax.swing.JRadioButton jRadioButtonSpecialite;
    private javax.swing.JRadioButton jRadioButtonTriCout;
    private javax.swing.JRadioButton jRadioButtonTriDate;
    private javax.swing.JRadioButton jRadioButtonTriNumero;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextFieldAnneeD;
    private javax.swing.JTextField jTextFieldAnneeF;
    private javax.swing.JTextField jTextFieldCoef1;
    private javax.swing.JTextField jTextFieldIdentifiant;
    private javax.swing.JTextField jTextFieldNom;
    private javax.swing.JTextField jTextFieldPrenom;
    private javax.swing.JTextField jTextFieldTelephone;
    // End of variables declaration//GEN-END:variables

    /**
     * Initialise les éléments dans calcule le cout d'un acte
     */
    private void initialiseCoutActe() {
        this.jLabelCout3.setText("");
        this.jTextFieldCoef1.setText("");
        this.jLabelCoutGras.setVisible(false);
        this.jLabelCout3.setVisible(false);
        this.jLabelErreurActe.setVisible(false);
    }

    /**
     * Trouve un patient a partir de son numero INSEE
     *
     * @param numeroINSEE numero INSEE a chercher
     * @return le patient
     */
    private Patient trouvePatient(String numeroINSEE) {
        int i2 = 0;
        Patient p = dossierMedical.getListeTousPatients().get(0);
        //Trouve le medecin sur lequel on a cliqué
        while (i2 < dossierMedical.getListeTousPatients().size() && !numeroINSEE.equals(dossierMedical.getListeTousPatients().get(i2).getNumeroSecuriteSociale())) {
            i2++;
            p = dossierMedical.getListeTousPatients().get(i2);
        }

        return p;
    }

    /**
     * Trouve une fiche a partir de son numéri
     *
     * @param numeroFiche numero de fiche
     * @return la fiche de soins
     */
    private FicheDeSoins trouveFiche(String numeroFiche) {
        int numero = Integer.parseInt(numeroFiche);
        int i2 = 0;
        FicheDeSoins f = ListeFicheDeSoins.get(0);
        while (i2 < ListeFicheDeSoins.size() && numero != ListeFicheDeSoins.get(i2).getNumero()) {
            i2++;
            f = ListeFicheDeSoins.get(i2);

        }
        return f;
    }

    /**
     * Rempli la table du personnel
     */
    private void remplirPersonnel() {
        DefaultTableModel model_Personnel = (DefaultTableModel) this.jTable2.getModel();
        model_Personnel.setRowCount(0);
        DecimalFormat df = new DecimalFormat("####.##");
        for (Personnel personnel : this.persHopital.getListePersonnel()) {
            String specialite = "";
            if (personnel.getMetier() == MetierCHU.MEDECIN) {
                Medecin medecin = (Medecin) personnel;
                specialite = medecin.getSpecialite().toString();
            }
            model_Personnel.addRow(new Object[]{personnel.getNom(), personnel.getPrenom(), personnel.getUsername(), personnel.getTelephone(), personnel.getMetier(), specialite});
        }
        model_Personnel.addRow(new Object[]{"", "", "", "", "", ""});
    }

    /**
     * Rempli les champs dans feuille de soins
     *
     * @param fiche fiche de soins a remplir
     */
    private void remplirChampFeuilleDeSoins(FicheDeSoins fiche) {
        this.jLabelFiche.setText("FEUILLE DE SOINS N° " + fiche.getNumero());

        this.jLabelNomPatient.setText(fiche.getPatient().getNom().toUpperCase());
        this.jLabelPrenomPatient.setText(fiche.getPatient().getPrenom());
        this.jLabelDateNaissance.setText(fiche.getPatient().getDateDeNaissance().toStringDate());
        this.jLabelAdresse.setText(fiche.getPatient().getAdresse());
        this.jLabelINSEE.setText(fiche.getPatient().getNumeroSecuriteSociale());

        this.jLabelNomMedecin.setText(fiche.getMedecin().getNom().toUpperCase());
        this.jLabelPrenomMedecin.setText(fiche.getMedecin().getPrenom());
        this.jLabelSpecialite.setText(fiche.getMedecin().getSpecialite().toString());
        this.jLabelRPPS.setText(fiche.getMedecin().getUsername());
        this.jLabelTelephoneMed.setText(fiche.getMedecin().getTelephone());

        DefaultTableModel model_Acte = (DefaultTableModel) this.jTable1.getModel();
        model_Acte.setRowCount(0);
        DecimalFormat df = new DecimalFormat("####.##");
        for (Acte actes : fiche.getActes()) {
            model_Acte.addRow(new Object[]{actes.getDate(), actes.getCode(), actes.getCode().getLibelle(), actes.getCode().getCoutUnitaire() + " €", actes.getCoefficient(), df.format(actes.getCode().calculerCout(actes.getCoefficient())) + " €"});
        }

        this.jLabelTotal.setText(df.format(fiche.coutTotal()) + " €");
        this.jTabbedPane1.setSelectedIndex(1);
        this.jTabbedPane1.setEnabledAt(1, true);
    }

    /**
     * Initialise la table avec les medecins
     */
    private void initialiseMedecin() {
        DefaultTableModel model = (DefaultTableModel) this.jTable.getModel();
        model.setRowCount(0);
        model.setColumnCount(6);
        model.setColumnIdentifiers(new Object[]{"Medecin", "n°RPPS", "", "", "", "Prix"});
        for (Medecin medecin : this.persHopital.getListeMedecins()) {
            DecimalFormat df = new DecimalFormat("####.##");
            model.addRow(new Object[]{medecin.toString(), medecin.getUsername(), "", "", "", df.format(dossierMedical.coutMedecin(medecin, ListeFicheDeSoins)) + " €"});
        }
        model.addRow(new Object[]{"", "", "", ""});
    }

    /**
     * Initialise la table avec les patients
     */
    private void initialisePatient() {
        model.setRowCount(0);
        model.setColumnCount(6);
        model.setColumnIdentifiers(new Object[]{"Patient", "n° INSEE", "", "", "", "Prix"});
        for (Patient patient : dossierMedical.getListeTousPatients()) {
            DecimalFormat df = new DecimalFormat("####.##");
            model.addRow(new Object[]{patient.toString(), patient.getNumeroSecuriteSociale(), "", "", "", df.format(dossierMedical.coutPatient(patient, ListeFicheDeSoins)) + " €"});
        }
        model.addRow(new Object[]{"", "", "", ""});
    }

    /**
     * /**
     * Initialise la table avec les specialites
     */
    private void initialiseSpecialite() {
        model.setRowCount(0);
        model.setColumnCount(5);
        model.setColumnIdentifiers(new Object[]{"Spécialité", "", "", "", "Prix"});
        for (Specialite specialite : Specialite.values()) {
            DecimalFormat df = new DecimalFormat("####.##");
            model.addRow(new Object[]{specialite.toString(), "", "", "", df.format(dossierMedical.coutSpecialite(specialite.toString(), ListeFicheDeSoins)) + " €"});
        }
        model.addRow(new Object[]{"", "", "", ""});
    }

    /**
     * Initialise la table avec les fiches de soins
     */
    private void initaliseFiches() {
        DefaultTableModel model = (DefaultTableModel) this.jTable.getModel();
        model.setRowCount(0);
        model.setColumnCount(6);
        model.setColumnIdentifiers(new Object[]{"n° fiche", "Date", "Patient", "Medecin", "Prix"});
        for (FicheDeSoins fiche : ListeFicheDeSoins) {
            DecimalFormat df = new DecimalFormat("####.##");
            model.addRow(new Object[]{fiche.getNumero(), fiche.getDate(), fiche.getPatient(), fiche.getMedecin(), df.format(fiche.coutTotal()) + " €"});
        }
        model.addRow(new Object[]{"", "", "", ""});
    }

    /**
     * Initialise les champs selon la selection
     */
    private void intialiseSelonSelection() {
        if (this.jRadioButtonMedecin.isSelected()) {
            this.initialiseMedecin();
        } else if (this.jRadioButtonPatient.isSelected()) {
            this.initialisePatient();
        } else if (this.jRadioButtonSpecialite.isSelected()) {
            this.initialiseSpecialite();
        } else if (this.jRadioButtonFicheSoins.isSelected()) {
            initaliseFiches();
        }
    }

    /**
     * Obtient les élements selectionnés dans entre deux dates
     */
    private void afficheEntreDeuxDates() {
        if (this.jCheckBoxEntre2Dates.isSelected()) {
            int jourD = Integer.parseInt(this.jComboBoxJourD.getSelectedItem().toString());
            int moisD = Integer.parseInt(this.jComboBoxMoisD.getSelectedItem().toString());
            int jourF = Integer.parseInt(this.jComboJourF.getSelectedItem().toString());
            int moisF = Integer.parseInt(this.jComboMoisF.getSelectedItem().toString());
            int anneeD = 0;
            int anneeF = 0;
            Date d1 = null;
            Date d2 = null;
            try {
                anneeD = Integer.parseInt(this.jTextFieldAnneeD.getText());
                anneeF = Integer.parseInt(this.jTextFieldAnneeF.getText());
                d1 = new Date(jourD, moisD, anneeD, 0, 0);
                d2 = new Date(jourF, moisF, anneeF, 0, 0);
                ListeFicheDeSoins = dossierMedical.fichesTriees2Dates(d1, d2);
                intialiseSelonSelection();

            } catch (Exception e) {
                this.jLabelErreurDate.setVisible(true);
            }
        }
    }

    /**
     * Vide les champs de création du personnel
     */
    private void viderChampPersonnel() {
        this.jTextFieldNom.setText("");
        this.jTextFieldPrenom.setText("");
        this.jTextFieldTelephone.setText("");
        this.jTextFieldIdentifiant.setText("");
        this.jPasswordFieldPassWord.setText("");
        this.jComboBoxFonction.setSelectedIndex(1);
        this.jComboBoxSpecialite.setSelectedIndex(0);
        this.jPanelCreationEmploye.setVisible(false);
    }

}
