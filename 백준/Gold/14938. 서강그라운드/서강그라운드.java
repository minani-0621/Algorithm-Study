import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n, m, r;
	static int[] itemArray;
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
		r = Integer.parseInt(input[2]);
		itemArray = new int[n + 1];
		String[] items = br.readLine().split(" ");
		graph = new LinkedList[n + 1];
		dist = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			graph[i] = new LinkedList<Node>();
		}
		
		for(int i = 1; i <= n; i++) {
			itemArray[i] = Integer.parseInt(items[i - 1]);
		}
		
		for(int i = 0; i < r; i++) {
			String[] info = br.readLine().split(" ");
			int a = Integer.parseInt(info[0]);
			int b = Integer.parseInt(info[1]);
			int l = Integer.parseInt(info[2]);
			graph[a].add(new Node(b, l));
			graph[b].add(new Node(a, l));
		}
		
		int maxItems = 0;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				dist[j] = Integer.MAX_VALUE;
			}
			
			maxItems = Math.max(maxItems, dijkstra(i));
		}
		
		System.out.println(maxItems);
	}
	
	static int dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node checkNode = pq.poll();
			int currentNodeNum = checkNode.nodeNum;
			int currentNodeWeight = checkNode.weight;
			
			if(currentNodeWeight > dist[currentNodeNum]) {
				continue;
			}
			
			for(Node nextNode: graph[currentNodeNum]) {
				int nextNodeNum = nextNode.nodeNum;
				int nextNodeWeight = nextNode.weight;
				
				if(currentNodeWeight + nextNodeWeight <= m) {
					if(dist[nextNodeNum] > currentNodeWeight + nextNodeWeight) {
						dist[nextNodeNum] = currentNodeWeight + nextNodeWeight;
						pq.add(new Node(nextNodeNum, dist[nextNodeNum]));
					}
				}
			}
		}
		
		int itemCount = 0;
		
		for(int i = 1; i <= n; i++) {
			if(dist[i] <= m) {
				itemCount += itemArray[i];
			}
		}
		
		return itemCount;
	}
}
