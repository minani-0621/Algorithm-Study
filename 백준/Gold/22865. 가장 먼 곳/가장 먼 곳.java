import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, A, B, C;
	static LinkedList<Node>[] graph;
	static int[] dist;
	static int[] allCaseDist;
	static ArrayList<Integer> answer = new ArrayList<>();
	
	static class Node implements Comparable<Node>{
		int nodeNum, dist;
		public Node(int nodeNum, int dist) {
			this.nodeNum = nodeNum;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node node) {
			return dist - node.dist;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		graph = new LinkedList[N + 1];
		dist = new int[N + 1];
		allCaseDist = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<Node>();
			dist[i] = Integer.MAX_VALUE;
			allCaseDist[i] = Integer.MAX_VALUE;
		}
		
		String[] locations = br.readLine().split(" ");
		A = Integer.parseInt(locations[0]);
		B = Integer.parseInt(locations[1]);
		C = Integer.parseInt(locations[2]);
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			String[] info = br.readLine().split(" ");
			int D = Integer.parseInt(info[0]);
			int E = Integer.parseInt(info[1]);
			int L = Integer.parseInt(info[2]);
			graph[D].add(new Node(E, L));
			graph[E].add(new Node(D, L));
		}
		
		dijkstra(A);
		
		for(int i = 1; i <= N; i++) {
			if(dist[i] < allCaseDist[i]) {
				allCaseDist[i] = dist[i];
			}
		}
		
		for(int i = 1; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		dijkstra(B);
		
		for(int i = 1; i <= N; i++) {
			if(dist[i] < allCaseDist[i]) {
				allCaseDist[i] = dist[i];
			}
		}
		
		for(int i = 1; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		dijkstra(C);
		
		for(int i = 1; i <= N; i++) {
			if(dist[i] < allCaseDist[i]) {
				allCaseDist[i] = dist[i];
			}
		}
		
		int maxDist = 0;
		
		for(int i = 1; i <= N; i++) {
			if(maxDist < allCaseDist[i]) {
				answer.clear();
				answer.add(i);
				maxDist = allCaseDist[i];
			}else if(maxDist == allCaseDist[i]) {
				answer.add(i);
			}
		}
		
		Collections.sort(answer);
		System.out.println(answer.get(0));
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node checkNode = pq.poll();
			int checkNodeNum = checkNode.nodeNum;
			int checkNodeDist = checkNode.dist;
			
			if(dist[checkNodeNum] < checkNodeDist) {
				continue;
			}
			
			for(Node nextNode: graph[checkNodeNum]) {
				int nextNodeNum = nextNode.nodeNum;
				int nextNodeDist = nextNode.dist;
				
				if(dist[nextNodeNum] > checkNodeDist + nextNodeDist) {
					pq.add(new Node(nextNodeNum, checkNodeDist + nextNodeDist));
					dist[nextNodeNum] = checkNodeDist + nextNodeDist;
				}
			}
		}
	}
}
