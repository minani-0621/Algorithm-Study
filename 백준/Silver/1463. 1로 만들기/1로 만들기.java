import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int N;
	static boolean[] visited;
	static class Node {
		int x, calcCount;
		public Node(int x, int calcCount) {
			this.x = x;
			this.calcCount = calcCount;
		}
	}
	
	public static void main(String[] args) {
		N = scanner.nextInt();
		visited = new boolean[N + 1];
		
		System.out.println(makeOne(N));
	}
	
	static int makeOne(int n) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(n, 0));
		visited[n] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.x == 1) {
				return checkNode.calcCount;
			}
			
			if(checkNode.x % 3 == 0) {
				if(!visited[checkNode.x / 3]) {
					queue.offer(new Node(checkNode.x / 3, checkNode.calcCount + 1));
					visited[checkNode.x / 3] = true;
				}
			}
			
			if(checkNode.x % 2 == 0) {
				if(!visited[checkNode.x / 2]) {
					queue.offer(new Node(checkNode.x / 2, checkNode.calcCount + 1));
					visited[checkNode.x / 2] = true;
				}
			}
			
			if(!visited[checkNode.x - 1]) {
				queue.offer(new Node(checkNode.x - 1, checkNode.calcCount + 1));
				visited[checkNode.x - 1] = true;
			}
		}
		
		return -1;
	}
}
