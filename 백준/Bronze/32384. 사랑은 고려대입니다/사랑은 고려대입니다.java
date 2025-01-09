import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int N = scanner.nextInt();
		
		for(int i = 0; i < N; i++) {
			bw.write("LoveisKoreaUniversity ");
		}
		
		bw.flush();
		bw.close();
	}
}
