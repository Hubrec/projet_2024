package main.java.com.app.model;

/**
 * Classe représentant un programmeur avec des détails personnels et professionnels.
 * Elle contient des informations telles que le nom, le prénom, l'adresse, le pseudo,
 * le responsable, le hobby, l'année de naissance, le salaire et la prime.
 */
public class Programmeur {
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

    /**
     * Constructeur par défaut. Initialise les attributs avec des valeurs par défaut.
     */
    public Programmeur() {
        this.id = null;
        this.nom = "";
        this.prenom = "";
        this.adresse = "";
        this.pseudo = "";
        this.responsable = "";
        this.hobby = "";
        this.anNaissance = 0;
        this.salaire = 0;
        this.prime = 0;
    }

    /**
     * Constructeur avec paramètres pour initialiser un programmeur avec des valeurs spécifiques.
     * @param nom Le nom du programmeur.
     * @param prenom Le prénom du programmeur.
     * @param adresse L'adresse du programmeur.
     * @param pseudo Le pseudo du programmeur.
     * @param responsable Le responsable du programmeur.
     * @param hobby Le hobby du programmeur.
     * @param anNaissance L'année de naissance du programmeur.
     * @param salaire Le salaire du programmeur.
     * @param prime La prime du programmeur.
     * @param id L'identifiant unique du programmeur.
     */
    public Programmeur(String nom, String prenom, String adresse, String pseudo, String responsable, String hobby, Integer anNaissance, Integer salaire, Integer prime, Integer id) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.pseudo = pseudo;
        this.responsable = responsable;
        this.hobby = hobby;
        this.anNaissance = anNaissance;
        this.salaire = salaire;
        this.prime = prime;
        this.id = id;
    }

    // Getters et Setters avec documentation

    /**
     * Getter pour l'identifiant du programmeur.
     * @return L'identifiant du programmeur.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter pour l'identifiant du programmeur.
     * @param id L'identifiant à attribuer au programmeur.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter pour le nom du programmeur.
     * @return Le nom du programmeur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter pour le nom du programmeur.
     * @param nom Le nom à attribuer au programmeur.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter pour le prénom du programmeur.
     * @return Le prénom du programmeur.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Setter pour le prénom du programmeur.
     * @param prenom Le prénom à attribuer au programmeur.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Getter pour l'adresse du programmeur.
     * @return L'adresse du programmeur.
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Setter pour l'adresse du programmeur.
     * @param adresse L'adresse à attribuer au programmeur.
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Getter pour le pseudo du programmeur.
     * @return Le pseudo du programmeur.
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * Setter pour le pseudo du programmeur.
     * @param pseudo Le pseudo à attribuer au programmeur.
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * Getter pour le responsable du programmeur.
     * @return Le responsable du programmeur.
     */
    public String getResponsable() {
        return responsable;
    }

    /**
     * Setter pour le responsable du programmeur.
     * @param responsable Le responsable à attribuer au programmeur.
     */
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    /**
     * Getter pour le hobby du programmeur.
     * @return Le hobby du programmeur.
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * Setter pour le hobby du programmeur.
     * @param hobby Le hobby à attribuer au programmeur.
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    /**
     * Getter pour l'année de naissance du programmeur.
     * @return L'année de naissance du programmeur.
     */
    public Integer getAnNaissance() {
        return anNaissance;
    }

    /**
     * Setter pour l'année de naissance du programmeur.
     * @param anNaissance L'année à attribuer au programmeur.
     */
    public void setAnNaissance(Integer anNaissance) {
        this.anNaissance = anNaissance;
    }

    /**
     * Getter pour le salaire du programmeur.
     * @return Le salaire du programmeur.
     */
    public Integer getSalaire() {
        return salaire;
    }

    /**
     * Setter pour le salaire du programmeur.
     * @param salaire Le salaire à attribuer au programmeur.
     */
    public void setSalaire(Integer salaire) {
        this.salaire = salaire;
    }

    /**
     * Getter pour la prime du programmeur.
     * @return La prime du programmeur.
     */
    public Integer getPrime() {
        return prime;
    }

    /**
     * Setter pour la prime du programmeur.
     * @param prime La prime à attribuer au programmeur.
     */
    public void setPrime(Integer prime) {
        this.prime = prime;
    }

    /**
     * Retourne une chaîne de caractères représentant les informations du programmeur.
     * @return Une représentation textuelle du programmeur.
     */
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
