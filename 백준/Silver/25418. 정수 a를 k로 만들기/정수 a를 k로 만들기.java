import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int A, K;
	static boolean[] visited;
	static class Node {
		int x, calcCount;
		public Node(int x, int calcCount) {
			this.x = x;
			this.calcCount = calcCount;
		}
	}
	
	public static void main(String[] args) {
		A = scanner.nextInt();
		K = scanner.nextInt();
		visited = new boolean[1000001];
		
		System.out.println(bfs(A));
	}
	
	static int bfs(int x) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, 0));
		visited[x] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.x == K) {
				return checkNode.calcCount;
			}
			
			int[] nextX = {checkNode.x + 1, checkNode.x * 2};
			
			for(int i = 0; i < 2; i++) {
				if(nextX[i] <= 1000000 && !visited[nextX[i]]) {
					queue.offer(new Node(nextX[i], checkNode.calcCount + 1));
					visited[nextX[i]] = true;
				}
			}
		}
		
		return -1;
	}
}
