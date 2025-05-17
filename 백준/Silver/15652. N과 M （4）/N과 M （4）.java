import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		N = scanner.nextInt();
		M = scanner.nextInt();
		
		ArrayList<Integer> selected = new ArrayList<>();
		makeSequence(1, selected);
		bw.flush();
	}
	
	static void makeSequence(int start, ArrayList<Integer> selected) throws IOException {
		if(selected.size() == M) {
			for(int num: selected) {
				bw.write(num + " ");
			}
			
			bw.write("\n");
			return;
		}else {
			for(int i = start; i <= N; i++) {
				selected.add(i);
				makeSequence(i, selected);
				selected.remove(selected.size() - 1);
			}
		}
	}
}
