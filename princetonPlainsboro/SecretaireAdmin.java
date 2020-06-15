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
public class SecretaireAdmin extends Personnel {

    public SecretaireAdmin(String prenom, String nom, String username, String mdp,  String telephone) {
        super(prenom, nom, username, mdp, telephone);

    }
    
    @Override
    public MetierCHU getMetier() {
        return MetierCHU.SECRETAIRE_ADMINISTRATIVE;
    }
}