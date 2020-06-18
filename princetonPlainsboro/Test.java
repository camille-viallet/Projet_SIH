package princetonPlainsboro;


class Test {

    public static void main(String[] args) {
        LectureXML test = new LectureXML("dossiers.xml");
        DossierMedical dossierMedical = test.getDossier();
        
        Medecin medecin = new Medecin("HOUSE", "Gregory", "123", "heyho", "06.68.26.59.36", Specialite.CARDIOLOGIE);

        Acte a = new Acte(Code.CS, 5, "Medecine générale", medecin, new Date(10,6,2020,15,45), Type.DIAG, "En pleine santé");
        Patient patient = new Patient("Claire", "DUPRE", "28 Ch.des Vignes 98560 NEUILLY", new Date(25,6,1960,8,45), "192011300135260", 52, 1.82);
        FicheDeSoins fiche = new FicheDeSoins(patient, medecin, new Date(10,6,2020,15,45), 15);
        fiche.ajouterActe(a);
        System.out.println(fiche);
        
        System.out.println("# TEST SECU - Attendu false : "+Patient.verifierSecu("025896df3548365"));
        System.out.println("# TEST SECU - Attendu true : "+Patient.verifierSecu("192011300135260"));
        
        Date d1 = new Date(10,6,2020,15,45);
        //System.out.println("# TEST VERIFIER DATE - Attendu true : "+ );
        
        
    }
}
