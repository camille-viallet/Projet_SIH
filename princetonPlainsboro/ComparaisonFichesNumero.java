/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

/**
 * Compare deux fiches de soins en fonction de leur numéro
 *
 * @author Camille
 */
public class ComparaisonFichesNumero implements ComparaisonFiches {

    /**
     * Compare deux fiches de soins en fonction de leurs dates
     *
     * @param fiche1
     * @param fiche2
     * @return >0 si fiche1 < fiche2 0 , si fiche1 == fiche2 <0 , si fiche1 >
     * fiche2
     */
    @Override
    public int comparer(FicheDeSoins fiche1, FicheDeSoins fiche2) {
        Integer c1 = new Integer(fiche1.getNumero());
        Integer c2 = new Integer(fiche2.getNumero());
        return -c1.compareTo(c2);
    }
}
