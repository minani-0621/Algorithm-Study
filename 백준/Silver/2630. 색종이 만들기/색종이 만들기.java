import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] grid;
	static int whiteCount = 0, blueCount = 0;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] oneLine = br.readLine().split(" ");
			
			for(int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(oneLine[j]);
			}
		}
		
		quarterSplit(0, 0, N - 1, N - 1);
		System.out.println(whiteCount + "\n" + blueCount);
	}
	
	static boolean isSameColor(int startX, int startY, int endX, int endY) {
		int color = grid[startX][startY];
		
		for(int i = startX; i <= endX; i++) {
			for(int j = startY; j <= endY; j++) {
				if(color != grid[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static void quarterSplit(int startX, int startY, int endX, int endY) {
		if(isSameColor(startX, startY, endX, endY)) {
			if(grid[startX][startY] == 0) {
				whiteCount++;
			}else {
				blueCount++;
			}
		}else {
			int midX = (startX + endX) / 2;
			int midY = (startY + endY) / 2;
			
			quarterSplit(startX, startY, midX, midY);
			quarterSplit(startX, midY + 1, midX, endY);
			quarterSplit(midX + 1, startY, endX, midY);
			quarterSplit(midX + 1, midY + 1, endX, endY);
		}
	}
}
