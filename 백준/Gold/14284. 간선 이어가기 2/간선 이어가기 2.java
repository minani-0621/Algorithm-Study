import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n, m, s, t;
	static LinkedList<Node>[] graph;
	static int[] dist;
	
	static class Node implements Comparable<Node> {
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
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		graph = new LinkedList[n + 1];
		dist = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			graph[i] = new LinkedList<Node>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < m; i++) {
			String[] info = br.readLine().split(" ");
			int a = Integer.parseInt(info[0]);
			int b = Integer.parseInt(info[1]);
			int c = Integer.parseInt(info[2]);
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
		
		String[] twoNode = br.readLine().split(" ");
		s = Integer.parseInt(twoNode[0]);
		t = Integer.parseInt(twoNode[1]);
		
		dijkstra(s);
		System.out.println(dist[t]);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node checkNode = pq.poll();
			int checkNodeNum = checkNode.nodeNum;
			int checkNodeWeight = checkNode.weight;
			
			if(dist[checkNodeNum] < checkNodeWeight) {
				continue;
			}
			
			for(Node nextNode: graph[checkNodeNum]) {
				int nextNodeNum = nextNode.nodeNum;
				int nextNodeWeight = nextNode.weight;
				
				if(dist[nextNodeNum] > checkNodeWeight + nextNodeWeight) {
					pq.add(new Node(nextNodeNum, checkNodeWeight + nextNodeWeight));
					dist[nextNodeNum] = checkNodeWeight + nextNodeWeight;
				}
			}
		}
	}
}
