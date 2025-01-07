import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static HashSet<Long> hashset = new HashSet<>();
	static long A, B;
	static class Node {
		long x;
		int calcCount;
		public Node(long x, int calcCount) {
			this.x = x;
			this.calcCount = calcCount;
		}
	}
	
	public static void main(String[] args) {
		A = scanner.nextInt();
		B = scanner.nextInt();
		
		System.out.println(bfs(A));
	}
	
	static int bfs(long x) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, 1));
		hashset.add(x);
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.x == B) {
				return checkNode.calcCount;
			}
			
			long[] nextX = {checkNode.x * 2, Long.parseLong(Long.toString(checkNode.x).concat("1"))};
			int nextCalcCount = checkNode.calcCount + 1;
			
			for(int i = 0; i < 2; i++) {
				if(nextX[i] <= B && !hashset.contains(nextX[i])) {
					queue.offer(new Node(nextX[i], nextCalcCount));
					hashset.add(nextX[i]);
				}
			}
		}
		
		return -1;
	}
}
