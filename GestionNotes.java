import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class GestionNotes {
    private final Promotion promotion;
    private final List<Note> notes;

    public GestionNotes(Promotion promotion) {
        if (promotion == null) throw new IllegalArgumentException("La promotion ne peut pas être nulle");
        this.promotion = promotion;
        this.notes = new ArrayList<>();
    }

    public void ajouterNote(Note note) {
        if (note != null) {
            notes.add(note);
        }
    }

    public double getExamGrade(Exam exam, Etudiant etudiant, Instant t) {
        for (Note note : notes) {
            if (note.getExam().equals(exam) && note.getEtudiant().equals(etudiant)) {
                return note.getValeurA(t);
            }
        }
        return 0.0;
    }

    public double getCourseGrade(Cours course, Etudiant etudiant, Instant t) {
        double sommeNotesPonderees = 0.0;
        double sommeCoefficients = 0.0;

        for (Note note : notes) {
            if (note.getExam().getCours().equals(course) && note.getEtudiant().equals(etudiant)) {
                double valeur = note.getValeurA(t);
                double coeff = note.getExam().getCoefficient();
                sommeNotesPonderees += valeur * coeff;
                sommeCoefficients += coeff;
            }
        }

        if (sommeCoefficients == 0.0) {
            return 0.0;
        }
        return sommeNotesPonderees / sommeCoefficients;
    }

    public List<Note> getNotes() {
        return new ArrayList<>(notes);
    }

    public Promotion getPromotion() {
        return promotion;
    }
}
