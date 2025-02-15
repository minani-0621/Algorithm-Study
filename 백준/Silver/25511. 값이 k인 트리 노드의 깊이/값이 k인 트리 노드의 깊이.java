import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static LinkedList<Integer>[] graph;
	static HashMap<Integer, Integer> hashmap = new HashMap<>();
	static class Node {
		int nodeNum, depth;
		public Node(int nodeNum, int depth) {
			this.nodeNum = nodeNum;
			this.depth = depth;
		}
	}
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		graph = new LinkedList[n];
		
		for(int i = 0; i < n; i++) {
			graph[i] = new LinkedList<>();
		}
		
		for(int i = 0; i < n - 1; i++) {
			int p = scanner.nextInt();
			int c = scanner.nextInt();
			graph[p].add(c);
		}
		
		for(int i = 0; i < n; i++) {
			hashmap.put(scanner.nextInt(), i);
		}
		
		System.out.println(bfsTree(k));
	}
	
	static int bfsTree(int k) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 0));
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.nodeNum == hashmap.get(k)) {
				return checkNode.depth;
			}
			
			Iterator<Integer> iter = graph[checkNode.nodeNum].iterator();
			
			while(iter.hasNext()) {
				int nextNode = iter.next();
				queue.offer(new Node(nextNode, checkNode.depth + 1));
			}
		}
		
		return -1;
	}
}
