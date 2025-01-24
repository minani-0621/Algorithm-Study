import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static char[][] initialMap;
	static char[][] playingMap;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		initialMap = new char[N][N];
		playingMap = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String oneLine = br.readLine();
			
			for(int j = 0; j < N; j++) {
				initialMap[i][j] = oneLine.charAt(j);
			}
		}
		
		boolean isOpenMine = false;
		
		for(int i = 0; i < N; i++) {
			String oneLine = br.readLine();
			
			for(int j = 0; j < N; j++) {
				playingMap[i][j] = oneLine.charAt(j);
				
				if(playingMap[i][j] == 'x' && initialMap[i][j] == '*') {
					isOpenMine = true;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(isOpenMine && initialMap[i][j] == '*') {
					bw.write("*");
				}else if(playingMap[i][j] == 'x'){
					bw.write(checkMine(i, j, N) + "");
				}else {
					bw.write(".");
				}
			}
			
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		
	}
	
	static int checkMine(int x, int y, int size) {
		int mineCount = 0;
		int[] mx = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] my = {-1, 0, 1, -1, 1, -1, 0, 1};
		
		for(int i = 0; i < 8; i++) {
			int nextX = x + mx[i];
			int nextY = y + my[i];
			
			if(nextX >= 0 && nextX < size && nextY >= 0 && nextY < size && initialMap[nextX][nextY] == '*') {
				mineCount++;
			}
		}
		
		return mineCount;
	}
}
