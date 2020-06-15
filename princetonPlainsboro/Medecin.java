package princetonPlainsboro;

import java.util.ArrayList;
import java.util.List;

public class Medecin extends Personnel {

    private Specialite specialite;
//    private List <Acte> listActes; 

    public Medecin(String prenom, String nom, String username, String mdp, String telephone, Specialite specialite) {
        super(prenom, nom, username, mdp, telephone);
        this.specialite = specialite;
//        listActes = new ArrayList <Acte>() ; 
    }

    public String toString() {
        return "Docteur " + super.getNom().toUpperCase() + " " + super.getPrenom() + " - " + getSpecialite() ;
    }
     public String toStringAvecTelephone() {
        return "Docteur " + super.getPrenom() + " " + super.getNom() + " - " + getSpecialite() + "\n  Numéro de téléphone : " + getTelephone();
    }

    public boolean equals(Object o) {
        if (o instanceof Medecin) {
            Medecin p = (Medecin) o;
            return getNom().equals(p.getNom()) && getPrenom().equals(p.getPrenom());
        } else {
            return false;
        }
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    @Override
    public MetierCHU getMetier() {
        return MetierCHU.MEDECIN;

    }
}