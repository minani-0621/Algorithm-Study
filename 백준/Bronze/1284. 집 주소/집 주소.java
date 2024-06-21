import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception, IOException {
		while(true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				break;
			}
			
			String number = Integer.toString(n);
			
			int length = 0;
			
			length += number.length() + 1;
			
			for(int i = 0; i < number.length(); i++) {
				if(number.charAt(i) == '1') {
					length += 2;
				}else if(number.charAt(i) == '2') {
					length += 3;
				}else if(number.charAt(i) == '0') {
					length += 4;
				}else {
					length += 3;
				}
			}
			
			bw.write(length + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
