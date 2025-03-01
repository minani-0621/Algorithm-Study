import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static LinkedList<Node>[] graph;
	static boolean[] visited;
	static int maxSum = 0;
	static Node maxSumNode;
	static class Node {
		int nodeNum, dist;
		public Node(int nodeNum, int dist) {
			this.nodeNum = nodeNum;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		graph = new LinkedList[V + 1];
		
		for(int i = 1; i <= V; i++) {
			graph[i] = new LinkedList<Node>();
		}
		
		for(int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int nodeNum = Integer.parseInt(st.nextToken());
			
			while(true) {
				int linkNode = Integer.parseInt(st.nextToken());
				
				if(linkNode == -1) {
					break;
				}
				
				int distance = Integer.parseInt(st.nextToken());
				graph[nodeNum].add(new Node(linkNode, distance));
			}
		}
		
		visited = new boolean[V + 1];
		Node tempLongestNode = dfs(1, 0);
		visited = new boolean[V + 1];
		Node longestNode = dfs(tempLongestNode.nodeNum, 0);
		
		System.out.println(longestNode.dist);
	}
	
	static Node dfs(int start, int sum) {
		visited[start] = true;
        
		if(maxSum < sum) {
			maxSum = sum;
			maxSumNode = new Node(start, maxSum);
		}
		
		
		for(Node nextNode: graph[start]) {
			int nextSum = sum + nextNode.dist;
			
			if(!visited[nextNode.nodeNum]) {
				dfs(nextNode.nodeNum, nextSum);
			}
		}
		
		return maxSumNode;
	}
}
