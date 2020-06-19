package princetonPlainsboro;

/**
 * Compare deux fiches de soins en fonction de leur date
 *
 * @author Groupe 8
 */
public class ComparaisonFichesDates implements ComparaisonFiches {

    /**
     * Compare deux fiches de soins en fonction de leurs dates
     *
     * @param fiche1
     * @param fiche2
     * @return <0 si fiche1 < fiche2,
     * 0  si fiche1 == fiche2,
     * >0 si fiche1 > fiche2
     */
    @Override
    public int comparer(FicheDeSoins fiche1, FicheDeSoins fiche2) {
        return fiche1.getDate().compareTo(fiche2.getDate());
    }
}
