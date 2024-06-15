import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[][] result;
	static class Node {
		int x, y, distance;
		public Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}
	public static void main(String[] args) throws IOException {		
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		map = new int[n][m];
		visited = new boolean[n][m];
		result = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = scanner.nextInt();
				
				if(map[i][j] == 0) {
					result[i][j] = 0;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 2) {
					bfs(i, j);
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visited[i][j] && map[i][j] != 0) {
					bw.write(-1 + " ");
				}else {
					bw.write(result[i][j] + " ");
				}
			}
			
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static void bfs(int startX, int startY) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startX, startY, 0));
		visited[startX][startY] = true;
		result[startX][startY] = 0;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			//상,하,좌,우
			int[] mr = {0, 0, -1, 1};
			int[] mc = {-1, 1, 0, 0};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY] && map[nextX][nextY] == 1) {
					queue.offer(new Node(nextX, nextY, checkNode.distance + 1));
					visited[nextX][nextY] = true;
					result[nextX][nextY] = checkNode.distance + 1;
				}
			}
		}
	}
}
