import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int r, c;
	static char[][] map;
	static boolean[][] visited;
	static int maxDistance = 0;
	static HashSet<Character> checkAlphabet = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		String input = br.readLine();
		String[] inputArr = input.split(" ");
		
		r = Integer.parseInt(inputArr[0]);
		c = Integer.parseInt(inputArr[1]);
		
		map = new char[r][c];
		visited = new boolean[r][c];
		
		for(int i = 0; i < r; i++) {
			String oneLine = br.readLine();
			
			for(int j = 0; j < c; j++) {
				map[i][j] = oneLine.charAt(j);
			}
		}
		
		dfs(0, 0, 1);
		System.out.println(maxDistance);
	}
	
	static void dfs(int x, int y, int dist) {
		visited[x][y] = true;
		checkAlphabet.add(map[x][y]);
		maxDistance = Math.max(maxDistance, dist);
		
		int[] mr = {-1, 1, 0, 0};
		int[] mc = {0, 0, -1, 1};
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + mr[i];
			int nextY = y + mc[i];
			
			if(nextX >= 0 && nextX < r && nextY >= 0 && nextY < c && !visited[nextX][nextY] && !checkAlphabet.contains(map[nextX][nextY])) {
				dfs(nextX, nextY, dist + 1);
			}
		}
		
		visited[x][y] = false;
		checkAlphabet.remove(map[x][y]);
	}
}
