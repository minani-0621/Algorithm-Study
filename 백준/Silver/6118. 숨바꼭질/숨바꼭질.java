import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int N, M;
	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	static class Node {
		int nodeNum, dist;
		public Node(int nodeNum, int dist) {
			this.nodeNum = nodeNum;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) {
		N = scanner.nextInt();
		M = scanner.nextInt();
		
		graph = new LinkedList[N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 0; i <= N; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}
		
		ArrayList<Node> farNodes = bfs();
		Collections.sort(farNodes, Comparator.comparingInt(n -> n.nodeNum));
		System.out.println(farNodes.get(0).nodeNum + " " + farNodes.get(0).dist + " " + farNodes.size());
	}
	
	static ArrayList<Node> bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(1, 0));
		visited[1] = true;
		ArrayList<Node> farNodes = new ArrayList<>();
		int maxDist = 0;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			Iterator<Integer> iter = graph[checkNode.nodeNum].iterator();
			
			while(iter.hasNext()) {
				int linkNode = iter.next();
				
				if(!visited[linkNode]) {
					queue.offer(new Node(linkNode, checkNode.dist + 1));
					
					if(maxDist < checkNode.dist + 1) {
						maxDist = checkNode.dist + 1;
						farNodes.clear();
						farNodes.add(new Node(linkNode, checkNode.dist + 1));
					}else if(maxDist == checkNode.dist + 1) {
						farNodes.add(new Node(linkNode, checkNode.dist + 1));
					}
					
					visited[linkNode] = true;
				}
			}
		}
		
		return farNodes;
	}
}
