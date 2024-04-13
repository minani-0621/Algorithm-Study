import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n, m;
	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	static int componentCount = 0;
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		graph = new LinkedList[n + 1];
		for(int i = 1; i <= n; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		visited = new boolean[n + 1];
		
		for(int i = 0; i < m; i++) {
			int n1 = scanner.nextInt();
			int n2 = scanner.nextInt();
			
			graph[n1].add(n2);
			graph[n2].add(n1);
		}
		
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				bfs(i);
				componentCount++;
			}
		}
		
		System.out.println(componentCount);
	}
	
	static void bfs(int rootNode) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(rootNode);
		visited[rootNode] = true;
		
		while(!queue.isEmpty()) {
			int checkNode = queue.poll();
			Iterator<Integer> iterator = graph[checkNode].iterator();
			
			while(iterator.hasNext()) {
				int node = iterator.next();
				
				if(!visited[node]) {
					queue.offer(node);
					visited[node] = true;
				}
			}
		}
	}
}
