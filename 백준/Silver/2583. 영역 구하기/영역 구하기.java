import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static class Point {
		int x, y, count;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<Integer> result = new ArrayList<>();
	
	public static void main(String[] args) {
		m = scanner.nextInt(); // 새로
		n = scanner.nextInt(); // 가로
		int k = scanner.nextInt(); // 영역 개수
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < k; i++) {
			int x1 = scanner.nextInt();
			int y1 = scanner.nextInt();
			int x2 = scanner.nextInt();
			int y2 = scanner.nextInt();
			
			for(int j = x1; j < x2; j++) {// 0 ~ 3
				for(int l = y1; l < y2; l++) {// 2 ~ 3
					map[j][l] = 1;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0 && !visited[i][j]) {
					result.add(bfs(i, j));
				}
			}
		}
		
		Collections.sort(result);
		System.out.println(result.size());
		for(int i = 0; i < result.size(); i++) {
			System.out.printf("%d ", result.get(i));
		}
		
	}
	
	static int bfs(int startX, int startY) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(startX, startY));
		visited[startX][startY] = true;
		int maxCount = 1;
		
		while(!queue.isEmpty()) {
			Point checkNode = queue.poll();
			
			// 상,하,좌,우
			int[] mr = {0, 0, -1, 1};
			int[] mc = {1, -1, 0, 0};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY] && map[nextX][nextY] == 0) {
					queue.offer(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
					maxCount++;
				}
			}
		}
		
		return maxCount;
	}
}
