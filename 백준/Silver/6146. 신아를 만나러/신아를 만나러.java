import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int X, Y;
	static boolean[][] map;
	static boolean[][] visited;
	static class Node {
		int x, y, dist;
		public Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) {
		X = scanner.nextInt();
		Y = scanner.nextInt();
		int N = scanner.nextInt();
		
		map = new boolean[1001][1001];
		visited = new boolean[1001][1001];
		
		for(int i = 0; i < N; i++) {
			int puddleX = scanner.nextInt() + 500;
			int puddleY = scanner.nextInt() + 500;
			map[puddleX][puddleY] = true; // 물웅덩이가 있는 곳은 true로
		}
		
		System.out.println(bfs(500, 500));
	}
	
	static int bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y, 0));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(checkNode.x == X + 500 && checkNode.y == Y + 500) {
				return checkNode.dist;
			}
			
			int[] mr = {-1, 1, 0, 0};
			int[] mc = {0, 0, -1, 1};
			
			for(int i = 0; i < 4; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				int nextDist = checkNode.dist + 1;
				
				if(nextX >= 0 && nextX < 1001 && nextY >= 0 && nextY < 1001 && !visited[nextX][nextY] && !map[nextX][nextY]) {
					queue.offer(new Node(nextX, nextY, nextDist));
					visited[nextX][nextY] = true;
				}
			}
		}
		
		return -1;
	}
}
