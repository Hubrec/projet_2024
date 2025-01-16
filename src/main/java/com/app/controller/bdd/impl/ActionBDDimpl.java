package main.java.com.app.controller.bdd.impl;

import main.java.com.app.controller.bdd.ActionsBDD;
import main.java.com.app.model.Programmeur;

import java.sql.*;

public class ActionBDDimpl implements ActionsBDD {

    private static final String URL = "jdbc:mysql://localhost:3306/projet_2024";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

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

    @Override
    public Programmeur[] recupererProgrammeurs() {
        String sql = "SELECT * FROM programmeur";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            rs.last();
            int rowCount = rs.getRow();
            rs.beforeFirst();
            Programmeur[] programmeurs = new Programmeur[rowCount];
            int i = 0;
            while (rs.next()) {
                programmeurs[i++] = new Programmeur(
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
            return programmeurs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Programmeur[0];
    }
}
