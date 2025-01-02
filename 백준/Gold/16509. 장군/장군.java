import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int R1, C1, R2, C2;
	static int[][] map;
	static boolean[][] visited;
	static class Node {
		int x, y, moveCount;
		public Node(int x, int y, int moveCount) {
			this.x = x;
			this.y = y;
			this.moveCount = moveCount;
		}
	}
	
	public static void main(String[] args) {
		R1 = scanner.nextInt();
		C1 = scanner.nextInt();
		R2 = scanner.nextInt();
		C2 = scanner.nextInt();
		
		map = new int[10][9];
		visited = new boolean[10][9];
		// 빈 공간은 0으로, 왕이 있는 부분을 1로 초기화.
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 9; j++) {
				map[i][j] = 0;
			}
		}
		
		map[R2][C2] = 1;
		System.out.println(bfsSangMove(R1, C1));
	}
	
	static int bfsSangMove(int sangX, int sangY) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(sangX, sangY, 0));
		visited[sangX][sangY] = true;
		
		while(!queue.isEmpty()) {
			Node checkNode = queue.poll();
			
			if(map[checkNode.x][checkNode.y] == 1) {
				return checkNode.moveCount;
			}
			
			int[] mr = {-2, -3, -3, -2, 2, 3, 3, 2};
			int[] mc = {-3, -2, 2, 3, 3, 2, -2, -3};
			
			for(int i = 0; i < 8; i++) {
				int nextX = checkNode.x + mr[i];
				int nextY = checkNode.y + mc[i];
				int nextMoveCount = checkNode.moveCount + 1;
				
				if(nextX >= 0 && nextX < 10 && nextY >= 0 && nextY < 9 && !visited[nextX][nextY] && !existObstacle(mr[i], mc[i], checkNode.x, checkNode.y)) {
					queue.offer(new Node(nextX, nextY, nextMoveCount));
					visited[nextX][nextY] = true;
				}
			}
		}
		
		return -1;
	}
	
	static boolean existObstacle(int mr, int mc, int x, int y) {
		if(mr == -2) {
			if(mc == -3) {
				if(map[x][y - 1] == 1) {
					return true;
				}
				
				if(map[x - 1][y - 2] == 1) { 
					return true;
				}
			}else if(mc == 3) {
				if(map[x][y + 1] == 1) {
					return true;
				}
				
				if(map[x - 1][y + 2] == 1) {
					return true;
				}
			}
		}else if(mr == -3) {
			if(mc == -2) {
				if(map[x - 1][y] == 1) {
					return true;
				}
				
				if(map[x - 2][y - 1] == 1) {
					return true;
				}
			}else if(mc == 2) {
				if(map[x - 1][y] == 1) {
					return true;
				}
				
				if(map[x - 2][y + 1] == 1) {
					return true;
				}
			}
		}else if(mr == 2) {
			if(mc == -3) {
				if(map[x][y - 1] == 1) {
					return true;
				}
				
				if(map[x + 1][y - 2] == 1) {
					return true;
				}
			}else if(mc == 3) {
				if(map[x][y + 1] == 1) {
					return true;
				}
				
				if(map[x + 1][y + 2] == 1) {
					return true;
				}
			}
		}else if(mr == 3) {
			if(mc == -2) {
				if(map[x + 1][y] == 1) {
					return true;
				}
				
				if(map[x + 2][y - 1] == 1) {
					return true;
				}
			}else if(mc == 2) {
				if(map[x + 1][y] == 1) {
					return true;
				}
				
				if(map[x + 2][y + 1] == 1) {
					return true;
				}
			}
		}
		
		return false;
	}
}
