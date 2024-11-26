import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static char[][] grid;
	static Boolean[][] visited;
	static int N, M;
	static int caseCount = 0;
	
	public static void main(String[] args) throws IOException {
		String input = br.readLine();
		String[] inputArr = input.split(" ");
		N = Integer.parseInt(inputArr[0]);
		M = Integer.parseInt(inputArr[1]);
		
		grid = new char[N][M];
		visited = new Boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String oneLine = br.readLine();
			
			for(int j = 0; j < M; j++) {
				grid[i][j] = oneLine.charAt(j);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {	
				if(dfs(i, j)) {
					caseCount++;
				}
			}
		}
		
		System.out.println(caseCount);
	}
	
	static boolean dfs(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) {
			return true;
		}
		
		if(visited[x][y] != null) {
			return visited[x][y];
		}
		
		visited[x][y] = false;
		int nextX = x;
		int nextY = y;
		
		switch(grid[x][y]) {
			case 'U': nextX--; break;
			case 'D': nextX++; break;
			case 'L': nextY--; break;
			case 'R': nextY++; break;
		}
		
		visited[x][y] = dfs(nextX, nextY);
		return visited[x][y];
	}
}
