import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] map;
	static boolean[][] visited;
	static int earthWormsCount;
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int t = scanner.nextInt();
		
		for(int i = 0; i < t; i++) {
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			
			map = new int[m][n];
			visited = new boolean[m][n];
			earthWormsCount = 0;
			
			for(int j = 0; j < k; j++) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				
				map[x][y] = 1;
			}
			
			for(int j = 0; j < m; j++) {
				for(int l = 0; l < n; l++) {
					if(map[j][l] == 1 && !visited[j][l]) {
						bfs(map, m, n, j, l);
						earthWormsCount++;
					}
				}
			}
			
			bw.write(earthWormsCount + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static void bfs(int[][] map, int m, int n, int startX, int startY) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(startX, startY));
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			Point checkNode = queue.poll();
			// 상,하,좌,우
			int[] mr = {0, 0, -1, 1};
			int[] mc = {1, -1, 0 ,0};
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
					queue.offer(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
		}
	}
}
