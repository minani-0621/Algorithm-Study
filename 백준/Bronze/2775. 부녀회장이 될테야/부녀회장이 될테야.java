import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int t = scanner.nextInt();
		
		int array[][] = new int[15][14];
		
		for(int i = 0; i < 14; i++) {
			array[0][i] = i + 1;
		}
		
		for(int i = 1; i <= 14; i++) {
			for(int j = 0; j < 14; j++) {
				if(j == 0) {
					array[i][j] = 1;
				}else {
					array[i][j] = array[i - 1][j] + array[i][j - 1];
				}
			}
		}
		
		for(int i = 0; i < t; i++) {
			int k = scanner.nextInt();
			int n = scanner.nextInt();
			
			bw.write(array[k][n - 1] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
