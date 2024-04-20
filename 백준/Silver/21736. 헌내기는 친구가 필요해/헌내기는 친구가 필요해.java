import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static char[][] map;
	static boolean[][] visited;
	static int n, m;
	static int personCount = 0;
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		map = new char[n][m];
		visited = new boolean[n][m];
		
		int doyeonX = 0, doyeonY = 0;
		
		for(int i = 0; i < n; i++) {
			String oneLine = scanner.next();
			
			for(int j = 0; j < m; j++) {
				map[i][j] = oneLine.charAt(j);
				if(map[i][j] == 'I') {
					doyeonX = i;
					doyeonY = j;
				}
			}
		}
		
		bfs(map, doyeonX, doyeonY, n, m);
		
		if(personCount == 0) {
			System.out.println("TT");
		}else {
			System.out.println(personCount);
		}
	}
	
	static void bfs(char[][] map, int startX, int startY, int n, int m) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(startX, startY));
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			Point checkNode = queue.poll();
			if(map[checkNode.x][checkNode.y] == 'P') {
				personCount++;
			}
			// 상,하,좌,우
			int[] mr = {0, 0, -1, 1};
			int[] mc = {-1, 1, 0, 0};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY] && map[nextX][nextY] != 'X') {
					queue.offer(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
		}
	}
}
