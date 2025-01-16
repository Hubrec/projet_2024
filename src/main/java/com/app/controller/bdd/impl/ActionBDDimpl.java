package main.java.com.app.controller.bdd.impl;

import main.java.com.app.controller.bdd.ActionsBDD;
import main.java.com.app.model.Programmateur;

import java.sql.*;

public class ActionBDDimpl implements ActionsBDD {

    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public Integer ajouterProgrammateur(String nom, String prenom, String adresse, String pseudo, String responsable, String hobby, Integer anNaissance, Integer salaire, Integer prime) {
        String sql = "INSERT INTO programmateurs (nom, prenom, adresse, pseudo, responsable, hobby, anNaissance, salaire, prime) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setString(3, adresse);
            stmt.setString(4, pseudo);
            stmt.setString(5, responsable);
            stmt.setString(6, hobby);
            stmt.setInt(7, anNaissance);
            stmt.setInt(8, salaire);
            stmt.setInt(9, prime);
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

    @Override
    public Integer supprimerProgrammateur(Number id) {
        String sql = "DELETE FROM programmateurs WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id.intValue());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer modifierProgrammateur(String pseudo, String nom, String prenom, String adresse, String responsable, String hobby) {
        String sql = "UPDATE programmateurs SET nom = ?, prenom = ?, adresse = ?, responsable = ?, hobby = ? WHERE pseudo = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setString(3, adresse);
            stmt.setString(4, responsable);
            stmt.setString(5, hobby);
            stmt.setString(6, pseudo);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Programmateur recupererProgrammateur(String pseudo) {
        String sql = "SELECT * FROM programmateurs WHERE pseudo = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pseudo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Programmateur(
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("adresse"),
                            rs.getString("pseudo"),
                            rs.getString("responsable"),
                            rs.getString("hobby")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Programmateur[] recupererProgrammateurs() {
        String sql = "SELECT * FROM programmateurs";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            rs.last();
            int rowCount = rs.getRow();
            rs.beforeFirst();
            Programmateur[] programmateurs = new Programmateur[rowCount];
            int i = 0;
            while (rs.next()) {
                programmateurs[i++] = new Programmateur(
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("adresse"),
                        rs.getString("pseudo"),
                        rs.getString("responsable"),
                        rs.getString("hobby")
                );
            }
            return programmateurs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Programmateur[0];
    }
}
