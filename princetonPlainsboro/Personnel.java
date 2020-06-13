/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

/**
 *
 * @author dasilvae
 */
public class Personnel {
    
    private String prenom ;
    private String nom ;
    private String username ;
    private String mdp;
    private MetierCHU metier;
    private String telephone ;


    
    public Personnel(String prenom, String nom, String username, String mdp, MetierCHU metier, String telephone){
        this.prenom = prenom ;
        this.nom = nom ;
        this.username = username ;
        this.mdp = mdp ;
        this.metier = metier ; 
        this.telephone = telephone ; 
      }

    public String toString() {
        return "NOM : " + this.prenom + this.nom.toUpperCase() + " \n METIER : " + this.metier + " \n NUMERO DE TELEPHONE : " + this.telephone ;
    }
 
    // getter et setter pour le prénom du personnel
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // getter et setter pour le nom du personnel
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    // getter et setter pour le login du personnel
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    // getter et setter pour le mot-de-passe du personnel
    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    // getter et setter pour le métierr
    public MetierCHU getMetier() {
        return metier;
    }
    public void setMetier(MetierCHU metier) {
        this.metier = metier;
    }

    // getter et setter pour le numéro de téléphone du personnel
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
