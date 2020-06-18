package princetonPlainsboro;

import java.util.Vector;

public class FicheDeSoins {

    private Patient patient;
    private Medecin medecin;
    private Date date;
    private Vector<Acte> actes;       // contient des objets de classe 'Acte'
    int numero;

    public FicheDeSoins(Patient patient, Medecin medecin, Date date, int numero) {
        this.patient = patient;
        this.medecin = medecin;
        this.date = date;
        actes = new Vector<Acte>();   // liste vide
        this.numero = numero;
    }

    public Patient getPatient() {
        return patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public Date getDate() {
        return date;
    }

    public void ajouterActe(Acte acte) {
        actes.add(acte);
    }

    public void ajouterActe(Code code, int coefficient, String nomActe, Medecin med, Date date, Type type, String comm) {
        Acte acte = new Acte(code, coefficient, nomActe, med, date, type, comm);
        actes.add(acte);
    }

    public void afficher() {
        System.out.println(this);
    }
    public int getNumero(){
        return this.numero;
    }
    public String getNumeroString(){
        return this.numero+"";
    }

    /*public Vector<Acte> getActes(Medecin m) {
     Vector<Acte> liste = new Vector<Acte>();
     for (int i = 0; i < this.actes.size(); i++) {
     Acte a = actes.get(i);
     if (m.equals(a.getMedecin())) {
     if (!liste.contains(a)) {
     liste.add(a);
     }
     }
     }
     return liste;
     }*/
    public Vector<Acte> getActes() {
        Vector<Acte> liste = new Vector<Acte>();
        for (int i = 0; i < this.actes.size(); i++) {
            Acte a = actes.get(i);
            if (!liste.contains(a)) {
                liste.add(a);
            }
        }
        return liste;
    }

    public String toString() {
        String chaine = "Fiche de soins n° "+numero+" du " + date.toString() + "\n";

        chaine = chaine + "- medecin : " + medecin.toString() + "\n";
        chaine = chaine + "- actes medicaux :\n";
        for (int i = 0; i < actes.size(); i++) {
            Acte a = actes.get(i);
            chaine = chaine + "    > " + a.toString() + "\n";
        }
        return chaine;
    }

    public double coutTotal() {
        double total = 0;
        for (int i = 0; i < actes.size(); i++) {
            Acte a = actes.get(i);
            total += a.calculeCout();
        }
        return total;
    }
}
