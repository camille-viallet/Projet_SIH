package princetonPlainsboro;

class Acte {

    private Code code;
    private int coef;
    private String nomActe;
    private String nomMed;
    private Date date;
    private Type type;
    private String comm;

    public Acte(Code code, int coef, String nomActe, Medecin med, Date date, Type type, String comm) {
        this.code = code;
        this.coef = coef;
        this.nomActe = nomActe;
        this.nomMed = med.getNom();
        this.date = date;
        this.type = type;
        this.comm = comm;
    }
   
      
    public String toString() {
        return getCode().toString() + ", coefficient : " + getCoef() + ", \n nom de l'acte : " + getNomActe() + ", \n nom du médecin : " + getNomMed() + ", \n date : " + getDate() + ", \n type d'acte : " + getType().toString() + ", \n Observations : " + getComm();
    }

    public double cout() {
        return getCode().calculerCout(getCoef());
    }

    /**
     * @return the code
     */
    public Code getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(Code code) {
        this.code = code;
    }

    /**
     * @return the coef
     */
    public int getCoef() {
        return coef;
    }

    /**
     * @param coef the coef to set
     */
    public void setCoef(int coef) {
        this.coef = coef;
    }

    /**
     * @return the nomActe
     */
    public String getNomActe() {
        return nomActe;
    }

    /**
     * @param nomActe the nomActe to set
     */
    public void setNomActe(String nomActe) {
        this.nomActe = nomActe;
    }

    /**
     * @return the nomMed
     */
    public String getNomMed() {
        return nomMed;
    }

    /**
     * @param nomMed the nomMed to set
     */
    public void setNomMed(String nomMed) {
        this.nomMed = nomMed;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * @return the comm
     */
    public String getComm() {
        return comm;
    }

    /**
     * @param comm the comm to set
     */
    public void setComm(String comm) {
        this.comm = comm;
    }
}
