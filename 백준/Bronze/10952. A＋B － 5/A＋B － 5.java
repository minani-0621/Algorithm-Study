import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		while(true) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			if(a == 0 && b == 0) {
				break;
			}
			
			int result = a + b;
			
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
