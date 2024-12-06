import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int[] array;
	static boolean[] visited;
	static int N;
	static class Node {
		int x, jumpCount;
		public Node(int x, int jumpCount) {
			this.x = x;
			this.jumpCount = jumpCount;
		}
	}
	
	public static void main(String[] args) {
		N = scanner.nextInt();
		array = new int[N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			array[i] = scanner.nextInt();
		}
		
		int result = bfs();
		System.out.println(result);
	}
	
	static int bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 0));
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.x == N - 1) {
				return checkNode.jumpCount;
			}
			
			for(int i = 1; i <= array[checkNode.x]; i++) {
				if(checkNode.x + i < N && !visited[checkNode.x + i]) {
					queue.offer(new Node(checkNode.x + i, checkNode.jumpCount + 1));
					visited[checkNode.x + i] = true;
				}
			}
			
		}
		
		return -1;
	}
}
