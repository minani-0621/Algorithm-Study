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
			String input = scanner.next();
			bw.write(input.charAt(0));
			bw.write(input.charAt(input.length() - 1) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
