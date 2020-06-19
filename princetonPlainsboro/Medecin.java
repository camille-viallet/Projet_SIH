package princetonPlainsboro;

/**
 * Modélise un medecin de l'hopital ( qui est un membre du personnel particulier )
 *
 * @author Groupe 8
 */
public class Medecin extends Personnel {

    private Specialite specialite;

    /**
     * Construit un medecin
     *
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

    }

    /**
     * Créer une chaine de caractére avec les informations du medecin
     *
     * @return la chaine de caractére
     */
    @Override
    public String toString() {
        return "Dr. " + super.getNom().toUpperCase() + " " + super.getPrenom() + " - " + getSpecialite();
    }

    /**
     * Créer une chaine de caractére avec les informations du medecin + son
     * numéro de telephone
     *
     * @return la chaine de caractére
     */
    public String toStringAvecTelephone() {
        return "Dr. " + super.getPrenom() + " " + super.getNom() + " - " + getSpecialite() + "\n  Numéro de téléphone : " + getTelephone();
    }

    /**
     * Determine si deux instances de Medecin sont égales
     *
     * @param o le medecin à comparer avec l'instance
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Medecin) {
            Medecin p = (Medecin) o;
            return this.getUsername().equals(p.getUsername());
        } else {
            return false;
        }
    }

    /**
     * Obtient la spécialité du medecin
     *
     * @return la spécialité du medecin
     */
    public Specialite getSpecialite() {
        return specialite;
    }

    /**
     * Obtient le metier du medecin
     *
     * @return le metier
     */
    @Override
    public MetierCHU getMetier() {
        return MetierCHU.MEDECIN;

    }

    /**
     * Trouve l'instance du medecin en ayant son numéro RPPS
     *
     * @param RPPS le numéro rpps du medecin
     * @return le medecin correspondant
     */
    public static Medecin trouveMedecin(String RPPS) {
        LectureXMLPersonnel personnel = new LectureXMLPersonnel("personnels.xml");
        PersonnelHopital persHopital = personnel.getPersonnel();
        int i2 = 0;
        Medecin m = null;
        //Trouve le medecin sur lequel on a cliqué
        while (i2 < persHopital.getListeMedecins().size() && !RPPS.equals(persHopital.getListeMedecins().get(i2).getUsername())) {
            i2++;
        }
        if (i2 < persHopital.getListeMedecins().size()) {
            m = persHopital.getListeMedecins().get(i2);
        }

        return m;

    }
}
