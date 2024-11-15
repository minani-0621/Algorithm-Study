import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	static int[][] matrix;
	static boolean[][] visited;
	
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		matrix = new int[m][n];
		visited = new boolean[m][n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		
		boolean result = bfs(0, 0, m - 1, n - 1);
		
		if(result) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
	
	static boolean bfs(int startX, int startY, int destX, int destY) {
		boolean isPossible;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(startX, startY));
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			Point checkNode = queue.poll();
			
			if(checkNode.x == destX && checkNode.y == destY) {
				isPossible = true;
				return isPossible;
			}
			
			int[] mr = {1, 0};
			int[] mc = {0, 1};
			
			for(int i = 0; i < 2; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX <= destX && nextY >= 0 && nextY <= destY && !visited[nextX][nextY] && matrix[nextX][nextY] == 1) {
					queue.offer(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
		}
		
		isPossible = false;
		return isPossible;
	}
}
