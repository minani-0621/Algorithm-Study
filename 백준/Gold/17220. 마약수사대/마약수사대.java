import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static LinkedList<Integer>[] graph;
	static boolean[] visited; // 마약 공급책이 경찰에 검거되었으면 true로 설정
	static HashSet<Integer> originSet = new HashSet<>(); // 원산지 집합
	static int count = 0; // 검거 후 여전히 마약을 공급 받는 마약 공급책의 수
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		graph = new LinkedList[N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		// 처음에는 모든 마약 공급책을 원산지라고 가정
		for(int i = 0; i < N; i++) {
			originSet.add(i);
		}
		
		for(int i = 0; i < M; i++) {
			String[] nodes = br.readLine().split(" ");
			int node1 = nodes[0].charAt(0) - 65;
			int node2 = nodes[1].charAt(0) - 65;
			graph[node1].add(node2);
			originSet.remove(node2); // 다른 공급책에게 공급받는 마약 공급책은 원산지에서 제외
		}
		
		String[] knownSupply = br.readLine().split(" ");
		
		// 경찰에게 검거된 마약 공급책은 visited[]에서 true 설정
		for(int i = 1; i <= Integer.parseInt(knownSupply[0]); i++) {
			visited[knownSupply[i].charAt(0) - 65] = true;
		}
		
		// 원산지인 마약 공급책에서 dfs로 탐색
		for(int origin: originSet) {
			if(!visited[origin]) {
				dfs(origin);
			}
		}
		
		System.out.println(count);
	}
	
	static void dfs(int start) {
		for(int nextNode: graph[start]) {
			if(!visited[nextNode]) {
				dfs(nextNode);
				count++;
			}
		}
	}
}
