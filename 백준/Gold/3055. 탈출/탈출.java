import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int r, c;
	static char[][] map;
	static boolean[][] visited;
	static int[][] waterTime;
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
		
		r = Integer.parseInt(inputArr[0]);
		c = Integer.parseInt(inputArr[1]);
		
		map = new char[r][c];
		visited = new boolean[r][c];
		waterTime = new int[r][c];
		
		for(int i = 0; i < r; i++) {
			String oneLine = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = oneLine.charAt(j);
			}
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				waterTime[i][j] = 10000;
			}
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] == '*') {
					bfsWater(i, j);
				}
			}
		}
		
		visited = new boolean[r][c];
		int answer = 0;
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++){
				if(map[i][j] == 'S') {
					answer = bfsHedgehog(i, j);
				}
			}
		}
		
		if(answer != 0) {
			System.out.println(answer);
		}else {
			System.out.println("KAKTUS");
		}
	}
	
	static void bfsWater(int startX, int startY) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startX, startY, 0));
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			// 상,하,좌,우
			int[] mr = {0, 0, -1, 1};
			int[] mc = {-1, 1, 0, 0};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < r && nextY >= 0 && nextY < c && !visited[nextX][nextY] && map[nextX][nextY] == '.') {
					queue.offer(new Node(nextX, nextY, checkNode.time + 1));
					visited[nextX][nextY] = true;
					waterTime[nextX][nextY] = checkNode.time + 1;
				}
			}
		}
	}
	
	static int bfsHedgehog(int startX, int startY) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startX, startY, 0));
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(map[checkNode.x][checkNode.y] == 'D') {
				int minTime = checkNode.time;
				return minTime;
			}
			// 상,하,좌,우
			int[] mr = {0, 0, -1, 1};
			int[] mc = {-1, 1, 0, 0};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if (nextX >= 0 && nextX < r && nextY >= 0 && nextY < c) {
				    if (!visited[nextX][nextY] && (map[nextX][nextY] == '.' || map[nextX][nextY] == 'D')) {
				        if (waterTime[nextX][nextY] > checkNode.time + 1) {
				            queue.offer(new Node(nextX, nextY, checkNode.time + 1));
				            visited[nextX][nextY] = true;
				        }
				    }
				}

			}
		}
		
		return 0;
	}
}
