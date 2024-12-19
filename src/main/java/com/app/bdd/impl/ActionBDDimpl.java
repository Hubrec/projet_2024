package com.app.bdd.impl;

import com.app.bdd.ActionsBDD;
import com.app.domain.Programmateur;

public class ActionBDDimpl implements ActionsBDD {
    public void ajouterProgrammateur(String nom, String prenom, String adresse, String pseudo, String responsable, String hobby) {

    }

    public void supprimerProgrammateur(String pseudo) {

    }

    @Override
    public Integer ajouterProgrammateur(String nom, String prenom, String adresse, String pseudo, String responsable, String hobby, Integer anNaissance, Integer salaire, Integer prime) {
        return null;
    }

    @Override
    public Integer supprimerProgrammateur(Number id) {
        return null;
    }

    public Integer modifierProgrammateur(String pseudo, String nom, String prenom, String adresse, String responsable, String hobby) {
        return null;
    }

    @Override
    public Programmateur recupererProgrammateur(String pseudo) {
        return null;
    }

    @Override
    public Programmateur[] recupererProgrammateurs() {
        return new Programmateur[0];
    }

    public void afficherProgrammateur(String pseudo) {

    }

    public void afficherProgrammateurs() {

    }
}
