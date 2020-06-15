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
public class SecretaireMed extends Personnel {

    public SecretaireMed(String prenom, String nom, String username, String mdp, String telephone) {
        super(prenom, nom, username, mdp, telephone);

    }

    @Override
    public MetierCHU getMetier() {
        return  MetierCHU.SECRETAIRE_MEDICALE;
    }
}
