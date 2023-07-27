package exo;

import java.util.Scanner;

public class MaxValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        int [] tableau = new int[6];
        for (int i = 0; i < tableau.length; i++) {
            System.out.println("Enter a number: ");
            tableau[i] = scanner.nextInt();
        }
    }
}
