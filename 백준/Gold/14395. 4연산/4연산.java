import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static long s, t;
	static HashSet<Long> set = new HashSet<>();
	static class Node {
		long x;
		String result = "";
		public Node(long x, String result) {
			this.x = x;
			this.result = result;
		}
	}
	
	public static void main(String[] args) {
		s = scanner.nextInt();
		t = scanner.nextInt();
		
		System.out.println(bfs(s, t));
	}
	
	static String bfs(long s, long t) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(s, ""));
		set.add(s);
		
		if(s == t) {
			return "0";
		}
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.x == t) {
				return checkNode.result;
			}
			
			long[] nextX = {checkNode.x * checkNode.x, checkNode.x + checkNode.x, checkNode.x - checkNode.x, checkNode.x == 0 ? -1 : checkNode.x / checkNode.x};
			String[] nextResult = {checkNode.result.concat("*"), checkNode.result.concat("+"), checkNode.result.concat("-"), checkNode.result.concat("/")};
			
			for(int i = 0; i < 4; i++) {
				if(nextX[i] >= 0 && nextX[i] <= 1000000000 && !set.contains(nextX[i]) && nextX[i] != -1) {
					queue.offer(new Node(nextX[i], nextResult[i]));
					set.add(nextX[i]);
				}
			}
		}
		
		return "-1";
	}
}
