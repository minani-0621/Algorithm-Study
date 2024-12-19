import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		N = scanner.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
		
		boolean result = jellyBfs(0, 0);
		
		if(result) {
			System.out.println("HaruHaru");
		}else {
			System.out.println("Hing");
		}
	}
	
	static boolean jellyBfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.x == N - 1 && checkNode.y == N - 1) {
				return true;
			}
			
			int[] mr = {1, 0};
			int[] mc = {0, 1};
			
			for(int i = 0; i < 2; i++) {
				int nextX = checkNode.x + map[checkNode.x][checkNode.y] * mr[i];
				int nextY = checkNode.y + map[checkNode.x][checkNode.y] * mc[i];
				
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextX][nextY]) {
					queue.offer(new Node(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
		}
		
		return false;
	}
}
