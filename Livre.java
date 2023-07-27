// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Livre {
    // Attributs
    private String titre;
    private String auteur;
    private int nombreDePages;
    private boolean estEmprunte;

    // Constructeur
    public Livre(String titre, String auteur, int nombreDePages) {
        this.titre = titre;
        this.auteur = auteur;
        this.nombreDePages = nombreDePages;
        this.estEmprunte = false;
    }

    // Getters
    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public boolean estEmprunte() {
        return estEmprunte;
    }

    // Méthode pour emprunter le livre
    public void emprunter() {
        estEmprunte = true;
    }

    // Méthode pour rendre le livre
    public void rendre() {
        estEmprunte = false;
    }

    // Méthode pour afficher les détails du livre
    public void afficherDetails() {
        System.out.println("Titre: " + titre);
        System.out.println("Auteur: " + auteur);
        System.out.println("Nombre de pages: " + nombreDePages);
        System.out.println("Emprunté: " + (estEmprunte ? "Oui" : "Non"));
    }

    // Méthode main pour tester la classe Livre
    public static void main(String[] args) {
        Livre livre1 = new Livre("Harry Potter à l'école des sorciers", "J.K. Rowling", 336);
        livre1.afficherDetails();

        System.out.println("Emprunter le livre...");
        livre1.emprunter();
        livre1.afficherDetails();

        System.out.println("Rendre le livre...");
        livre1.rendre();
        livre1.afficherDetails();
    }
}
