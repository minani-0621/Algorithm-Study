import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		graph = new LinkedList[N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 1; j <= N; j++) {
				int isLink = Integer.parseInt(st.nextToken());
				
				if(isLink == 1) {
					graph[i].add(j);
					graph[j].add(i);
				}
			}
 		}
		
		ArrayList<Integer> plan = new ArrayList<>();
		String[] planArr = br.readLine().split(" ");
		
		for(int i = 0; i < planArr.length; i++) {
			plan.add(Integer.parseInt(planArr[i]));
		}
		
		bfs(plan.get(0));
		boolean result = true;
		
		for(int i = 0; i < plan.size(); i++) {
			if(!visited[plan.get(i)]) {
				result = false;
				break;
			}
		}
		
		if(result) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int checkNode = queue.poll();
			
			for(int nextNode: graph[checkNode]) {
				if(!visited[nextNode]) {
					queue.offer(nextNode);
					visited[nextNode] = true;
				}
			}
		}
	}
}
