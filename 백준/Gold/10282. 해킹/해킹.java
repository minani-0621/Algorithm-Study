import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, d, c;
	static LinkedList<Node>[] graph;
	static int[] time;
	static HashSet<Integer> infectedSet;
	
	static class Node implements Comparable<Node>{
		int comNum, time;
		public Node(int comNum, int time) {
			this.comNum = comNum;
			this.time = time;
		}
		
		@Override
		public int compareTo(Node node) {
			return time - node.time;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			String[] input = br.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			d = Integer.parseInt(input[1]);
			c = Integer.parseInt(input[2]);
			graph = new LinkedList[n + 1];
			time = new int[n + 1];
			infectedSet = new HashSet<>();
			
			for(int j = 1; j <= n; j++) {
				graph[j] = new LinkedList<Node>();
				time[j] = Integer.MAX_VALUE;
			}
			
			for(int j = 0; j < d; j++) {
				String[] info = br.readLine().split(" ");
				int a = Integer.parseInt(info[0]);
				int b = Integer.parseInt(info[1]);
				int s = Integer.parseInt(info[2]);
				graph[b].add(new Node(a, s));
			}
			
			dijkstra(c);
			bw.write(infectedSet.size() + " ");
			int lastInfectedTime = 0;
			
			for(int j = 1; j <= n; j++) {
				if(time[j] != Integer.MAX_VALUE && time[j] > lastInfectedTime) {
					lastInfectedTime = time[j];
				}
			}
			
			bw.write(lastInfectedTime + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		time[start] = 0;
		infectedSet.add(start);
		
		while(!pq.isEmpty()) {
			Node checkNode = pq.poll();
			int checkNodeNum = checkNode.comNum;
			int checkNodeTime = checkNode.time;
			
			if(time[checkNodeNum] < checkNodeTime) {
				continue;
			}
			
			for(Node nextNode: graph[checkNodeNum]) {
				int nextNodeNum = nextNode.comNum;
				int nextNodeTime = nextNode.time;
				
				if(time[nextNodeNum] > checkNodeTime + nextNodeTime) {
					pq.add(new Node(nextNodeNum, checkNodeTime + nextNodeTime));
					time[nextNodeNum] = checkNodeTime + nextNodeTime;
					infectedSet.add(nextNodeNum);
				}
			}
		}
	}
}
