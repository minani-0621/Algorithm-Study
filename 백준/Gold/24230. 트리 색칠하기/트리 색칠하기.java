import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] color;
	static LinkedList<Integer>[] tree;
	static boolean[] visited;
	static int minDraw = 0;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		color = new int[N + 1];
		tree = new LinkedList[N + 1];
		visited = new boolean[N + 1];
		
		String[] colors = br.readLine().split(" ");
		
		for(int i = 0; i < colors.length; i++) {
			color[i + 1] = Integer.parseInt(colors[i]);
		}
		
		for(int i = 1; i <= N; i++) {
			tree[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < N - 1; i++) {
			String[] input = br.readLine().split(" ");
			int node1 = Integer.parseInt(input[0]);
			int node2 = Integer.parseInt(input[1]);
			
			tree[node1].add(node2);
			tree[node2].add(node1);
		}
		
		if(color[1] != 0) {
			minDraw++;
		}
		
		dfs(1);
		System.out.println(minDraw);
	}
	
	static void dfs(int currentNode) {
		visited[currentNode] = true;
		int currentColor = color[currentNode];
		
		for(int nextNode: tree[currentNode]) {
			if(!visited[nextNode]) {
				int nextColor = color[nextNode];
				
				if(nextColor != currentColor) {
					minDraw++;
				}
				
				dfs(nextNode);
			}
		}
	}
}
