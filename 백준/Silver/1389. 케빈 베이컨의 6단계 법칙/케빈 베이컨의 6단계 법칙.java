import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	static int n;
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		int m = scanner.nextInt();
		
		graph = new LinkedList[n + 1];
		for(int i = 1; i <= n; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		ArrayList<Integer> kevinBaconCountList = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			int p1 = scanner.nextInt();
			int p2 = scanner.nextInt();
			
			graph[p1].add(p2);
			graph[p2].add(p1);
		}
		
		for(int i = 1; i <= n; i++) {
			int countCase = 0;
			for(int j = 1; j <= n; j++) {
				visited = new boolean[n + 1];
				if(i != j) {
					countCase += bfs(i, j, visited);
				}
			}
			kevinBaconCountList.add(countCase);
		}
		
		int smallerPersonNum = 0;
		int lowerBacon = kevinBaconCountList.get(smallerPersonNum);
		for(int i = 1; i < kevinBaconCountList.size(); i++) {
			if(kevinBaconCountList.get(i) < lowerBacon) {
				smallerPersonNum = i;
				lowerBacon = kevinBaconCountList.get(i);
			}else if(kevinBaconCountList.get(i) == lowerBacon && i < smallerPersonNum) {
				smallerPersonNum = i;
			}
		}
		System.out.println(smallerPersonNum + 1);
	}
	
	static int bfs(int startNode, int endNode, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(startNode);
		visited[startNode] = true;
		HashMap<Integer, Integer> distance = new HashMap<>();
		for(int i = 1; i <= n; i++) {
			distance.put(i, 0);
		}
		
		while(!queue.isEmpty()) {
			int checkNode = queue.poll();
			Iterator<Integer> iterator = graph[checkNode].iterator();
			
			while(iterator.hasNext()) {
				int node = iterator.next();
				
				if(node == endNode) {
					return distance.get(checkNode) + 1;
				}
				
				if(!visited[node]) {
					queue.offer(node);
					visited[node] = true;
					distance.replace(node, distance.get(checkNode) + 1);
				}
			}
		}
		
		return 0;
	}
}
