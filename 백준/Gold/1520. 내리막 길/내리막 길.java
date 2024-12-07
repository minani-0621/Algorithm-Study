import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int[][] map;
	static int[][] dp;
	static int M, N;
	
	public static void main(String[] args) {
		M = scanner.nextInt();
		N = scanner.nextInt();
		map = new int[M][N];
		dp = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = scanner.nextInt();
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0, 0));
	}
	
	static int dfs(int x, int y) {
		if(x == M - 1 && y == N - 1) {
			return dp[x][y] = 1;
		}
		
		if(dp[x][y] != -1) {
			return dp[x][y];
		}
		
		dp[x][y] = 0;
		
		int[] mr = {-1, 1, 0, 0};
		int[] mc = {0, 0, -1, 1};
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + mr[i];
			int nextY = y + mc[i];
			
			if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && map[nextX][nextY] < map[x][y]) {
				dp[x][y] += dfs(nextX, nextY);
			}
		}
		
		return dp[x][y];
	}
}
