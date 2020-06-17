package princetonPlainsboro;

import java.util.List;
import java.util.Vector;

public class DossierMedical {

    private List<FicheDeSoins> fiches;     // contient des objets de classe 'FicheDeSoins'

    public DossierMedical() {
        fiches = new Vector<FicheDeSoins>();  // liste vide
    }

    public void ajouterFiche(FicheDeSoins fiche) {
        fiches.add(fiche);

    }
    public int dernierNumeroFiche(){
        return this.fiches.size();
    }
    
    public List<FicheDeSoins> getFicheDeSoins(){
        List<FicheDeSoins> liste =  this.fiches;
        return liste;
    }
    /**
     * Renvoie un string des fiches de soins d'un patient
     *
     * @param p patient
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
     * Renvoie la liste des fiches de soins d'un patient
     *
     * @param p patient
     * @return
     */
    public Vector<FicheDeSoins> getFichesDeSoinsPatient(Patient p) {
        Vector<FicheDeSoins> liste = new Vector<FicheDeSoins>();
        for (int i = 0; i < fiches.size(); i++) {
            if (fiches.get(i).getPatient().equals(p)) {
                liste.add(fiches.get(i));
            }
        }
        return liste;
    }

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

    public double coutPatient(Patient p) {
        double cout = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (p.equals(f.getPatient())) {
                cout += f.coutTotal();
            }
        }
        return cout;
    }

    public double coutMedecin(Medecin m) {
        double cout = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (m.equals(f.getMedecin())) {
                cout += f.coutTotal();
            }
        }
        return cout;
    }

    public double coutActe(Code c) {
        double cout = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            for (Acte a : fiches.get(i).getActes()) {
                if (c.equals(a.getCode())) {
                    cout += a.getCode().calculerCout(a.getCoef());
                }
            }
        }
        return cout;

    }

    public double coutSpecialite(String specialite) {
        double cout = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (specialite.equals(f.getMedecin().getSpecialite().toString())) {

                cout += f.coutTotal();
            }
        }
        return cout;
    }

    public void afficherListePatients(Medecin m) {
        System.out.println("> liste des patients du " + m.toString() + " :");
        Vector<Patient> liste = new Vector<Patient>();
        // 'liste' contient tous les patients deja affiches
        // --> ceci permet de ne pas reafficher un patient deja affiche
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (m.equals(f.getMedecin())) {
                Patient p = f.getPatient();
                if (!liste.contains(p)) {
                    System.out.println(" - " + p.toString());
                    liste.add(p);
                }
            }
        }
    }

    public Vector<Patient> getListePatients(Medecin m) {
        Vector<Patient> liste = new Vector<Patient>();
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (m.equals(f.getMedecin())) {
                Patient p = f.getPatient();
                if (!liste.contains(p)) {
                    liste.add(p);
                }
            }
        }
        return liste;
    }

    public Vector<Patient> getListeTousPatients() {
        Vector<Patient> liste = new Vector<Patient>();
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            Patient p = f.getPatient();
            if (!liste.contains(p)) {
                liste.add(p);
            }
        }
        return liste;
    }

    public Vector<Medecin> getListeMedecins() {

        Vector<Medecin> liste = new Vector<Medecin>();
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);

            Medecin m = f.getMedecin();
            if (!liste.contains(m)) {
                liste.add(m);

            }

        }
        return liste;
    }

    public int nombreFichesIntervalle(Date d1, Date d2) {
        int n = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            Date d = f.getDate();
            if (d.compareTo(d1) >= 0 && d.compareTo(d2) <= 0) {
                n++;
            }
        }
        return n;
    }


    public Vector<FicheDeSoins> fichesTriees2Dates(Date d1, Date d2) {
        Vector<FicheDeSoins> fiche =  new Vector<FicheDeSoins>();
        Vector<FicheDeSoins> fichesSoinTriees2Dates = new Vector<FicheDeSoins>(fiches);
        fiches.clear();
        while (!fichesSoinTriees2Dates.isEmpty()) {
            int min = 0;
            FicheDeSoins f1 = fichesSoinTriees2Dates.get(min);
            for (int i = 0; i < fichesSoinTriees2Dates.size(); i++) {
                FicheDeSoins copie = fichesSoinTriees2Dates.get(i);
                Date d = copie.getDate();
                if (d.compareTo(d1) >= 0 && d.compareTo(d2) <= 0) {
                    min = i;
                    f1 = copie;
                    //System.out.println(fichesSoinTriees2Dates);
                }
            }
            fiche.add(f1);
            fichesSoinTriees2Dates.remove(min);
        }
        return fiche;
    }

    /**
     * Trie les dates des fiches du plus récent au plus ancien
     *
     */
//    public void trierDates() {
//        Vector<FicheDeSoins> copieFiches = new Vector<FicheDeSoins>(fiches);
//        fiches.clear();
//
//        while (!copieFiches.isEmpty()) {
//            // on cherche la fiche de soins de date maximale :
//            int imax = 0;
//            FicheDeSoins f1 = copieFiches.get(imax);
//            for (int i = 1; i < copieFiches.size(); i++) {
//                FicheDeSoins f2 = copieFiches.get(i);
//                if (f2.getDate().compareTo(f1.getDate()) > 0) {
//                    imax = i;
//                    f1 = f2;
//                }
//            }
//
//            fiches.add(f1);
//            //on la supprime de la liste :
//            copieFiches.remove(imax);
//
//        }
   /* }*/

    // tri generique :
    public void trierDecroissant(ComparaisonFiches c) {
        Vector<FicheDeSoins> copieFiches = new Vector<FicheDeSoins>(fiches);
        fiches.clear();

        while (!copieFiches.isEmpty()) {
            // on cherche la fiche de soins minimale :
            int imin = 0;
            FicheDeSoins f1 = copieFiches.get(imin);
            for (int i = 1; i < copieFiches.size(); i++) {
                FicheDeSoins f2 = copieFiches.get(i);
                if (c.comparer(f2, f1) > 0) {
                    imin = i;
                    f1 = f2;
                    //                    System.out.println(copieFiches);
                }
            }
            fiches.add(f1);
            //on la supprime de la liste :
            copieFiches.remove(imin);
            //       } System.out.println(copieFiches);
        }
    }
}
