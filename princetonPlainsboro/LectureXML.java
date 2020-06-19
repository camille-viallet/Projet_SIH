/*
 * LectureXML.java
 *
 * Created on 5 janvier 2006, 18:26
 *
 * Lecture d'un document XML et transformation en instances Java
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
 * Lecture d'un document XML et transformation en instances Java.
 *
 * @author Groupe 8
 */
public class LectureXML {

    /// nom du document XML a analyser
    private String nomFichier;
    private final static String repBase = "src/donnees/";

    // 'nomFichier' est le nom d'un fichier XML se trouvant dans le repertoire 'repBase' a lire :
    public LectureXML(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    /**
     * Obtient le dossier medical (ensemble des fiches de soins )stocké dans le
     * fichier java
     *
     * @return le dossier medical
     */
    public DossierMedical getDossier() {
        DossierMedical dossierCourant = null;
        Date date = null;
        Medecin medecinCourant = null;
        Medecin medecinActeCourant = null;
        Patient patientCourant = null;
        List<Acte> actes = new Vector<Acte>();
        String donneesCourantes = "";
        String nomCourant = "";
        String prenomCourant = "";
        Double poids = 0.0;
        Double taille = 0.0;
        String telephone = "";
        String adresse = "";
        String RPPS = "";
        String nomActe = "";
        Specialite specialite = null;
        Code codeCourant = null;
        int coefCourant = 0;
        int numero = 0;
        String noSecu = "";
        Date dateN = null;
        Date dateActe = null;
        Type type = null;
        String comm = "";

        // analyser le fichier par StAX
        try {
            // instanciation du parser
           //InputStream in = getClass().getResourceAsStream("/donnees/" + nomFichier);
            InputStream in = new FileInputStream(repBase + nomFichier);
            //ystem.out.println(getClass().getResource("/donnees/" + nomFichier).getFile());
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader parser = factory.createXMLStreamReader(in);

            // lecture des evenements
            for (int event = parser.next(); event != XMLStreamConstants.END_DOCUMENT; event = parser.next()) {
                // traitement selon l'evenement
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (parser.getLocalName().equals("dossiers")) {
                            dossierCourant = new DossierMedical();
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:

                        if (parser.getLocalName().equals("code")) {
                            codeCourant = getCode(donneesCourantes);
                            if (codeCourant == null) {
                                throw new XMLStreamException("Impossible de trouver le code d'acte = " + donneesCourantes);
                            }
                        }
                        if (parser.getLocalName().equals("coef")) {
                            coefCourant = Integer.parseInt(donneesCourantes);
                        }
                        if (parser.getLocalName().equals("date")) {
                            int annee = Integer.parseInt(donneesCourantes.substring(0, donneesCourantes.indexOf('-')));
                            int mois = Integer.parseInt(donneesCourantes.substring(donneesCourantes.indexOf('-') + 1, donneesCourantes.lastIndexOf('-')));
                            int jour = Integer.parseInt(donneesCourantes.substring(donneesCourantes.lastIndexOf('-') + 1, donneesCourantes.length()));

                            //A CHANGER
                            date = new Date(jour, mois, annee, 0, 0);
                        }
                        if (parser.getLocalName().equals("dateN")) {
                            int annee = Integer.parseInt(donneesCourantes.substring(0, donneesCourantes.indexOf('-')));
                            int mois = Integer.parseInt(donneesCourantes.substring(donneesCourantes.indexOf('-') + 1, donneesCourantes.lastIndexOf('-')));
                            int jour = Integer.parseInt(donneesCourantes.substring(donneesCourantes.lastIndexOf('-') + 1, donneesCourantes.length()));

                           
                            dateN = new Date(jour, mois, annee, 0, 0);
                        }
                        if (parser.getLocalName().equals("dateActe")) {
                            int annee = Integer.parseInt(donneesCourantes.substring(0, donneesCourantes.indexOf('-')));
                            int mois = Integer.parseInt(donneesCourantes.substring(donneesCourantes.indexOf('-') + 1, donneesCourantes.lastIndexOf('-')));
                            int jour = Integer.parseInt(donneesCourantes.substring(donneesCourantes.lastIndexOf('-') + 1, donneesCourantes.lastIndexOf('_')));
                            int heure = Integer.parseInt(donneesCourantes.substring(donneesCourantes.lastIndexOf('_') + 1, donneesCourantes.lastIndexOf('h')));
                            int minutes = Integer.parseInt(donneesCourantes.substring(donneesCourantes.lastIndexOf('h') + 1, donneesCourantes.length()));
                            
                            dateActe = new Date(jour, mois, annee, heure, minutes);
                        }

                        if (parser.getLocalName().equals("medecin")) {

                            if (Medecin.trouveMedecin(RPPS) != null) {
                                medecinCourant = Medecin.trouveMedecin(RPPS);
                            } else {
                                medecinCourant = new Medecin(prenomCourant, nomCourant, RPPS, "hopital", telephone, specialite);
                            }
                        }
                        if (parser.getLocalName().equals("medecinActe")) {

                            if (Medecin.trouveMedecin(RPPS) != null) {
                                medecinActeCourant = Medecin.trouveMedecin(RPPS);
                            } else {
                                medecinActeCourant = new Medecin(prenomCourant, nomCourant, RPPS, "hopital", telephone, specialite);
                            }
                        }
                        if (parser.getLocalName().equals("ficheDeSoins")) {
                            FicheDeSoins f = new FicheDeSoins(patientCourant, medecinCourant, date, numero);
                            // ajout des actes
                            for (int i = 0; i < actes.size(); i++) {
                                Acte a = (Acte) actes.get(i);
                                f.ajouterActe(a);
                            }
                            // effacer tous les actes de la liste
                            actes.clear();
                            // ajouter la fiche de soin au dossiers
                            dossierCourant.ajouterFiche(f);
                        }
                        if (parser.getLocalName().equals("acte")) {
                            actes.add(new Acte(codeCourant, coefCourant, nomActe, medecinActeCourant, dateActe, type, comm));
                        }
                        if (parser.getLocalName().equals("nomActe")) {
                            nomActe = donneesCourantes;
                        }
                        if (parser.getLocalName().equals("type")) {
                            type = Type.valueOf(donneesCourantes);
                        }
                        if (parser.getLocalName().equals("comm")) {
                            comm = donneesCourantes;
                        }
                        if (parser.getLocalName().equals("numero")) {
                            numero = Integer.parseInt(donneesCourantes);
                        }
                        if (parser.getLocalName().equals("nom")) {
                            nomCourant = donneesCourantes;
                        }
                        if (parser.getLocalName().equals("specialite")) {
                            specialite = Specialite.valueOf(donneesCourantes);
                            if (specialite == null) {
                                throw new XMLStreamException("Impossible de trouver la spécialité = " + donneesCourantes);
                            }
                        }
                        if (parser.getLocalName().equals("patient")) {
                            patientCourant = new Patient(prenomCourant, nomCourant, adresse, dateN, noSecu, poids, taille);
                        }
                        if (parser.getLocalName().equals("prenom")) {
                            prenomCourant = donneesCourantes;
                        }
                        if (parser.getLocalName().equals("telephone")) {
                            telephone = donneesCourantes;
                        }
                        if (parser.getLocalName().equals("rpps")) {
                            RPPS = donneesCourantes;
                        }
                        if (parser.getLocalName().equals("poids")) {
                            poids = Double.parseDouble(donneesCourantes);
                        }
                        if (parser.getLocalName().equals("taille")) {
                            taille = Double.parseDouble(donneesCourantes);
                        }
                        if (parser.getLocalName().equals("adresse")) {
                            adresse = donneesCourantes;
                        }
                        if (parser.getLocalName().equals("secu")) {
                            noSecu = donneesCourantes;
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
        }catch (IOException ex) {
         System.out.println("Exception de type 'IOException' lors de la lecture du fichier : " + nomFichier);
         System.out.println("Verifier le chemin.");
         System.out.println(ex.getMessage());
         }

        return dossierCourant;
    }

    /**
     * Obtient une instance de code correspondant à la chaine de caractére
     * associée
     *
     * @param code code dans le fichier java
     * @return instance de Code
     */
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
