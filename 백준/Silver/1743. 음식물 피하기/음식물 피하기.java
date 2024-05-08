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
	static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		n = scanner.nextInt(); // 세로 길이
		m = scanner.nextInt(); // 가로 길이
		int k = scanner.nextInt(); // 음식물 쓰레기 개수
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < k; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			
			map[x - 1][y - 1] = 1;
		}
		
		ArrayList<Integer> caseList = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					caseList.add(bfs(i, j));
				}
			}
		}
		
		Collections.sort(caseList, Collections.reverseOrder());
		
		System.out.println(caseList.get(0));
	}
	
	static int bfs(int startX, int startY) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(startX, startY));
		visited[startX][startY] = true;
		int count = 1;
		
		while(!queue.isEmpty()) {
			Point checkNode = queue.poll();
			// 상,하,좌,우
			int mr[] = {0, 0, -1, 1};
			int mc[] = {1, -1, 0, 0};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY] && map[nextX][nextY] == 1) {
					queue.offer(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
					count++;
				}
			}
		}
		
		return count;
	}
}
