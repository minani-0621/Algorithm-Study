import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	static int m, n;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Node> queue = new LinkedList<>();
	
	static class Node {
		int x, y, day;
		public Node(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
	
	public static void main(String[] args) {
		m = scanner.nextInt(); // 세로
		n = scanner.nextInt(); // 가로
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1) {
					queue.offer(new Node(i, j, 0));
					visited[i][j] = true;
				}else if(map[i][j] == -1) {
					visited[i][j] = true;
				}
			}
		}
		
		int answerDay = bfs();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(visited[i][j] != true) {
					answerDay = -1;
				}
			}
		}
		
		System.out.println(answerDay);
	}
	
	static int bfs() {
		int maxDay = 0;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			// 상,하,좌,우
			int[] mr = {0, 0, -1, 1};
			int[] mc = {-1, 1, 0, 0};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				int nextDay = checkNode.day + 1;
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY] && map[nextX][nextY] == 0) {
					queue.offer(new Node(nextX, nextY, nextDay));
					visited[nextX][nextY] = true;
					map[nextX][nextY] = 1;
					
					if(maxDay < nextDay) {
						maxDay = nextDay;
					}
				}
			}
		}
		
		return maxDay;
	}
}
