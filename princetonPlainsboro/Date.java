package princetonPlainsboro;

/**
 * Modélise un date. Elle est définie par une année, un mois, un jour, une
 * heure, et des minutes
 *
 * @author Camille
 */
public class Date implements Comparable {

    private final int jour;
    private final int mois;
    private final int annee;
    private final int heure;
    private final int minute;

    /**
     * Construit une date
     *
     * @param jour jour de la date
     * @param mois mois de la date. Exemple 2 pour février
     * @param annee année de la date
     * @param heure heure de la date
     * @param minute minute de la date
     */
    public Date(int jour, int mois, int annee, int heure, int minute) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
        this.heure = heure;
        this.minute = minute;
    }

    /**
     * Obtient l'heure
     *
     * @return l'heure
     */
    public String getHeure() {
        return heure + "";
    }

    /**
     * Obtient les minutes
     *
     * @return les minutes
     */
    public String getMinutes() {
        return minute + "";
    }

    /**
     * Determine une chaine de caractére correspondant à la date. De la forme "
     * 18/6/2020 à 17h14". Renvoie " La date rentrée n'est pas valide. Veuillez
     * réessayer" si la date n'est pas valide
     *
     * @return la chaine de caractére
     */
    public String toString() {
        if (verifierDate() == true) {
            return jour + "/" + mois + "/" + annee + " à " + heure + " h " + minute + " min";
        } else {
            return "La date rentrée n'est pas valide. Veuillez réessayer.";
        }
    }

    /**
     * Determine une chaine de caractére de la date. Sous la forme
     * "2020-6-18_17h14"
     *
     * @return la chaine de caractére
     */
    public String toStringXML() {

        return annee + "-" + mois + "-" + jour + "_" + heure + "h" + minute;

    }

    /**
     * Determine une chaine de caractére sans les heures et minutes. De la forme
     * " 18/6/2020 ". Renvoie "La date rentrée n'est pas valide. Veuillez
     * réessayer." si la date n'est pas valide
     *
     * @return la chaine de caractére
     */
    public String toStringDate() {
        if (verifierDate()) {
            return jour + "/" + mois + "/" + annee;
        } else {
            return "La date rentrée n'est pas valide. Veuillez réessayer.";
        }
    }

    /**
     * Determine si deux dates sont égales
     *
     * @param o la date a comparer avec l'instance ( de format Date)
     * @return true si les deux dates sont égales, false sinon
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Date) {
            Date d = (Date) o;
            return (annee == d.annee) && (mois == d.mois) && (jour == d.jour) && (heure == d.heure) && (minute == d.minute);
        } else {
            return false;
        }
    }

    /**
     * Verifie si la date est valide de maniére succinte. Verifie seulement que
     * les jours sont inférieurs à 31 , que les mois sont inférieurs à 12 et que
     * les années sont supérieures à 1900.
     *
     * @return true si la date est valide , false sinon
     */
    public boolean verifierDate() {
        boolean estValide = true;
        estValide = jour >= 1 && jour <= 31
                && mois >= 1 && mois <= 12
                && annee >= 1900
                && heure >= 0 && heure <= 23
                && minute >= 0 && minute <= 59;
        return estValide;
    }

    
    /**
     * Compare deux instances de date
     * @param o la date a comparer avec l'instance
     * @return <0 si instance < o,
     * 0  si instance == o,
     * >0 si instance > 0
     */
    @Override
    public int compareTo(Object o) {
        Date d = (Date) o;
        if (annee != d.annee) {
            return annee - d.annee;
        }
        // ici on a forcement annee == d.annee :
        if (mois != d.mois) {
            return mois - d.mois;
        }
        // ici on a forcement annee == d.annee et mois == d.mois :
        if (jour != d.jour) {
            return jour - d.jour;
        }
        if (heure != d.heure) {
            return heure - d.heure;
        }
        return minute - d.minute;
    }

}
