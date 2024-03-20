
public class abc {

    public static void main(String[] args) {
        int n_rows = 4;

        for (int i = 0; i < n_rows; i++) {
            // Print leading spaces
            for (int k = 0; k < i; k++) {
                System.out.print(" ");
            }

            // Print asterisks
            for (int j = i; j < n_rows; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
