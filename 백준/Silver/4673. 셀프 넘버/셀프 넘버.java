import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		for(int i = 1; i < 10000; i++) {
			if(checkSelfNum(i)) {
				bw.write(i + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	static boolean checkSelfNum(int n) {
		for(int i = 1; i < n; i++) {
			int sum = i;
			String num = Integer.toString(i);
			
			for(int j = 0; j < num.length(); j++) {
				sum += Character.getNumericValue(num.charAt(j));
			}
			
			if(sum == n) {
				return false;
			}
		}
		return true;
	}
}
