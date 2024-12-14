import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int N, M, S, E;
	static HashMap<Integer, List<Integer>> teleport = new HashMap<>();
	static boolean[] visited;
	static class Node {
		int x, time;
		public Node(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}
	
	public static void main(String[] args) {
		N = scanner.nextInt();
		M = scanner.nextInt();
		S = scanner.nextInt();
		E = scanner.nextInt();
		
		visited = new boolean[N + 1];
		
		for(int i = 0; i < M; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			
			teleport.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
			teleport.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
		}
		
		System.out.println(bfs(S));
	}
	
	static int bfs(int x) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, 0));
		visited[x] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.x == E) {
				return checkNode.time;
			}
			
			int[] mx = {-1, 1};
			
			for(int i = 0; i < 2; i++) {
				int nextX = checkNode.x + mx[i];
				int nextTime = checkNode.time + 1;
				
				if(nextX >= 1 && nextX <= N && !visited[nextX]) {
					queue.offer(new Node(nextX, nextTime));
					visited[nextX] = true;
				}
			}
			
			
			if(teleport.containsKey(checkNode.x)) {
				for(int teleportX: teleport.get(checkNode.x)) {
					if(!visited[teleportX]) {
						queue.offer(new Node(teleportX, checkNode.time + 1));
						visited[teleportX] = true;
					}
				}
			}
		}
		
		return -1;
	}
}
