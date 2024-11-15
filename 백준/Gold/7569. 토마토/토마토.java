import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int[][][] grid;
	static boolean[][][] visited;
	static int m, n, h;
	static Queue<Point> queue = new LinkedList<>();
	static class Point {
		int x;
		int y;
		int z;
		int day;
		public Point(int x, int y, int z, int day) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.day = day;
		}
	}
	
	public static void main(String[] args) {
		m = scanner.nextInt();
		n = scanner.nextInt();
		h = scanner.nextInt();
		
		grid = new int[n][m][h];
		visited = new boolean[n][m][h];
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					grid[j][k][i] = scanner.nextInt();
				}
			}
		}	
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					if(grid[j][k][i] == 1) {
						queue.offer(new Point(j, k, i, 0));
						visited[j][k][i] = true;
					}
				}
			}
		}
		
		int countDay = bfs();
		boolean isRipe = true;
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					if(grid[j][k][i] == 0) {
						isRipe = false;
					}
				}
			}
		}
		
		if(!isRipe) {
			System.out.println(-1);
		}else {
			System.out.println(countDay);
		}
	}
	
	static int bfs() {
		int maxDay = 0;
		
		while(!queue.isEmpty()) {
			Point checkNode = queue.poll();
			
			int[] mx = {0, 0, -1, 1, 0, 0};
			int[] my = {0, 0, 0, 0, 1, -1};
			int[] mz = {1, -1, 0, 0, 0, 0};
			
			for(int i = 0; i < 6; i++) {
				int nextX = checkNode.x + mx[i];
				int nextY = checkNode.y + my[i];
				int nextZ = checkNode.z + mz[i];
				int nextDay = checkNode.day + 1;
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && nextZ >= 0 && nextZ < h && !visited[nextX][nextY][nextZ] && grid[nextX][nextY][nextZ] == 0) {
					queue.offer(new Point(nextX, nextY, nextZ, nextDay));
					visited[nextX][nextY][nextZ] = true;
					grid[nextX][nextY][nextZ] = 1;
					
					if(maxDay < nextDay) {
						maxDay = nextDay;
					}
				}
			}
		}
		
		return maxDay;
	}
}
