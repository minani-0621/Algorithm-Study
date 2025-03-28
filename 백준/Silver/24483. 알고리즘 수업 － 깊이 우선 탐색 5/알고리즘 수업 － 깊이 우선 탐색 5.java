import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static LinkedList<Integer>[] graph;
	static int[] visited;
	static int[] depth;
	static int N, M, R;
	static int visitCount = 1;
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		R = Integer.parseInt(input[2]);
		
		graph = new LinkedList[N + 1];
		visited = new int[N + 1];
		depth = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<>();
		}
		
		for(int i = 1; i <= N; i++) {
			depth[i] = -1;
		}
		
		for(int i = 0; i < M; i++) {
			String[] nodes = br.readLine().split(" ");
			int node1 = Integer.parseInt(nodes[0]);
			int node2 = Integer.parseInt(nodes[1]);
			graph[node1].add(node2);
			graph[node2].add(node1);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}
		
		dfs(R, 0);
		long result = 0;
		
		for(int i = 1; i <= N; i++) {
			result += (long) visited[i] * depth[i];
		}
		
		System.out.println(result);
	}
	
	static void dfs(int start, int dep) {
		visited[start] = visitCount++;
		depth[start] = dep;
		
		for(int nextNode: graph[start]) {
			if(depth[nextNode] == -1) {
				dfs(nextNode, dep + 1);
			}
		}
	}
}
