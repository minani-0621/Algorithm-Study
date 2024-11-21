import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static class Node {
		int x, y; 
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		N = scanner.nextInt();
		int L = scanner.nextInt();
		int R = scanner.nextInt();
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
		
		int time = 0;
		
		while(true) {
			visited = new boolean[N][N];
			boolean isMoving = false;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						if(bfs(i, j, L, R)) {
							isMoving = true;
						}
					}
				}
			}
			
			if(!isMoving) {
				break;
			}
			
			time++;
		}
		
		System.out.println(time);
	}
	
	static boolean bfs(int startX, int startY, int L, int R) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startX, startY));
		visited[startX][startY] = true;
		Queue<Node> unite = new LinkedList<>();
		unite.offer(new Node(startX, startY));
		boolean isMoving = false;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			int[] mr = {-1, 1, 0, 0};
			int[] mc = {0, 0, -1, 1};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextX][nextY]) {
					int gap = Math.abs(map[checkNode.x][checkNode.y] - map[nextX][nextY]);
					
					if(gap >= L && gap <= R) {
						queue.offer(new Node(nextX, nextY));
						visited[nextX][nextY] = true;
						unite.offer(new Node(nextX, nextY));
						isMoving = true;
					}
				}
			}
		}
		
		int uniteCount = unite.size();
		int sum = 0;
		
		if(!isMoving) {
			return false;
		}
		
		for(Node n: unite) {
			sum += map[n.x][n.y];
		}
		
		int update = sum / uniteCount;
		
		while(!unite.isEmpty()) {
			Node updateNode = unite.poll();
			map[updateNode.x][updateNode.y] = update;
		}
		
		return true;
	}
}
