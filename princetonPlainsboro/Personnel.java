/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

/**
 * Modélise les caractéristiques principales du personnel de l'hopital
 *
 * @author Groupe 8
 */
public abstract class Personnel {

    private String prenom;
    private String nom;
    private String username;
    private String motDePasse;
    private String telephone;

    /**
     * Construit un personnel
     *
     * @param prenom
     * @param nom
     * @param username
     * @param motDePasse
     * @param telephone
     */
    public Personnel(String prenom, String nom, String username, String motDePasse, String telephone) {
        this.prenom = prenom;
        this.nom = nom;
        this.username = username;
        this.motDePasse = motDePasse;
        this.telephone = telephone;
    }

    /**
     * Determine une chaine de caractére représentant le personnel
     *
     * @return la chaine de caractére
     */
    @Override
    public String toString() {
        return "NOM : " + this.prenom + this.nom.toUpperCase() + " \n METIER : " + this.getMetier() + " \n NUMERO DE TELEPHONE : " + this.telephone;
    }

    /**
     * Obtient le prenom
     *
     * @return le prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     *
     * Obtient le nom
     *
     * @return le nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Obtient l'identifiant (unique)
     *
     * @return l'indentifiant
     */
    public String getUsername() {
        return username;
    }

    /**
     * Obtient le mot de passe pour se connecter à l'application
     *
     * @return le mot de passe
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * Obtient le metier correspondant au personnel. Les classes héritant de
     * personnel devront implementer cette méthode
     *
     * @return le metier correspondant
     */
    public abstract MetierCHU getMetier();

    /**
     * Obtient le numéro de téléphone
     *
     * @return le numéro de telephone
     */
    public String getTelephone() {
        return telephone;
    }

}
