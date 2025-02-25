import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, k, minTotalCost = 0;
	static LinkedList<Integer>[] graph;
	static int[] cost;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		k = Integer.parseInt(input[2]);
		graph = new LinkedList[N + 1];
		cost = new int[N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		String[] costs = br.readLine().split(" ");
		
		for(int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(costs[i - 1]);
		}
		
		for(int i = 0; i < M; i++) {
			String[] relation = br.readLine().split(" ");
			int v = Integer.parseInt(relation[0]);
			int w = Integer.parseInt(relation[1]);
			graph[v].add(w);
			graph[w].add(v);
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				minTotalCost += bfs(i);
			}
		}
		
		if(minTotalCost <= k) {
			System.out.println(minTotalCost);
		}else {
			System.out.println("Oh no");
		}
	}
	
	static int bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		int minSubCost = cost[start];
		
		while(!queue.isEmpty()) {
			int checkNode = queue.poll();
			
			for(int nextNode: graph[checkNode]) {
				if(!visited[nextNode]) {
					queue.offer(nextNode);
					visited[nextNode] = true;
					
					if(cost[nextNode] < minSubCost) {
						minSubCost = cost[nextNode];
					}
				}
			}
		}
		
		return minSubCost;
	}
}
