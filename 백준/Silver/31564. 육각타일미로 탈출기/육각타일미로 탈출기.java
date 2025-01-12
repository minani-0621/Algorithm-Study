import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static boolean[][] maze;
	static boolean[][] visited;
	static int N, M, K;
	static class Node {
		int x, y, dist;
		public Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) {
		N = scanner.nextInt();
		M = scanner.nextInt();
		K = scanner.nextInt();
		maze = new boolean[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < K; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			maze[x][y] = true; // 미로에 장애물이 있으면 true.
		}
		
		System.out.println(bfs(0, 0));
	}
	
	static int bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y, 0));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.x == N - 1 && checkNode.y == M - 1) {
				return checkNode.dist;
			}
			
			if(checkNode.x % 2 == 0) {
				int[] mr = {-1, -1, 0, 1, 1, 0};
				int[] mc = {-1, 0, 1, 0, -1, -1};
				
				for(int i = 0; i < 6; i++) {
					int nextX = checkNode.x + mr[i];
					int nextY = checkNode.y + mc[i];
					int nextDist = checkNode.dist + 1;
					
					if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextX][nextY] && !maze[nextX][nextY]) {
						queue.offer(new Node(nextX, nextY, nextDist));
						visited[nextX][nextY] = true;
					}
				}
			}else {
				int[] mr = {-1, -1, 0, 1, 1, 0};
				int[] mc = {0, 1, 1, 1, 0, -1};
				
				for(int i = 0; i < 6; i++) {
					int nextX = checkNode.x + mr[i];
					int nextY = checkNode.y + mc[i];
					int nextDist = checkNode.dist + 1;
					
					if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextX][nextY] && !maze[nextX][nextY]) {
						queue.offer(new Node(nextX, nextY, nextDist));
						visited[nextX][nextY] = true;
					}
				}
			}
		}
		
		return -1;
	}
}
