import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static ArrayList<Integer> sequence = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		makeSequence(sequence);
		bw.flush();
		bw.close();
	}
	
	static void makeSequence(ArrayList<Integer> seq) throws IOException {
		if(seq.size() == M) {
			for(int num: seq) {
				bw.write(num + " ");
			}
			
			bw.write("\n");
			return;
		}else {
			for(int i = 1; i <= N; i++) {
				seq.add(i);
				makeSequence(seq);
				seq.remove(seq.size() - 1);
			}
		}
	}
}
