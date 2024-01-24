import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n, m;
	static String input;
	static ArrayList<String> array = new ArrayList<>();
	static HashMap<String, Integer> hashmap = new HashMap<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			input = scanner.next();
			hashmap.put(input, 1);
		}
		
		for(int i = 0; i < m; i++) {
			input = scanner.next();
			if(hashmap.containsKey(input)) {
				array.add(input);
			}
		}
		
		System.out.println(array.size());

		Collections.sort(array);
		
		for(String name: array) {
			bw.write(name + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
