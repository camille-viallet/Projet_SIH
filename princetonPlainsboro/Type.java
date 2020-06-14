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

public enum Type {
    // valeurs de l'�num :
    DIAG("Diagnostique"),
    THERA("Thérapeutique");
                             
    // attributs de l'�num :
    private String libelle;
    
    // constructeur :
    private Type (String libelle) {
        this.libelle = libelle;
  
        }
    
    // m�thodes :
    public String toString() {
        return super.toString() + " : " + libelle ;
        }
    
    }
