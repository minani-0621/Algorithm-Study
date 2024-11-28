import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[][] map;
	static boolean[][] visited;
	static int R, C, K, caseCount = 0;
	
	public static void main(String[] args) throws IOException { 
		String input = br.readLine();
		String[] inputArr = input.split(" ");
		
		R = Integer.parseInt(inputArr[0]);
		C = Integer.parseInt(inputArr[1]);
		K = Integer.parseInt(inputArr[2]);
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			String oneLine = br.readLine();
			
			for(int j = 0; j < C; j++) {
				map[i][j] = oneLine.charAt(j);
			}
		}
		
		dfs(R - 1, 0, 1);
		System.out.println(caseCount);
	}
	
	static void dfs(int x, int y, int dist) {
		if(x == 0 && y == C - 1 && dist == K) {
			caseCount++;
			return;
		}
		
		visited[x][y] = true;
		
		int[] mr = {-1, 1, 0, 0};
		int[] mc = {0, 0, -1, 1};
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + mr[i];
			int nextY = y + mc[i];
			int nextDist = dist + 1;
			
			if(nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && !visited[nextX][nextY] && map[nextX][nextY] != 'T') {
				dfs(nextX, nextY, nextDist);
			}
		}
		
		visited[x][y] = false;
	}
}
