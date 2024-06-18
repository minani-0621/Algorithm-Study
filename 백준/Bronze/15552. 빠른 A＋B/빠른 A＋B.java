import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception, IOException {
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			String input = br.readLine();
			String[] inputArr = input.split(" ");
			
			int result = Integer.parseInt(inputArr[0]) + Integer.parseInt(inputArr[1]);
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
