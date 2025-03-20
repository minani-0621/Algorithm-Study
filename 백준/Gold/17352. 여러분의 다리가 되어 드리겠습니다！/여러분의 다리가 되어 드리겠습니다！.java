import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	static ArrayList<Integer> array = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		graph = new LinkedList[N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < N - 2; i++) {
			String[] nodes = br.readLine().split(" ");
			int node1 = Integer.parseInt(nodes[0]);
			int node2 = Integer.parseInt(nodes[1]);
			graph[node1].add(node2);
			graph[node2].add(node1);
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i);
				array.add(i);
			}
		}
		
		System.out.println(array.get(0) + " " + array.get(1));
	}
	
	static void dfs(int start) {
		visited[start] = true;
		
		for(int nextNode: graph[start]) {
			if(!visited[nextNode]) {
				dfs(nextNode);
			}
		}
	}
}
