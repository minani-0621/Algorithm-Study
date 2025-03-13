import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int C = scanner.nextInt();
		
		bw.write((A + B) % C + " ");
		bw.write(((A % C) + (B % C)) % C + " ");
		bw.write((A * B) % C + " ");
		bw.write(((A % C) * (B % C)) % C + " ");
		bw.flush();
		bw.close();
	}
}
