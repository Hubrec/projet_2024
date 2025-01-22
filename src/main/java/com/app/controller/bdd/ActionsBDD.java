package main.java.com.app.controller.bdd;

import main.java.com.app.model.Programmeur;

/**
 * Interface définissant les opérations de base de données pour la gestion des programmeurs.
 * Fournit les méthodes nécessaires pour ajouter, supprimer, modifier et récupérer des programmeurs.
 */
public interface ActionsBDD {

    /**
     * Ajoute un programmeur à la base de données.
     * @param programmeur L'objet Programmeur à ajouter.
     * @return L'identifiant généré du programmeur ajouté, null si l'opération échoue.
     */
    Integer ajouterProgrammeur(Programmeur programmeur);

    /**
     * Supprime un programmeur de la base de données en utilisant son pseudo.
     * @param pseudo Le pseudo du programmeur à supprimer.
     * @return Le nombre de lignes affectées par l'opération (1 si réussi, 0 si échoué).
     */
    Integer supprimerProgrammeur(String pseudo);

    /**
     * Modifie les informations d'un programmeur existant dans la base de données.
     * @param programmeur L'objet Programmeur contenant les informations mises à jour.
     * @return Le nombre de lignes affectées par l'opération (1 si réussi, 0 si échoué).
     */
    Integer modifierProgrammeur(Programmeur programmeur);

    /**
     * Récupère les détails d'un programmeur spécifique à partir de la base de données en utilisant son pseudo.
     * @param pseudo Le pseudo du programmeur à récupérer.
     * @return L'objet Programmeur correspondant, ou null si aucun programmeur n'est trouvé.
     */
    Programmeur recupererProgrammeur(String pseudo);

    /**
     * Récupère tous les programmeurs présents dans la base de données.
     * @return Un tableau contenant tous les programmeurs, peut être vide si aucun programmeur n'est trouvé.
     */
    Programmeur[] recupererProgrammeurs();
}
