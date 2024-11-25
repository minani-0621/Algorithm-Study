import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[][] grid;
	static boolean[][] visited;
	static int N, M;
	static boolean result = false;
	
	public static void main(String[] args) throws IOException {
		String input = br.readLine();
		String[] inputArr = input.split(" ");
		N = Integer.parseInt(inputArr[0]);
		M = Integer.parseInt(inputArr[1]);
		grid = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String oneLine = br.readLine();
			
			for(int j = 0; j < oneLine.length(); j++) {
				grid[i][j] = oneLine.charAt(j);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j]) {
					dfs(i, j, i, j, grid[i][j], 1);
				}
			}
		}
		
		if(result) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
	
	static void dfs(int startX, int startY, int x, int y, char dot, int count) {
		visited[x][y] = true;
		
		int[] mr = {-1, 1, 0, 0};
		int[] mc = {0, 0, -1, 1};
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + mr[i];
			int nextY = y + mc[i];
			int nextCount = count + 1;
			
			if(nextX == startX && nextY == startY && nextCount >= 4) {
				result = true;
				return;
			}
			
			if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextX][nextY] && grid[nextX][nextY] == dot) {
				dfs(startX, startY, nextX, nextY, dot, nextCount);
			}
		}
		
		visited[x][y] = false;
	}
}
