import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		String word = scanner.next();
		
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) >= 65 && word.charAt(i) <= 90) {
				bw.write((char)(word.charAt(i) + 32)); 
			}else if(word.charAt(i) >= 97 && word.charAt(i) <= 122) {
				bw.write((char)(word.charAt(i) - 32));
			}
		}
		
		bw.flush();
		bw.close();
	}
}
