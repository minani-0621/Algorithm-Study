import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int w, h;
	static char[][] map;
	static int[][] fireTimeMap;
	static boolean[][] visited;
	static boolean[][] visitedFire;
	static class Node {
		int x, y, time;
		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			String size = br.readLine();
			String[] sizeArr = size.split(" ");
			
			w = Integer.parseInt(sizeArr[0]);
			h = Integer.parseInt(sizeArr[1]);
			
			map = new char[h][w];
			fireTimeMap = new int[h][w];
			visited = new boolean[h][w];
			visitedFire = new boolean[h][w];
			
			int startX = 0, startY = 0;
			
			for(int j = 0; j < h; j++) {
				String oneLine = br.readLine();
				
				for(int k = 0; k < w; k++) {
					map[j][k] = oneLine.charAt(k);
					
					if(map[j][k] == '@') {
						startX = j;
						startY = k;
					}
					
					fireTimeMap[j][k] = Integer.MAX_VALUE;
				}
			}
			
			Queue<Node> queueFire = new LinkedList<>();
			
			for(int j = 0; j < h; j++) {
				for(int k = 0; k < w; k++) {
					if(map[j][k] == '*') {
						queueFire.offer(new Node(j, k, 0));
						visitedFire[j][k] = true;
					}
				}
			}
			
			bfsFire(queueFire);
			
			int result = bfs(startX, startY);
			if(result == -1) {
				bw.write("IMPOSSIBLE\n");
			}else {
				bw.write(result + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	static int bfs(int startX, int startY) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startX, startY, 0));
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if((checkNode.x == 0 && (checkNode.y >= 0 && checkNode.y < w)) || ((checkNode.x == h - 1) && (checkNode.y >= 0 && checkNode.y < w)) || ((checkNode.y == 0) && (checkNode.x >= 0 && checkNode.x < h)) || ((checkNode.y == w - 1) && (checkNode.x >= 0 && checkNode.x < h))) {
				return checkNode.time + 1;
			}
			
			// 상,하,좌,우
			int[] mr = {0, 0, -1, 1};
			int[] mc = {-1, 1, 0, 0};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				int nextTime = checkNode.time + 1;
				
				if(nextX >= 0 && nextX < h && nextY >= 0 && nextY < w && !visited[nextX][nextY] && map[nextX][nextY] == '.') {
					if(fireTimeMap[nextX][nextY] > nextTime) {
						queue.offer(new Node(nextX, nextY, nextTime));
						visited[nextX][nextY] = true;
					}
				}
			}
		}

		return -1;
	}
	
	static void bfsFire(Queue<Node> queueFire) {		
		while(!queueFire.isEmpty()) {
			Node checkNode = queueFire.poll();
			
			// 상,하,좌,우
			int[] mr = {0, 0, -1, 1};
			int[] mc = {-1, 1, 0, 0};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				int nextTime = checkNode.time + 1;
				
				if(nextX >= 0 && nextX < h && nextY >= 0 && nextY < w && !visitedFire[nextX][nextY] && map[nextX][nextY] != '#') {
					queueFire.offer(new Node(nextX, nextY, nextTime));
					visitedFire[nextX][nextY] = true;
					fireTimeMap[nextX][nextY] = nextTime;
				}
			}
		}
	}
}
