import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int N, M;
	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) {
		N = scanner.nextInt();
		M = scanner.nextInt();
		
		graph = new LinkedList[N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 0; i <= N; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			int beforeNode = scanner.nextInt();
			int afterNode = scanner.nextInt();
			graph[afterNode].add(beforeNode);
		}
		
		int targetWork = scanner.nextInt();
		System.out.println(bfs(targetWork));
	}
	
	static int bfs(int targetWork) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(targetWork);
		visited[targetWork] = true;
		int beforeNodeCount = 0;
		
		while(!queue.isEmpty()) {
			int checkNode = queue.poll();
			Iterator<Integer> iter = graph[checkNode].iterator();
			
			while(iter.hasNext()) {
				int beforeNode = iter.next();
				
				if(!visited[beforeNode]) {
					queue.offer(beforeNode);
					visited[beforeNode] = true;
					beforeNodeCount++;
				}
				
			}
		}
		
		return beforeNodeCount;
	}
}
