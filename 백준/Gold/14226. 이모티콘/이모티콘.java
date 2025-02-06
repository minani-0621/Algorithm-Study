import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static boolean[][] visited = new boolean[2001][2001];
	static int S;
	static class Node {
		int x, clipBoard, time;
		public Node(int x, int clipBoard, int time) {
			this.x = x;
			this.clipBoard = clipBoard;
			this.time = time;
		}
	}
	
	public static void main(String[] args) {
		S = scanner.nextInt();
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(1, 0, 0));
		visited[1][0] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.x == S) {
				return checkNode.time;
			}
			
			int nextX[] = {checkNode.x, checkNode.x + checkNode.clipBoard, checkNode.x - 1};
			int nextClipBoard[] = {checkNode.x, checkNode.clipBoard, checkNode.clipBoard};
			int nextTime = checkNode.time + 1;
			
			for(int i = 0; i < 3; i++) {
				if(nextX[i] >= 0 && nextX[i] <= 2000 && !visited[nextX[i]][nextClipBoard[i]]) {
					queue.offer(new Node(nextX[i], nextClipBoard[i], nextTime));
					visited[nextX[i]][nextClipBoard[i]] = true;
				}
			}
		}
		
		return -1;
	}
}
