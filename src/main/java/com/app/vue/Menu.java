package main.java.com.app.vue;

import main.java.com.app.controller.bdd.impl.ActionBDDimpl;
import main.java.com.app.model.Programmeur;
import main.java.com.app.controller.bdd.ActionsBDD;

import java.util.Scanner;

public class Menu {

    public static void afficherMenu() {
        int value = 0;

        do {
            System.out.println("----------- Menu -----------");
            System.out.println("1. Ajouter un programmateur"); // DONE
            System.out.println("2. Supprimer un programmateur");
            System.out.println("3. Modifier un programmateur");
            System.out.println("4. Afficher un programmateur"); // DONE
            System.out.println("5. Afficher tous les programmeurs"); // DONE
            System.out.println("6. Quitter");

            System.out.print("Votre choix : ");
            value = verifiedInt();

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

    public static Integer verifiedInt() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        int input = 0;
        do {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                validInput = true;
            } else {
                System.out.print("Valeur incorrecte, veuillez entrer un entier : ");
                scanner.nextLine();
            }
        } while (!validInput);

        return input;
    }

    public static void afficherMenuAjouter() {
        Programmeur prog = new Programmeur();
        Scanner scanner = new Scanner(System.in);

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
        prog.setAnNaissance(verifiedInt());
        System.out.print("Salaire : ");
        prog.setSalaire(verifiedInt());
        System.out.print("Prime : ");
        prog.setPrime(verifiedInt());

        ActionsBDD actionsBDD = new ActionBDDimpl();
        Integer id = actionsBDD.ajouterProgrammeur(prog);
        if (id != null) {
            System.out.println("Programmateur ajouté avec l'id : " + id);
        }
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

        ActionsBDD actionsBDD = new ActionBDDimpl();
        Programmeur[] programmeurs = actionsBDD.recupererProgrammeurs();

        if (programmeurs != null) {
            afficherProgrammeurs(programmeurs);
        } else {
            System.out.println("Aucun programmateur trouvé");
        }
    }

    public static void afficherMenuQuitter() {
        System.out.println("Quitter");
    }

    public static void afficherErreur() {
        System.out.println("Erreur de saisie");
    }

    public static void afficherProgrammeur(Programmeur prog) {
        System.out.println(prog.toString());
    }

    public void afficherProgrammeurInexistant() {
        System.out.println("Programmateur inexistant");
    }

    public static void afficherProgrammeurs(Programmeur[] programmeurs) {
        for (Programmeur prog: programmeurs) {
            afficherProgrammeur(prog);
            System.out.println("<---------------->");
        }
    }
}
