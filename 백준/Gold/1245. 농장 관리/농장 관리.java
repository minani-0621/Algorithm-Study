import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int count = 0;
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
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
					if(!visited[i][j] && bfs(i, j)) {
						count++;
					}
			}
		}
		
		System.out.println(count);
	}
	
	static boolean bfs(int startX, int startY) {
		Queue<Node> queue = new LinkedList<>();
		Queue<Node> tmpQueue = new LinkedList<>();
		queue.offer(new Node(startX, startY));
		tmpQueue.offer(new Node(startX, startY));
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) { // 높이가 같은 격자 집합을 구하는 로직
			Node checkNode = queue.poll();
			
			// 인접한 8방향
			int[] mr = {-1, 0, 1, -1, 1, -1, 0, 1};
			int[] mc = {-1, -1, -1, 0, 0, 1, 1, 1};
			
			for(int i = 0; i < 8; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY] && map[checkNode.x][checkNode.y] == map[nextX][nextY]) {
					queue.offer(new Node(nextX, nextY));
					tmpQueue.offer(new Node(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
		}
		
		while(!tmpQueue.isEmpty()) { // 구해놓은 같은 격자의 집합이 산봉우리가 될 수 있는지 주변 탐색
			Node checkNode = tmpQueue.poll();
			
			// 인접한 8방향
			int[] mr = {-1, 0, 1, -1, 1, -1, 0, 1};
			int[] mc = {-1, -1, -1, 0, 0, 1, 1, 1};
			
			for(int i = 0; i < 8; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && map[checkNode.x][checkNode.y] < map[nextX][nextY]) {
					return false;
				}
			}
		}
		
		return true;
	}
}
