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
	
	static char[][][] struct;
	static boolean[][][] visited;
	static class Node {
		int x, y, z, time;
		public Node(int x, int y, int z, int time) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int answer = 0;
		while(true) {
			String input = br.readLine();
			String[] inputArr = input.split(" ");
			
			int l = Integer.parseInt(inputArr[0]);
			int r = Integer.parseInt(inputArr[1]);
			int c = Integer.parseInt(inputArr[2]);
			
			if(l == 0 && r == 0 && c == 0) {
				break;
			}else {
				struct = new char[r][c][l];
				visited = new boolean[r][c][l];
				
				for(int i = 0; i < l; i++) {
					for(int j = 0; j < r; j++) {
						String oneRow = br.readLine();
						for(int k = 0; k < c; k++) {
							struct[j][k][i] = oneRow.charAt(k);
						}
					}
					
					br.readLine();
				}
				
				for(int i = 0; i < l; i++) {
					for(int j = 0; j < r; j++) {
						for(int k = 0; k < c; k++) {
							if(struct[j][k][i] == 'S') {
								answer = bfs(j, k, i, l, r, c);
							}
						}
					}
				}
			}
			
			if(answer != 0) {
				bw.write("Escaped in " + answer + " minute(s).\n");
			}else {
				bw.write("Trapped!\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	static int bfs(int startX, int startY, int startZ, int l, int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startX, startY, startZ, 0));
		visited[startX][startY][startZ] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(struct[checkNode.x][checkNode.y][checkNode.z] == 'E') {
				return checkNode.time;
			}
			
			// 동,서,남,북,상,하 6방향
			int[] mx = {0, 0, 1, -1, 0, 0};
			int[] my = {1, -1, 0, 0, 0, 0};
			int[] mz = {0, 0, 0, 0, -1, 1};
			
			for(int i = 0; i < 6; i++) {
				int nextX = checkNode.x + mx[i];
				int nextY = checkNode.y + my[i];
				int nextZ = checkNode.z + mz[i];
				
				if(nextX >= 0 && nextX < r && nextY >= 0 && nextY < c && nextZ >= 0 && nextZ < l && struct[nextX][nextY][nextZ] != '#' && !visited[nextX][nextY][nextZ]) {
					queue.offer(new Node(nextX, nextY, nextZ, checkNode.time + 1));
					visited[nextX][nextY][nextZ] = true;
				}
			}
		}
		
		return 0;
	}
}
