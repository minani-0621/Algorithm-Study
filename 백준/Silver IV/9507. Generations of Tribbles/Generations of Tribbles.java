import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int t;
	static long array[];
	
	public static void main(String[] args) throws IOException {
		t = scanner.nextInt();
		
		for(int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			array = new long[n + 1];
			
			bw.write(koong(n) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static long koong(int n) {
		if(n < 2) {
			return 1;
		}else if(n == 2) {
			return 2;
		}else if(n == 3) {
			return 4;
		}else if(array[n] != 0) {
			return array[n];
		}else { // n > 3
			return array[n] = koong(n - 1) + koong(n - 2) + koong(n - 3) + koong(n - 4);
		}
	}
}
