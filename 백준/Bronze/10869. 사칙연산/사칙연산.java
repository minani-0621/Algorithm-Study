import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		int sum = a + b;
		int diff = a - b;
		int mul = a * b;
		int div = a / b;
		int mod = a % b;
		
		bw.write(sum + "\n");
		bw.write(diff + "\n");
		bw.write(mul + "\n");
		bw.write(div + "\n");
		bw.write(mod + "\n");
		
		bw.flush();
		bw.close();
	}
}
