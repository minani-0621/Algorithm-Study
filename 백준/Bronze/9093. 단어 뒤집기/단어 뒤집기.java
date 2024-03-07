import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int t = scanner.nextInt();
		scanner.nextLine();
		
		for(int i = 0; i < t; i++) {
			String oneLine = scanner.nextLine();
			String[] token = oneLine.split(" ");
			
			for(String str: token) {
				for(int j = str.length() - 1; j >= 0; j--) {
					bw.write(str.charAt(j));
				}
				
				bw.write(" ");
			}
			
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
}