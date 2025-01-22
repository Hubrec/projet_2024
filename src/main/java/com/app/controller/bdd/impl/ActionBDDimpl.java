package main.java.com.app.controller.bdd.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.com.app.controller.bdd.ActionsBDD;
import main.java.com.app.model.Programmeur;

/**
 * Implémentation de {@link ActionsBDD} pour la gestion des données des programmeurs dans une base de données.
 * Fournit des fonctionnalités pour ajouter, supprimer, modifier et récupérer des détails des programmeurs.
 */
public class ActionBDDimpl implements ActionsBDD {

    private static final String URL = "jdbc:mysql://localhost:3306/projet_2024";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    /**
     * Récupère une nouvelle connexion à la base de données.
     * @return Un objet {@link Connection} à la base de données.
     * @throws SQLException Si une erreur d'accès à la base de données se produit.
     */
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Ajoute un nouveau programmeur dans la base de données.
     * @param p L'objet {@link Programmeur} contenant les informations du programmeur à ajouter.
     * @return L'ID généré du nouveau programmeur si l'ajout est réussi, null sinon.
     */
    @Override
    public Integer ajouterProgrammeur(Programmeur p) {
        String sql = "INSERT INTO programmeur (nom, prenom, adresse, pseudo, responsable, hobby, an_naissance, salaire, prime) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, p.getNom());
            stmt.setString(2, p.getPrenom());
            stmt.setString(3, p.getAdresse());
            stmt.setString(4, p.getPseudo());
            stmt.setString(5, p.getResponsable());
            stmt.setString(6, p.getHobby());
            stmt.setInt(7, p.getAnNaissance());
            stmt.setInt(8, p.getSalaire());
            stmt.setInt(9, p.getPrime());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Supprime un programmeur de la base de données en fonction de son pseudo.
     * @param pseudo Le pseudo du programmeur à supprimer.
     * @return Le nombre de lignes affectées par l'opération de suppression.
     */
    @Override
    public Integer supprimerProgrammeur(String pseudo) {
        String sql = "DELETE FROM programmeur WHERE pseudo = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pseudo);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Met à jour les détails d'un programmeur existant dans la base de données.
     * @param p L'objet {@link Programmeur} contenant les informations mises à jour du programmeur.
     * @return Le nombre de lignes affectées par l'opération de mise à jour.
     */
    @Override
    public Integer modifierProgrammeur(Programmeur p) {
        String sql = "UPDATE programmeur SET nom = ?, prenom = ?, adresse = ?, responsable = ?, hobby = ?, an_naissance = ?, salaire = ?, prime = ? WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNom());
            stmt.setString(2, p.getPrenom());
            stmt.setString(3, p.getAdresse());
            stmt.setString(4, p.getPseudo());
            stmt.setString(5, p.getResponsable());
            stmt.setString(6, p.getHobby());
            stmt.setInt(7, p.getAnNaissance());
            stmt.setInt(8, p.getSalaire());
            stmt.setInt(9, p.getPrime());
            stmt.setInt(10, p.getId());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Récupère les détails d'un programmeur de la base de données en fonction de son pseudo.
     * @param pseudo Le pseudo du programmeur à récupérer.
     * @return Un objet {@link Programmeur} contenant les détails du programmeur si trouvé, null sinon.
     */
    @Override
    public Programmeur recupererProgrammeur(String pseudo) {
        String sql = "SELECT * FROM programmeur WHERE pseudo = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pseudo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Programmeur(
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("adresse"),
                            rs.getString("pseudo"),
                            rs.getString("responsable"),
                            rs.getString("hobby"),
                            rs.getInt("an_naissance"),
                            rs.getInt("salaire"),
                            rs.getInt("prime"),
                            rs.getInt("id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Récupère tous les programmeurs de la base de données.
     * @return Un tableau d'objets {@link Programmeur} contenant les détails de tous les programmeurs.
     */
    @Override
    public Programmeur[] recupererProgrammeurs() {
        String sql = "SELECT * FROM programmeur";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery()) {

            List<Programmeur> programmeurs = new ArrayList<>();
            while (rs.next()) {
                programmeurs.add(new Programmeur(
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("adresse"),
                        rs.getString("pseudo"),
                        rs.getString("responsable"),
                        rs.getString("hobby"),
                        rs.getInt("an_naissance"),
                        rs.getInt("salaire"),
                        rs.getInt("prime"),
                        rs.getInt("id")
                ));
            }
            return programmeurs.toArray(new Programmeur[0]);
        } catch (SQLException e) {
            System.out.println("Erreur SQL lors de la récupération des programmeurs.");
            e.printStackTrace();
        }
        return new Programmeur[0];
    }
}
