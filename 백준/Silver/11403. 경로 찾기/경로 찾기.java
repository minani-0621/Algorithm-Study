import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 이 문제는 인접리스트를 사용하여 구현하였다. 어떤 한 정점에서 또 다른 한 정점(자기 자신도 포함)으로 갈 수 있는지는 bfs 통해서 찾는다.
 * 하지만 어느 한 정점에서 다른 정점을 찍고 돌아서 다시 자기 자신 정점으로 되돌아 올 수 있는지는 visited[] 배열값이 처음부터 true로
 * 시작하기 때문에 시작 정점을 한 번 더 방문할 수가 없다. 이를 해결하기 위해서 bfs()의 인자값으로 목적지 노드를 넘겨주어 큐에 추가하기
 * 전에 다음 노드가 목적지 노드인지 확인하는 코드를 추가한다.
 */
public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[][] matrix, answer;
	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		matrix = new int[n + 1][n + 1];
		answer = new int[n + 1][n + 1];
		
		graph = new LinkedList[n + 1];
		for(int i = 1; i <= n; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				matrix[i][j] = scanner.nextInt();
				
				if(matrix[i][j] == 1) {
					graph[i].add(j);
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {			
			for(int j = 1; j <= n; j++) {
				visited = new boolean[n + 1];
				int result = bfs(i, j);
				
				if(result == 1) {
					answer[i][j] = 1;
				}else if(result == 0) {
					answer[i][j] = 0;
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				bw.write(answer[i][j] + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static int bfs(int startNode, int endNode) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(startNode);
		visited[startNode] = true;
		
		while(!queue.isEmpty()) {
			int checkNode = queue.poll();
			
			Iterator<Integer> iterator = graph[checkNode].iterator();
			
			while(iterator.hasNext()) {
				int node = iterator.next();
				
				if(node == endNode) {
					return 1;
				}
				
				if(!visited[node]) {
					queue.offer(node);
					visited[node] = true;
				}
			}
		}
		
		return 0;
	}
}
