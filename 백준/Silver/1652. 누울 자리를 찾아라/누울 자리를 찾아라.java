import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[][] room;
	
	public static void main(String[] args) throws Exception, IOException {
		int N = Integer.parseInt(br.readLine());
		room = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String oneLine = br.readLine();
			
			for(int j = 0; j < N; j++) {
				room[i][j] = oneLine.charAt(j);
			}
		}
		
		int widthLie = 0, heightLie = 0;
		
		for(int i = 0; i < N; i++) {
			int count = 0;
			
			for(int j = 0; j < N; j++) {
				if(room[i][j] == '.') {
					count++;
					
					if(count == 2) {
						widthLie++;
						continue;
					}
				}else {
					count = 0;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			int count = 0;
			
			for(int j = 0; j < N; j++) {
				if(room[j][i] == '.') {
					count++;
					
					if(count == 2) {
						heightLie++;
						continue;
					}
				}else {
					count = 0;
				}
			}
		}
		
		System.out.println(widthLie + " " + heightLie);
	}
}
