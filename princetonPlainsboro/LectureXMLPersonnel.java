/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * Lit un fichier XML contenant le personnel de l'hopital
 *
 * @author Groupe 8
 */
public class LectureXMLPersonnel {
    /// nom du document XML a analyser

    private String nomFichier;
    private final static String repBase = "src/donnees/";

    // 'nomFichier' est le nom d'un fichier XML se trouvant dans le repertoire 'repBase' a lire :
    public LectureXMLPersonnel(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    /**
     * Obtient le personnel de l'hopital à partir du fichier XML
     *
     * @return le personnel de l'hopital
     */
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

        try {
            // instanciation du parser
            //getClass().getResource("/Interface/hop.jpg"))
            InputStream in = new FileInputStream(repBase + nomFichier);
            //InputStream in = getClass().getResourceAsStream("/donnees/" + nomFichier);
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
            System.out.println("Details (class LectureXMLPersonnel ):");
            System.out.println(ex);
        } catch (IOException ex) {
         System.out.println("Exception de type 'IOException' lors de la lecture du fichier : " + nomFichier);
         System.out.println("Verifier le chemin.");
         System.out.println(ex.getMessage());
         }

        return PersonnelEnCours;
    }
}
