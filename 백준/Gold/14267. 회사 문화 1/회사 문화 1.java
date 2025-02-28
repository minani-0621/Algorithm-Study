import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static LinkedList<Integer>[] graph;
	static int[] complimentEmp;
	static int[] compliment;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graph = new LinkedList[n + 1];
		complimentEmp = new int[n + 1];
		compliment = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= n; i++) {
			int boss = Integer.parseInt(st.nextToken());
			
			if(boss != -1) {
				graph[boss].add(i);
			}
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int empNum = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			compliment[empNum] += w;
		}
		
		dfs(1, 0);
		
		for(int i = 1; i <= n; i++) {
			bw.write(complimentEmp[i] + " ");
		}
		
		bw.flush();
		bw.close();
	}
	
	static void dfs(int parentNode, int w) {
		w += compliment[parentNode];
		complimentEmp[parentNode] += w;
		
		for(int childNode: graph[parentNode]) {
			dfs(childNode, w);
		}
	}
}
