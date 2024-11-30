import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int[][] grid;
	static boolean[][] visited;
	static int N, M;
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		N = scanner.nextInt();
		M = scanner.nextInt();
		grid = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < M; j++) {
				grid[i][j] = scanner.nextInt();
			}
		}
		
		int sectionCount = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && grid[i][j] == 0) {
					bfs(i, j);
					sectionCount++;					
				}
			}
		}
		
		System.out.println(sectionCount);
	}
	
	static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			int[] mr = {-1, 1, 0, 0};
			int[] mc = {0, 0, -1, 1};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= N) {
					nextX = nextX % N;
				}else if(nextX < 0) {
					nextX = N + nextX;
				}
				
				if(nextY >= M) {
					nextY = nextY % M;
				}else if(nextY < 0) {
					nextY = M + nextY;
				}
				
				if(!visited[nextX][nextY] && grid[nextX][nextY] == 0) {
					queue.offer(new Node(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
		}
	}
}
