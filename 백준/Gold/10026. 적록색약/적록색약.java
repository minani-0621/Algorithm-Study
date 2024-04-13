import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static char[][] grid1, grid2;
	static boolean[][] visited1, visited2;
	static int nomalCount = 0; // 일반인에 대한 구역 수
	static int RGColorBlindCount = 0; // 적록색맹인에 대한 구역 수
	static class Point {
		int row, col;
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		grid1 = new char[n][n]; // 일반인에 대한 그리드
		grid2 = new char[n][n]; // 적록색맹인에 대한 그리드
		visited1 = new boolean[n][n]; // 일반인에 대한 방문여부 배열
		visited2 = new boolean[n][n]; // 적록색맹인에 대한 방문여부 배열
		
		for(int i = 0; i < n; i++) {
			String oneLine = scanner.next();
			
			for(int j = 0; j < n; j++) {
				grid1[i][j] = oneLine.charAt(j);
				grid2[i][j] = oneLine.charAt(j);
			}
		}
		// 적록색맹인은 G와 R을 구분 못하므로 grid2에서 R인 곳을 G로 대체.
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(grid2[i][j] == 'G') {
					grid2[i][j] = 'R';
				}
			}
		}
		// 일반인에 대한 구역의 수 구하는 부분.
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited1[i][j] && grid1[i][j] == 'R') {
					bfs(grid1, visited1, i, j, 'R', n);
					nomalCount++;
				}else if(!visited1[i][j] && grid1[i][j] == 'G') {
					bfs(grid1, visited1, i, j, 'G', n);
					nomalCount++;
				}else if(!visited1[i][j] && grid1[i][j] == 'B') {
					bfs(grid1, visited1, i, j, 'B', n);
					nomalCount++;
				}
			}
		}
		// 적록색맹인에 대한 구역의 수 구하는 부분.
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited2[i][j] && grid2[i][j] == 'R') {
					bfs(grid2, visited2, i, j, 'R', n);
					RGColorBlindCount++;
				}else if(!visited2[i][j] && grid2[i][j] == 'B') {
					bfs(grid2, visited2, i, j, 'B', n);
					RGColorBlindCount++;
				}
			}
		}
			
		System.out.print(nomalCount + " " + RGColorBlindCount);
	}
	
	static void bfs(char[][] grid, boolean[][] visited, int startRow, int startCol, char findColor, int size) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(startRow, startCol));
		visited[startRow][startCol] = true;
		// 상,하,좌,우
		int[] mr = {0, 0, -1, 1};
		int[] mc = {1, -1, 0, 0};
		
		while(!queue.isEmpty()) {
			Point checkNode = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nextRow = checkNode.row + mr[i];
				int nextCol = checkNode.col + mc[i];
				if(nextRow >= 0 && nextRow < size && nextCol >= 0 && nextCol < size && !visited[nextRow][nextCol] && grid[nextRow][nextCol] == findColor) {
					queue.offer(new Point(nextRow, nextCol));
					visited[nextRow][nextCol] = true;
				}
			}
		}
	}
}
