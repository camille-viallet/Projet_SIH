package princetonPlainsboro;

/**
 * Modélise un medecin de l'hopital
 * @author Camille
 */
public class Medecin extends Personnel {

    private Specialite specialite;
/**
 * Construit un medecin
 * @param prenom
 * @param nom
 * @param username numero RPPS du medecin
 * @param motDePasse mot de passe pour accéder au logiciel
 * @param telephone
 * @param specialite spécialité médicale à laquelle il appartient
 */
    public Medecin(String prenom, String nom, String username, String motDePasse, String telephone, Specialite specialite) {
        super(prenom, nom, username, motDePasse, telephone);
        this.specialite = specialite;
//        listActes = new ArrayList <Acte>() ; 
    }

    @Override
    public String toString() {
        return "Dr. " + super.getNom().toUpperCase() + " " + super.getPrenom() + " - " + getSpecialite();
    }

    public String toStringAvecTelephone() {
        return "Dr. " + super.getPrenom() + " " + super.getNom() + " - " + getSpecialite() + "\n  Numéro de téléphone : " + getTelephone();
    }

    public boolean equals(Object o) {
        if (o instanceof Medecin) {
            Medecin p = (Medecin) o;
            return this.getUsername().equals(p.getUsername());
        } else {
            return false;
        }
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    @Override
    public MetierCHU getMetier() {
        return MetierCHU.MEDECIN;

    }

    public static Medecin trouveMedecin(String RPPS) {
        LectureXMLPersonnel personnel = new LectureXMLPersonnel("personnels.xml");
        PersonnelHopital persHopital = personnel.getPersonnel();
        int i2 = 0;
        Medecin m = null;
        //Trouve le medecin sur lequel on a cliqué
        while (i2 < persHopital.getListeMedecins().size() && !RPPS.equals(persHopital.getListeMedecins().get(i2).getUsername())) {
            i2++;
        }
        if (i2 < persHopital.getListeMedecins().size()){
            m = persHopital.getListeMedecins().get(i2);
        }
        
        return m;

    }
}
