import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int N, K, minTime = Integer.MAX_VALUE, caseCount;
	static int[] visited;
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
		visited = new int[200002];
		
		caseCount = bfsMove();
		System.out.println(minTime + "\n" + caseCount);
	}
	
	static int bfsMove() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(N, 0));
		visited[N] = 1;
		caseCount = 0;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();

			if(checkNode.time > minTime) {
				break;
			}
			
			if(checkNode.x == K) {
				if(checkNode.time < minTime) {
					minTime = checkNode.time;
					caseCount = 1;
				}else if(checkNode.time == minTime) {
					caseCount++;
				}
				continue;
			}
			
			int[] nextX = {checkNode.x - 1, checkNode.x + 1, checkNode.x * 2};
			int nextTime = checkNode.time + 1;
			
			for(int i = 0; i < 3; i++) {
				if(nextX[i] >= 0 && nextX[i] <= 200001) {
					if(visited[nextX[i]] == 0 || visited[nextX[i]] == nextTime) {
						visited[nextX[i]] = nextTime;
						queue.offer(new Node(nextX[i], nextTime));
					}
					
				}
			}
		}
		
		return caseCount;
	}
}
