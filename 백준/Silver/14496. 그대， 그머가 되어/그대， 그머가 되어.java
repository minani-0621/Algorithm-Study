import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	static class Node {
		int nodeNum, replaceCount;
		public Node(int nodeNum, int replaceCount) {
			this.nodeNum = nodeNum;
			this.replaceCount = replaceCount;
		}
	}
	
	public static void main(String[] args) {
		int c1 = scanner.nextInt();
		int c2 = scanner.nextInt();
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		graph = new LinkedList[N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			int n1 = scanner.nextInt();
			int n2 = scanner.nextInt();
			graph[n1].add(n2);
			graph[n2].add(n1);
		}
		
		System.out.println(bfs(c1, c2));
	}
	
	static int bfs(int depart, int dest) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(depart, 0));
		visited[depart] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.nodeNum == dest) {
				return checkNode.replaceCount;
			}
			
			Iterator<Integer> iter = graph[checkNode.nodeNum].iterator();
			
			while(iter.hasNext()) {
				int next = iter.next();
				if(!visited[next]) {
					queue.offer(new Node(next, checkNode.replaceCount + 1));
					visited[next] = true;
				}
			}
		}
		
		return -1;
	}
}
