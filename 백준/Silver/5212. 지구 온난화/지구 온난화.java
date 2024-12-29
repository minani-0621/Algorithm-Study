import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static char[][] grid, changeGrid;
	static int R, C;
	
	public static void main(String[] args) throws IOException {
		String[] size = br.readLine().split(" ");
		R = Integer.parseInt(size[0]);
		C = Integer.parseInt(size[1]);
		grid = new char[R][C];
		changeGrid = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String oneLine = br.readLine();
			
			for(int j = 0; j < C; j++) {
				grid[i][j] = oneLine.charAt(j);
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(grid[i][j] == 'X') {
					isSinking(i, j);
				}else {
					changeGrid[i][j] = '.';
				}
			}
		}
		
		int startX = R - 1, endX = 0, startY = C - 1, endY = 0;
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(changeGrid[i][j] == 'X') {
					if(startX > i) {
						startX = i;
					}
					
					if(endX < i) {
						endX = i;
					}
					
					if(startY > j) {
						startY = j;
					}
					
					if(endY < j) {
						endY = j;
					}
				}
			}
		}
		
		for(int i = startX; i <= endX; i++) {
			for(int j = startY; j <= endY; j++) {
				bw.write(String.valueOf(changeGrid[i][j]));
			}
			
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static void isSinking(int x, int y) {
		int waterCount = 0;
		int[] mr = {-1, 1, 0, 0};
		int[] mc = {0, 0, -1, 1};
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + mr[i];
			int nextY = y + mc[i];
			
			if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) {
				waterCount++;
			}else if(nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && grid[nextX][nextY] == '.') {
				waterCount++;
			}
		}
		
		if(waterCount >= 3) {
			changeGrid[x][y] = '.';
		}else {
			changeGrid[x][y] = 'X';
		}
	}
}
