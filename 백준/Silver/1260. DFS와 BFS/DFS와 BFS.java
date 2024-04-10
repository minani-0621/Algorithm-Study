import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n, m, v;
	static boolean[] visited;
	static int[][] graph;
	
	public static void main(String[] args) {
		n = scanner.nextInt(); // 정점 수
		m = scanner.nextInt(); // 간선 수
		v = scanner.nextInt(); // 시작 정점 번호
		
		visited = new boolean[n + 1];
		graph = new int[n + 1][n + 1];
		
		for(int i = 0; i < m; i++) {
			int n1 = scanner.nextInt();
			int n2 = scanner.nextInt();
			
			graph[n1][n2] = 1;
			graph[n2][n1] = 1;
		}
		
		dfs(v);
		System.out.println();
		
		visited = new boolean[n + 1];
		bfs(v);
	}
	
	static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for(int i = 1; i <= n; i++) {
			if(graph[v][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			int checkNode = queue.poll();
			System.out.print(checkNode + " ");
			
			for(int i = 1; i <= n; i++) {
				if(graph[checkNode][i] == 1 && visited[i] != true) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
