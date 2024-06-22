import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	static int n, m;
	static int[][] grid;
	static boolean[][] visited;
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		grid = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				grid[i][j] = 0;
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = 0; k < 3; k++) {
					grid[i][j] += scanner.nextInt();
				}
				
				grid[i][j] /= 3;
			}
		}
		
		int t = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid[i][j] >= t) {
					grid[i][j] = 255;
				}else {
					grid[i][j] = 0;
				}
			}
		}
		
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid[i][j] == 255 && !visited[i][j]) {
					bfs(i, j);
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
	
	static void bfs(int startX, int startY) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startX, startY));
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			//상,하,좌,우
			int[] mr = {0, 0, -1, 1};
			int[] mc = {-1, 1, 0, 0};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY] && grid[nextX][nextY] == 255) {
					queue.offer(new Node(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
		}
	}
}
