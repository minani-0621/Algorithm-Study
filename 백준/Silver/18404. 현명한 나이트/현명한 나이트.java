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
	
	static int n, m;
	static int[][] turnTime;
	static boolean[][] visited;
	static class Node {
		int x, y, turn;
		public Node(int x, int y, int turn) {
			this.x = x;
			this.y = y;
			this.turn = turn;
		}
	}
	
	public static void main(String[] args) throws IOException {
		String size = br.readLine();
		String[] sizeArr = size.split(" ");
		
		n = Integer.parseInt(sizeArr[0]);
		m = Integer.parseInt(sizeArr[1]);
		
		String knightCoord = br.readLine();
		String[] knightCoordArr = knightCoord.split(" ");
		
		int knightX = Integer.parseInt(knightCoordArr[0]);
		int knightY = Integer.parseInt(knightCoordArr[1]);
		
		turnTime = new int[n][n];
		visited = new boolean[n][n];
		bfs(knightX - 1, knightY - 1);
		
		for(int i = 0; i < m; i++) {
			String enemyCoord = br.readLine();
			String[] enemyCoordArr = enemyCoord.split(" ");
			
			int enemyX = Integer.parseInt(enemyCoordArr[0]);
			int enemyY = Integer.parseInt(enemyCoordArr[1]);
			
			bw.write(turnTime[enemyX - 1][enemyY - 1] + " ");
		}
		
		bw.flush();
		bw.close();
	}
	
	static void bfs(int startX, int startY) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startX, startY, 0));
		visited[startX][startY] = true;
		turnTime[startX][startY] = 0;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			// 나이트가 움직일 수 있는 8방향
			int[] mr = {-2, -1, 1, 2, 2, 1, -1, -2};
			int[] mc = {-1, -2, -2, -1, 1, 2, 2, 1};
			
			for(int i = 0; i < 8; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
					queue.offer(new Node(nextX, nextY, checkNode.turn + 1));
					visited[nextX][nextY] = true;
					turnTime[nextX][nextY] = checkNode.turn + 1;
				}
			}
		}
	}
}
