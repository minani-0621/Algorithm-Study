import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int F, S, G, U, D;
	static boolean[] visited;
	static class Node {
		int x, moveCount;
		public Node(int x, int moveCount) {
			this.x = x;
			this.moveCount = moveCount;
		}
	}
	
	public static void main(String[] args) {
		F = scanner.nextInt();
		S = scanner.nextInt();
		G = scanner.nextInt();
		U = scanner.nextInt();
		D = scanner.nextInt();
		
		visited = new boolean[F + 1];
		int answer = bfs(S);
		
		if(answer == -1) {
			System.out.println("use the stairs");
		}else {
			System.out.println(answer);
		}
	}
	
	static int bfs(int x) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, 0));
		visited[x] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.x == G) {
				return checkNode.moveCount;
			}
			
			int[] mr = {U, -D};
			
			for(int i = 0; i < 2; i++) {
				int nextX = checkNode.x + mr[i];
				int nextMoveCount = checkNode.moveCount + 1;
				
				if(nextX > 0 && nextX <= F && !visited[nextX]) {
					queue.offer(new Node(nextX, nextMoveCount));
					visited[nextX] = true;
				}
			}
		}
		
		return -1;
	}
}
