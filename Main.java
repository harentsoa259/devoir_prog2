import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Enseignant enseignant = new Enseignant(1, "Ramarozaka", "Tokimahery", 
                LocalDate.of(1985, 1, 1), "ramarozaka@gmail.com", "0334455667", "Programmation");
        
        Tuteur tuteur = new Tuteur(1, "Rakoto", "Jean", LocalDate.of(1970, 5, 15),
                "rakoto@gmail.com", "0321122334", "Père");
        
        Etudiant etudiant = new Etudiant(1, "Randria", "Marie", LocalDate.of(2002, 3, 20),
                "randria@gmail.com", "0345566778", "Groupe A", tuteur);
        
        Cours coursProg2 = new Cours(1, "PROG2", 6, enseignant);
        
        Exam exam1 = new Exam(1, "Partiel", coursProg2, 
                LocalDateTime.of(2024, 1, 15, 9, 0), 2.0);
        Exam exam2 = new Exam(2, "Final", coursProg2, 
                LocalDateTime.of(2024, 2, 20, 9, 0), 3.0);

        Promotion promotion = new Promotion();
        promotion.ajouterEtudiant(etudiant);
        
        GestionNotes gestionNotes = new GestionNotes(promotion);

        Note noteExam1 = new Note(etudiant, exam1, 12.0, 
                Instant.parse("2024-01-16T10:00:00Z"), "Note initiale partiel");
        noteExam1.modifierNote(14.0, Instant.parse("2024-01-20T14:30:00Z"), "Réévaluation");
        
        Note noteExam2 = new Note(etudiant, exam2, 16.0, 
                Instant.parse("2024-02-21T10:00:00Z"), "Note finale");
        
        gestionNotes.ajouterNote(noteExam1);
        gestionNotes.ajouterNote(noteExam2);

        Instant maintenant = Instant.now();
        double noteExam = gestionNotes.getExamGrade(exam1, etudiant, maintenant);
        double noteCours = gestionNotes.getCourseGrade(coursProg2, etudiant, maintenant);
        
        System.out.println("=== SYSTÈME DE GESTION DES NOTES ===");
        System.out.println("Étudiant: " + etudiant.getPrenom() + " " + etudiant.getNom());
        System.out.println("Note à l'examen partiel: " + noteExam + "/20");
        System.out.println("Note finale en PROG2: " + noteCours + "/20");
        System.out.println("Calcul: (14.0 * 2 + 16.0 * 3) / 5 = " + noteCours);
    }
}