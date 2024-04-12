import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * bfs를 구현할 때, 노드들 간의 연결 여부를 2차원 인접행렬를 통해서 구할 수도 있지만, 노드의 수가 많아지게 되면 ((노드의 개수)^2)개
 * 해당하는 만큼의 메모리가 필요하기 때문에 필요한 메모리가 너무 커지게 된다. 이는 인접리스트를 이용하여 메모리 사용량을 최적화 할 수
 * 있는데, 인접리스트는 해당 노드와 간선으로 연결되어 있는 노드들의 정보만 가지고 있기 때문이다. 그러므로 노드의 수가 많다면 인접리스트를
 *  사용하는 것이 더 효율적이다.
*/
public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	static int[] parentNode;
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		graph = new LinkedList[n + 1];
		for(int i = 0; i <= n; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		visited = new boolean[n + 1];
		parentNode = new int[n + 1];
		
		for(int i = 0; i < n - 1; i++) {
			int n1 = scanner.nextInt();
			int n2 = scanner.nextInt();
			
			graph[n1].add(n2);
			graph[n2].add(n1);
		}
		
		bfs(1);
		
		for(int i = 2; i <= n; i++) {
			System.out.println(parentNode[i]);
		}
		
	}
	
	static void bfs(int rootNode) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(rootNode);
		visited[rootNode] = true;
		
		while(!queue.isEmpty()) {
			int checkNode = queue.poll();
			Iterator<Integer> iterator = graph[checkNode].iterator();
			
			while(iterator.hasNext()) {
				int node = iterator.next();
				if(!visited[node]) {
					queue.offer(node);
					visited[node] = true;
					parentNode[node] = checkNode;
				}
			}
		}
	}
}
