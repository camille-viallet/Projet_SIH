package princetonPlainsboro;

public class Medecin {

    private String nom;
    private String prenom;
    private String specialite;
    private String telephone;
    private String mdp;

    public Medecin(String nom, String prenom, String specialite, String telephone, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.telephone = telephone;
        this.mdp = mdp;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMdp() {
        return mdp;
    }

    public String toString() {
        return "Dr " + getPrenom() + " " + getNom() + ", " + getSpecialite() + " - Téléphone : " + getTelephone();
    }

    public boolean equals(Object o) {
        if (o instanceof Medecin) {
            Medecin p = (Medecin) o;
            return getNom().equals(p.getNom()) && getPrenom().equals(p.getPrenom());
        } else {
            return false;
        }
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
