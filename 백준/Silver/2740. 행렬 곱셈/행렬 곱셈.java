import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n, m, k;
	static int matrixA[][], matrixB[][], matrixMultiply[][];
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		matrixA = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				matrixA[i][j] = scanner.nextInt();
			}
		}
		
		m = scanner.nextInt();
		k = scanner.nextInt();
		
		matrixB = new int[m][k];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < k; j++) {
				matrixB[i][j] = scanner.nextInt();
			}
		}
		
		matrixMultiply = new int[n][k];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < k; j++) {
				matrixMultiply[i][j] = calcMultiply(matrixA, matrixB, i, j);
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < k; j++) {
				System.out.printf("%d ", matrixMultiply[i][j]);
			}
			System.out.println();
		}
	}

	public static int calcMultiply(int matrix1[][], int matrix2[][], int x, int y) { // 두 행렬의 곱셈으로 생긴 matrixMultiply의 각각의 배열요소 자리의 값을 구하는 메소드
		int result = 0;
		
		for(int i = 0; i < m; i++) {
			result += matrixA[x][i] * matrixB[i][y];
		}
		
		return result;
	}
}
