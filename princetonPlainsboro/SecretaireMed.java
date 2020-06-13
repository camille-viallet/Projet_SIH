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

    public SecretaireMed(String prenom, String nom, String username, String mdp, MetierCHU metier, String telephone) {
        super(prenom, nom, username, mdp, metier, telephone);

    }
    
        // getters pour les Sécretaires Médicales
    
      public String getPrenom() {
        return super.getPrenom() ;
    }
      public String getNom() {
          return super.getNom() ; 
      }
      public String getUsername() {
          return super.getUsername() ;
      }
      public String getMdp() {
          return super.getMdp() ;
      }
      public MetierCHU getMetierCHU(){
         return MetierCHU.SECRETAIRE_MEDICALE ;
     }
      public String getTelephone() {
          return super.getTelephone() ; 
      }
}
