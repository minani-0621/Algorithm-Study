import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int k, n;
	
	public static void main(String[] args) throws IOException {
		k = scanner.nextInt();
		
		for(int i = 0; i < k; i++) {
			ArrayList<Integer> array = new ArrayList<>();
			n = scanner.nextInt();
			
			for(int j = 0; j < n; j++) {
				int score = scanner.nextInt();
				array.add(score);
			}
			
			Collections.sort(array);
			
			int largestGap = 0;
			if(array.size() > 1) {
				for(int k = 0; k < array.size() - 1; k++) {
					if(array.get(k + 1) - array.get(k) > largestGap) {
						largestGap = array.get(k + 1) - array.get(k);
					}
				}
			}
			
			bw.write("Class " + (i + 1) + "\n");
			bw.write("Max " + array.get(array.size() - 1) + ", ");
			bw.write("Min " + array.get(0) + ", ");
			bw.write("Largest gap " + largestGap + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
