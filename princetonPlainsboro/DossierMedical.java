package princetonPlainsboro;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Modélise un dossier medical contenant des fiches de soins
 *
 * @author Groupe 8
 */
public class DossierMedical {

    private List<FicheDeSoins> fiches;     // contient des objets de classe 'FicheDeSoins'

    /**
     * Créer un dossier médical en initialisant une lise de fiche de soins vide
     */
    public DossierMedical() {
        fiches = new Vector<>();  // liste vide
    }

    /**
     * Ajoute une fiche dans le dossier medical
     *
     * @param fiche fiche à ajouter
     */
    public void ajouterFiche(FicheDeSoins fiche) {
        fiches.add(fiche);

    }

    /**
     * Renvoi le numéro de la derniére fiche de soins
     *
     * @return le dernier numéro
     */
    public int dernierNumeroFiche() {
        return this.fiches.size();
    }

    /**
     * Obtient la liste des fiches de soins. Attention tout ajout dans cette
     * liste n'aura aucune répercussion sur les fiche de soins du dossier
     * medical. Utilisez la méthode ajouterFiche pour ajouter une fiche.
     *
     * @return la liste des fiches de soins contenues dans le dossier medical
     */
    public List<FicheDeSoins> getFicheDeSoins() {
        List<FicheDeSoins> liste = this.fiches;
        return liste;
    }

    /**
     * Renvoie une chaine de caractére des fiches de soins d'un patient.
     *
     * @param p patient dont on souhaite obtenir les fiches de soins
     * @return chaine de caractére
     */
    public String getFichesPatient(Patient p) {
        String chaine = "";
        for (int i = 0; i < fiches.size(); i++) {
            if (fiches.get(i).getPatient().equals(p)) {
                chaine = chaine + fiches.get(i).toString() + "\n";
                chaine = chaine + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - \n";
            }
        }
        return chaine;
    }

    /**
     * Renvoie la liste des fiches de soins d'un patient. Attention tout ajout
     * dans cette liste n'aura aucune répercussion sur les fiche de soins du
     * dossier medical. Utilisez la méthode ajouterFiche pour ajouter une fiche.
     *
     * @param p patient dont on souhaite les fiches de soins
     * @return une liste de fiches de soins
     */
    public Vector<FicheDeSoins> getFichesDeSoinsPatient(Patient p) {
        Vector<FicheDeSoins> liste = new Vector<>();
        for (FicheDeSoins fiche : fiches) {
            if (fiche.getPatient().equals(p)) {
                liste.add(fiche);
            }
        }
        return liste;
    }

