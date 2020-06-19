/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Modélise l'ensemble des personnels de l'hopital
 *
 * @author Groupe 8
 */
public class PersonnelHopital {

    private ArrayList<Personnel> listePersonnel;

    /**
     * Construit une liste vide de personnels
     */
    public PersonnelHopital() {
        listePersonnel = new ArrayList<Personnel>();
    }

    /**
     * Ajoute un personnel dans la liste du personnel
     *
     * @param personnel personnel a ajouter dans la liste
     */
    public void addPersonnel(Personnel personnel) {
        listePersonnel.add(personnel);
    }

    /**
     * Eneleve un personnel dans la liste
     * @param personnel 
     */
    public void removePersonnel(Personnel personnel) {
        listePersonnel.remove(personnel);
    }

    /**
     * Affiche le nombre de personnels de la liste dans la console
     * @param p 
     */
    public void sizePersonnel() {
        System.out.println("Il y a " + listePersonnel.size() + "personnes travaillant au CHU de Princeton Plainsboro.");
    }

    // à tester pour voir si ça marche
    public void afficherPersonnel() {
        System.out.println("List du personnel du CHU de Princeton Plainsboro :");
        for (int i = 0; i < listePersonnel.size(); i++) {
            Personnel p = listePersonnel.get(i);
            p.toString();
            // pour separer chaque personne :
            System.out.println("--------------------------------------");
        }
    }

    public List<Personnel> getListePersonnel() {
        return Collections.unmodifiableList(listePersonnel);
    }

    public ArrayList<Medecin> getListeMedecins() {
        ArrayList<Medecin> liste = new ArrayList<>();
        for (Personnel personnel : listePersonnel) {
            if (personnel.getMetier() == MetierCHU.MEDECIN) {
                if (!liste.contains((Medecin) personnel)) {
                    liste.add((Medecin) personnel);
                }
            }
        }
        return liste;
    }
}
