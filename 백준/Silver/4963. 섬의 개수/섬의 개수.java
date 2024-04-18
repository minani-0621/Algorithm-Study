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
	static int islandCount;
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		while(true) {
			int w = scanner.nextInt();
			int h = scanner.nextInt();
			
			if(w == 0 && h == 0) {
				break;
			}
			
			map = new int[h][w];
			visited = new boolean[h][w];
			islandCount = 0;
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					map[i][j] = scanner.nextInt();
				}
			}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						bfs(map, i, j, w, h);
						islandCount++;
					}
				}
			}
			
			bw.write(islandCount + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static void bfs(int[][] map, int startX, int startY, int h, int w) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(startX, startY));
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			Point checkNode = queue.poll();
			// checkNode 주위의 8방향에 있는 노드 탐색
			int[] mr = {-1, 0, 1, -1, 1, -1, 0, 1};
			int[] mc = {-1, -1, -1, 0, 0, 1, 1, 1};
			for(int i = 0; i < 8; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				if(nextX >= 0 && nextX < w && nextY >= 0 && nextY < h && map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
					queue.offer(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
		}
	}
}
