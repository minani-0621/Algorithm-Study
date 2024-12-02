import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int[] rocks;
	static boolean[] visited;
	static int n, s, count = 0;
	static class Node {
		int x;
		public Node(int x) {
			this.x = x;
		}
	}
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		rocks = new int[n];
		visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			rocks[i] = scanner.nextInt();
		}
		
		s = scanner.nextInt();
		bfs(s - 1);		
		System.out.println(count);
	}
	
	static void bfs(int x) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x));
		visited[x] = true;
		count++;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			int[] nextX = new int[2];
			nextX[0] = checkNode.x - rocks[checkNode.x];
			nextX[1] = checkNode.x + rocks[checkNode.x];
			
			for(int i = 0; i < 2; i++) {
				if((nextX[i] >= 0 && nextX[i] < n) && !visited[nextX[i]]) {
					queue.offer(new Node(nextX[i]));
					visited[nextX[i]] = true;
					count++;
				}
			}
		}
	}
}
