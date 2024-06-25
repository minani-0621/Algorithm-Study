import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int n, m;
	static char[][] grid1;
	static char[][] grid2;
	static char[][] grid1Change;
	static boolean[][] visited;
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		String size = br.readLine();
		String[] sizeArr = size.split(" ");
		
		n = Integer.parseInt(sizeArr[0]);
		m = Integer.parseInt(sizeArr[1]);
		
		grid1 = new char[n][m];
		grid2 = new char[n][m];
		grid1Change = new char[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			String oneLine = br.readLine();
			
			for(int j = 0; j < m; j++) {
				grid1[i][j] = oneLine.charAt(j);	
			}
		}
		
		for(int i = 0; i < n; i++) {
			String oneLine = br.readLine();
			
			for(int j = 0; j < m; j++) {
				grid2[i][j] = oneLine.charAt(j);
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		boolean result = possibleChange();
		
		if(result) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
	}
	
	static void bfs(int startX, int startY) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startX, startY));
		visited[startX][startY] = true;
		grid1Change[startX][startY] = grid2[startX][startY];
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			// 상,하,좌,우
			int[] mr = {0, 0, -1, 1};
			int[] mc = {-1, 1, 0, 0};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY] && grid1[nextX][nextY] == grid1[checkNode.x][checkNode.y]) {
					queue.offer(new Node(nextX, nextY));
					visited[nextX][nextY] = true;
					grid1Change[nextX][nextY] = grid2[startX][startY];
				}
			}
		}
	}
	
	static boolean possibleChange() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid1Change[i][j] != grid2[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
}
