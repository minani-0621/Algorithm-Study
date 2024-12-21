import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static char[][] grid;
	static boolean[][] visited;
	static class Node {
		int x, y;
		char shape;
		public Node(int x, int y, char shape) {
			this.x = x;
			this.y = y;
			this.shape = shape;
		}
	}
	
	public static void main(String[] args) throws IOException {
		String[] size = br.readLine().split(" ");
		N = Integer.parseInt(size[0]);
		M = Integer.parseInt(size[1]);
		
		grid = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String oneLine = br.readLine();
			
			for(int j = 0; j < M; j++) {
				grid[i][j] = oneLine.charAt(j);
			}
		}
		
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j]) {
					bfs(i, j, grid[i][j]);
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
	
	static void bfs(int x, int y, char shape) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y, shape));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(shape == '-') {
				int nextX = checkNode.x;
				int nextY = checkNode.y + 1;
				
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextX][nextY] && grid[nextX][nextY] == shape) {
					queue.offer(new Node(nextX, nextY, shape));
					visited[nextX][nextY] = true;
				}
			}else if(shape == '|') {
				int nextX = checkNode.x + 1;
				int nextY = checkNode.y;
				
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextX][nextY] && grid[nextX][nextY] == shape) {
					queue.offer(new Node(nextX, nextY, shape));
					visited[nextX][nextY] = true;
				}
			}
		}
	}
}
