package main.java.com.app.vue;

import java.util.Scanner;

import main.java.com.app.controller.bdd.ActionsBDD;
import main.java.com.app.controller.bdd.impl.ActionBDDimpl;
import main.java.com.app.model.Programmeur;

/**
 * Classe Menu fournissant une interface utilisateur pour la gestion des programmeurs.
 * Permet d'ajouter, supprimer, modifier et afficher les informations des programmeurs via une interface en ligne de commande.
 */
public class Menu {

    /**
     * Affiche le menu principal et permet à l'utilisateur de choisir parmi différentes actions.
     * L'utilisateur peut ajouter, supprimer, modifier, afficher un ou tous les programmeurs, ou quitter le programme.
     */
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

    /**
     * Affiche le menu pour ajouter un nouveau programmeur et collecte les informations via l'entrée utilisateur.
     * Les informations sont ensuite utilisées pour créer un programmeur dans la base de données.
     */
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

    /**
     * Affiche le menu pour supprimer un programmeur en demandant le pseudo à l'utilisateur.
     * Supprime le programmeur correspondant de la base de données si trouvé.
     */
    public static void afficherMenuSupprimer() {
        System.out.println("Supprimer un programmeur");

        int value = 0; 
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Pseudo (tapez '1' pour quitter) : ");
            String pseudo = scanner.next(); 

            if (pseudo.equals("1")) {
                System.out.println("Vous avez quitté le menu de suppression.");
                break; 
            }

            scanner.nextLine();

            ActionsBDD actionsBDD = new ActionBDDimpl();
            value = actionsBDD.supprimerProgrammeur(pseudo);

            if (value == 1) {
                System.out.println("Le programmeur avec le pseudo '" + pseudo + "' a été supprimé avec succès.");
            } else {
                System.out.println("Le programmeur avec le pseudo '" + pseudo + "' n'existe pas ou la suppression a échoué.");
            }

        } while (value != 1);

        System.out.println("Fin du programme de suppression.");
    }

    /**
     * Affiche le menu pour modifier les informations d'un programmeur existant.
     * L'utilisateur doit entrer les nouvelles informations pour mettre à jour le programmeur spécifié.
     */
    public static void afficherMenuModifier() {
        System.out.println("Modification d'un programmateur");
    }

    /**
     * Affiche le menu pour afficher les informations d'un programmeur spécifique.
     * Demande le pseudo du programmeur et affiche ses informations si trouvé.
     */
    public static void afficherMenuAfficher() {
        System.out.println("Afficher un programmeur");
    
        Scanner scanner = new Scanner(System.in);
    
        while (true) {
            System.out.print("Pseudo (tapez '1' pour quitter) : ");
            String pseudo = scanner.next();
    
            if (pseudo.equals("1")) {
                System.out.println("Vous avez quitté le menu d'affichage.");
                break;
            }
    
            scanner.nextLine(); 
    
            ActionsBDD actionsBDD = new ActionBDDimpl();
            Programmeur programmeur = actionsBDD.recupererProgrammeur(pseudo);
    
            if (programmeur != null) {
                System.out.println("Programmeur trouvé :");
                System.out.println(programmeur.toString());
            } else {
                System.out.println("Le programmeur avec le pseudo '" + pseudo + "' n'existe pas.");
            }
        }
    
        System.out.println("Fin du programme d'affichage.");
    }
    
    /**
     * Affiche le menu pour afficher tous les programmeurs enregistrés dans la base de données.
     * Liste les informations de tous les programmeurs disponibles.
     */
    public static void afficherMenuAfficherTous() {
        System.out.println("Affichage de tous les programmeurs");
    
        ActionsBDD actionsBDD = new ActionBDDimpl();
        Programmeur[] programmeurs = actionsBDD.recupererProgrammeurs();
        
        if (programmeurs != null && programmeurs.length > 0) {
            for (Programmeur prog : programmeurs) {
                System.out.println(prog.toString());
                System.out.println("<---------------->");
            }
        } else {
            System.out.println("Aucun programmeur trouvé.");
        }
    
        System.out.println("Fin de l'affichage de tous les programmeurs.");
    }

    /**
     * Affiche un message pour quitter le programme et ferme l'application.
     */
    public static void afficherMenuQuitter() {
        System.out.println("Quitter");
    }

    /**
     * Affiche un message d'erreur en cas de sélection invalide dans le menu principal.
     */
    public static void afficherErreur() {
        System.out.println("Erreur");
    }

    /**
     * Affiche les détails d'un programmeur spécifique.
     * @param prog L'objet Programmeur dont les détails doivent être affichés.
     */
    public static void afficherProgrammateur(Programmeur prog) {
        System.out.println(prog.toString());
    }

    /**
     * Affiche un message indiquant que le programmateur spécifié est inexistant.
     */
    public void afficherProgrammateurInexistant() {
        System.out.println("Programmateur inexistant");
    }

    /**
     * Affiche les informations de tous les programmeurs passés en paramètre.
     * @param programmeurs Un tableau contenant les programmeurs à afficher.
     */
    public void afficherProgrammateurs(Programmeur[] programmeurs) {
        for (Programmeur prog: programmeurs) {
            afficherProgrammateur(prog);
            System.out.println("<---------------->");
        }
    }
}
