import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int[][] map;
	static boolean[][] visited;
	static int n;
	static int babySharkX, babySharkY;
	static class Point {
		int x, y, dist;
		public Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = scanner.nextInt();
				
				if(map[i][j] == 9) {
					babySharkX = i;
					babySharkY = j;
					map[i][j] = 0;
				}
			}
		}
		
		int totalTime = 0;
		int babySharkSize = 2;
		int eatCount = 0;
		
		while(true) {
			visited = new boolean[n][n];
			int result = bfs(babySharkX, babySharkY, babySharkSize);
			
			if(result == -1) {
				break;
			}else {
				totalTime += result;
				eatCount++;
				
				if(eatCount == babySharkSize) {
					babySharkSize++;
					eatCount = 0;
				}
			}
		}
		
		System.out.println(totalTime);
	}
	
	static int bfs(int startX, int startY, int babySharkSize) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(startX, startY, 0));
		visited[startX][startY] = true;
		Queue<Point> eatPossible = new PriorityQueue<>((a, b) -> {
			if(a.dist != b.dist) {
				return Integer.compare(a.dist, b.dist);
			}else if(a.x != b.x) {
				return Integer.compare(a.x, b.x);
			}else {
				return Integer.compare(a.y, b.y);
			}
		});
		
		while(!queue.isEmpty()) {
			Point checkNode = queue.poll();
			
			if(map[checkNode.x][checkNode.y] < babySharkSize && map[checkNode.x][checkNode.y] > 0) {
				eatPossible.offer(new Point(checkNode.x, checkNode.y, checkNode.dist));
			}
			
			int[] mr = {-1, 1, 0, 0};
			int[] mc = {0, 0, -1, 1};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				int nextDist = checkNode.dist + 1;
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY] && map[nextX][nextY] <= babySharkSize) {
					queue.offer(new Point(nextX, nextY, nextDist));
					visited[nextX][nextY] = true;
				}
			}
		}
		
		if(eatPossible.isEmpty()) {
			return -1;
		}else {
			Point eatNode = eatPossible.poll();
			map[eatNode.x][eatNode.y] = 0;
			babySharkX = eatNode.x;
			babySharkY = eatNode.y;
			return eatNode.dist;
		}
	}
}
