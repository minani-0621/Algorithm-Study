import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, R, giga, trunkLength = 0, longestBranchLength = 0;
	static LinkedList<Node>[] tree;
	static boolean[] visited;
	static class Node {
		int nodeNum, distance;
		public Node(int nodeNum, int distance) {
			this.nodeNum = nodeNum;
			this.distance = distance;
		}
	}
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		R = Integer.parseInt(input[1]);
		tree = new LinkedList[N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) {
			tree[i] = new LinkedList<Node>();
		}
		
		for(int i = 0; i < N - 1; i++) {
			String[] info = br.readLine().split(" ");
			int a = Integer.parseInt(info[0]);
			int b = Integer.parseInt(info[1]);
			int d = Integer.parseInt(info[2]);
			tree[a].add(new Node(b, d));
			tree[b].add(new Node(a, d));
		}
		
		dfsTrunk(R);
		if(giga != 0) {
			dfsBranch(giga, 0);
		}
		
		bw.write(trunkLength + " " + longestBranchLength);
		bw.flush();
		bw.close();
	}
	
	static void dfsTrunk(int start) {
		visited[start] = true;
		int childCount = 0;
		
		for(Node childNode : tree[start]) {
			if(!visited[childNode.nodeNum]) {
				childCount++;
			}
		}
		// 자식의 개수가 2개 이상일 때 기가 노드이며, 자식의 개수가 0개일 때 기가 노드이지만 가지가 없는 경우
		if(childCount >= 2 || childCount == 0) {
			giga = start;
			return;
		}
		
		for(Node childNode : tree[start]) {
			if(!visited[childNode.nodeNum]) {
				trunkLength += childNode.distance;
				dfsTrunk(childNode.nodeNum);
			}
		}
	}
	
	static void dfsBranch(int start, int length) {
		visited[start] = true;
		// 트리가 양방향 그래프이므로 탐색 중인 노드의 연결 요소가 한 개이면 리프 노드임
		if(tree[start].size() == 1) {
			longestBranchLength = Math.max(longestBranchLength, length);
		}else {
			for(Node childNode : tree[start]) {
				if(!visited[childNode.nodeNum]) {
					dfsBranch(childNode.nodeNum, length + childNode.distance);
				}
			}
		}
		
		visited[start] = false;
	}
}
