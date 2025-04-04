import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, X;
	static LinkedList<Node>[] graph;
	static int[] goToXDist;
	static int[] totalDist;
	static class Node implements Comparable<Node>{
		int nodeNum, weight;
		public Node(int nodeNum, int weight) {
			this.nodeNum = nodeNum;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node node) {
			return weight - node.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		X = Integer.parseInt(input[2]);
		graph = new LinkedList[N + 1];
		goToXDist = new int[N + 1];
		totalDist = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<Node>();
			goToXDist[i] = Integer.MAX_VALUE;
			totalDist[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < M; i++) {
			String[] info = br.readLine().split(" ");
			int s = Integer.parseInt(info[0]);
			int e = Integer.parseInt(info[1]);
			int t = Integer.parseInt(info[2]);
			graph[s].add(new Node(e, t));
		}
		
		dijkstra(X, totalDist);
		
		for(int i = 1; i <= N; i++) {
			if(i != X) {
				for(int j = 1; j <= N; j++) {
					goToXDist[j] = Integer.MAX_VALUE;
				}
				
				dijkstra(i, goToXDist);
				totalDist[i] += goToXDist[X];
			}
		}
		
		Arrays.sort(totalDist);
		System.out.println(totalDist[totalDist.length - 1]);
	}
	
	static void dijkstra(int start, int[] dist) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node checkNode = pq.poll();
			int currentNodeNum = checkNode.nodeNum;
			int currentNodeWeight = checkNode.weight;
			
			if(dist[currentNodeNum] < currentNodeWeight) {
				continue;
			}
			
			for(Node nextNode: graph[currentNodeNum]) {
				int nextNodeNum = nextNode.nodeNum;
				int nextNodeWeight = nextNode.weight;
				
				if(dist[nextNodeNum] > currentNodeWeight + nextNodeWeight) {
					pq.add(new Node(nextNodeNum, currentNodeWeight + nextNodeWeight));
					dist[nextNodeNum] = currentNodeWeight + nextNodeWeight;
				}
			}
		}
	}
}
