package princetonPlainsboro;

// Cette enumeration fait intervenir des valeurs qui possedent des

import java.text.DecimalFormat;

// attributs ('libelle' et 'cout') qui sont initialises par un appel du
// constructeur (arguments entre parentheses apres le nom de chaque valeur).
// Par exemple, la valeur Code.FP a un attribut 'libelle' contenant la chaine
// de caracteres "forfait pediatrique" et un attribut 'cout' ayant la valeur 5.0
public enum Code {

    // valeurs de l'�num :

    CS("consultation au cabinet par le médecin généraliste", 23.0),
    CSC("consultation cardiologie", 47.73),
    FP("forfait pediatrique", 5.0),
    KC("actes de chirurgie et de specialite", 2.09),
    KE("actes d'echographie doppler", 1.89),
    K("autres actes de specialite", 1.92),
    KFA("forfait A", 30.49),
    KFB("forfait B", 60.98),
    ORT("orthodontie", 2.15),
    PRO("prothese dentaire", 2.15);

    // attributs de l'�num :
    private String libelle;
    private double cout;

    // constructeur :
    private Code(String libelle, double cout) {
        this.libelle = libelle;
        this.cout = cout;
    }

 
    public String toString(int coefficient) {
        return super.toString()+""+coefficient + " : " + libelle + " ( Coût unitaire : " + cout + " € )";
    }

    // calcule le prix pour un coefficient donne :
    public double calculerCout(int coefficient) {
        return coefficient * cout;
    }
}
