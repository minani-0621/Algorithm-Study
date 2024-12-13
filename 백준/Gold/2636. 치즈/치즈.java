import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int N, M;
	static int[][] grid;
	static boolean[][] visited;
	static boolean[][] air;
	static int beforeRemainCheese;
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
			int cheeseCount = calcCheese();
			
			if(cheeseCount == 0) {
				System.out.println(time);
				System.out.println(beforeRemainCheese);
				break;
			}
			
			beforeRemainCheese = calcCheese();
			visited = new boolean[N][M];
			airSpread(0, 0);
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(grid[i][j] == 1) {
						removeCheese(i, j);
					}
				}
			}
			
			time++;
		}
	}
	
	static void airSpread(int x, int y) {
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
	
	static void removeCheese(int x, int y) {
		int[] mr = {-1, 1, 0, 0};
		int[] mc = {0, 0, -1, 1};
		
		for(int i = 0; i < 4; i++) {
			int checkX = x + mr[i];
			int checkY = y + mc[i];
			
			if(air[checkX][checkY]) {
				grid[x][y] = 0;
				break;
			}
		}
	}
	
	static int calcCheese() {
		int cheeseCount = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(grid[i][j] == 1) {
					cheeseCount++;
				}
			}
		}
		
		return cheeseCount;
	}
}
