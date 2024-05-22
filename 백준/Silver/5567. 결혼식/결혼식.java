import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	static int n, listLength, countInviting;
	static int[][] graph;
	static boolean[] visited;
	
	static class Node {
		int num, distance;
		public Node(int num, int distance) {
			this.num = num;
			this.distance = distance;
		}
	}
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		listLength = scanner.nextInt();
		
		graph = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		
		for(int i = 0; i < listLength; i++) {
			int n1 = scanner.nextInt();
			int n2 = scanner.nextInt();
			
			graph[n1][n2] = 1;
			graph[n2][n1] = 1;
		}
		
		bfs(1);
		System.out.println(countInviting);
	}
	
	static void bfs(int startNode) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startNode, 0));
		visited[startNode] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			for(int i = 1; i <= n; i++) {
				if(graph[checkNode.num][i] == 1 && !visited[i] && checkNode.distance + 1 <= 2) {
					queue.offer(new Node(i, checkNode.distance + 1));
					visited[i] = true;
					countInviting++;
				}
			}
		}
	}
}
