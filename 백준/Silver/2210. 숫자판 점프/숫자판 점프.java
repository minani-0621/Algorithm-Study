import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int[][] grid;
	
	public static void main(String[] args) {
		grid = new int[5][5];
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				grid[i][j] = scanner.nextInt();
			}
		}
		
		HashSet<String> hashset = new HashSet<>();
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				dfs(i, j, 0, "", hashset);
			}
		}
		
		System.out.println(hashset.size());
	}
	
	static void dfs(int x, int y, int move, String str, HashSet<String> hashset) {
		int[] mr = {-1, 1, 0, 0};
		int[] mc = {0, 0, -1, 1};
		
		if(move == 6) {
			hashset.add(str);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + mr[i];
			int nextY = y + mc[i];
			int nextMove = move + 1;
			
			if(nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 5) {
				dfs(nextX, nextY, nextMove, str.concat(String.valueOf(grid[x][y])), hashset);
			}
		}
	}
}
