import java.time.LocalDate;

public class Enseignant extends Personne {
    private String specialite;

    public Enseignant(int id, String nom, String prenom, LocalDate dateNaissance, 
                      String email, String telephone, String specialite) {
        super(id, nom, prenom, dateNaissance, email, telephone);
        this.specialite = specialite;
    }

    public String getSpecialite() { return specialite; }
}