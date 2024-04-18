import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		map = new int[n][n];
		ArrayList<Integer> caseList = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
		
		for(int rainfall = 0; rainfall <= 100; rainfall++) {
			int safetyZoneCount = 0;
			visited = new boolean[n][n];
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if(map[j][k] > rainfall && !visited[j][k]) {
						bfs(map, j, k, rainfall, n);
						safetyZoneCount++;
					}
				}
			}
			caseList.add(safetyZoneCount);
		}
		Collections.sort(caseList, Collections.reverseOrder());
		System.out.println(caseList.get(0));
	}
	
	static void bfs(int[][] map, int startX, int startY, int rainfall, int n) {
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
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY] && map[nextX][nextY] > rainfall) {
					queue.offer(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
			
		}
	}
}
