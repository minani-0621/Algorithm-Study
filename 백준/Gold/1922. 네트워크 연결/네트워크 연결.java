import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static LinkedList<Node>[] graph;
	static HashSet<Integer> set = new HashSet<>();
	static int minCostSum = 0;
	static class Node {
		int linkNode, cost;
		public Node(int linkNode, int cost) {
			this.linkNode = linkNode;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new LinkedList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<Node>();
		}
		
		for(int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
		
		set.add(1);
		
		while(set.size() != N) {
			int minCost = Integer.MAX_VALUE;
			Node minCostNode = null;
			
			for(int nodeNum: set) {
				for(Node nextNode: graph[nodeNum]) {
					if(!set.contains(nextNode.linkNode)) {
						if(nextNode.cost < minCost) {
							minCostNode = nextNode;
							minCost = nextNode.cost;
						}
					}
				}
			}
			
			set.add(minCostNode.linkNode);
			minCostSum += minCostNode.cost;
		}
		
		System.out.println(minCostSum);
	}
}
