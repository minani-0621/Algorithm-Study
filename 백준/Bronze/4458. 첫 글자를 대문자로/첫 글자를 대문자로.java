import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(scanner.nextLine());
		
		for(int i = 0; i < N; i++) {
			String input = scanner.nextLine();
			String result = input.substring(0, 1).toUpperCase() + input.substring(1);
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
