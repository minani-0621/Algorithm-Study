import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int row, col;
	static String encryption;
	static String matrix[][];
	static int index = 0;
	
	public static void main(String[] args) {
		col = scanner.nextInt();
		encryption = scanner.next();
		
		int length = encryption.length();
		row = length / col;
		
		matrix = new String[row][col];
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(i % 2 == 0) {
					matrix[i][j] = encryption.substring(index, index + 1);
					index++;
				}
				else if(i % 2 == 1) {
					matrix[i][col - j - 1] = encryption.substring(index, index + 1);
					index++;
				}
			}
		}
		
		for(int i = 0; i < col; i++) {
			for(int j = 0; j < row; j++) {
				System.out.printf("%s", matrix[j][i]);
			}
		}
	}
}
