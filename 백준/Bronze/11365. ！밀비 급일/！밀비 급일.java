import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		while(true) {
			String oneLine = br.readLine();
			
			if(oneLine.equals("END")) {
				break;
			}
			
			for(int i = oneLine.length() - 1; i >= 0; i--) {
				bw.write(oneLine.charAt(i));
			}
			
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
}
