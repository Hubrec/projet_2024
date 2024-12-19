package com.app.bdd;

public interface ActionsBDD {
    void ajouterProgrammateur(String nom, String prenom, String adresse, String pseudo, String responsable, String hobby);
    void supprimerProgrammateur(String pseudo);
    void modifierProgrammateur(String pseudo, String nom, String prenom, String adresse, String responsable, String hobby);
    void afficherProgrammateur(String pseudo);
    void afficherProgrammateurs();
}
