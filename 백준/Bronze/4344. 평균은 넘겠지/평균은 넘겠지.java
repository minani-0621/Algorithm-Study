import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int c = scanner.nextInt();
		
		for(int i = 0; i < c; i++) {
			int n = scanner.nextInt();
			ArrayList<Integer> array = new ArrayList<>();
			int sumScore = 0;
			
			for(int j = 0; j < n; j++) {
				int score = scanner.nextInt();
				array.add(score);
				sumScore += score;
			}
			
			double avgScore = sumScore / n;
			
			int count = 0;
			
			for(int j = 0; j < n; j++) {
				if((double)array.get(j) > avgScore) {
					count++;
				}
			}
			
			bw.write(Double.toString(Math.round((double)count / (double)n * 100000) / 1000.0) + "%\n");
		}
		
		bw.flush();
		bw.close();
	}
}
