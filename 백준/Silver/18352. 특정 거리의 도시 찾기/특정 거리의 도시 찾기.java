import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static LinkedList<Integer>[] graph;
	static int[] minDistance;
	static ArrayList<Integer> reachableCity = new ArrayList<>();
	static class Node {
		int nodeNum, dist;
		public Node(int nodeNum, int dist) {
			this.nodeNum = nodeNum;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		graph = new LinkedList[N + 1];
		minDistance = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
		}
		
		findDistance(X, K);
		Collections.sort(reachableCity);
		
		if(reachableCity.isEmpty()) {
			System.out.println(-1);
		}else {
			for(int num: reachableCity) {
				System.out.println(num);
			}
		}
	}
	
	static void findDistance(int start, int minDist) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(start, 0));
		minDistance[start] = -1; // 시작 지점에 다시 돌아올 때 접근 못하도록 -1로 초기화
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.dist == minDist) {
				reachableCity.add(checkNode.nodeNum);
				continue;
			}
			
			for(int nextNode: graph[checkNode.nodeNum]) {
				// minDistance 값이 0이 아닌 수이면 이미 최소 거리로 도달했다는 의미이므로 0인 노드만 접근
				if(minDistance[nextNode] == 0) {
					queue.offer(new Node(nextNode, checkNode.dist + 1));
					minDistance[nextNode] = checkNode.dist + 1;
				}
			}
		}
	}
}
