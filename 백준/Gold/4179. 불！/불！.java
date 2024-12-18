import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[][] map;
	static int[][] fireSpreadTime;
	static boolean[][] humanVisited;
	static boolean[][] fireVisited;
	static int R, C;
	static class Node {
		int x, y, time;
		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		map = new char[R][C];
		fireSpreadTime = new int[R][C];
		humanVisited = new boolean[R][C];
		fireVisited = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			String oneLine = br.readLine();
			
			for(int j = 0; j < C; j++) {
				map[i][j] = oneLine.charAt(j);
				fireSpreadTime[i][j] = Integer.MAX_VALUE;
			}
		}
		
		Queue<Node> fireQueue = new LinkedList<>();
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 'F') {
					fireQueue.offer(new Node(i, j, 0));
					fireVisited[i][j] = true;
					fireSpreadTime[i][j] = 0;
				}
			}
		}
		
		fireBfs(fireQueue);
		
		int result = -1;
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 'J') {
					result = humanBfs(i, j);
				}
			}
		}
		
		if(result == -1) {
			System.out.println("IMPOSSIBLE");
		}else {
			System.out.println(result);
		}
	}
	
	static int humanBfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y, 0));
		humanVisited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.x == 0 || checkNode.x == R - 1 || checkNode.y == 0 || checkNode.y == C - 1) {
				return checkNode.time + 1;
			}
			
			int[] mr = {-1, 1, 0, 0};
			int[] mc = {0, 0, -1, 1};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				int nextTime = checkNode.time + 1;
				
				if(nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && !humanVisited[nextX][nextY] && map[nextX][nextY] != '#' && fireSpreadTime[nextX][nextY] > nextTime) {
					queue.offer(new Node(nextX, nextY, nextTime));
					humanVisited[nextX][nextY] = true;
				}
			}
		}
		
		return -1;
	}
	
	static void fireBfs(Queue<Node> fireQueue) {
		while(!fireQueue.isEmpty()) {
			Node checkNode = fireQueue.poll();
			
			int[] mr = {-1, 1, 0, 0};
			int[] mc = {0, 0, -1, 1};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				int nextTime = checkNode.time + 1;
				
				if(nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && !fireVisited[nextX][nextY] && map[nextX][nextY] != '#') {
					fireQueue.offer(new Node(nextX, nextY, nextTime));
					fireVisited[nextX][nextY] = true;
					fireSpreadTime[nextX][nextY] = nextTime;
				}
			}
		}
	}
}
