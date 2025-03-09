import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static LinkedList<Room>[] graph;
	static boolean[] visited;
	static class Room {
		int roomNum;
		long distance;
		public Room(int roomNum, long distance) {
			this.roomNum = roomNum;
			this.distance = distance;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		graph = new LinkedList[N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<Room>();
		}
		
		for(int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			graph[A].add(new Room(B, C));
			graph[B].add(new Room(A, C));
		}
		
		System.out.println(bfsToMaxDistance());
	}
	
	static long bfsToMaxDistance() {
		Queue<Room> queue = new LinkedList<>();	
		queue.offer(new Room(1, 0));
		visited[1] = true;
		long maxDist = 0;
		
		while(!queue.isEmpty()) {
			Room checkNode = queue.poll();
			maxDist = Math.max(maxDist, checkNode.distance);
			
			for(Room nextRoom: graph[checkNode.roomNum]) {
				if(!visited[nextRoom.roomNum]) {
					queue.offer(new Room(nextRoom.roomNum, checkNode.distance + nextRoom.distance));
					visited[nextRoom.roomNum] = true;
				}
			}
		}
		
		return maxDist;
	}
}
