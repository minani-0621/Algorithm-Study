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
	
	static int r, c;
	static int wolfCount = 0, sheepCount = 0;
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
		String size = br.readLine();
		String sizeArray[] = size.split(" ");
		r = Integer.parseInt(sizeArray[0]);
		c = Integer.parseInt(sizeArray[1]);
		
		map = new char[r][c];
		visited = new boolean[r][c];
		
		for(int i = 0; i < r; i++) {
			String oneLine = br.readLine();
			
			for(int j = 0; j < c; j++) {
				map[i][j] = oneLine.charAt(j);
			}
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] != '#' && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		bw.write(sheepCount + " " + wolfCount);
		bw.flush();
		bw.close();
	}
	
	static void bfs(int startX, int startY) {
		int wolfCnt = 0, sheepCnt = 0;
		
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(startX, startY));
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			Point checkNode = queue.poll();
			
			if(map[checkNode.x][checkNode.y] == 'v') {
				wolfCnt++;
			}else if(map[checkNode.x][checkNode.y] == 'o') {
				sheepCnt++;
			}
			// 상,하,좌,우
			int[] mr = {0, 0, -1, 1};
			int[] mc = {-1, 1, 0, 0};
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < r && nextY >= 0 && nextY < c && !visited[nextX][nextY] && map[nextX][nextY] != '#') {
					queue.offer(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
		}
		
		if(sheepCnt > wolfCnt) {
			sheepCount += sheepCnt;
		}else if(sheepCnt <= wolfCnt){
			wolfCount += wolfCnt;
		}
	}
}
