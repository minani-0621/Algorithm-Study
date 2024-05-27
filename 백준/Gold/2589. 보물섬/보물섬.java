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
	
	static class Node {
		int x, y, distance;
		public Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}
	
	public static void main(String[] args) throws IOException {
		String size = br.readLine();
		String[] sizeArr = size.split(" ");
		
		r = Integer.parseInt(sizeArr[0]);
		c = Integer.parseInt(sizeArr[1]);
		
		map = new char[r][c];
		visited = new boolean[r][c];
		
		for(int i = 0; i < r; i++) {
			String oneLine = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = oneLine.charAt(j);
			}
		}
		
		int answerDist = 0, temp = 0;
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				visited = new boolean[r][c];
				if(map[i][j] == 'L') {
					temp = bfs(i, j);
				}
				
				if(temp > answerDist) {
					answerDist = temp;
				}
			}
		}
		
		System.out.println(answerDist);
	}
	
	static int bfs(int startX, int startY) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startX, startY, 0));
		visited[startX][startY] = true;
		
		int longestDist = 0;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.distance > longestDist) {
				longestDist = checkNode.distance;
			}
			
			// 상,하,좌,우
			int[] mr = {0, 0, -1, 1};
			int[] mc = {-1, 1, 0, 0};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < r && nextY >= 0 && nextY < c && !visited[nextX][nextY] && map[nextX][nextY] == 'L') {
					queue.offer(new Node(nextX, nextY, checkNode.distance + 1));
					visited[nextX][nextY] = true;
				}
			}
		}
		
		return longestDist;
	}
}
