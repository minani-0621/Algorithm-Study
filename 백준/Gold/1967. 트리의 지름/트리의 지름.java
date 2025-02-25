import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static LinkedList<Node>[] graph;
	static int maxSum = 0;
	static int caseMaxSum = 0;
	static boolean[] visited;
	static class Node {
		int linkNode, weight;
		public Node(int linkNode, int weight) {
			this.linkNode = linkNode;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		graph = new LinkedList[n + 1];
		
		for(int i = 1; i <= n; i++) {
			graph[i] = new LinkedList<Node>();
		}
		
		for(int i = 0; i < n - 1; i++) {
			String[] info = br.readLine().split(" ");
			int parent = Integer.parseInt(info[0]);
			int child = Integer.parseInt(info[1]);
			int weight = Integer.parseInt(info[2]);
			graph[parent].add(new Node(child, weight));
			graph[child].add(new Node(parent, weight));
		}
		
		for(int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			int maxSum = dfs(i, 0);
			caseMaxSum = Math.max(caseMaxSum, maxSum);
		}
		
		System.out.println(caseMaxSum);
	}
	
	static int dfs(int start, int sum) {
		Iterator<Node> iter = graph[start].iterator();
		maxSum = Math.max(maxSum, sum);
		visited[start] = true;
		
		while(iter.hasNext()) {
			Node next = iter.next();
			int nextSum = sum + next.weight;
			
			if(!visited[next.linkNode]) {
				dfs(next.linkNode, nextSum);
			}
		}
		
		return maxSum;
	}
}
