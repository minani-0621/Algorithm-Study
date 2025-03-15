import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M, R;
	static LinkedList<Integer>[] graph;
	static int[] visited;
	static int visitTime = 1;
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		R = Integer.parseInt(input[2]);
		graph = new LinkedList[N + 1];
		visited = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			String[] linkInfo = br.readLine().split(" ");
			int n1 = Integer.parseInt(linkInfo[0]);
			int n2 = Integer.parseInt(linkInfo[1]);
			graph[n1].add(n2);
			graph[n2].add(n1);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}
		
		dfs(R);
		
		for(int i = 1; i <= N; i++) {
			bw.write(visited[i] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static void dfs(int nodeNum) {
		visited[nodeNum] = visitTime;
		visitTime++;
		
		for(int nextNodeNum: graph[nodeNum]) {
			if(visited[nextNodeNum] == 0) {
				dfs(nextNodeNum);
			}
		}
	}
}
