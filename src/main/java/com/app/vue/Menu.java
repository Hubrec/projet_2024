package main.java.com.app.vue;

import main.java.com.app.controller.bdd.impl.ActionBDDimpl;
import main.java.com.app.model.Programmeur;
import main.java.com.app.controller.bdd.ActionsBDD;

import java.util.Scanner;

public class Menu {

    public static void afficherMenu() {
        int value = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("----------- Menu -----------");
            System.out.println("1. Ajouter un programmateur");
            System.out.println("2. Supprimer un programmateur");
            System.out.println("3. Modifier un programmateur");
            System.out.println("4. Afficher un programmateur");
            System.out.println("5. Afficher tous les programmeurs");
            System.out.println("6. Quitter");

            System.out.print("Votre choix : ");
            value = scanner.nextInt();
            scanner.nextLine();

            switch (value) {
                case 1:
                    afficherMenuAjouter();
                    break;
                case 2:
                    afficherMenuSupprimer();
                    break;
                case 3:
                    afficherMenuModifier();
                    break;
                case 4:
                    afficherMenuAfficher();
                    break;
                case 5:
                    afficherMenuAfficherTous();
                    break;
                case 6:
                    afficherMenuQuitter();
                    break;
                default:
                    afficherErreur();
                    break;
            }
        } while (value != 6);


    }

    public static void afficherMenuAjouter() {
        Scanner scanner = new Scanner(System.in);
        Programmeur prog = new Programmeur();

        System.out.println("Ajout d'un programmateur");
        System.out.print("Nom : ");
        prog.setNom(scanner.nextLine());
        System.out.print("Prenom : ");
        prog.setPrenom(scanner.nextLine());
        System.out.print("Adresse : ");
        prog.setAdresse(scanner.nextLine());
        System.out.print("Pseudo : ");
        prog.setPseudo(scanner.nextLine());
        System.out.print("Responsable : ");
        prog.setResponsable(scanner.nextLine());
        System.out.print("Hobby : ");
        prog.setHobby(scanner.nextLine());
        System.out.print("Annee de naissance : ");
        prog.setAnNaissance(scanner.nextInt());
        System.out.print("Salaire : ");
        prog.setSalaire(scanner.nextInt());
        System.out.print("Prime : ");
        prog.setPrime(scanner.nextInt());

        ActionsBDD actionsBDD = new ActionBDDimpl();
        Integer id = actionsBDD.ajouterProgrammeur(prog);

        System.out.println("Programmateur ajouté avec l'id : " + id);
    }

    public static void afficherMenuSupprimer() {
        System.out.println("Suppression d'un programmateur");
    }

    public static void afficherMenuModifier() {
        System.out.println("Modification d'un programmateur");
    }

    public static void afficherMenuAfficher() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Affichage d'un programmateur");

        System.out.print("Pseudo : ");
        String pseudo = scanner.nextLine();

        ActionsBDD actionsBDD = new ActionBDDimpl();
        Programmeur prog = actionsBDD.recupererProgrammeur(pseudo);
        System.out.println(prog.toString());
    }

    public static void afficherMenuAfficherTous() {
        System.out.println("Affichage de tous les programmeurs");
    }

    public static void afficherMenuQuitter() {
        System.out.println("Quitter");
    }

    public static void afficherErreur() {
        System.out.println("Erreur");
    }

    public static void afficherProgrammateur(Programmeur prog) {
        System.out.println(prog.toString());
    }

    public void afficherProgrammateurInexistant() {
        System.out.println("Programmateur inexistant");
    }

    public void afficherProgrammateurs(Programmeur[] programmeurs) {
        for (Programmeur prog: programmeurs) {
            afficherProgrammateur(prog);
            System.out.println("<---------------->");
        }
    }
}
