import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		while(true) {
			String inputWord = scanner.next();
			boolean isSurprising = true;
			
			if(inputWord.equals("*")) {
				break;
			}else {
				for(int i = 1; i <= inputWord.length() - 1; i++) {
					HashSet<String> hashset = new HashSet<>();
					
					for(int j = 0; j < inputWord.length() - i; j++) {
						String token = inputWord.charAt(j) + "" + inputWord.charAt(j + i);
						
						if(!hashset.contains(token)) {
							hashset.add(token);
						}else {
							isSurprising = false;
						}
					}
				}
				
				if(isSurprising) {
					bw.write(inputWord + " is surprising.\n");
				}else {
					bw.write(inputWord + " is NOT surprising.\n");
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
}
