import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M, R;
	static LinkedList<Integer>[] graph;
	static int[] visitedTime;
	static int visitTime = 1;
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		R = Integer.parseInt(input[2]);
		
		graph = new LinkedList[N + 1];
		visitedTime = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			String[] nodes = br.readLine().split(" ");
			int node1 = Integer.parseInt(nodes[0]);
			int node2 = Integer.parseInt(nodes[1]);
			graph[node1].add(node2);
			graph[node2].add(node1);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(graph[i], Collections.reverseOrder());
		}
		
		bfs(R);
		
		for(int i = 1; i <= N; i++) {
			bw.write(visitedTime[i] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visitedTime[start] = visitTime;
		
		while(!queue.isEmpty()) {
			int checkNode = queue.poll();
			
			for(int nextNode: graph[checkNode]) {
				if(visitedTime[nextNode] == 0) {
					queue.offer(nextNode);
					visitedTime[nextNode] = ++visitTime;
				}
			}
		}
	}
}
