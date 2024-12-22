import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		while(true) {
			String[] size = br.readLine().split(" ");
			int R = Integer.parseInt(size[0]);
			int C = Integer.parseInt(size[1]);
			char[][] grid = new char[R][C];
			
			if(R == 0 && C == 0) {
				break;
			}
			
			for(int i = 0; i < R; i++) {
				String oneLine = br.readLine();
				
				for(int j = 0; j < C; j++) {
					grid[i][j] = oneLine.charAt(j);
				}
			}
			
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(grid[i][j] == '*') {
						bw.write('*');
					}else {
						int result = checkMine(i, j, grid, R, C);
						bw.write(result + "");
					}
				}
				
				bw.write("\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	static int checkMine(int x, int y, char[][] grid, int R, int C) {
		int mineCount = 0;
		int[] mr = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] mc = {-1, 0, 1, -1, 1, -1, 0, 1};
		
		for(int i = 0; i < 8; i++) {
			int nextX = x + mr[i];
			int nextY = y + mc[i];
			
			if(nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && grid[nextX][nextY] == '*') {
				mineCount++;
			}
		}
		
		return mineCount;
	}
}
