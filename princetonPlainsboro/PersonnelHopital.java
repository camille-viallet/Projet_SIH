/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Camille
 */
public class PersonnelHopital {

    private ArrayList<Personnel> listePersonnel;

    public PersonnelHopital() {
        listePersonnel = new ArrayList<Personnel>();
    }

    public void addPersonnel(Personnel p) {
        listePersonnel.add(p);
    }

    public List<Personnel> getListePersonnel() {
        return Collections.unmodifiableList(listePersonnel);
    }
}
