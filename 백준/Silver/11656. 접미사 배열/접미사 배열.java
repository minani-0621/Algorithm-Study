import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<String> array = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		String word = scanner.next();
		
		for(int i = 0; i < word.length(); i++) {
			String input = word.substring(i);
			array.add(input);
		}
		
		Collections.sort(array);
		
		for(String str: array) {
			bw.write(str + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
