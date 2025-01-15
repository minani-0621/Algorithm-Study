import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int H, W;
	static char[][] map;
	static int[][] forecast;
	
	public static void main(String[] args) throws IOException {
		String[] size = br.readLine().split(" ");
		H = Integer.parseInt(size[0]);
		W = Integer.parseInt(size[1]);
		map = new char[H][W];
		forecast = new int[H][W];
		
		for(int i = 0; i < H; i++) {
			String oneLine = br.readLine();
			
			for(int j = 0; j < W; j++) {
				map[i][j] = oneLine.charAt(j);
			}
		}
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(map[i][j] == 'c') {
					forecast[i][j] = 0;
				}else {
					forecast[i][j] = -1;
					
					for(int k = j; k >= 0; k--) {
						if(map[i][k] == 'c') {
							forecast[i][j] = j - k;
							break;
						}
					}
				}
			}
		}
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				bw.write(forecast[i][j] + " ");
			}
			
			bw.write("\n");
 		}
		
		bw.flush();
		bw.close();
	}
}
