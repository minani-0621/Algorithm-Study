import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static class Node {
		int x, y, distance;
		public Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
		
		int maxSafeDistance = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				visited = new boolean[n][m];
				
				if(map[i][j] == 0) {
					int distance = bfs(i, j);
					
					if(distance > maxSafeDistance) {
						maxSafeDistance = distance;
					}
				}
			}
		}
		
		System.out.println(maxSafeDistance);
	}
	
	static int bfs(int startX, int startY) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startX, startY, 0)); 
		visited[startX][startY] = true;
		int safeDistance = 0;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(map[checkNode.x][checkNode.y] == 1) {
				return checkNode.distance;
			}
			
			//상, 하, 좌, 우, 대각선 8방향
			int[] mr = {-1, 0, 1, -1, 1, -1, 0, 1};
			int[] mc = {-1, -1, -1, 0, 0, 1, 1, 1};
			
			for(int i = 0; i < 8; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY]) {
					queue.offer(new Node(nextX, nextY, checkNode.distance + 1));
					visited[nextX][nextY] = true;
				}
			}
		}
		
		return -1;
	}
}
