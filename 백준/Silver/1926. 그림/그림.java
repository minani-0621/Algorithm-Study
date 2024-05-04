import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	static int n, m;
	static int[][] grid;
	static boolean[][] visited;
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		n = scanner.nextInt(); // 새로
		m = scanner.nextInt(); // 가로
		
		grid = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				grid[i][j] = scanner.nextInt();
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid[i][j] == 1 && !visited[i][j]) {
					list.add(bfs(i, j));
				}
			}
		}
		
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list.size());
		
		if(list.size() == 0) {
			System.out.println(0);
		}else {
			System.out.println(list.get(0));
		}
	}
	
	static int bfs(int startX, int startY) {
		int area = 0;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(startX, startY));
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			Point checkNode = queue.poll();
			area++;
			// 상,하,좌,우
			int[] mr = {0, 0, -1, 1};
			int[] mc = {1, -1, 0, 0};
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY] && grid[nextX][nextY] == 1) {
					queue.offer(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
		}
		
		return area;
	}
}
