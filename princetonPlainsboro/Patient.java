package princetonPlainsboro;

/**
 * Modélise un patient
 *
 * @author Camille
 */
public class Patient {

    private String nom;
    private String prenom;
    private String adresse;
    private Date dateDeNaissance;
    private String numeroSecuriteSociale;
    private double poids;
    private double taille;

    /**
     * Construit un patient
     *
     * @param prenom
     * @param nom
     * @param adresse
     * @param dateNaissance
     * @param numeroSecuriteSociale
     * @param poids
     * @param taille
     */
    public Patient(String prenom, String nom, String adresse, Date dateNaissance, String numeroSecuriteSociale, double poids, double taille) {
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
        this.dateDeNaissance = dateNaissance;
        this.numeroSecuriteSociale = numeroSecuriteSociale;
        this.poids = poids;
        this.taille = taille;
    }

    /**
     * Renvoie une chaine de caractére avec le nom et le prenom du patient
     *
     * @return la chaine de caractére
     */
    @Override
    public String toString() {
        return prenom + " " + nom.toUpperCase();
    }

    /**
     * Affiche toute les informations du patient
     */
    public void infosPatient() {
        String infos = "Informations sur " + this.prenom + " " + this.nom.toUpperCase() + ", né(e) le " + this.dateDeNaissance.toString() + ", demeurant à " + this.adresse + "\n Son poids actuel est : " + this.getPoids() + "kg \n Sa taille est de : " + this.getTaille() + "m" + "\n Numéro de sécurité sociale : ";
        if (Patient.verifierSecu(numeroSecuriteSociale) == true) {
            infos += numeroSecuriteSociale;
        } else {
            infos += " numéro renseigné invalide !";
        }
        System.out.println(infos);
    }

    /**
     * Determine si deux instances de patient sont égales
     *
     * @param o le patient a comparer à l'instance
     * @return true si les deux instances sont égales , false sinon
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Patient) {
            Patient p = (Patient) o;
            return nom.equals(p.nom) && prenom.equals(p.prenom);
        } else {
            return false;
        }
    }

    /**
     * Verifie si le numéro de sécurité sociale est conforme
     *
     * @param nSecu le numero de sécurité sociale a tester
     * @return true si le numéro est conforme false sinon
     */
    public static boolean verifierSecu(String nSecu) {
        boolean valide = true;
        int i = 0;
        try {
            long cle = 97 - ((Long.parseLong(nSecu.substring(0, 13)) % 97));

            while (valide == true && i <= 12) {

                if (nSecu.length() != 15) {
                    valide = false;

                } else {
                    if (Integer.parseInt(nSecu.substring(0, 1)) == 1 || Integer.parseInt(nSecu.substring(0, 1)) == 2) {
                        i++;
                    } else {
                        valide = false;
                    }
                    if (Integer.parseInt(nSecu.substring(1, 3)) >= 0 && Integer.parseInt(nSecu.substring(1, 3)) < 100) {
                        i++;
                        i++;
                    } else {
                        valide = false;
                    }
                    if (Integer.parseInt(nSecu.substring(3, 5)) > 0 && Integer.parseInt(nSecu.substring(3, 5)) < 13) {
                        i++;
                        i++;
                    } else {
                        valide = false;

                    }
                    if (Integer.parseInt(nSecu.substring(5, 7)) > 0 && Integer.parseInt(nSecu.substring(5, 7)) < 99) {
                        i++;
                        i++;
                    } else {
                        valide = false;
                    }

                    if (Integer.parseInt(nSecu.substring(7, 10)) > 0 && Integer.parseInt(nSecu.substring(7, 10)) < 1000) {
                        i++;
                        i++;
                        i++;

                    } else {
                        valide = false;

                    }
                    if (Integer.parseInt(nSecu.substring(10, 13)) > 0 && Integer.parseInt(nSecu.substring(10, 13)) < 1000) {
                        i++;
                        i++;
                        i++;

                    } else {
                        valide = false;

                    }
                    if (Integer.parseInt(nSecu.substring(13, 15)) == cle) {
                        i++;

                    } else {
                        valide = false;
                    }
                }

            }
        } catch (Exception e) {
            return false;

        }
        return valide;
    }

    /**
     * Obtient le nom du patient
     *
     * @return le nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Obtient le prenom du patient
     *
     * @return le prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Obtient l'adresse du patient
     *
     * @return l'adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Obtient la date de naissance du patient
     *
     * @return la date de naissance
     */
    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    /**
     * Obtient le numéro de sécurité sociale.
     *
     * @return le numéro de sécurité sociale , si le numéro n'est pas valide
     * renvoie " numéro renseigné invalide !"
     */
    public String getNumeroSecuriteSociale() {
        if (Patient.verifierSecu(numeroSecuriteSociale) == true) {
            return numeroSecuriteSociale;
        } else {
            return " numéro renseigné invalide !";
        }
    }

    /**
     * Obtient le poids du patient (en kilos)
     *
     * @return le poids
     */
    public double getPoids() {
        return poids;
    }

    /**
     * Dtermine le poids du patient (en kilos)
     *
     * @param poids
     */
    public void setPoids(double poids) {
        this.poids = poids;
    }

    /**
     * Obtient la taille du patient (en m)
     *
     * @return la taille
     */
    public double getTaille() {
        return taille;
    }

    /**
     * Determine la taille du patient (en m)
     *
     * @param taille
     */
    public void setTaille(double taille) {
        this.taille = taille;
    }

    /**
     * Obtient la taille en format String
     * @return chaine de caractére correspondante
     */
    public String getTailleString() {
        return this.taille + "";
    }
/**
     * Obtient le poids en format String
     * @return chaine de caractére correspondante
     */
    public String getPoidsString() {
        return this.poids + "";
    }
}
