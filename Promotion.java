import java.util.*;

public class Promotion {
    private Map<String, List<Etudiant>> groupes;

    public Promotion() {
        this.groupes = new HashMap<>();
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        groupes.computeIfAbsent(etudiant.getGroupe(), k -> new ArrayList<>()).add(etudiant);
    }

    public List<Etudiant> getEtudiantsParGroupe(String groupe) {
        return groupes.getOrDefault(groupe, new ArrayList<>());
    }

    public List<Etudiant> getTousEtudiants() {
        List<Etudiant> tous = new ArrayList<>();
        for (List<Etudiant> liste : groupes.values()) {
            tous.addAll(liste);
        }
        return tous;
    }
}
