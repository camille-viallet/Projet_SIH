/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import java.io.InputStream;

/**
 *
 * @author Camille
 */
public class ModificationXMLPersonnel {

    String file;
    DocumentBuilderFactory dbf;
    DocumentBuilder db;
    Document doc;

    public ModificationXMLPersonnel() {
        //OutputStream outputStream = getClass().getResourceAsStream("/donnees/personnels.xml");
        try {
            file = "src/donnees/personnels.xml";
            InputStream s = getClass().getResourceAsStream("/donnees/personnels.xml");
            
            db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = db.parse(new InputSource(s));
            // file =this.getClass().getResource("/donnees/personnels.xml").toString();
            //dbf = DocumentBuilderFactory.newInstance();
            //db = dbf.newDocumentBuilder();
            //doc = db.parse(file);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("classe modif personnel");
        }

    }

    public boolean ajouterPersonnel(Personnel p) {
        boolean correct  =true;
        try {

            // Récupérer l'élément racine
            Node personnel = doc.getFirstChild();

            Element metier = null;
            Element id = null;

            if (p.getMetier() == MetierCHU.MEDECIN) {
                metier = doc.createElement("medecin");
                id = doc.createElement("rpps");
                Element specialite = doc.createElement("specialite");
                Medecin m = (Medecin) p;
                specialite.appendChild(doc.createTextNode(m.getSpecialite().toString()));
                metier.appendChild(specialite);
            } else if (p.getMetier() == MetierCHU.SECRETAIRE_ADMINISTRATIVE) {
                metier = doc.createElement("secretaireAdm");
                id = doc.createElement("matricule");
            } else if (p.getMetier() == MetierCHU.SECRETAIRE_MEDICALE) {
                metier = doc.createElement("secretaireMed");
                id = doc.createElement("matricule");
            }

            Element nom = doc.createElement("nom");
            Element prenom = doc.createElement("prenom");
            Element telephone = doc.createElement("telephone");
            Element motPasse = doc.createElement("mdp");

            prenom.appendChild(doc.createTextNode(p.getPrenom()));
            nom.appendChild(doc.createTextNode(p.getNom()));
            telephone.appendChild(doc.createTextNode(p.getTelephone()));
            id.appendChild(doc.createTextNode(p.getUsername()));
            motPasse.appendChild(doc.createTextNode(p.getMotDePasse()));

            metier.appendChild(nom);
            metier.appendChild(prenom);
            metier.appendChild(telephone);
            metier.appendChild(id);
            metier.appendChild(motPasse);
            personnel.appendChild(metier);

            // écrire le contenu dans un fichier xml
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource src = new DOMSource(doc);
            
            //POUR ARRIVER A OUVRIR DANS LE JAR
            //StreamResult res = new StreamResult(getClass().getResource("/donnees/personnels.xml").getFile());
            
            StreamResult res = new StreamResult(new File("src/donnees/personnels.xml"));
            
            
            transformer.transform(src, res);
            
           
        } catch (Exception e) {
            e.printStackTrace();
            correct = false; 
        }
        return correct;

    }

}
