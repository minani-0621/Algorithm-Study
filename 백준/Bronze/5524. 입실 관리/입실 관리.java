import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			String input = scanner.next();
			String inputTemp = "";
			for(int j = 0; j < input.length(); j++) {
				if(input.charAt(j) < 97) {
					inputTemp = inputTemp.concat(Character.toString(input.charAt(j) + 32));
				}else {
					inputTemp = inputTemp.concat(Character.toString(input.charAt(j)));
				}
			}
			
			bw.write(inputTemp + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
