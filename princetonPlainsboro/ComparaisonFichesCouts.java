package princetonPlainsboro;
/**
 * Compare deux fiches de soins en fonction de leur cout 
 * @author Camille
 */
public class ComparaisonFichesCouts implements ComparaisonFiches {
    /**
     * Compare deux fiches de soins en fonction de leurs couts
     * @param fiche1
     * @param fiche2
     * @return 
     * <0 si fiche1 < fiche2,
     * 0  si fiche1 == fiche2,
     * >0 si fiche1 > fiche2
     */
    @Override
    public int comparer(FicheDeSoins fiche1, FicheDeSoins fiche2) {
        Double c1 = fiche1.coutTotal();
        Double c2 = fiche2.coutTotal();
        return c1.compareTo(c2);
        }
    }
