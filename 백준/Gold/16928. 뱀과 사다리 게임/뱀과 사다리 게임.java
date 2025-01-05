import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int N, M;
	static boolean[] visited = new boolean[101];
	static HashMap<Integer, Integer> snakeLadder = new HashMap<>();
	static class Node {
		int x, moveCount;
		public Node(int x, int moveCount) {
			this.x = x;
			this.moveCount = moveCount;
		}
	}
	
	public static void main(String[] args) {
		N = scanner.nextInt();
		M = scanner.nextInt();
		
		for(int i = 0; i < N; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			snakeLadder.put(x, y);
		}
		
		for(int i = 0; i < M; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			snakeLadder.put(u, v);
		}
		
		System.out.println(bfsMove());
	}
	
	static int bfsMove() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(1, 0));
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.x == 100) {
				return checkNode.moveCount;
			}
			
			for(int i = 1; i <= 6; i++) {
				int nextX = checkNode.x + i;
				int nextMoveCount = checkNode.moveCount + 1;
				
				if(nextX >= 1 && nextX <= 100 && !visited[nextX]) {
					if(snakeLadder.containsKey(nextX)) {
						queue.offer(new Node(snakeLadder.get(nextX), nextMoveCount));
						visited[snakeLadder.get(nextX)] = true;
					}else {
						queue.offer(new Node(nextX, nextMoveCount));
						visited[nextX] = true;
					}
				}
			}
			
		}
		
		return -1;
	}
}
