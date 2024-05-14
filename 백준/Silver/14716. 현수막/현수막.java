import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	static int n, m;
	static int[][] grid;
	static boolean[][] visited;
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		m = scanner.nextInt();
		n = scanner.nextInt();
		
		grid = new int[m][n];
		visited = new boolean[m][n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				grid[i][j] = scanner.nextInt();
			}
		}
		
		int wordCount = 0;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					wordCount++;
				}
			}
		}
		
		System.out.println(wordCount);
	}
	
	static void bfs(int startX, int startY) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(startX, startY));
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			Point checkNode = queue.poll();
			// 상하좌우, 대각선 8방향
			int[] mr = {-1, 0, 1, -1, 1, -1, 0, 1};
			int[] mc = {-1, -1, -1, 0, 0, 1, 1, 1};
			
			for(int i = 0; i < 8; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY] && grid[nextX][nextY] == 1) {
					queue.offer(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
		}
	}
}
