/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Vector;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author Camille
 */
public class LectureXMLPersonnel {
    /// nom du document XML a analyser

    private String nomFichier;
    private final static String repBase = "src/donnees/";

    // 'nomFichier' est le nom d'un fichier XML se trouvant dans le repertoire 'repBase' a lire :
    public LectureXMLPersonnel(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public PersonnelHopital getPersonnel() {
        PersonnelHopital PersonnelEnCours = null;
        String donneesCourantes = "";
        String nom = "";
        String prenom = "";
        String motDePasse = "";
        String telephone = "";
        Specialite specialite = null;
        Medecin medecin = null;
        SecretaireMed secMed = null;
        SecretaireAdmin secAdmin = null;
        String rpps = "";
        String matricule = "";

        // analyser le fichier par StAX
        try {
            // instanciation du parser
            InputStream in = new FileInputStream(repBase + nomFichier);
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader parser = factory.createXMLStreamReader(in);

            // lecture des evenements
            for (int event = parser.next(); event != XMLStreamConstants.END_DOCUMENT; event = parser.next()) {
                // traitement selon l'evenement
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (parser.getLocalName().equals("personnels")) {
                            PersonnelEnCours = new PersonnelHopital();
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:

                        if (parser.getLocalName().equals("medecin")) {
                            medecin = new Medecin(prenom, nom, rpps, motDePasse, telephone, specialite);
                            PersonnelEnCours.addPersonnel(medecin);
                        }
                        if (parser.getLocalName().equals("secretaireMed")) {
                            secMed = new SecretaireMed(prenom, nom, matricule, motDePasse, telephone);
                            PersonnelEnCours.addPersonnel(secMed);
                        }
                        if (parser.getLocalName().equals("secretaireAdm")) {
                            secAdmin = new SecretaireAdmin(prenom, nom, matricule, motDePasse, telephone);
                            PersonnelEnCours.addPersonnel(secAdmin);
                        }
                        if (parser.getLocalName().equals("nom")) {
                            nom = donneesCourantes;
                        }
                        if (parser.getLocalName().equals("specialite")) {
                            specialite = Specialite.valueOf(donneesCourantes);
                            if (specialite == null) {
                                throw new XMLStreamException("Impossible de trouver la spécialité = " + donneesCourantes);
                            }
                        }
                        if (parser.getLocalName().equals("prenom")) {
                            prenom = donneesCourantes;
                        }

                        if (parser.getLocalName().equals("telephone")) {
                            telephone = donneesCourantes;
                        }
                        if (parser.getLocalName().equals("rpps")) {
                            rpps = donneesCourantes;
                        }
                        if (parser.getLocalName().equals("mdp")) {
                            motDePasse = donneesCourantes;
                        }
                        if (parser.getLocalName().equals("username")) {
                            motDePasse = donneesCourantes;
                        }
                        if (parser.getLocalName().equals("matricule")) {
                            matricule = donneesCourantes;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        donneesCourantes = parser.getText();
                        break;
                } // end switch
            } // end while
            parser.close();
        } catch (XMLStreamException ex) {
            System.out.println("Exception de type 'XMLStreamException' lors de la lecture du fichier : " + nomFichier);
            System.out.println("Details :");
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println("Exception de type 'IOException' lors de la lecture du fichier : " + nomFichier);
            System.out.println("Verifier le chemin.");
            System.out.println(ex.getMessage());
        }

        return PersonnelEnCours;
    }

    private static Code getCode(String code) {
        if (code.equals("CS")) {
            return Code.CS;
        }
        if (code.equals("C")) {
            return Code.C;
        }
        if (code.equals("TCG")) {
            return Code.TCG;
        }
        if (code.equals("COE")) {
            return Code.COE;
        }
        if (code.equals("CCP")) {
            return Code.CCP;
        }
        if (code.equals("CNPSY")) {
            return Code.CNPSY;
        }
        if (code.equals("CDE")) {
            return Code.CDE;
        }
        if (code.equals("CSC")) {
            return Code.CSC;
        }
        if (code.equals("FP")) {
            return Code.FP;
        }
        if (code.equals("KC")) {
            return Code.KC;
        }
        if (code.equals("KE")) {
            return Code.KE;
        }
        if (code.equals("K")) {
            return Code.K;
        }
        if (code.equals("KFA")) {
            return Code.KFA;
        }
        if (code.equals("KFB")) {
            return Code.KFB;
        }
        if (code.equals("ORT")) {
            return Code.ORT;
        }
        if (code.equals("PRO")) {
            return Code.PRO;
        }
        // probleme : code inconnu
        return null;
    }
}
