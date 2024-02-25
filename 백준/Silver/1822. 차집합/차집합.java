import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int nA = scanner.nextInt();
		int nB = scanner.nextInt();
		
		HashSet<Integer> setA = new HashSet<>();
		HashSet<Integer> setB = new HashSet<>();
		
		for(int i = 0; i < nA; i++) {
			setA.add(scanner.nextInt());
		}
		
		for(int i = 0; i < nB; i++) {
			setB.add(scanner.nextInt());
		}
		
		setA.removeAll(setB);
		
		bw.write(setA.size() + "\n");
		
		ArrayList<Integer> array = new ArrayList<>();
		
		for(int num: setA) {
			array.add(num);
		}
		
		Collections.sort(array);
		
		for(int num: array) {
			bw.write(num + " ");
		}
		
		bw.flush();
		bw.close();
	}
}
