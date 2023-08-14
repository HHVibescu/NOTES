import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Client {
    String identifiant;
    String nom;
    String prenom;
    String numeroTelephone;

    public Client(String identifiant, String nom, String prenom, String numeroTelephone) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTelephone = numeroTelephone;
    }
}

class Chambre {
    String numero;
    String statut;
    int nombreLits;
    double tarif;

    public Chambre(String numero, String statut, int nombreLits, double tarif) {
        this.numero = numero;
        this.statut = statut;
        this.nombreLits = nombreLits;
        this.tarif = tarif;
    }
}

class Reservation {
    String identifiant;
    String statut;
    List<String> chambres;
    Client client;

    public Reservation(String identifiant, String statut, List<String> chambres, Client client) {
        this.identifiant = identifiant;
        this.statut = statut;
        this.chambres = chambres;
        this.client = client;
    }
}

class Hotel {
    List<Client> clients = new ArrayList<>();
    List<Chambre> chambres = new ArrayList<>();
    List<Reservation> reservations = new ArrayList<>();

    public void ajouterClient(Client client) {
        clients.add(client);
    }

    public void ajouterChambre(Chambre chambre) {
        chambres.add(chambre);
    }

    public void ajouterReservation(Reservation reservation) {
        reservations.add(reservation);
    }
}

public class GestionHotel {
    public static void main(String[] args) {
        Hotel monHotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Ajouter un client");
            System.out.println("2. Ajouter une chambre");
            System.out.println("3. Ajouter une réservation");
            System.out.println("4. Quitter");

            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    // Code pour ajouter un client
                    System.out.print("Identifiant du client : ");
                    String identifiant = scanner.next();
                    System.out.print("Nom du client : ");
                    String nom = scanner.next();
                    System.out.print("Prénom du client : ");
                    String prenom = scanner.next();
                    System.out.print("Numéro de téléphone du client : ");
                    String numeroTelephone = scanner.next();
                    Client client = new Client(identifiant, nom, prenom, numeroTelephone);
                    monHotel.ajouterClient(client);
                    System.out.println("Client ajouté avec succès !");
                    break;
                case 2:
                    // Code pour ajouter une chambre
                    System.out.print("Numéro de la chambre : ");
                    String numero = scanner.next();
                    System.out.print("Statut de la chambre : ");
                    String statut = scanner.next();
                    System.out.print("Nombre de lits de la chambre : ");
                    int nombreLits = scanner.nextInt();
                    System.out.print("Tarif de la chambre : ");
                    double tarif = scanner.nextDouble();
                    Chambre chambre = new Chambre(numero, statut, nombreLits, tarif);
                    monHotel.ajouterChambre(chambre);
                    System.out.println("Chambre ajoutée avec succès !");
                    break;
                case 3:
                    // Code pour ajouter une réservation
                    System.out.print("Identifiant de la réservation : ");
                    String identifiantReservation = scanner.next();
                    System.out.print("Statut de la réservation : ");
                    String statutReservation = scanner.next();

                    List<String> chambresReservees = new ArrayList<>();
                    System.out.print("Nombre de chambres réservées : ");
                    int nbChambres = scanner.nextInt();
                    for (int i = 0; i < nbChambres; i++) {
                        System.out.print("Numéro de la chambre réservée : ");
                        String numeroChambre = scanner.next();
                        chambresReservees.add(numeroChambre);
                    }

                    System.out.print("Identifiant du client : ");
                    String identifiantClient = scanner.next();
                    Client clientReservation = null;
                    for (Client c : monHotel.clients) {
                        if (c.identifiant.equals(identifiantClient)) {
                            clientReservation = c;
                            break;
                        }
                    }

                    if (clientReservation == null) {
                        System.out.println("Client introuvable.");
                        break;
                    }

                    Reservation reservation = new Reservation(identifiantReservation, statutReservation, chambresReservees, clientReservation);
                    monHotel.ajouterReservation(reservation);
                    System.out.println("Réservation ajoutée avec succès !");
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Option invalide. Veuillez sélectionner une option valide.");
            }
        }
    }
}
