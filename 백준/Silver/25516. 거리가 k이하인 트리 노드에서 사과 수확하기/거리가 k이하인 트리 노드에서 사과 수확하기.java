import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n, k;
	static LinkedList<Integer>[] graph;
	static int[] appleLocation;
	static class Node {
		int nodeNum, dist;
		public Node(int nodeNum, int dist) {
			this.nodeNum = nodeNum;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		k = scanner.nextInt();
		graph = new LinkedList[n + 1];
		appleLocation = new int[n];
		
		for(int i = 0; i < n; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < n - 1; i++) {
			int p = scanner.nextInt();
			int c = scanner.nextInt();
			graph[p].add(c);
		}
		
		for(int i = 0; i < n; i++) {
			appleLocation[i] = scanner.nextInt();
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 0));
		int appleCount = 0;
		
		if(appleLocation[0] == 1) {
			appleCount++;
		}
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			Iterator<Integer> iter = graph[checkNode.nodeNum].iterator();
			
			while(iter.hasNext()) {
				int childNode = iter.next();
				
				if(checkNode.dist + 1 <= k) {
					queue.offer(new Node(childNode, checkNode.dist + 1));
					
					if(appleLocation[childNode] == 1) {
						appleCount++;
					}
				}
			}
		}
		
		return appleCount;
	}
}
