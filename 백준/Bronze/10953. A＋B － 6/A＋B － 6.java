import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			String[] input = br.readLine().split(",");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			bw.write(A + B + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
