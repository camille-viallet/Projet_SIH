/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

/**
 * Type énuméré indiquant le type d'un acte ( diagnostique ou thérapeutique )
 *
 * @author Groupe 8
 */
public enum Type {

    // valeurs de l'�num :
    DIAG("Diagnostique"),
    THERA("Thérapeutique");

    private String libelle;

    /**
     * Construit un nouveau type
     *
     * @param libelle
     */
    private Type(String libelle) {
        this.libelle = libelle;

    }

    /**
     * Obtient la chaine de caractére correspondant au type
     *
     * @return la chaine de caractére
     */
    public String toString() {
        return super.toString() + " : " + libelle;
    }

}
