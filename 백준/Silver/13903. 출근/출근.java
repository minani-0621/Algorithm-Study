import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int R, C, N;
	static int[][] map;
	static boolean[][] visited;
	static class Node {
		int x, y, dist;
		public Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) {
		R = scanner.nextInt();
		C = scanner.nextInt();
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
		
		N = scanner.nextInt();
		
		int[] mr = new int[N];
		int[] mc = new int[N];
		
		for(int i = 0; i < N; i++) {
			mr[i] = scanner.nextInt();
			mc[i] = scanner.nextInt();
		}
		
		System.out.println(bfs(mr, mc));
	}
	
	static int bfs(int[] mr, int[] mc) {
		Queue<Node> queue = new LinkedList<>();
		
		for(int i = 0; i < C; i++) {
			if(map[0][i] == 1) {
				queue.offer(new Node(0, i, 0));
				visited[0][i] = true;
			}
		}
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.x == R - 1) {
				return checkNode.dist;
			}
			
			for(int i = 0; i < N; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				int nextDist = checkNode.dist + 1;
				
				if(nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
					queue.offer(new Node(nextX, nextY, nextDist));
					visited[nextX][nextY] = true;
				}
			}
		}
		
		return -1;
	}
}
