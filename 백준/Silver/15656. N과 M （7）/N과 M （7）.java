import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static ArrayList<Integer> inputNum = new ArrayList<>();
	static ArrayList<Integer> sequence = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		String[] nums = br.readLine().split(" ");
		
		for(int i = 0; i < N; i++) {
			inputNum.add(Integer.parseInt(nums[i]));
		}
		
		Collections.sort(inputNum);
		makeSequence(sequence);
		
		bw.flush();
		bw.close();
	}
	
	static void makeSequence(ArrayList<Integer> seq) throws IOException {
		if(seq.size() == M) {
			for(int i = 0; i < M; i++) {
				bw.write(seq.get(i) + " ");
			}
			
			bw.write("\n");
			return;
		}else {
			for(int i = 0; i < N; i++) {
				seq.add(inputNum.get(i));
				makeSequence(seq);
				seq.remove(seq.size() - 1);
			}
		}
	}
}
