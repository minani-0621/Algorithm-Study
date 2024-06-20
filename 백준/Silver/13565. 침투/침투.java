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
	
	static int m, n;
	static int[][] grid;
	static boolean[][] visited;
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		String size = br.readLine();
		String[] sizeArr = size.split(" ");
		
		m = Integer.parseInt(sizeArr[0]);
		n = Integer.parseInt(sizeArr[1]);
		
		grid = new int[m][n];
		visited = new boolean[m][n];
		
		for(int i = 0; i < m; i++) {
			String oneLine = br.readLine();
			
			for(int j = 0; j < n; j++) {
				grid[i][j] = Character.getNumericValue(oneLine.charAt(j));
			}
		}
		
		Queue<Node> queue = new LinkedList<>();
		
		for(int j = 0; j < n; j++) {
			if(grid[0][j] == 0) {
				queue.offer(new Node(0, j));
				visited[0][j] = true;
			}
		}
		
		boolean result = bfs(queue);
		
		if(result == true) {
			bw.write("YES");
		}else {
			bw.write("NO");
		}
		
		bw.flush();
		bw.close();
	}
	
	static boolean bfs(Queue<Node> queue) {		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.x == m - 1) { // 안쪽(가장 밑) 영역까지 도달했을 때
				return true;
			}
			
			// 상,하,좌,우
			int[] mr = {0, 0, -1, 1};
			int[] mc = {-1, 1, 0, 0};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
					queue.offer(new Node(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
		}
		
		return false;
	}
}
