import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int board[][] = new int[9][9];
	static int most;
	static int row;
	static int col;
	
	public static void main(String[] args) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				int num = scanner.nextInt();
				board[i][j] = num;
			}
		}
		
		most = 0;
		row = 0;
		col = 0;
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(most <= board[i][j]) {
					most = board[i][j];
					row = i + 1;
					col = j + 1;
				}
			}
		}
		
		System.out.printf("%d\n", board[row - 1][col - 1]);
		System.out.printf("%d %d", row, col);
	}
}