import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int pc, network;
	static int[][] graph;
	static boolean[] visited;
	static int count = 0;
	
	public static void main(String[] args) {
		pc = scanner.nextInt();
		network = scanner.nextInt();
		
		graph = new int[pc + 1][pc + 1];
		visited = new boolean[pc + 1];
		
		for(int i = 0; i < network; i++) {
			int pc1 = scanner.nextInt();
			int pc2 = scanner.nextInt();
			
			graph[pc1][pc2] = 1;
			graph[pc2][pc1] = 1;
		}
		
		bfsSpread(1);
		System.out.println(count);
	}
	
	static void bfsSpread(int p) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(p);
		visited[p] = true;
		
		while(!queue.isEmpty()) {
			int checkPC = queue.poll();
			
			for(int i = 1; i <= pc; i++) {
				if(graph[checkPC][i] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					count++;
				}
			}
		}
	}
}
