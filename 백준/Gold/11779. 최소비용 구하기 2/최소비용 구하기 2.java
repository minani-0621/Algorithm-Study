import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m, start, end;
	static LinkedList<Node>[] graph;
	static int[] dist;
	static ArrayList<Integer>[] visitedCity;
	
	static class Node implements Comparable<Node>{
		int nodeNum, cost;
		public Node(int nodeNum, int cost) {
			this.nodeNum = nodeNum;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node node) {
			return cost - node.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		graph = new LinkedList[n + 1];
		dist = new int[n + 1];
		visitedCity = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i++) {
			graph[i] = new LinkedList<Node>();
			dist[i] = Integer.MAX_VALUE;
			visitedCity[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			String[] info = br.readLine().split(" ");
			int start = Integer.parseInt(info[0]);
			int end = Integer.parseInt(info[1]);
			int cost = Integer.parseInt(info[2]);
			graph[start].add(new Node(end, cost));
		}
		
		String[] startAndEnd = br.readLine().split(" ");
		start = Integer.parseInt(startAndEnd[0]);
		end = Integer.parseInt(startAndEnd[1]);
		
		dijkstra(start);
		
		bw.write(dist[end] + "\n");
		bw.write(visitedCity[end].size() + "\n");
		for(int cityNum: visitedCity[end]) {
			bw.write(cityNum + " ");
		}
		
		bw.flush();
		bw.close();
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		visitedCity[start].add(start);
		
		while(!pq.isEmpty()) {
			Node checkNode = pq.poll();
			int currentNodeNum = checkNode.nodeNum;
			int currentNodeCost = checkNode.cost;
			
			if(dist[currentNodeNum] < currentNodeCost) {
				continue;
			}
			
			for(Node nextNode: graph[currentNodeNum]) {
				int nextNodeNum = nextNode.nodeNum;
				int nextNodeCost = nextNode.cost;
				
				if(dist[nextNodeNum] > currentNodeCost + nextNodeCost) {
					pq.add(new Node(nextNodeNum, currentNodeCost + nextNodeCost));
					dist[nextNodeNum] = currentNodeCost + nextNodeCost;
					visitedCity[nextNodeNum] = new ArrayList<>(visitedCity[currentNodeNum]);
					visitedCity[nextNodeNum].add(nextNodeNum);
				}
			}
		}
	}
}
