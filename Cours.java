public class Cours {
    private int id;
    private String label;
    private int credits;
    private Enseignant enseignant;

    public Cours(int id, String label, int credits, Enseignant enseignant) {
        this.id = id;
        this.label = label;
        this.credits = credits;
        this.enseignant = enseignant;
    }

    public int getId() { return id; }
    public String getLabel() { return label; }
    public int getCredits() { return credits; }
    public Enseignant getEnseignant() { return enseignant; }
}