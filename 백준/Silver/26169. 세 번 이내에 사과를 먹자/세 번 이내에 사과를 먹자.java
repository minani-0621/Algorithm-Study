import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int[][] map = new int[5][5];
	static boolean[][] visited = new boolean[5][5];
	static int appleCount = 0;
	
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
		
		int r = scanner.nextInt();
		int c = scanner.nextInt();
		
		dfs(r, c, 0, 0);
		
		if(appleCount >= 2) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
	
	static void dfs(int x, int y, int dist, int eatApple) {
		visited[x][y] = true;
		appleCount = Math.max(appleCount, eatApple);
		
		int[] mr = {-1, 1, 0, 0};
		int[] mc = {0, 0, -1, 1};
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + mr[i];
			int nextY = y + mc[i];
			
			if(nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 5 && !visited[nextX][nextY] && dist <= 2 && map[nextX][nextY] != -1) {
				if(map[nextX][nextY] == 1) {
					dfs(nextX, nextY, dist + 1, eatApple + 1);
				}else {
					dfs(nextX, nextY, dist + 1, eatApple);
				}
			}
		}
		
		visited[x][y] = false;
	}
}
