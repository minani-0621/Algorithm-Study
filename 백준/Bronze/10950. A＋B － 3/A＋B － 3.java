import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int t = scanner.nextInt();
		
		for(int i = 0; i < t; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			int sum = a + b;
			
			bw.write(sum + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
