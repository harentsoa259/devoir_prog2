import java.time.LocalDate;

public abstract class Personne {
    protected int id;
    protected String nom;
    protected String prenom;
    protected LocalDate dateNaissance;
    protected String email;
    protected String telephone;

    public Personne(int id, String nom, String prenom, LocalDate dateNaissance, String email, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.telephone = telephone;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public LocalDate getDateNaissance() { return dateNaissance; }
    public String getEmail() { return email; }
    public String getTelephone() { return telephone; }
}