    /**
     * Affiche le dossier medical dans la console
     */
    public void afficher() {
        System.out.println("Dossier medical informatisé :");
        System.out.println("-----------------------------");
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            f.afficher();
            // pour separer les fiches de soins :
            System.out.println("--------------------------------------");
        }
    }

    /**
     * Calcule le coût d'un patient à l'hopital
     *
     * @param patient patient dont on souhaite connaitre le cout
     * @param liste liste des fiches que l'on souhaite prendre en compte ( par
     * exemple seulement celles comprises dans une période donnée)
     * @return le cout du patient
     */
    public double coutPatient(Patient patient, List<FicheDeSoins> liste) {
        double cout = 0;
        for (FicheDeSoins f : liste) {
            if (patient.equals(f.getPatient())) {
                cout += f.coutTotal();
            }
        }
        return cout;
    }

    /**
     * Calcule le coût d'un patient à l'hopital
     *
     * @param m medecin dont on souhaite connaitre le cout généré
     * @param liste liste des fiches que l'on souhaite prendre en compte ( par
     * exemple seulement celles comprises dans une période donnée)
     * @return le cout généré par le medecin
     */
    public double coutMedecin(Medecin m, List<FicheDeSoins> liste) {
        double cout = 0;
        for (FicheDeSoins f : liste) {
            if (m.equals(f.getMedecin())) {
                cout += f.coutTotal();
            }
        }
        return cout;
    }

    /**
     * Calcule les générés par un certain type de code
     *
     * @param code code de l'acte
     * @param liste liste des fiches que l'on souhaite prendre en compte ( par
     * exemple seulement celles comprises dans une période donnée)
     * @return les couts généré par un code
     */
    public double coutCode(Code code, List<FicheDeSoins> liste) {
        double cout = 0;
        for (FicheDeSoins f : liste) {
            for (Acte a : f.getActes()) {
                if (code.equals(a.getCode())) {
                    cout += a.getCode().calculerCout(a.getCoefficient());
                }
            }
        }
        return cout;

    }

    /**
     * Calcule les couts générés dans une spécialité donnée
     *
     * @param specialite spécialité dont on souhaite connaitre les couts générés
     * @param liste liste des fiches que l'on souhaite prendre en compte ( par
     * exemple seulement celles comprises dans une période donnée)
     * @return le cout de la spécialité
     */
    public double coutSpecialite(String specialite, List<FicheDeSoins> liste) {
        double cout = 0;
        for (FicheDeSoins f : liste) {
            if (specialite.equals(f.getMedecin().getSpecialite().toString())) {
                cout += f.coutTotal();
            }
        }
        return cout;
    }

    /**
     * Affiche dans la console la liste des patients d'un medecin donné
     *
     * @param medecin medecin dont on souhaite connaitre la liste des patients
     */
    public void afficherListePatients(Medecin medecin) {
        System.out.println("> liste des patients du " + medecin.toString() + " :");
        Vector<Patient> liste = new Vector<>();
        // 'liste' contient tous les patients deja affiches
        // --> ceci permet de ne pas reafficher un patient deja affiche
        for (FicheDeSoins f : fiches) {
            if (medecin.equals(f.getMedecin())) {
                Patient p = f.getPatient();
                if (!liste.contains(p)) {
                    System.out.println(" - " + p.toString());
                    liste.add(p);
                }
            }
        }
    }

    /**
     * Récupére la liste des patients d'un medecin donné
     *
     * @param medecin dont on souhaite la liste des patients
     * @return la liste des patients
     */
    public Vector<Patient> getListePatients(Medecin medecin) {
        Vector<Patient> liste = new Vector<>();
        for (FicheDeSoins f : fiches) {
            if (medecin.equals(f.getMedecin())) {
                Patient p = f.getPatient();
                if (!liste.contains(p)) {
                    liste.add(p);
                }
            }
        }
        return liste;
    }

    /**
     * Obtient la liste de tous les patients présents dans le dossier medical
     *
     * @return la liste de tous les patients
     */
    public Vector<Patient> getListeTousPatients() {
        Vector<Patient> liste = new Vector<>();
        for (FicheDeSoins f : fiches) {
            Patient p = f.getPatient();
            if (!liste.contains(p)) {
                liste.add(p);
            }
        }
        return liste;
    }

    /**
     * Obtient la liste de tous les medecins présents dans le dossier medical
     * (peut ne pas contenir tous les medecins de l'hopital, voir classe
     * Personnel)
     *
     * @return la liste des medecins
     */
    public Vector<Medecin> getListeMedecins() {

        Vector<Medecin> liste = new Vector<>();
        for (FicheDeSoins f : fiches) {
            Medecin m = f.getMedecin();
            if (!liste.contains(m)) {
                liste.add(m);

            }
        }
        return liste;
    }

    /**
     * Obtient le nombre de fiches de soins dans un intervalle donné
     *
     * @param dateDebut
     * @param dateFin
     * @return le nombre de fiches de soins dans cet intervalle
     */
    public int nombreFichesIntervalle(Date dateDebut, Date dateFin) {
        int n = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            Date d = f.getDate();
            if (d.compareTo(dateDebut) >= 0 && d.compareTo(dateFin) <= 0) {
                n++;
            }
        }
        return n;
    }

    /**
     * Obtient une liste de fiches dans une période donnée
     *
     * @param dateDebut date de début de la période souhaitée
     * @param dateFin date de fin de la période souhaitée
     * @return une liste de fiches de soins
     */
    public List<FicheDeSoins> fichesTriees2Dates(Date dateDebut, Date dateFin) {
        Vector<FicheDeSoins> fichesSoinTriees2Dates = new Vector<>();

        for (FicheDeSoins fiche : fiches) {
            if (fiche.getDate().compareTo(dateDebut) > 0 && fiche.getDate().compareTo(dateFin) < 0) {
                fichesSoinTriees2Dates.add(fiche);
            }
        }
        return fichesSoinTriees2Dates;
    }

    /**
     * Trie les listes du dossier médical de la plus récente à la plus ancienne
     *
     */
    public void trieListeDate() {
        this.fiches = DossierMedical.trierDecroissant(new ComparaisonFichesDates(), fiches);
    }

    /**
     * Trie la liste passée en paramétres
     *
     * @param c element de comparaison ( cout, date, numero) pour trier les
     * fiches
     * @param feuilleSoins fiches à trier
     * @return la liste triées de fiche
     */
    public static List<FicheDeSoins> trierDecroissant(ComparaisonFiches c, List<FicheDeSoins> feuilleSoins) {
        List<FicheDeSoins> copieFiches = new ArrayList<>(feuilleSoins);
        List<FicheDeSoins> fichesSoins = new ArrayList<>();

        while (!copieFiches.isEmpty()) {
            // on cherche la fiche de soins minimale :
            int imin = 0;
            FicheDeSoins f1 = copieFiches.get(imin);
            for (int i = 1; i < copieFiches.size(); i++) {
                FicheDeSoins f2 = copieFiches.get(i);
                if (c.comparer(f2, f1) > 0) {
                    imin = i;
                    f1 = f2;

                }
            }
            fichesSoins.add(f1);
            //on la supprime de la liste :
            copieFiches.remove(imin);
        }
        return fichesSoins;
    }
}
