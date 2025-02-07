import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		String str = scanner.next();
		int q = scanner.nextInt();
		int[][] prefixSum = new int[26][str.length()];		
		
		for(int i = 0; i < str.length(); i++) {
			for(int j = 0; j < 26; j++) {
				if(i > 0) {
					prefixSum[j][i] = prefixSum[j][i - 1];
				}
			}
			
			prefixSum[str.charAt(i) - 97][i] += 1; 
		}
		
		for(int i = 0; i < q; i++) {
			String alphabet = scanner.next();
			int l = scanner.nextInt();
			int r = scanner.nextInt();			
			
			if(l == 0) {
				bw.write(prefixSum[alphabet.charAt(0) - 97][r] + "\n");
			}else{
				bw.write((prefixSum[alphabet.charAt(0) - 97][r] - prefixSum[alphabet.charAt(0) - 97][l - 1]) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}

}
