/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 * Permet d'ajouter des FichesDeSoins et des Actes dans le fichier XML des
 * dossiers medicaux
 *
 * @author Camille
 */
public class ModificationXMLDossierMedical {

    String file;
    DocumentBuilderFactory dbf;
    DocumentBuilder db;
    Document doc;

    /**
     * Construit une nouvelle modification
     *
     */
    public ModificationXMLDossierMedical() {
        try {
            file = "src/donnees/dossiers.xml";
            //file =this.getClass().getResource("/donnees/dossiers.xml").toString();

            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
            doc = db.parse(file);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ajoute un baliseActe dans la ficheDeSoins de soins passée en paramétre
     *
     * @param ficheDeSoins baliseFiche de soins à modifier
     * @param acte baliseActe a ajouter
     */
    public void ajouterActeDansFicheDeSoins(FicheDeSoins ficheDeSoins, Acte acte) {
        System.out.println("new acte");
        try {

            // Récupérer l'élément racine
            Node dossiers = doc.getFirstChild();
            Node baliseFiche = doc.getElementsByTagName("ficheDeSoins").item(ficheDeSoins.getNumero() - 1);
            baliseFiche.appendChild(this.createBaliseActe(acte));
            // écrire le contenu dans un fichier xml
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource src = new DOMSource(doc);
            StreamResult res = new StreamResult(new File(file));

            transformer.transform(src, res);
        } catch (DOMException | TransformerException e) {
            e.printStackTrace();
        }

    }

    /**
     * Créer une nouvelle baliseFiche de soins dans le fichier XML
     *
     * @param ficheACreer baliseFiche a ajouter dans le fichier XML
     */
    public void nouvelleFicheDeSoins(FicheDeSoins ficheACreer) {
        try {

            // Récupérer l'élément racine
            Node dossiers = doc.getFirstChild();
            dossiers.appendChild(this.createBaliseFiche(ficheACreer));

            // écrire le contenu dans un fichier xml
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource src = new DOMSource(doc);
            StreamResult res = new StreamResult(new File(file));
            transformer.transform(src, res);
        } catch (DOMException | TransformerException e) {
            e.printStackTrace();
        }

    }

    /**
     * Créer une balise contenant les informations d'un medecin
     *
     * @param medecin medecin a ajouter dans la baliseFiche
     * @param acte indique si le medecin doit etre placé dans un baliseActe (
     * true ) ou dans la baliseFiche ( false)
     * @return la balise avec les informations du medecin
     */
    private Element createBaliseMedecin(Medecin medecin, boolean acte) {
        Element baliseMedecin = null;
        if (acte) {
            baliseMedecin = doc.createElement("medecinActe");
        } else {
            baliseMedecin = doc.createElement("medecin");
        }
        Element nom = doc.createElement("nom");
        Element prenom = doc.createElement("prenom");
        Element spe = doc.createElement("specialite");
        Element telephone = doc.createElement("telephone");
        Element rpps = doc.createElement("rpps");

        nom.appendChild(doc.createTextNode(medecin.getNom()));
        prenom.appendChild(doc.createTextNode(medecin.getPrenom()));
        spe.appendChild(doc.createTextNode(medecin.getSpecialite().toString()));
        telephone.appendChild(doc.createTextNode(medecin.getTelephone()));
        rpps.appendChild(doc.createTextNode(medecin.getUsername()));

        baliseMedecin.appendChild(nom);
        baliseMedecin.appendChild(prenom);
        baliseMedecin.appendChild(spe);
        baliseMedecin.appendChild(telephone);
        baliseMedecin.appendChild(rpps);
        System.out.println("medecin");
        return baliseMedecin;
    }

    /**
     * Créer une balise avec les informations du patient
     *
     * @param patient la patient à inserer
     * @return la balise du patient
     */
    private Element createBalisePatient(Patient patient) {
        Element balisePatient = doc.createElement("patient");
        Element nom = doc.createElement("nom");
        Element prenom = doc.createElement("prenom");
        Element adresse = doc.createElement("adresse");
        Element dateN = doc.createElement("dateN");
        Element secu = doc.createElement("secu");
        Element poids = doc.createElement("poids");
        Element taille = doc.createElement("taille");

        nom.appendChild(doc.createTextNode(patient.getNom()));
        prenom.appendChild(doc.createTextNode(patient.getPrenom()));
        adresse.appendChild(doc.createTextNode(patient.getAdresse()));
        dateN.appendChild(doc.createTextNode(patient.getDateDeNaissance().toStringXMLSansHeuresMinutes()));
        secu.appendChild(doc.createTextNode(patient.getNumeroSecuriteSociale()));
        poids.appendChild(doc.createTextNode(patient.getPoidsString()));
        taille.appendChild(doc.createTextNode(patient.getTailleString()));
        balisePatient.appendChild(nom);
        balisePatient.appendChild(prenom);
        balisePatient.appendChild(adresse);
        balisePatient.appendChild(dateN);
        balisePatient.appendChild(secu);
        balisePatient.appendChild(poids);
        balisePatient.appendChild(taille);
        return balisePatient;
    }

    /**
     * Créer une balise avec les informations d'un acte
     *
     * @param patient la patient à inserer
     * @return la balise de l'acte
     */
    private Element createBaliseActe(Acte acte) {
        Element baliseActe = doc.createElement("acte");
        Element code = doc.createElement("code");
        Element coef = doc.createElement("coef");
        Element nom = doc.createElement("nomActe");
        Element type = doc.createElement("type");
        Element date = doc.createElement("dateActe");
        Element comm = doc.createElement("comm");

        code.appendChild(doc.createTextNode(acte.getCode().name()));
        nom.appendChild(doc.createTextNode(acte.getNomActe()));
        coef.appendChild(doc.createTextNode(acte.getCoefString()));
        type.appendChild(doc.createTextNode(acte.getType().name()));
        date.appendChild(doc.createTextNode(acte.getDate().toStringXML()));
        comm.appendChild(doc.createTextNode(acte.getCommentaire()));

        baliseActe.appendChild(code);
        baliseActe.appendChild(nom);
        baliseActe.appendChild(coef);
        baliseActe.appendChild(type);
        baliseActe.appendChild(date);
        baliseActe.appendChild(comm);
        baliseActe.appendChild(this.createBaliseMedecin(acte.getMedecin(), true));

        return baliseActe;

    }

    /**
     * Créer une balise avec les informations d'une fiche
     *
     * @param fiche la fcihe à inserer
     * @return la balise de la fiche
     */
    private Element createBaliseFiche(FicheDeSoins fiche) {
        Element baliseFiche = doc.createElement("ficheDeSoins");
        Element date = doc.createElement("date");
        Element numero = doc.createElement("numero");

        date.appendChild(doc.createTextNode(fiche.getDate().toStringXMLSansHeuresMinutes()));
        numero.appendChild(doc.createTextNode(fiche.getNumeroString()));
        baliseFiche.appendChild(date);
        baliseFiche.appendChild(numero);
        baliseFiche.appendChild(this.createBaliseMedecin(fiche.getMedecin(), false));
        baliseFiche.appendChild(this.createBalisePatient(fiche.getPatient()));

        return baliseFiche;

    }

}
