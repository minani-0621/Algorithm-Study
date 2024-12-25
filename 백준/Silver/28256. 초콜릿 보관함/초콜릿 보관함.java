import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			char[][] grid = new char[3][3];
			boolean[][] visited = new boolean[3][3];
			
			for(int j = 0; j < 3; j++) {
				String[] oneLine = br.readLine().split("");
				
				for(int k = 0; k < 3; k++) {
					grid[j][k] = oneLine[k].charAt(0);
				}
			}
			
			ArrayList<Integer> linkingList = new ArrayList<>();
			
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					if(grid[j][k] == 'O' && !visited[j][k]) {
						linkingList.add(bfs(j, k, grid, visited));
					}
				}
			}
			
			Collections.sort(linkingList);
			ArrayList<Integer> displayList = new ArrayList<>();
			String[] displayNum = br.readLine().split(" ");
			
			for(int j = 1; j <= Integer.parseInt(displayNum[0]); j++) {
				displayList.add(Integer.parseInt(displayNum[j]));
			}
			
			boolean result = true;
			
			if(displayList.size() != linkingList.size()) {
				result = false;
			}else {
				for(int j = 0; j < displayList.size(); j++) {
					if(!displayList.get(j).equals(linkingList.get(j))) {
						result = false;
						break;
					}
				}
			}
			
			if(result) {
				bw.write(1 + "\n");
			}else {
				bw.write(0 + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	public static int bfs(int x, int y, char[][] grid, boolean[][] visited) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y));
		visited[x][y] = true;
		int linkingSize = 1;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			int[] mr = {-1, 1, 0, 0};
			int[] mc = {0, 0, -1, 1};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < 3 && nextY >= 0 && nextY < 3 && !visited[nextX][nextY] && grid[nextX][nextY] == 'O') {
					queue.offer(new Node(nextX, nextY));
					visited[nextX][nextY] = true;
					linkingSize++;
				}
			}
		}
		
		return linkingSize;
	}
}
