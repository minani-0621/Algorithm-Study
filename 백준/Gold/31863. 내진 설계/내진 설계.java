import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, startX, startY, buildingCount = 0, brokenCount = 0;
	static char[][] map;
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		String[] mapSize = br.readLine().split(" ");
		N = Integer.parseInt(mapSize[0]);
		M = Integer.parseInt(mapSize[1]);
		map = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String oneLine = br.readLine();
			
			for(int j = 0; j < M; j++) {
				map[i][j] = oneLine.charAt(j);
				
				if(map[i][j] == '@') {
					startX = i;
					startY = j;
				}else if(map[i][j] == '*' || map[i][j] == '#') {
					buildingCount++;
				}
			}
		}
		
		bfs(startX, startY);
		System.out.println(brokenCount + " " + (buildingCount - brokenCount));
	}
	
	static void bfs(int startX, int startY) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startX, startY));
		int[] mr1 = {-1, 1, 0, 0};
		int[] mc1 = {0, 0, -1, 1};
		int[] mr2 = {-2, 2, 0, 0};
		int[] mc2 = {0, 0, -2, 2};
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(map[checkNode.x][checkNode.y] == '@') {
				map[checkNode.x][checkNode.y] = '.';
				
				for(int i = 0; i < 4; i++) {
					int nextX = checkNode.x + mr1[i];
					int nextY = checkNode.y + mc1[i];
					
					if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && map[nextX][nextY] != '|') {
						queue.offer(new Node(nextX, nextY));
						int nextX2 = checkNode.x + mr2[i];
						int nextY2 = checkNode.y + mc2[i];
						
						if(nextX2 >= 0 && nextX2 < N && nextY2 >= 0 && nextY2 < M && map[nextX2][nextY2] != '|') {
							queue.offer(new Node(nextX2, nextY2));
						}
					}else {
						continue;
					}
				}
			}else if(map[checkNode.x][checkNode.y] == '*') {
				map[checkNode.x][checkNode.y] = '.';
				brokenCount++;
				
				for(int i = 0; i < 4; i++) {
					int nextX = checkNode.x + mr1[i];
					int nextY = checkNode.y + mc1[i];
					
					if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && map[nextX][nextY] != '|') {
						queue.offer(new Node(nextX, nextY));
					}
				}
			}else if(map[checkNode.x][checkNode.y] == '#') {
				map[checkNode.x][checkNode.y] = '*';
			}
		}
	}
}
