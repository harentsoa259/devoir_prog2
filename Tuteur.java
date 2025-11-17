import java.time.LocalDate;

public class Tuteur extends Personne {
    private String lienAvecEtudiant;

    public Tuteur(int id, String nom, String prenom, LocalDate dateNaissance, 
                  String email, String telephone, String lienAvecEtudiant) {
        super(id, nom, prenom, dateNaissance, email, telephone);
        this.lienAvecEtudiant = lienAvecEtudiant;
    }

    public String getLienAvecEtudiant() { return lienAvecEtudiant; }
}