package princetonPlainsboro;

public class Patient {

    private String nom;
    private String prenom;
    private String adresse;
    private Date dateN;
    private String secu;
    private double poids;
    private double taille;

    public Patient(String nom, String prenom, String adresse, Date dateN, String secu, double poids, double taille) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String toString() {
        return prenom + " " + nom.toUpperCase();
    }

    public boolean equals(Object o) {
        if (o instanceof Patient) {
            Patient p = (Patient) o;
            return nom.equals(p.nom) && prenom.equals(p.prenom);
        } else {
            return false;
        }
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateN() {
        return dateN;
    }

    public void setDateN(Date dateN) {
        this.dateN = dateN;
    }

    public String getSecu() {
        return secu;
    }

    public void setSecu(String secu) {
        this.secu = secu;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }
}
