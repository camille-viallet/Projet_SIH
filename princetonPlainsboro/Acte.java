package princetonPlainsboro;

/**
 * Modélise un acte médical
 *
 * @author Groupe 8
 */
public class Acte {

    private Code code;
    private int coefficient;
    private String nomActe;
    private Medecin medecin;
    private Date date;
    private Type type;
    private String commentaire;

    /**
     * Construit un acte
     *
     * @param code Code de l'acte issu de la nomenclature médicale
     * @param coefficient Coefficient de l'acte ( nombre par lequel est
     * multiplié le cout unitaire)
     * @param nomActe Description de l'acte
     * @param medecin Medecin ayant réalisé l'acte
     * @param date Date de réalisation de l'acte
     * @param type Type d'acte ( diagnostique ou thérapeutique )
     * @param commentaire Commentaire sur l'acte
     */
    public Acte(Code code, int coefficient, String nomActe, Medecin medecin, Date date, Type type, String commentaire) {
        this.code = code;
        this.coefficient = coefficient;
        this.nomActe = nomActe;
        this.medecin = medecin;
        this.date = date;
        this.type = type;
        this.commentaire = commentaire;
    }

    /**
     * Renvoie une chaine de caractére définissant l'acte
     *
     * @return chaine de caractére avec tous les éléments d'un acte
     */
    @Override
    public String toString() {
        return getCode().toString(getCoefficient()) + ", "
                + "\n         nom de l'acte : " + getNomActe()
                + ", \n         nom du médecin : " + medecin.getNom() + " " + medecin.getPrenom() + " - " + medecin.getSpecialite()
                + ", \n         date : " + getDate()
                + ", \n         type d'acte : " + getType().toString()
                + ", \n         Observations : " + getCommentaire();
    }

    /**
     * Calcule le coût d'un acte
     *
     * @return le cout de l'acte
     */
    public double calculeCout() {
        return getCode().calculerCout(getCoefficient());
    }

    /**
     * Obtient le code de l'acte
     *
     * @return le code
     */
    public Code getCode() {
        return code;
    }

    /**
     * Définit le code de l'acte
     *
     * @param code code à définir
     */
    public void setCode(Code code) {
        this.code = code;
    }

    /**
     * Obtient le coefficient de l'acte
     *
     * @return the coef
     */
    public int getCoefficient() {
        return coefficient;
    }

    /**
     * Définit le coefficient de l'acte
     *
     * @param coefficient le coeffcient à définir
     */
    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    /**
     * Obtient le nom de l'acte
     *
     * @return le nom de l'acte
     */
    public String getNomActe() {
        return nomActe;
    }

    /**
     * Determine le nom de l'acte
     *
     * @param nomActe nom à determiner
     */
    public void setNomActe(String nomActe) {
        this.nomActe = nomActe;
    }

    /**
     * Obtient le medecin ayant réalisé l'acte
     *
     * @return le medecin
     */
    public Medecin getMedecin() {
        return medecin;
    }

    /**
     * Définit le medecin ayant réalisé l'acte
     *
     * @param medecin
     */
    public void setNomMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    /**
     * Obtient la date de réalisation de l'acte
     *
     * @return la date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Définit la date
     *
     * @param date date à définir
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Obtient le type de l'acte
     *
     * @return le type
     */
    public Type getType() {
        return type;
    }

    /**
     * Définit le type de l'acte
     *
     * @param type
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Obtient le commentaire du médecin sur l'acte
     *
     * @return le commentaire
     */
    public String getCommentaire() {
        return commentaire;
    }

    /**
     * Définit le commentaire
     *
     * @param comm
     */
    public void setCommentaire(String comm) {
        this.commentaire = comm;
    }

    /**
     * Obtient le coefficient sous forme de chaine de caractére
     *
     * @return le coefficient au format String
     */
    public String getCoefString() {
        return this.getCoefficient() + "";
    }
}
