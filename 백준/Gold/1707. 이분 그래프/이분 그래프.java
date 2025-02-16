import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	static int[] color;
	static class Node {
		int nodeNum, color;
		public Node(int nodeNum, int color) {
			this.nodeNum = nodeNum;
			this.color = color; // 값이 1이면 파랑색, 2이면 빨간색
		}
	}
	
	public static void main(String[] args) throws IOException {
		int K = scanner.nextInt();
		
		for(int i = 0; i < K; i++) {
			int V = scanner.nextInt();
			int E = scanner.nextInt();
			graph = new LinkedList[V + 1];
			visited = new boolean[V + 1];
			color = new int[V + 1]; // 값이 1이면 파랑색, 2이면 빨간색
			
			for(int j = 1; j <= V; j++) {
				graph[j] = new LinkedList<Integer>();
			}
			
			for(int j = 0; j < E; j++) {
				int n1 = scanner.nextInt();
				int n2 = scanner.nextInt();
				graph[n1].add(n2);
				graph[n2].add(n1);
			}
			
			boolean result = true;
			
			for(int j = 1; j <= V; j++) {
				if(!visited[j]) {
					if(!bfs(j)) {
						result = false;
						break;
					}
				}
			}
			
			if(result) {
				bw.write("YES\n");
			}else {
				bw.write("NO\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	static boolean bfs(int start) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(start, 1));
		visited[start] = true;
		color[start] = 1;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			Iterator<Integer> iter = graph[checkNode.nodeNum].iterator();
			
			while(iter.hasNext()) {
				int nextNode = iter.next();
				
				if(!visited[nextNode]) {
					int nextColor = checkNode.color == 1 ? 2 : 1;
					queue.offer(new Node(nextNode, nextColor));
					visited[nextNode] = true;
					color[nextNode] = nextColor;
				}else if(color[checkNode.nodeNum] == color[nextNode]) {
					return false;
				}
				
			}
		}
		
		return true;
	}
}
