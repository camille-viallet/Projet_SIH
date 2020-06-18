package princetonPlainsboro;

/**
 * Cette interface permet de representer une comparaison entre deux FicheDeSoins
 */
public interface ComparaisonFiches {

    /**
     * Compare deux fiche de soins
     *
     * @param fiche1
     * @param fiche2
     * @return <0 si fiche1 < fiche2,
     * 0  si fiche1 == fiche2,
     * >0 si fiche1 > fiche2
     */
    public int comparer(FicheDeSoins fiche1, FicheDeSoins fiche2);
}
