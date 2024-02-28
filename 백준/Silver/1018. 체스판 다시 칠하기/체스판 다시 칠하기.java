import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<Integer> caseArray = new ArrayList<>();
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		char[][] board = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			String inputLine = scanner.next();
			
			for(int j = 0; j < m; j++) {
				board[i][j] = inputLine.charAt(j);
			}
		}
		
		for(int i = 0; i <= n - 8; i++) {
			for(int j = 0; j <= m - 8; j++) {
				caseArray.add(checkingBoard(i, j, board));
			}
		}
		
		Collections.sort(caseArray);
		
		System.out.println(caseArray.get(0));
	}

	static int checkingBoard(int i, int j, char board[][]) {
		int count = 0;
		
		if(board[i][j] == 'B') {
			for(int k = 0; k < 8; k++) {
				for(int l = 0; l < 8; l++) {
					if(((k % 2 == 0 && l % 2 == 0) || (k % 2 == 1 && l % 2 == 1)) && board[i + k][j + l] != 'B') {
						count++;
					}else if(((k % 2 == 0 && l % 2 == 1) || (k % 2 == 1 && l % 2 == 0)) && board[i + k][j + l] != 'W') {
						count++;
					}
				}
			}
		}else if(board[i][j] == 'W') {
			for(int k = 0; k < 8; k++) {
				for(int l = 0; l < 8; l++) {
					if(((k % 2 == 0 && l % 2 == 0) || (k % 2 == 1 && l % 2 == 1)) && board[i + k][j + l] != 'W') {
						count++;
					}else if(((k % 2 == 0 && l % 2 == 1) || (k % 2 == 1 && l % 2 == 0)) && board[i + k][j + l] != 'B') {
						count++;
					}
				}
			}
		}
		
		return Math.min(count, 64 - count);
	}
}
