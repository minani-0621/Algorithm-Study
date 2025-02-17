import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static LinkedList<Node>[] graph;
	static boolean[] visited;
	static class Node {
		int nodeNum, dist;
		public Node(int nodeNum, int dist) {
			this.nodeNum = nodeNum;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new LinkedList[N + 1];
		
		for(int i = 1; i < N + 1; i++ ) {
			graph[i] = new LinkedList<Node>();
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			graph[node1].add(new Node(node2, dist));
			graph[node2].add(new Node(node1, dist));
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			visited = new boolean[N + 1];
			bw.write(bfsTree(node1, node2) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static int bfsTree(int n1, int n2) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(n1, 0));
		visited[n1] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.nodeNum == n2) {
				return checkNode.dist;
			}
			
			Iterator<Node> iter = graph[checkNode.nodeNum].iterator();
			
			while(iter.hasNext()) {
				Node nextNode = iter.next();
				if(!visited[nextNode.nodeNum]) {
					queue.offer(new Node(nextNode.nodeNum, checkNode.dist + nextNode.dist));
					visited[nextNode.nodeNum] = true;
				}
			}
		}
		
		return -1;
	}
}
