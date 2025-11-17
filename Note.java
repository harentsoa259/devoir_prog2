import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Note {
    private final Etudiant etudiant;
    private final Exam exam;
    private final List<ModificationNote> historique = new ArrayList<>();

    public static class ModificationNote {
        private final double valeur;
        private final Instant dateModification;
        private final String motif;

        public ModificationNote(double valeur, Instant dateModification, String motif) {
            this.valeur = valeur;
            this.dateModification = dateModification;
            this.motif = motif;
        }

        public double getValeur() { return valeur; }
        public Instant getDateModification() { return dateModification; }
        public String getMotif() { return motif; }
    }

    public Note(Etudiant etudiant, Exam exam, double valeurInitiale, Instant dateInitiale, String motifInitial) {
        this.etudiant = etudiant;
        this.exam = exam;
        modifierNote(valeurInitiale, dateInitiale, motifInitial);
    }

    public void modifierNote(double valeur, Instant date, String motif) {
        historique.add(new ModificationNote(valeur, date, motif));
    }

    public double getValeurActuelle() {
        return historique.isEmpty() ? 0.0 : historique.get(historique.size() - 1).getValeur();
    }

    public double getValeurA(Instant instant) {
        double valeur = 0.0;
        for (ModificationNote modif : historique) {
            if (!modif.getDateModification().isAfter(instant)) {
                valeur = modif.getValeur();
            } else break;
        }
        return valeur;
    }

    public Etudiant getEtudiant() { return etudiant; }
    public Exam getExam() { return exam; }
    public List<ModificationNote> getHistorique() { return new ArrayList<>(historique); }
}
