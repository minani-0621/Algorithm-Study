import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static char[][] map;
	static boolean[][] visited;
	static int n;
	static int startCount = 0;
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception, IOException {
		n = Integer.parseInt(br.readLine());
		
		map = new char[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			String oneLine = br.readLine();
			
			for(int j = 0; j < n; j++) {
				map[i][j] = oneLine.charAt(j);
			}
		}
		/* 모든 시작 가능한 지점에서 bfs를 돌려서 F에 도달할 수 있는지 확인하는 알고리즘으로 구현하면 시간복잡도가 
		   너무 커지기 때문에, F에서 한 번만 bfs를 돌려서 방문 가능한 시작 지점 수를 세는 방식으로 구현 */
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 'F') {
					bfs(i, j);
				}				
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(visited[i][j] && map[i][j] == '.') {
					startCount++;
				}				
			}
		}
		
		System.out.println(startCount);
	}
	
	static void bfs(int startX, int startY) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(startX, startY));
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			Point checkNode = queue.poll();
			
			int[] mr = {-1, -1, -1, 0, 1, 1, 0};
			int[] mc = {-1, 0, 1, 1, 1, -1, -1};
			
			for(int i = 0; i < 7; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY] && map[nextX][nextY] == '.') {
					queue.offer(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
		}
	}
}
