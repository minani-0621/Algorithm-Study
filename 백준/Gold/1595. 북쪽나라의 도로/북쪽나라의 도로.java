import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static LinkedList<Node>[] graph;
	static boolean[] visited;
	static int maxDist = 0;
	static Node maxDistNode;
	static class Node {
		int nodeNum, dist;
		public Node(int nodeNum, int dist) {
			this.nodeNum = nodeNum;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws IOException {
		graph = new LinkedList[10001];
		
		for(int i = 1; i <= 10000; i++) {
			graph[i] = new LinkedList<Node>();
		}
		
		boolean noInput = true;
		
		while(true) {
			String line = br.readLine();
			
			if(line == null) {
				break;
			}
			
			String[] input = line.split(" ");
			
			if(input.length != 3) {
				continue;
			}
			
			int city1 = Integer.parseInt(input[0]);
			int city2 = Integer.parseInt(input[1]);
			int distance = Integer.parseInt(input[2]);
			
			graph[city1].add(new Node(city2, distance));
			graph[city2].add(new Node(city1, distance));
			
			noInput = false;
		}
		
		if(noInput) {
			System.out.println(0);
			return;
		}

		visited = new boolean[10001];
		dfs(1, 0);
		visited = new boolean[10001];
		maxDist = 0;
		dfs(maxDistNode.nodeNum, 0);
		System.out.println(maxDist);
	}
	
	static void dfs(int start, int dist) {
		visited[start] = true;
		
		if(maxDist < dist) {
			maxDist = dist;
			maxDistNode = new Node(start, maxDist);
		}
		
		for(Node nextNode: graph[start]) {
			if(!visited[nextNode.nodeNum]) {
				dfs(nextNode.nodeNum, dist + nextNode.dist);
			}
		}
	}
}
