package main.java.com.app;

import main.java.com.app.vue.Menu;

/**
 * Classe principale de l'application qui démarre l'exécution du programme.
 * Cette classe contient la méthode {@code main}, point d'entrée du programme.
 */
public class Start {
    
    /**
     * Le point d'entrée principal du programme. Cette méthode lance l'affichage du menu principal de l'application.
     * @param args Les arguments de ligne de commande qui peuvent être passés au programme. Ils ne sont pas utilisés dans ce cas.
     */
    public static void main(String[] args) {
        Menu.afficherMenu();
    }
}
