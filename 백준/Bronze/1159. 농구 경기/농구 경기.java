import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static HashMap<Character, Integer> hashmap = new HashMap<>();
	static ArrayList<Character> array = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			String input = scanner.next();
			
			if(!hashmap.containsKey(input.charAt(0))){
				hashmap.put(input.charAt(0), 1);
			}else {
				hashmap.replace(input.charAt(0), hashmap.get(input.charAt(0)) + 1);
			}
		}
		
		for(char ch: hashmap.keySet()) {
			if(hashmap.get(ch) >= 5) {
				array.add(ch);
			}
		}
		
		Collections.sort(array);
		
		
		
		if(array.isEmpty()) {
			bw.write("PREDAJA");
		}else {
			for(char ch: array) {
				bw.write(ch);
			}
		}
		
		bw.flush();
		bw.close();
	}
}
