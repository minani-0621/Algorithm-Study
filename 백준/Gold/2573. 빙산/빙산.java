import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int[][] mapBefore;
	static int[][] mapAfter;
	static boolean[][] visited;
	static int n, m;
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
		
		mapBefore = new int[n][m];
		mapAfter = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int ice = scanner.nextInt();
				mapBefore[i][j] = ice;
				mapAfter[i][j] = ice;
			}
		}
		
		int period = 0;
		
		while(true) {
			visited = new boolean[n][m];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(mapBefore[i][j] != 0 && !visited[i][j]) {
						bfs(i, j);
					}
				}
			}
			
			mapBefore = mapAfter;
			mapAfter = new int[n][m];
			visited = new boolean[n][m];
			int icebergCount = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(mapBefore[i][j] != 0 && !visited[i][j]) {
						countIceberg(i, j);
						icebergCount++;
					}
				}
			}
			
			period++;
			
			if(icebergCount == 0) {
				System.out.println(0);
				break;
			}else if(icebergCount >= 2) {
				System.out.println(period);
				break;
			}
		}
	}
	
	static void bfs(int startX, int startY) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startX, startY));
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			int[] mr = {-1, 1, 0, 0};
			int[] mc = {0, 0, -1, 1};
			int meltingCount = 0;
			
			for(int i = 0; i < 4; i++) {
				int checkX = checkNode.x + mr[i];
				int checkY = checkNode.y + mc[i];
				
				if(checkX >= 0 && checkX < n && checkY >= 0 && checkY < m && mapBefore[checkX][checkY] == 0) {
					meltingCount++;
				}
			}
			
			int remainIce = mapBefore[checkNode.x][checkNode.y] - meltingCount;
			mapAfter[checkNode.x][checkNode.y] = remainIce < 0 ? 0 : remainIce;
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY] && mapBefore[nextX][nextY] != 0) {
					queue.offer(new Node(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
		}
	}
	
	static void countIceberg(int startX, int startY) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startX, startY));
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			int[] mr = {-1, 1, 0, 0};
			int[] mc = {0, 0, -1, 1};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY] && mapBefore[nextX][nextY] != 0) {
					queue.offer(new Node(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
		}
	}
}
