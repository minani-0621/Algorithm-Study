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
			
			if(oneLine.equals("# 0 0")) {
				break;
			}
			
			String[] token = oneLine.split(" ");
			
			String name = token[0];
			int age = Integer.parseInt(token[1]);
			int weight = Integer.parseInt(token[2]);
			
			if(age > 17 || weight >= 80) {
				bw.write(name + " Senior\n");
			}else {
				bw.write(name + " Junior\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
