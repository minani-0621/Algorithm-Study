import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, k;
	static char[][] board;
	static boolean[][] visited;
	static class Node {
		int x, y, time;
		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		String input[] = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		k = Integer.parseInt(input[1]);
		
		board = new char[2][N];
		visited = new boolean[2][N];
		
		String board1 = br.readLine();
		String board2 = br.readLine();
		
		for(int i = 0; i < board1.length(); i++) {
			board[0][i] = board1.charAt(i);
		}
		
		for(int i = 0; i < board2.length(); i++) {
			board[1][i] = board2.charAt(i);
		}
		
		boolean result = bfs();
		
		if(result) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
	
	static boolean bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 0, 0));
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.y + 1 >= N) {
				return true;
			}
			
			if(board[checkNode.x][checkNode.y + 1] == '1' && !visited[checkNode.x][checkNode.y + 1]) {
				queue.offer(new Node(checkNode.x, checkNode.y + 1, checkNode.time + 1));
				visited[checkNode.x][checkNode.y + 1] = true;
			}
			
			if(checkNode.y - 1 >= 0 && board[checkNode.x][checkNode.y - 1] == '1' && checkNode.y - 1 > checkNode.time && !visited[checkNode.x][checkNode.y - 1]) {
				queue.offer(new Node(checkNode.x, checkNode.y - 1, checkNode.time + 1));
				visited[checkNode.x][checkNode.y - 1] = true;
			}
			
			if(checkNode.x == 0) {
				if(checkNode.y + k >= N) {
					return true;
				}else {
					if(board[1][checkNode.y + k] == '1' && !visited[1][checkNode.y + k]) {
						queue.offer(new Node(1, checkNode.y + k, checkNode.time + 1));
						visited[1][checkNode.y + k] = true;
					}
				}
			}else {
				if(checkNode.y + k >= N) {
					return true;
				}else {
					if(board[0][checkNode.y + k] == '1' && !visited[0][checkNode.y + k]) {
						queue.offer(new Node(0, checkNode.y + k, checkNode.time + 1));
						visited[0][checkNode.y + k] = true;
					}
				}
			}
		}
		
		return false;
	}
}
