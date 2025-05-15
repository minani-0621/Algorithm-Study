import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, R, t = 1;
	static LinkedList<Integer>[] graph;
	static long[] depth;
	static int[] visitTime;
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		R = Integer.parseInt(input[2]);
		graph = new LinkedList[N + 1];
		depth = new long[N + 1];
		visitTime = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<Integer>();
			depth[i] = -1;
		}
		
		for(int i = 0; i < M; i++) {
			String[] info = br.readLine().split(" ");
			int u = Integer.parseInt(info[0]);
			int v = Integer.parseInt(info[1]);
			graph[u].add(v);
			graph[v].add(u);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(graph[i], Collections.reverseOrder());
		}
		
		dfs(R, 0);
		long answer = 0;
		
		for(int i = 1; i <= N; i++) {
			answer += depth[i] * visitTime[i];
		}
		
		System.out.println(answer);
	}
	
	static void dfs(int start, long dep) {
		depth[start] = dep;
		visitTime[start] = t++;
		
		for(int childNode: graph[start]) {
			if(depth[childNode] == -1) {
				dfs(childNode, dep + 1);
			}
		}
	}
}
