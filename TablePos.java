package exo;

public class TablePos {
    public static void main(String[] args) {
        int[] tableausource = new int[] {-5, 3, 24, -12, -10, 5, 100, -2, -71, 0};
        int[] tableauDestination = new int[tableausource.length];
        int indexpos = 0;
        for (int i = 0; i < tableausource.length; i++) {
            if (tableausource[i] > 0) {
                tableauDestination[indexpos] = tableausource[i];
                indexpos++;
            }
        }
        for (int i = 0; i < tableauDestination.length; i++) {
            System.out.print(tableauDestination[i] + " ");
        }



    }
}
