import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M, K;
	static LinkedList<Node>[] graph;
	static int[][] dist;
	
	static class Node implements Comparable<Node>{
		int nodeNum, dist;
		public Node(int nodeNum, int dist) {
			this.nodeNum = nodeNum;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node node) {
			if(dist == node.dist) {
				return nodeNum - node.nodeNum;
			}else {
				return dist - node.dist;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			graph = new LinkedList[N + 1];
			dist = new int[N + 1][N + 1];
			
			for(int j = 1; j <= N; j++) {
				graph[j] = new LinkedList<Node>();
				
				for(int k = 1; k <= N; k++) {
					dist[j][k] = Integer.MAX_VALUE;
				}
			}
			
			for(int j = 0; j < M; j++) {
				String[] info = br.readLine().split(" ");
				int a = Integer.parseInt(info[0]);
				int b = Integer.parseInt(info[1]);
				int c = Integer.parseInt(info[2]);
				graph[a].add(new Node(b, c));
				graph[b].add(new Node(a, c));
			}
			
			K = Integer.parseInt(br.readLine());
			String[] friends = br.readLine().split(" ");
			HashSet<Integer> set = new HashSet<>();
			
			for(int j = 0; j < friends.length; j++) {
				set.add(Integer.parseInt(friends[j]));
			}
			
			for(int j = 1; j <= N; j++) {
				dijkstra(j);
			}
			
			PriorityQueue<Node> cases = new PriorityQueue<>();
			
			for(int j = 1; j <= N; j++) {
				int distSum = 0;
				
				for(int k = 1; k <= N; k++) {
					if(set.contains(k)) {
						distSum += dist[j][k];
					}
				}
				
				cases.add(new Node(j, distSum));
			}
			
			bw.write(cases.poll().nodeNum + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start][start] = 0;
		
		while(!pq.isEmpty()) {
			Node checkNode = pq.poll();
			int checkNodeNum = checkNode.nodeNum;
			int checkNodeDist = checkNode.dist;
			
			if(dist[start][checkNodeNum] < checkNodeDist) {
				continue;
			}
			
			for(Node nextNode: graph[checkNodeNum]) {
				int nextNodeNum = nextNode.nodeNum;
				int nextNodeDist = nextNode.dist;
				
				if(dist[start][nextNodeNum] > checkNodeDist + nextNodeDist) {
					pq.add(new Node(nextNodeNum, checkNodeDist + nextNodeDist));
					dist[start][nextNodeNum] = checkNodeDist + nextNodeDist;
				}
			}
		}
	}
}
