package exo;

import java.util.Scanner;

public class SomConsec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un entier :");
        int result = 0;
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            result += i;
            System.out.println(String.format("Somme des entiers de 1 à %d = %d", i, result));
        }


    }
}