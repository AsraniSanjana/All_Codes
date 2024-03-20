
public class abd {

    public static void main(String[] args) {
        int n_rows=4;
        for(int i=0; i<n_rows; i++){
            for(int j=0;j<=n_rows-i-1; j++){
                System.out.print("("+i+" , "+ j +" )");
            }
            System.out.println();
        }

    }
    
}
