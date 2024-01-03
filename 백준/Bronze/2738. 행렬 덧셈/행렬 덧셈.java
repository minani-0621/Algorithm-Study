import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n, m;
	static int matrix1[][];
	static int matrix2[][];
	static int matrix3[][];
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		matrix1 = new int[n][m];
		matrix2 = new int[n][m];
		matrix3 = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int input = scanner.nextInt();
				matrix1[i][j] = input;
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int input = scanner.nextInt();
				matrix2[i][j] = input;
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
				System.out.printf("%d ", matrix3[i][j]);
			}
			System.out.println();
		}
	}
}
