import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static Scanner scanner  = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		char array[][] = new char[5][15];
		
		for(int i = 0; i < 5; i++) {
			String oneLine = scanner.next();
			
			for(int j = 0 ; j < oneLine.length(); j++) {
				array[i][j] = oneLine.charAt(j);
			}
		}
		
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 5; j++) {
				if((array[j][i] >= 48 && array[j][i] <= 57) || (array[j][i] >= 65 && array[j][i] <= 90) || (array[j][i] >= 97 && array[j][i] <= 122)) {
					bw.write(array[j][i]);
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
}
