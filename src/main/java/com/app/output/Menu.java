package com.app.output;

import com.app.domain.Programmateur;

public class Menu {

    public static void afficherMenu() {
        System.out.println("1. Ajouter un programmateur");
        System.out.println("2. Supprimer un programmateur");
        System.out.println("3. Modifier un programmateur");
        System.out.println("4. Afficher un programmateur");
        System.out.println("5. Afficher tous les programmeurs");
        System.out.println("6. Quitter");
    }

    public void afficherMenuAjouter() {
        System.out.println("Ajout d'un programmateur");
    }

    public void afficherMenuSupprimer() {
        System.out.println("Suppression d'un programmateur");
    }

    public void afficherMenuModifier() {
        System.out.println("Modification d'un programmateur");
    }

    public void afficherMenuAfficher() {
        System.out.println("Affichage d'un programmateur");
    }

    public void afficherMenuAfficherTous() {
        System.out.println("Affichage de tous les programmeurs");
    }

    public void afficherMenuQuitter() {
        System.out.println("Quitter");
    }

    public void afficherErreur() {
        System.out.println("Erreur");
    }

    public void afficherProgrammateur(Programmateur prog) {
        System.out.println(prog.toString());
    }

    public void afficherProgrammateurInexistant() {
        System.out.println("Programmateur inexistant");
    }

    public void afficherProgrammateurs(Programmateur[] programmateurs) {
        for (Programmateur prog: programmateurs) {
            afficherProgrammateur(prog);
            System.out.println("<---------------->");
        }
    }
}
