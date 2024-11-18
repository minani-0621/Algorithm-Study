import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int n, m, t;
	static int[][] map;
	static boolean[][] visited;
	static class Node {
		int x, y, time;
		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		String input = br.readLine();
		String[] inputArr = input.split(" ");
		
		n = Integer.parseInt(inputArr[0]);
		m = Integer.parseInt(inputArr[1]);
		t = Integer.parseInt(inputArr[2]);
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			String oneLine = br.readLine();
			String[] oneLineArr = oneLine.split(" ");
			
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(oneLineArr[j]);
			}
		}
		
		int resultNoSword = bfsPrincess(0, 0);
		visited = new boolean[n][m];
		int resultSword = bfsSword(0, 0);
		
		int result = Math.min(resultNoSword, resultSword);
		
		if(result <= t) {
			System.out.println(result);
		}else {
			System.out.println("Fail");
		}
	}
	
	static int bfsPrincess(int startX, int startY) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startX, startY, 0));
		visited[startX][startY] = true;
		int shortestTime = 99999;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.x == n - 1 && checkNode.y == m - 1) {
				if(shortestTime > checkNode.time) {
					shortestTime = checkNode.time;
					return shortestTime;
				}
			}
			
			int[] mr = {0, 0, -1, 1};
			int[] mc = {-1, 1, 0, 0};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				int nextTime = checkNode.time + 1;
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY]) {
					if(map[nextX][nextY] == 0) {
						queue.offer(new Node(nextX, nextY, nextTime));
						visited[nextX][nextY] = true;
					}
				}
			}
		}
		
		return 99999;
	}
	
	static int bfsSword(int startX, int startY) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startX, startY, 0));
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(map[checkNode.x][checkNode.y] == 2) {
				int time = checkNode.time + n - 1 - checkNode.x + m - 1 - checkNode.y;
				return time;
			}
			
			int[] mr = {0, 0, -1, 1};
			int[] mc = {-1, 1, 0, 0};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				int nextTime = checkNode.time + 1;
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY]) {
					if(map[nextX][nextY] == 0 || map[nextX][nextY] == 2) {
						queue.offer(new Node(nextX, nextY, nextTime));
						visited[nextX][nextY] = true;
					}
				}
			}
		}
		
		return 99999;
	}
}
