package com.app.bdd;

import com.app.domain.Programmateur;

public interface ActionsBDD {
    Integer ajouterProgrammateur(String nom, String prenom, String adresse, String pseudo, String responsable, String hobby, Integer anNaissance, Integer salaire, Integer prime);
    Integer supprimerProgrammateur(Number id);
    Integer modifierProgrammateur(String pseudo, String nom, String prenom, String adresse, String responsable, String hobby);
    Programmateur recupererProgrammateur(String pseudo);
    Programmateur[] recupererProgrammateurs();
}
