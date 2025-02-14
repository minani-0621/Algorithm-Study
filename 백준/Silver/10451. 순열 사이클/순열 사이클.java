import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		int T = scanner.nextInt();
		
		for(int i = 0; i < T; i++) {
			int N = scanner.nextInt();
			int[] array = new int[N + 1];
			visited = new boolean[N + 1];
			
			for(int j = 1; j <= N; j++) {
				array[j] = scanner.nextInt();
			}

			graph = new LinkedList[N + 1];
			
			for(int j = 1; j <= N; j++) {
				graph[j] = new LinkedList<Integer>();
			}
			
			for(int j = 1; j <= N; j++) {
				graph[j].add(array[j]);
			}
			
			int cycleCount = 0;
			
			for(int j = 1; j <= N; j++) {
				if(!visited[j]) {
					searchGraph(j);
					cycleCount++;
				}
			}
			
			bw.write(cycleCount + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static void searchGraph(int num) {
		visited[num] = true;
		int nextNode = graph[num].get(0);
		
		while(!visited[nextNode]) {
			visited[nextNode] = true;
			nextNode = graph[nextNode].get(0);
		}
	}
}
