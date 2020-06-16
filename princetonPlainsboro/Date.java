package princetonPlainsboro;


public class Date implements Comparable {

    private int jour;
    private int mois;
    private int annee;
    private int heure;
    private int minute;
    
    public Date(int jour, int mois, int annee, int heure, int minute) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
        this.heure = heure;
        this.minute = minute;
    }

    public String toString() {
        if (verifierDate() == true) {
            return jour + "/" + mois + "/" + annee + " à " + heure + " h " + minute + " min";
        } else {
            return "La date rentrée n'est pas valide. Veuillez réessayer.";
        }
    }
   
    public String toStringDate() {
        if (verifierDate()) {
            return jour + "/" + mois + "/" + annee ;
        } else {
            return "La date rentrée n'est pas valide. Veuillez réessayer.";
        }
    }

    public void verifBissextile() {
        if (annee  % 4 == 0 && annee % 100 != 0) {
            System.out.println(annee + " est une année bissextile.");
        }
        else if ( annee %  400 == 0) {
            System.out.println(annee + " est une année bissextile.");
        }
        else {
            System.out.println(annee + " n est pas une année bissextile.");
        }
    }
    
    public boolean equals(Object o) {
        if (o instanceof Date) {
            Date d = (Date) o;
            return (annee == d.annee) && (mois == d.mois) && (jour == d.jour) && (heure == d.heure) && (minute == d.minute);
        } else {
            return false;
        }
    }

    public boolean verifierDate() {
        boolean estValide = true;
        if (jour >= 1 && jour <= 31
                && mois >= 1 && mois <= 12
                && annee >= 1900 && annee <= 2020
                && heure >= 0 && heure <= 23
                && minute >= 0 && minute <= 59) {
            estValide = true;
        } else {
            estValide = false;
        }
        return estValide;
    }

    // precondition : 'o' est une instance de 'Date' :
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
