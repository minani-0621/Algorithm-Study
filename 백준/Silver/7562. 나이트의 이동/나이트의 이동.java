import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[][] board;
	static boolean[][] visited;
	static class Point {
		int x, y, moveCnt;
		public Point(int x, int y, int moveCnt) {
			this.x = x;
			this.y = y;
			this.moveCnt = moveCnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int testCase = scanner.nextInt();
		
		for(int i = 0; i < testCase; i++) {
			int I = scanner.nextInt();
			board = new int[I][I];
			visited = new boolean[I][I];
			
			int knightX = scanner.nextInt();
			int knightY = scanner.nextInt();
			
			int destX = scanner.nextInt();
			int destY = scanner.nextInt();
			
			bfs(board, knightX, knightY, destX, destY, I);
		}
		
		bw.flush();
		bw.close();
	}
	
	static void bfs(int[][] board, int startX, int startY, int destX, int destY, int I) throws IOException {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(startX, startY, 0));
		visited[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			Point checkNode = queue.poll();
			
			if(checkNode.x == destX && checkNode.y == destY) {
				bw.write(checkNode.moveCnt + "\n");
				break;
			}
			
			int[] mr = {-2, -1, 1, 2, 2, 1, -1, -2};
			int[] mc = {-1, -2, -2, -1, 1, 2, 2, 1};
			for(int i = 0; i < 8; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				int nextCnt = checkNode.moveCnt + 1;
				if(nextX >= 0 && nextX < I && nextY >= 0 && nextY < I && !visited[nextX][nextY]) {
					queue.offer(new Point(nextX, nextY, nextCnt));
					visited[nextX][nextY] = true;
				}
			}
		}
	}
}
