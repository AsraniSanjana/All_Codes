
public class fractal {

    public static void main(String[] args) {
        int n_rows=4;
        for(int i=0; i<n_rows; i++){
            for(int j=i;j<n_rows; j++){
                for(int k=i;k<n_rows;k++){    //# of leading spaces

                    System.out.print("*");
                }
                System.out.print(" ");
            }
            System.out.println();
        }

    }
    
}
