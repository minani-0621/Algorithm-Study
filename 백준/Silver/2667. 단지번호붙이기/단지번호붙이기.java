import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int[][] map;
	static boolean[][] visited;
	static int n;
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
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			String oneLine = scanner.next();
			for(int j = 0; j < n; j++) {
				map[i][j] = Character.getNumericValue(oneLine.charAt(j));
			}
		}
		
		// 단지 정보 ArrayList 생성.
		ArrayList<Integer> complexList = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				// 아직 방문하지 않았고, 집이 있는 곳(1인 곳)이면 bfs 탐색 실시.
				if(visited[i][j] == false && map[i][j] == 1) {
					int count = bfs(map, visited, i, j, n);
					complexList.add(count);
				}
			}
		}
		
		Collections.sort(complexList);
		System.out.println(complexList.size());
		
		for(int cnt: complexList) {
			System.out.println(cnt);
		}
	}
	
	static int bfs(int[][] map, boolean[][] visited, int startX, int startY, int n) {
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
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY] && map[nextX][nextY] == 1) {
					queue.offer(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
					count++;
				}
			}
		}
		return count;
	}
}
