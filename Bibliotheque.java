import java.util.ArrayList;

public class Bibliotheque {
    // Attributs
    private final ArrayList<Livre> collectionLivres;

    // Constructeur
    public Bibliotheque() {
        collectionLivres = new ArrayList<>();
    }

    // Méthode pour ajouter un livre à la collection
    public void ajouterLivre(Livre livre) {
        collectionLivres.add(livre);
    }

    // Méthode pour supprimer un livre de la collection
    public void supprimerLivre(Livre livre) {
        collectionLivres.remove(livre);
    }

    // Méthode pour afficher la liste de tous les livres
    public void afficherLivres() {
        System.out.println("Liste des livres dans la bibliothèque:");
        for (Livre livre : collectionLivres) {
            livre.afficherDetails();
        }
    }

    // Méthode pour emprunter un livre
    public void emprunterLivre(Livre livre) {
        livre.emprunter();
    }

    // Méthode pour retourner un livre
    public void retournerLivre(Livre livre) {
        livre.rendre();
    }

    // Méthode main pour tester la classe Bibliotheque
    public static void main(String[] args) {
        Bibliotheque bibliotheque = new Bibliotheque();

        // Ajout de livres à la bibliothèque
        bibliotheque.ajouterLivre(new Livre("Harry Potter à l'école des sorciers", "J.K. Rowling", 336));
        bibliotheque.ajouterLivre(new Livre("Le Seigneur des Anneaux : La Communauté de l'Anneau", "J.R.R. Tolkien", 576));
        bibliotheque.ajouterLivre(new Livre("1984", "George Orwell", 328));

        // Affichage de la liste de tous les livres
        System.out.println("Liste des livres avant emprunt/retour :");
        bibliotheque.afficherLivres();

        // Emprunter un livre et afficher la liste mise à jour
        Livre livreEmprunte = bibliotheque.collectionLivres.get(0);
        System.out.println("\nEmprunter le livre : " + livreEmprunte.getTitre());
        bibliotheque.emprunterLivre(livreEmprunte);

        System.out.println("\nListe des livres après emprunt :");
        bibliotheque.afficherLivres();

        // Retourner le livre emprunté et afficher la liste mise à jour
        System.out.println("\nRetourner le livre : " + livreEmprunte.getTitre());
        bibliotheque.retournerLivre(livreEmprunte);

        System.out.println("\nListe des livres après retour :");
        bibliotheque.afficherLivres();
    }
}

