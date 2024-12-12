import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int[][] grid;
	static boolean[][] visited;
	static boolean[][] air;
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
		air = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				grid[i][j] = scanner.nextInt();
			}
		}
		
		int time = 0;
		
		while(true) {
			visited = new boolean[N][M];
			air = new boolean[N][M];
			airBfs(0, 0);
			removeCheese();
			
			if(!checkRemainCheese()) {
				System.out.println(time + 1);
				return;
			}else {
				time++;
			}
		}
	}
	
	static void airBfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y));
		visited[x][y] = true;
		air[x][y] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			int[] mr = {-1, 1, 0, 0};
			int[] mc = {0, 0, -1, 1};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && grid[nextX][nextY] == 0 && !visited[nextX][nextY]) {
					queue.offer(new Node(nextX, nextY));
					visited[nextX][nextY] = true;
					air[nextX][nextY] = true;
				}
			}
		}
		
	}
	
	static void removeCheese() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!air[i][j] && grid[i][j] == 1) {
					int[] mr = {-1, 1, 0, 0};
					int[] mc = {0, 0, -1, 1};
					int airNear = 0;
					
					for(int k = 0; k < 4; k++) {
						int nextX = i + mr[k];
						int nextY = j + mc[k];
						
						if(air[nextX][nextY]) {
							airNear++;
						}
					}
					
					if(airNear >= 2) {
						grid[i][j] = 0;
					}
				}
			}
		}
	}
	
	static boolean checkRemainCheese() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(grid[i][j] == 1) {
					return true;
				}
			}
		}
		
		return false;
	}
}
