import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	static class Node {
		int num, distance;
		public Node(int num, int distance) {
			this.num = num;
			this.distance = distance;
		}
	}
	
	public static void main(String[] args) {
		int n = scanner.nextInt(); // 사람 수
		int p1 = scanner.nextInt(); // 촌수 계산 첫번째 대상
		int p2 = scanner.nextInt(); // 촌수 계산 두번째 대상
		int m = scanner.nextInt(); // 전체 관계 수
		graph = new LinkedList[n + 1];
		for(int i = 1; i <= n; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		visited = new boolean[n + 1];
		
		for(int i = 0; i < m; i++) {
			int parent = scanner.nextInt();
			int child = scanner.nextInt();
			graph[parent].add(child);
			graph[child].add(parent);
		}
		
		int result = bfs(p1,p2);
		System.out.println(result);
	}
	
	static int bfs(int startNode, int endNode) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startNode, 0));
		visited[startNode] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			Iterator<Integer> iterator = graph[checkNode.num].iterator();
			while(iterator.hasNext()) {
				int nextNode = iterator.next();
				
				if(!visited[nextNode]) {
					if(nextNode == endNode) {
						return checkNode.distance + 1;
					}
					queue.offer(new Node(nextNode, checkNode.distance + 1));
					visited[nextNode] = true;
				}
			}
		}
		
		return -1;
	}
}
