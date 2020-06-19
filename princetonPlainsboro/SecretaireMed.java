/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

/**
 * Modélise une secrétaire Médicale
 *
 * @author Groupe 8
 */
public class SecretaireMed extends Personnel {

    /**
     * Construit une secretaire medicale
     *
     * @param prenom
     * @param nom
     * @param username
     * @param motDePasse
     * @param telephone
     */
    public SecretaireMed(String prenom, String nom, String username, String motDePasse, String telephone) {
        super(prenom, nom, username, motDePasse, telephone);

    }

    /**
     * Obtient le métier
     *
     * @return le métier
     */
    @Override
    public MetierCHU getMetier() {
        return MetierCHU.SECRETAIRE_MEDICALE;
    }
}
