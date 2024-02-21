import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int t;
	
	public static void main(String[] args) throws IOException {
		t = scanner.nextInt();
		
		for(int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			
			BigInteger nSum = new BigInteger("1");
			for(int j = 1; j <= n; j++) {
				BigInteger bigInteger = new BigInteger(String.valueOf(j));
				nSum = nSum.multiply(bigInteger);
			}
			
			BigInteger mSum = new BigInteger("1");
			for(int j = m; j > m - n; j--) {
				BigInteger bigInteger = new BigInteger(String.valueOf(j));
				mSum = mSum.multiply(bigInteger);
			}
			
			mSum = mSum.divide(nSum);
			
			bw.write(mSum + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
