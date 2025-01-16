package main.java.com.app.controller.bdd;

import main.java.com.app.model.Programmeur;

public interface ActionsBDD {
    Integer ajouterProgrammeur(Programmeur programmeur);
    Integer supprimerProgrammeur(String pseudo);
    Integer modifierProgrammeur(Programmeur programmeur);
    Programmeur recupererProgrammeur(String pseudo);
    Programmeur[] recupererProgrammeurs();
}
