import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static char[][] map;
	static boolean[][] visited;
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		String size = br.readLine();
		String[] arr = size.split(" ");
		n = Integer.parseInt(arr[0]); // 가로 크기
		m = Integer.parseInt(arr[1]); // 세로 크기
		
		map = new char[m][n];
		visited = new boolean[m][n];
		
		for(int i = 0; i < m; i++) {
			String oneLine = br.readLine();
			for(int j = 0; j < n; j++) {
				map[i][j] = oneLine.charAt(j);
			}
		}
		
		int sumW = 0;
		int sumB = 0;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j] && map[i][j] == 'W') {
					sumW += Math.pow(bfs(i, j, 'W'), 2);
				}
			}
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j] && map[i][j] == 'B') {
					sumB += Math.pow(bfs(i, j, 'B'), 2);
				}
			}
		}
		
		bw.write(sumW + " " + sumB);
		bw.flush();
		bw.close();
	}
	
	static int bfs(int startX, int startY, char ch) {
		int count = 1;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(startX, startY));
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			Point checkNode = queue.poll();
			
			// 상,하,좌,우
			int[] mr = {0, 0, -1, 1};
			int[] mc = {1, -1, 0, 0};
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY] && map[nextX][nextY] == ch) {
					queue.offer(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
					count++;
				}
			}
		}
		
		return count;
	}
}
