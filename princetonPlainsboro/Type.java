/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

/**
 * Type énuméré indiquant le type d'un acte ( diagnostique ou thérapeutique )
 * @author Eduarda DA SILVA
 */

public enum Type {
    // valeurs de l'�num :
    DIAG("Diagnostique"),
    THERA("Thérapeutique");
                             
    // attributs de l'enum :
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
