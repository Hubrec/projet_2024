package main.java.com.app.model;

public class Programmateur {
    private Integer id;
    private String nom;
    private String prenom;
    private String adresse;
    private String pseudo;
    private String responsable;
    private String hobby;
    private Integer anNaissance;
    private Integer salaire;
    private Integer prime;

    public Programmateur(String nom, String prenom, String adresse, String pseudo, String responsable, String hobby) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.pseudo = pseudo;
        this.responsable = responsable;
        this.hobby = hobby;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnNaissance() {
        return anNaissance;
    }

    public void setAnNaissance(Integer anNaissance) {
        this.anNaissance = anNaissance;
    }

    public Integer getSalaire() {
        return salaire;
    }

    public void setSalaire(Integer salaire) {
        this.salaire = salaire;
    }

    public Integer getPrime() {
        return prime;
    }

    public void setPrime(Integer prime) {
        this.prime = prime;
    }

    @Override
    public String toString() {
        return "Id          : " + id + "\n" +
                "Nom         : " + nom + "\n" +
                "Prenom      : " + prenom + "\n" +
                "Adresse     : " + adresse + "\n" +
                "Pseudo      : " + pseudo + "\n" +
                "Responsable : " + responsable + "\n" +
                "Hobby       : " + hobby +"\n" +
                "Naissance   : " + anNaissance + "\n" +
                "Salaire     : " + salaire + "\n" +
                "Prime       : " + prime + "\n";

    }
}
