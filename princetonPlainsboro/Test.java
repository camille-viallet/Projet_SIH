package princetonPlainsboro;

class Test {

    public static void main(String[] args) {
        LectureXML test = new LectureXML("dossiers.xml");
        DossierMedical dm = test.getDossier();
//        dm.afficher();

        System.out.println("\n********\n");

        //Patient p1 = new Patient("Bole", "Pat");
       // System.out.println("> cout de " + p1.toString() + " : " + dm.coutPatient(p1));

        System.out.println("\n********\n");

        String spe = "Cardiologue";
//        System.out.println("> cout de la specialite '" + spe + "' : " + dm.coutSpecialite(spe));

        System.out.println("\n********\n");

        //Medecin m1 = new Medecin("Deblouze", "Agathe", "Cardiologue");
       // dm.afficherListePatients(m1);

        System.out.println("\n********\n");

        Date d1 = new Date(1, 11, 2005, 13, 56);
        Date d2 = new Date(5, 1, 2006, 9, 32);
        Date d3 = new Date (0, 1, 2002, 9, 33) ;
        Date d4 = new Date (1, 0, 2002, 9, 33) ;
        Date d5 = new Date (1, 1, 2021, 9, 33) ;
        Date d6 = new Date (1, 1, 2002, 24, 33) ;
        Date d7 = new Date (1, 1, 2002, 9, 60) ;
//        System.out.println("> nombre de fiches entre " + d1 + " et " + d2 + " : " + dm.nombreFichesIntervalle(d1, d2));

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);
        System.out.println(d5);
        System.out.println(d6);
        System.out.println(d7);
                
        System.out.println("\n********\n");

        System.out.println();
        System.out.println("Dossier trie selon les dates :");
        dm.trierDates();

        System.out.println("\n********\n");

        System.out.println();
        System.out.println("Dossier trie selon les couts :");
        dm.trier(new ComparaisonFichesCouts());
    }
}
