import java.io.*;

public class ChandyMisraHaasAlgo {
	public static int flag = 0;

	public static void main(String args[]) throws Exception {
		BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
		int init, aa, bb, x = 0, end = 5;
		File input = new File("Dependencymatrix.txt");
		@SuppressWarnings("resource")
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
		String line;
		int[][] a = new int[end][end];
//This code reads the dependency matrix from the file line by line and stores it into the 2D array a. It skips the first two lines because they contain headers.

		line = in.readLine();
		line = in.readLine();
		while ((line = in.readLine()) != null) {
			aa = 3;
			bb = 4;
			for (int y = 0; y < end; y++) {
				a[x][y] = Integer.parseInt(line.substring(aa, bb));
				aa += 2;
				bb += 2;
			}
			x++;
		}

		System.out.println();
		System.out.println(" Chandy Mishra Hass algorithm for Deadlock Management");
		System.out.println();
//This code prints the dependency matrix in tabular format.
		System.out.println("\tS1\tS2\tS3\tS4\tS5");
		for (int i = 0; i < end; i++) {
			System.out.print("S" + (i + 1) + "\t");
			for (int j = 0; j < end; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.print("Enter Initiator Site No. : ");
		init = Integer.parseInt(ob.readLine());
		int j = init - 1;
		System.out.println();
		System.out.println();
		System.out.println(" DIRECTION\tPROBE");
		System.out.println();
		for (int k = 0; k < end; k++) {
			if (a[j][k] == 1) {
				System.out.println(
						" S" + (j + 1) + " --> S" + (k + 1) + "     (" + init + "," + (j + 1) + "," + (k + 1) + ")");
				aman(a, j, k);
			}
		}
//If flag remains 0, it means no deadlock was detected, so it prints a message indicating no deadlock was detected.
		if (flag == 0) {
			System.out.println();
			System.out.println(" NO DEADLOCK DETECTED");
		}
		ob.readLine();

	}

	public static void aman(int[][] a, int init, int k) {
		int end = 5;
		for (int x = 0; x < end; x++) {
			if (a[k][x] == 1) {
				if (init == x) {
					System.out.println(" S" + (k + 1) + " --> S" + (x + 1) + "     (" + (init + 1) + "," + (k + 1) + ","
							+ (x + 1) + ")" + " --------> DEADLOCK DETECTED");
					flag = 1;
					break;
				}
				System.out.println(" S" + (k + 1) + " --> S" + (x + 1) + "     (" + (init + 1) + "," + (k + 1) + ","
						+ (x + 1) + ")");
				aman(a, init, x);
			}
		}
	}
}
