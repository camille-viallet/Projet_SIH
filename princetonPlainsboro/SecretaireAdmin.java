/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

/**
 * Modélise une secrétaire administrative ( qui est un membre du personnel particulier )
 * @author dasilvae
 */
public class SecretaireAdmin extends Personnel {

    /**
     * Construit une Secretaire Administrative
     * @param prenom
     * @param nom
     * @param matricule
     * @param motDePasse
     * @param telephone 
     */
    public SecretaireAdmin(String prenom, String nom, String matricule, String motDePasse,  String telephone) {
        super(prenom, nom, matricule, motDePasse, telephone);

    }
    
    /**
     * Obtient le métier
     * @return le métier
     */
    @Override
    public MetierCHU getMetier() {
        return MetierCHU.SECRETAIRE_ADMINISTRATIVE;
    }
}