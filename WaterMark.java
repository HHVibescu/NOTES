package exo;

public class WaterMark {
    public int PoidsVide;
    public int CapaciteMax;
    public int NiveauRemplissage;

    public void remplir(float mt) {
        if (NiveauRemplissage + mt > CapaciteMax) {
            System.out.println("La bouteille est pleine");
        } else {
            NiveauRemplissage += mt;
        }
        public void vider(float mt){
            if (NiveauRemplissage - mt < PoidsVide) {
                System.out.println("La bouteille est vide");
            } else {
                NiveauRemplissage -= mt;
            }

            public static void main (String[]args){
                WaterMark bouteille = new WaterMark();
                bouteille.PoidsVide = 100;
                bouteille.CapaciteMax = 1000;
                bouteille.NiveauRemplissage = 0;
                bouteille.remplir(500);
                bouteille.vider(200);
                System.out.println(bouteille.NiveauRemplissage);

            }

        }
    }