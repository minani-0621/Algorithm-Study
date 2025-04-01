import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static LinkedList<Node>[] graph;
	static int[] dist;
	
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
		
		graph = new LinkedList[N + 1];
		dist = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<Node>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < M; i++) {
			String[] link = br.readLine().split(" ");
			int node1 = Integer.parseInt(link[0]);
			int node2 = Integer.parseInt(link[1]);
			int weight = Integer.parseInt(link[2]);
			graph[node1].add(new Node(node2, weight));
			graph[node2].add(new Node(node1, weight));
		}
		
		dijkstra();
		System.out.println(dist[N]);
	}

	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
		dist[1] = 0;
		
		while(!pq.isEmpty()) {
			Node checkNode = pq.poll();
			int checkNodeNum = checkNode.nodeNum;
			int checkNodeWeight = checkNode.weight;
			
			for(Node nextNode: graph[checkNodeNum]) {
				int nextNodeNum = nextNode.nodeNum;
				int nextNodeWeight = nextNode.weight;
				
				if(dist[nextNodeNum] > checkNodeWeight + nextNodeWeight) {
					dist[nextNodeNum] = checkNodeWeight + nextNodeWeight;
					pq.add(new Node(nextNodeNum, dist[nextNodeNum]));
				}
			}
		}
		
	}
}
