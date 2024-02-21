import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<Integer> sanggeunCards = new ArrayList<>();
	static HashMap<Integer, Integer> sanggeunFreq = new HashMap<>();
	static int n, m;
	
	
	public static void main(String[] args) throws IOException {
		n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			sanggeunCards.add(scanner.nextInt());
		}
		
		for(int i = 0; i < n; i++) {
			if(!sanggeunFreq.containsKey(sanggeunCards.get(i))) {
				sanggeunFreq.put(sanggeunCards.get(i), 1);
			}else if(sanggeunFreq.containsKey(sanggeunCards.get(i))) {
				sanggeunFreq.replace(sanggeunCards.get(i), sanggeunFreq.get(sanggeunCards.get(i)) + 1);
			}
		}
		
		m = scanner.nextInt();
		
		for(int i = 0; i < m; i++) {
			int checkNum = scanner.nextInt();
			if(!sanggeunFreq.containsKey(checkNum)) {
				bw.write(0 + " ");
			}else if(sanggeunFreq.containsKey(checkNum)) {
				bw.write(sanggeunFreq.get(checkNum) + " ");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
