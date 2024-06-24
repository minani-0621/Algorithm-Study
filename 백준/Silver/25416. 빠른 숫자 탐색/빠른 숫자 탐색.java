import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
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
		map = new int[5][5];
		visited = new boolean[5][5];
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
		
		int r = scanner.nextInt();
		int c = scanner.nextInt();
		
		int result = bfs(r, c);

		System.out.println(result);
	}
	
	static int bfs(int startX, int startY) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startX, startY, 0));
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(map[checkNode.x][checkNode.y] == 1) {
				return checkNode.distance;
			}
			
			// 상,하,좌,우
			int[] mr = {0, 0, -1, 1};
			int[] mc = {-1, 1, 0, 0};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				int nextDistance = checkNode.distance + 1;
				
				if(nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 5 && !visited[nextX][nextY] && map[nextX][nextY] != -1) {
					queue.offer(new Node(nextX, nextY, nextDistance));
					visited[nextX][nextY] = true;
				}
			}
		}
		
		return -1;
	}
}
