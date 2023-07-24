package exo;

public class HundredElem {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(i + " ");

        }
    }
}
