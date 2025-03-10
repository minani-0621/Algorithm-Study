import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int[][] gridBefore;
	static int[][] gridAfter;
	static int[][] gridChange;
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
		
		gridBefore = new int[N][M];
		gridAfter = new int[N][M];
		gridChange = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				int value = scanner.nextInt();
				gridBefore[i][j] = value;
				gridChange[i][j] = value;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				gridAfter[i][j] = scanner.nextInt();
			}
		}
		
		int changeCount = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && gridBefore[i][j] != gridAfter[i][j]) {
					bfs(i, j);
					changeCount++;
				}
			}
		}
		
		boolean isSame = true;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(gridChange[i][j] != gridAfter[i][j]) {
					isSame = false;
					break;
				}
			}
		}
		
		if(!isSame) {
			System.out.println("NO");
		}else {
			if(changeCount >= 2) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
		}
	}
	
	static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y));
		visited[x][y] = true;
		int target = gridAfter[x][y];
		gridChange[x][y] = target;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			int[] mr = {-1, 1, 0, 0};
			int[] mc = {0, 0, -1, 1};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextX][nextY] && gridBefore[nextX][nextY] == gridBefore[x][y]) {
					queue.offer(new Node(nextX, nextY));
					visited[nextX][nextY] = true;
					gridChange[nextX][nextY] = target;
				}
			}
		}
	}
}