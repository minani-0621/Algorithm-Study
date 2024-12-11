import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int[][] map;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		map = new int[5][5];
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
		
		int startX = scanner.nextInt();
		int startY = scanner.nextInt();
		
		dfs(startX, startY, 0, 0);
		
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(answer);
		}
	}
	
	static void dfs(int x, int y, int moveCount, int eatAppleCount) {
		if(eatAppleCount == 3) {
			if(answer > moveCount) {
				answer = moveCount;
				return;
			}
		}
		
		int[] mr = {-1, 1, 0, 0};
		int[] mc = {0, 0, -1, 1};
		
		int temp = map[x][y];
		map[x][y] = -1;
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + mr[i];
			int nextY = y + mc[i];
			int nextMoveCount = moveCount + 1;
			
			if(nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 5 && map[nextX][nextY] != -1) {
				if(map[nextX][nextY] == 1) {
					dfs(nextX, nextY, nextMoveCount, eatAppleCount + 1);
				}else {
					dfs(nextX, nextY, nextMoveCount, eatAppleCount);
				}
			}
		}
		
		map[x][y] = temp;
	}
}
