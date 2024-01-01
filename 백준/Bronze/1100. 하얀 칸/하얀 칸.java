import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static char board[][] = new char[8][8];
	static int count = 0;
	public static void main(String[] args) {
		for(int i = 0; i < 8; i++) {
			String tmp = scanner.nextLine();
			for(int j = 0; j < 8; j++) {
				board[i][j] = tmp.charAt(j);
			}
		}
		
		for(int k = 0; k < 4; k++) {
			checkOddLine(k * 2);
			checkEvenLine(k * 2 + 1);
		}
		
		System.out.printf("%d",count);
	}
	
	static void checkOddLine(int rowIndex) {
		for(int i = 0; i < 4; i++) {
			if(board[rowIndex][i * 2] == 'F')
				count++;
		}
		
	}
	
	static void checkEvenLine(int rowIndex) {
		for(int i = 0; i < 4; i++) {
			if(board[rowIndex][i * 2 + 1] == 'F')
				count++;
		}
	}
}