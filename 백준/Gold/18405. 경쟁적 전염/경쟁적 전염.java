import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int[][] grid;
	static boolean[][] visited;
	static class Point {
		int x, y, turn;
		public Point(int x, int y, int turn) {
			this.x = x;
			this.y = y;
			this.turn = turn;
		}
	}
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		grid = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				grid[i][j] = scanner.nextInt();
			}
		}
		
		int s = scanner.nextInt();
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		
		Queue<Point> queue = new LinkedList<>();
		
		for(int i = 1; i <= k; i++) {
			for(int j = 0; j < n; j++) {
				for(int l = 0; l < n; l++) {
					if(grid[j][l] == i) {
						queue.offer(new Point(j, l, 0));
						visited[j][l] = true;
					}
				}
			}
		}
		
		bfs(n, s, queue);
		
		System.out.println(grid[x - 1][y - 1]);
	}
	
	static void bfs(int n, int s, Queue<Point> queue) {		
		while(!queue.isEmpty()) {
			Point checkNode = queue.poll();
			
			if(checkNode.turn < s) {
				int[] mr = {-1, 1, 0, 0};
				int[] mc = {0, 0, -1, 1};
				
				for(int i = 0; i < 4; i++) {
					int nextX = checkNode.x + mr[i];
					int nextY = checkNode.y + mc[i];
					int nextTurn = checkNode.turn + 1;
					
					if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
						queue.offer(new Point(nextX, nextY, nextTurn));
						visited[nextX][nextY] = true;
						grid[nextX][nextY] = grid[checkNode.x][checkNode.y];
					}
				}
			}else {
				break;
			}
		}
	}
}
