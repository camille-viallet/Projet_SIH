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

/**
 *
 * @author Camille
 */
public class ModificationXMLDossiers {

    String file;
    DocumentBuilderFactory dbf;
    DocumentBuilder db;
    Document doc;

    public ModificationXMLDossiers() {
        try {
            file = "src/donnees/dossiers.xml";
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
            doc = db.parse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ajouterActeDansFicheDeSoins(FicheDeSoins f, Acte a) {
        try {

            // Récupérer l'élément racine
            Node dossiers = doc.getFirstChild();
            // Récupérer l'élément employee
            Node fiche = doc.getElementsByTagName("ficheDeSoins").item(this.getnumeroFiche(f) - 1);
            // Ajouter un nouveau nœud
            fiche.appendChild(this.createBaliseActe(a));
            // écrire le contenu dans un fichier xml
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource src = new DOMSource(doc);
            StreamResult res = new StreamResult(new File(file));
            transformer.transform(src, res);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void nouvelleFicheDeSoins(FicheDeSoins f) {
        try {

            // Récupérer l'élément racine
            Node dossiers = doc.getFirstChild();
            // Récupérer l'élément employee

            // Ajouter un nouveau nœud
            dossiers.appendChild(this.createBaliseFiche(f));

            // écrire le contenu dans un fichier xml
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource src = new DOMSource(doc);
            StreamResult res = new StreamResult(new File(file));
            transformer.transform(src, res);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Element createBaliseMedecin(Medecin m, boolean acte) {
        Element medecin = null;
        if (acte) {
            medecin = doc.createElement("medecinActe");
        } else {
            medecin = doc.createElement("medecin");
        }
        Element nom = doc.createElement("nom");
        Element prenom = doc.createElement("prenom");
        Element spe = doc.createElement("specialite");
        Element telephone = doc.createElement("telephone");
        Element rpps = doc.createElement("rpps");
        nom.appendChild(doc.createTextNode(m.getNom()));
        prenom.appendChild(doc.createTextNode(m.getPrenom()));
        spe.appendChild(doc.createTextNode(m.getSpecialite().toString()));
        telephone.appendChild(doc.createTextNode(m.getTelephone()));
        rpps.appendChild(doc.createTextNode(m.getUsername()));
        medecin.appendChild(nom);
        medecin.appendChild(prenom);
        medecin.appendChild(spe);
        medecin.appendChild(telephone);
        medecin.appendChild(rpps);
        System.out.println("medecin");
        return medecin;
    }

    private Element createBalisePatient(Patient p) {
        Element patient = doc.createElement("patient");
        Element nom = doc.createElement("nom");
        Element prenom = doc.createElement("prenom");
        Element adresse = doc.createElement("adresse");
        Element dateN = doc.createElement("dateN");
        Element secu = doc.createElement("secu");
        Element poids = doc.createElement("poids");
        Element taille = doc.createElement("taille");

        nom.appendChild(doc.createTextNode(p.getNom()));
        prenom.appendChild(doc.createTextNode(p.getPrenom()));
        adresse.appendChild(doc.createTextNode(p.getAdresse()));
        dateN.appendChild(doc.createTextNode(p.getDateN().toStringXML()));
        secu.appendChild(doc.createTextNode(p.getSecu()));
        poids.appendChild(doc.createTextNode(p.getPoidsString()));
        taille.appendChild(doc.createTextNode(p.getTailleString()));
        patient.appendChild(nom);
        patient.appendChild(prenom);
        patient.appendChild(adresse);
        patient.appendChild(dateN);
        patient.appendChild(secu);
        patient.appendChild(poids);
        patient.appendChild(taille);
        System.out.println("patient");
        return patient;
    }

    private Element createBaliseActe(Acte a) {
        Element acte = doc.createElement("acte");
        Element code = doc.createElement("code");
        Element coef = doc.createElement("coef");
        Element nom = doc.createElement("nomActe");
        Element type = doc.createElement("type");
        Element date = doc.createElement("dateActe");
        Element comm = doc.createElement("acte");
        code.appendChild(doc.createTextNode(a.getCode().name()));
        nom.appendChild(doc.createTextNode(a.getNomActe()));
        coef.appendChild(doc.createTextNode(a.getCoefString()));
        type.appendChild(doc.createTextNode(a.getType().name()));
        date.appendChild(doc.createTextNode(a.getDate().toStringXML()));
        comm.appendChild(doc.createTextNode(a.getComm()));
        acte.appendChild(code);
        acte.appendChild(coef);
        acte.appendChild(type);
        acte.appendChild(date);
        acte.appendChild(comm);
        acte.appendChild(this.createBaliseMedecin(a.getMed(), true));
        System.out.println("acte");

        return acte;

    }

    private Element createBaliseFiche(FicheDeSoins f) {
        Element fiche = doc.createElement("ficheDeSoins");
        Element date = doc.createElement("date");
        Element numero = doc.createElement("numero");

        date.appendChild(doc.createTextNode(f.getDate().toStringXML()));
        numero.appendChild(doc.createTextNode(f.getNumeroString()));

        fiche.appendChild(date);
        fiche.appendChild(numero);
        fiche.appendChild(this.createBaliseMedecin(f.getMedecin(), false));
        fiche.appendChild(this.createBalisePatient(f.getPatient()));

        return fiche;

    }

    private int getnumeroFiche(FicheDeSoins f) {
        int num = 0;
        final Element racine = doc.getDocumentElement();
        final NodeList racineNoeuds = racine.getChildNodes();
        final int nbRacineNoeuds = racineNoeuds.getLength();
        boolean ok = false;

        for (int i = 0; i < nbRacineNoeuds; i++) {
            System.out.println("for");
            if (racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
                final Element fiche = (Element) racineNoeuds.item(i);
                final Element numero = (Element) fiche.getElementsByTagName("numero").item(0);
                String numeroFiche = numero.getTextContent();
                if (numeroFiche.equals(f.getNumeroString())) {
                    num = i;
                    ok = true;
                }
            }
        }
        System.out.println(num);
        return num;
    }
}
