package exo;

import java.util.Scanner;

public class Slide75{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un caractère :");
        char c = scanner.next().charAt(0);
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
            System.out.println(String.format("%s est une lettre de l'alphabet", c));
        } else if (c >= '0' && c <= '9') {
            System.out.println(String.format("%s est un chiffre.", c));
        } else {
            System.out.println(String.format("%s est un caractère spécial.", c));
        }
    }
}
