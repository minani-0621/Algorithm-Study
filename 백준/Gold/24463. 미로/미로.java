import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static char[][] map;
	static boolean[][] visited;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		String input = br.readLine();
		String[] inputArr = input.split(" ");
		
		N = Integer.parseInt(inputArr[0]);
		M = Integer.parseInt(inputArr[1]);
		
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String oneLine = br.readLine();
			
			for(int j = 0; j < M; j++) {
				map[i][j] = oneLine.charAt(j);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i == 0 || j == 0 || i == N - 1 || j == M - 1) {
					if(map[i][j] == '.' && !visited[i][j]) {
						dfs(i, j, i, j);
					}
				}
			}
		}
				
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j] == '.') {
					bw.write('@');
				}else if(map[i][j] == '+' || (visited[i][j] && map[i][j] == '.')) {
					bw.write(map[i][j]);
				}
			}
			
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static boolean dfs(int startX, int startY, int x, int y) {
		if((x == 0 || y == 0 || x == N - 1 || y == M - 1) && (x != startX || y != startY)) {
			visited[x][y] = true;
			return true;
		}
		
		visited[x][y] = true;
		
		int[] mr = {-1, 1, 0, 0};
		int[] mc = {0, 0, -1, 1};
		
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + mr[i];
			int nextY = y + mc[i];
			
			if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextX][nextY] && map[nextX][nextY] == '.') {
				if(dfs(startX, startY, nextX, nextY)) {
					return true;
				}
			}
		}
		
		visited[x][y] = false;
		return false;
	}
}
