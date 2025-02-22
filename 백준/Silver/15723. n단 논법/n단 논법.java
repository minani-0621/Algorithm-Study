import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static LinkedList<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		graph = new LinkedList[26];
		
		for(int i = 0; i < 26; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < N; i++) {
			String[] premise = br.readLine().split(" is ");
			int child = premise[0].charAt(0) - 97;
			int parent = premise[1].charAt(0) - 97;
			graph[child].add(parent);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			String[] premise = br.readLine().split(" is ");
			int child = premise[0].charAt(0) - 97;
			int parent = premise[1].charAt(0) - 97;
			
			boolean result = bfs(child, parent);
			
			if(result) {
				bw.write("T\n");
			}else {
				bw.write("F\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	static boolean bfs(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int checkNode = queue.poll();
			
			if(checkNode == end) {
				return true;
			}
			
			Iterator<Integer> iter = graph[checkNode].iterator();
			
			while(iter.hasNext()) {
				int next = iter.next();
				queue.offer(next);
			}
		}
		
		return false;
	}
}
