package princetonPlainsboro;

public class Patient {

    private String nom;
    private String prenom;
    private String adresse;
    private Date dateN;
    private String secu;
    private double poids;
    private double taille;

    public Patient(String prenom, String nom, String adresse, Date dateN, String secu, double poids, double taille) {
        this.prenom = prenom ;
        this.nom = nom ;
        this.adresse = adresse ;
        this.dateN = dateN ;
        this.secu = secu ;
        this.poids = poids ;
        this.taille = taille ;
    }

    public String toString() {
        return prenom + " " + nom.toUpperCase();
    }

    // Afficher toutes les informations du patient 
    public void infosPatient() {
        String infos = "Informations sur " + this.prenom + " " + this.nom.toUpperCase() + ", né(e) le " + this.dateN.toString() + ", demeurant à " + this.adresse + "\n Son poids actuel est : " + this.getPoids() + "kg \n Sa taille est de : " + this.getTaille() + "m" + "\n Numéro de sécurité sociale : ";
        if (Patient.verifierSecu(secu) == true) {
            infos += secu;
        } else {
            infos += " numéro renseigné invalide !";
        }
        System.out.println(infos);
    }

    public boolean equals(Object o) {
        if (o instanceof Patient) {
            Patient p = (Patient) o;
            return nom.equals(p.nom) && prenom.equals(p.prenom);
        } else {
            return false;
        }
    }

    // Vérifier que le numéro de sécurité sociale est correct
    public static boolean verifierSecu(String nSecu) {
        boolean valide = true;
        int i = 0;
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
        return valide;
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
        if (Patient.verifierSecu(secu) == true) {
             return secu;
        } else {
            return " numéro renseigné invalide !";
        }
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
    
    public String getTailleString(){
        return this.taille+"";
    }
    public String getPoidsString(){
        return this.poids+"";
    }
}
