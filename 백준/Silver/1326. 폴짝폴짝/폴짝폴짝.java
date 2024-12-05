import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int[] array;
	static int N, a, b;
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
		
		for(int i = 0; i < N; i++) {
			array[i] = scanner.nextInt();
		}
		
		a = scanner.nextInt();
		b = scanner.nextInt();
		
		int answer = bfs(a - 1);
		System.out.println(answer);
	}
	
	static int bfs(int x) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, 0));
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.x == b - 1) {
				return checkNode.jumpCount;
			}
			
			int i = 1;
			while(true) {
				int jump = array[checkNode.x] * i;
				
				if(checkNode.x + jump < N) {
					queue.offer(new Node(checkNode.x + jump, checkNode.jumpCount + 1));
					i++;
				}else {
					break;
				}
			}
			
			i = 1;
			while(true) {
				int jump = array[checkNode.x] * i;
				
				if(checkNode.x - jump >= 0) {
					queue.offer(new Node(checkNode.x - jump, checkNode.jumpCount + 1));
					i++;
				}else {
					break;
				}
			}
		}
		
		return -1;
	}
}
