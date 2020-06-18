package princetonPlainsboro;

import java.util.Vector;

/**
 * Modélise une fiche de soins
 *
 * @author Camille
 */
public class FicheDeSoins {

    private Patient patient;
    private Medecin medecin;
    private Date date;
    private Vector<Acte> actes;       // contient des objets de classe 'Acte'
    int numero;

    /**
     * Construit une fiche de soins
     *
     * @param patient patient concerné par la fiche de soins
     * @param medecin medecin référent de la fiche
     * @param date date d'emission de la fiche
     * @param numero numero permettant d'identifier la fiche
     */
    public FicheDeSoins(Patient patient, Medecin medecin, Date date, int numero) {
        this.patient = patient;
        this.medecin = medecin;
        this.date = date;
        actes = new Vector<Acte>();   // liste vide
        this.numero = numero;
    }

    /**
     * Obtient le patient concerné par la fiche
     *
     * @return le patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Obtient le medecin
     *
     * @return le medecin
     */
    public Medecin getMedecin() {
        return medecin;
    }

    /**
     * Obtient la date d'émission de la feuille
     *
     * @return la date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Ajoute un acte à la feuille de soins
     *
     * @param acte acte a ajouter
     */
    public void ajouterActe(Acte acte) {
        actes.add(acte);
    }

    /**
     * Affiche l'acte dans la console
     */
    public void afficher() {
        System.out.println(this);
    }

    /**
     * Obtient le numéro de la fiche
     *
     * @return le numéro
     */
    public int getNumero() {
        return this.numero;
    }

    /**
     * Obtient le numéro de la fiche sous forme de chaine de caractére
     *
     * @return le numéro
     */
    public String getNumeroString() {
        return this.numero + "";
    }

    /**
     * Obtient la liste des actes de la fiche. Attention ajouter un acte à la
     * liste retournée ne sera pas pris en compte. Utilisez la méthode
     * addActe().
     *
     * @return la liste des actes de la fiche
     */
    public Vector<Acte> getActes() {
        Vector<Acte> liste = new Vector<>();
        for (Acte a : this.actes) {
            if (!liste.contains(a)) {
                liste.add(a);
            }
        }
        return liste;
    }

    /**
     * Convertis en chaine de caractére la liste
     *
     * @return la chaine de caractére
     *
     */
    public String toString() {
        String chaine = "Fiche de soins n° " + numero + " du " + date.toString() + "\n";

        chaine = chaine + "- medecin : " + medecin.toString() + "\n";
        chaine = chaine + "- actes medicaux :\n";
        for (Acte a : actes) {
            chaine = chaine + "    > " + a.toString() + "\n";
        }
        return chaine;
    }

    /**
     * Calcule le cout total de la fiche de soins
     *
     * @return le cout de la fiche
     */
    public double coutTotal() {
        double total = 0;
        for (Acte a : actes) {
            total += a.calculeCout();
        }
        return total;
    }
}
