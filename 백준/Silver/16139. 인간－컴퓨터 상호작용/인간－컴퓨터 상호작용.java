import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		int q = Integer.parseInt(br.readLine());
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
			String[] oneCase = br.readLine().split(" " );
			String alphabet = oneCase[0];
			int l = Integer.parseInt(oneCase[1]);
			int r = Integer.parseInt(oneCase[2]);
			
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
