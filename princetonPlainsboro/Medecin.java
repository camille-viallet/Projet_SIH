package princetonPlainsboro;

import java.util.ArrayList;
import java.util.List;

public class Medecin extends Personnel {

    private Specialite specialite;
//    private List <Acte> listActes; 

    public Medecin(String prenom, String nom, String username, String mdp,  String telephone, Specialite specialite) {
        super(prenom, nom, username, mdp, MetierCHU.MEDECIN, telephone);
        this.specialite = specialite ;
//        listActes = new ArrayList <Acte>() ; 
    }

    public String toString() {
        return "Docteur " + super.getPrenom() + " " + super.getNom() + " - " + getSpecialite() + "\nNuméro de téléphone : " + getTelephone();
    }

    public boolean equals(Object o) {
        if (o instanceof Medecin) {
            Medecin p = (Medecin) o;
            return getNom().equals(p.getNom()) && getPrenom().equals(p.getPrenom());
        } else {
            return false;
        }
    }
    
//    // Pour additioner un acte à une liste d'actes créée par un médecin.
//    public void ajouterUnActe(Acte acte){
//        listActes.add(acte);
//    }
//    
//    // Pour supprimer un acte à une liste d'actes créée par un médecin.
//    public void supprimerUnActe(Acte acte){
//        listActes.remove(acte);
//    }
//    
//    // Taille de la liste d'actes d'un médecin.
//    public void tailleListActes (Acte acte) {
//        System.out.println("Il y a " + listActes.size() + "actes.");
//    }
    
    // getters pour les Médecins
    public String getPrenom() {
        return super.getPrenom();
    }

    public String getNom() {
        return super.getNom();
    }

    public String getUsername() {
        return super.getUsername();
    }

    public String getMdp() {
        return super.getMdp();
    }

    public MetierCHU getMetierCHU() {
        return MetierCHU.MEDECIN ;
    }

    public String getTelephone() {
        return super.getTelephone();
    }
     public Specialite getSpecialite() {
        return specialite;
    }
     
}
