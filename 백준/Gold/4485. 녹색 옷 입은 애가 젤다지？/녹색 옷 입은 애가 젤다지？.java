import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, caseNum = 1;
	static int[][] map;
	static int[][] dist;
	
	static class Node implements Comparable<Node> {
		int x, y, cost;
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node node) {
			return cost - node.cost;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		while(true) {
			N = Integer.parseInt(br.readLine());
			
			if(N == 0) {
				break;
			}
			
			map = new int[N][N];
			dist = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String[] oneLine = br.readLine().split(" ");
				
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(oneLine[j]);
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			dijkstra(0, 0, map[0][0]);
			bw.write("Problem " + caseNum + ": " + dist[N - 1][N - 1] + "\n");
			caseNum++;
		}
		
		bw.flush();
		bw.close();
	}
	
	static void dijkstra(int startX, int startY, int startCost) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(startX, startY, startCost));
		dist[startX][startY] = startCost;
		
		while(!pq.isEmpty()) {
			Node checkNode = pq.poll();
			int currentX = checkNode.x;
			int currentY = checkNode.y;
			int currentCost = checkNode.cost;
			
			if(dist[currentX][currentY] < currentCost) {
				continue;
			}
			
			int[] mr = {-1, 1, 0, 0};
			int[] mc = {0, 0, -1, 1};
			
			for(int i = 0; i < 4; i++) {
				int nextX = currentX + mr[i];
				int nextY = currentY + mc[i];
				
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
					int nextCost = map[nextX][nextY];
					
					if(dist[nextX][nextY] > currentCost + nextCost) {
						pq.add(new Node(nextX, nextY, currentCost + nextCost));
						dist[nextX][nextY] = currentCost + nextCost;
					}
				}
			}
		}
	}
}
