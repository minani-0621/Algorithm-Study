import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int h, w;
	static char[][] map;
	static boolean[][] visited;
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			String size = br.readLine();
			String[] sizeArr = size.split(" ");
			h = Integer.parseInt(sizeArr[0]);
			w = Integer.parseInt(sizeArr[1]);
			
			map = new char[h][w];
			visited = new boolean[h][w];
			
			for(int j = 0; j < h; j++) {
				String oneLine = br.readLine();
				
				for(int k = 0; k < w; k++) {
					map[j][k] = oneLine.charAt(k);
				}
			}
			
			int count = 0;
			
			for(int j = 0; j < h; j++) {
				for(int k = 0; k < w; k++) {
					if(map[j][k] == '#' && !visited[j][k]) {
						bfs(j, k);
						count++;
					}
				}
			}
			
			bw.write(count + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static void bfs(int startX, int startY) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(startX, startY));
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			Point checkNode = queue.poll();
			// 상,하,좌,우
			int[] mr = {0, 0, -1, 1};
			int[] mc = {-1, 1, 0, 0};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < h && nextY >= 0 && nextY < w && map[nextX][nextY] == '#' && !visited[nextX][nextY]) {
					queue.offer(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
		}
	}
}
