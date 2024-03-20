
public class dbc {

    public static void main(String[] args) {
        int n_rows = 4;

        for (int i = 0; i < n_rows; i++) {
            // Print leading spaces
            for(int k=0;k<=n_rows-i-1; k++){
                System.out.print(" ");
            }

            // Print asterisks
            for (int j = n_rows-i-1; j < n_rows; j++) {
                System.out.print("*");
                // System.out.print("("+i+" , "+ j +" )");
            }

            System.out.println();
        }
    }
}
