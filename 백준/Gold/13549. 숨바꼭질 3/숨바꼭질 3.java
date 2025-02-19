import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int N, K;
	static int[] visited; // 값이 0이면 아직 방문x, 양수의 값은 도달 시간.
	static class Node {
		int x, time;
		public Node(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}
	
	public static void main(String[] args) {
		N = scanner.nextInt();
		K = scanner.nextInt();
		visited = new int[1000002];
		
		System.out.println(bfs(N));
	}
	
	static int bfs(int start) {
		int minTime = Integer.MAX_VALUE;
		Queue<Node> queue = new LinkedList<>();
		
		if(start == 0 && K != 0) {
			queue.offer(new Node(1, 1));
			visited[1] = 1;
		}else if(start == 0 && K == 0) {
			return 0;
		}else {
			queue.offer(new Node(start, 0));
			visited[start] = 0;
		}
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.x == K) {
				minTime = Math.min(minTime, checkNode.time);
			}
			
			int[] nextX = {checkNode.x - 1, checkNode.x + 1, checkNode.x * 2};
			int[] nextTime = {checkNode.time + 1, checkNode.time + 1, checkNode.time};
			
			for(int i = 0; i < 3; i++) {
				if(nextX[i] >= 0 && nextX[i] < 100002 && visited[nextX[i]] == 0) {
					queue.offer(new Node(nextX[i], nextTime[i]));
					visited[nextX[i]] = nextTime[i];
				}else if(nextX[i] >= 0 && nextX[i] < 100002 && visited[nextX[i]] != 0 && nextTime[i] < visited[nextX[i]]) {
					queue.offer(new Node(nextX[i], nextTime[i]));
					visited[nextX[i]] = nextTime[i];
				}
			}
		}
		
		return minTime;
	}
}
