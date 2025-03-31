import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, start, end;
	static LinkedList<Node>[] graph;
	static long[] dist; // 각 간선의 최대 weight가 100,000이기 때문에 int형으로 선언하면 overflow의 가능성이 있음
	
	static class Node implements Comparable<Node>{
		int nodeNum;
		long weight;
		
		public Node(int nodeNum, long weight) {
			this.nodeNum = nodeNum;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node node) {
			return Long.compare(weight, node.weight);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new LinkedList[N + 1];
		dist = new long[N + 1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<Node>();
			dist[i] = Long.MAX_VALUE;
		}
		
		for(int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int s = Integer.parseInt(input[0]);
			int e = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);
			graph[s].add(new Node(e, w));
		}
		
		String[] startEnd = br.readLine().split(" ");
		start = Integer.parseInt(startEnd[0]);
		end = Integer.parseInt(startEnd[1]);
		
		dijkstra(start);
		System.out.println(dist[end]);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node currentNode = pq.poll();
			int currentNodeNum = currentNode.nodeNum;
			long currentNodeWeight = currentNode.weight;
			
			if(dist[currentNodeNum] < currentNodeWeight) {
				continue;
			}
			
			for(Node nextNode: graph[currentNodeNum]) {
				int nextNodeNum = nextNode.nodeNum;
				long nextNodeWeight = nextNode.weight;
				
				if(dist[nextNodeNum] > currentNodeWeight + nextNodeWeight) {
					dist[nextNodeNum] = currentNodeWeight + nextNodeWeight;
					pq.add(new Node(nextNodeNum, dist[nextNodeNum]));
				}
			}
		}
	}
}
