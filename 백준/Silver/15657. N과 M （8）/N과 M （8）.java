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
	static ArrayList<Integer> arr = new ArrayList<>();
	static ArrayList<Integer> sequence = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		String[] arrStr = br.readLine().split(" ");
		
		for(int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(arrStr[i]));
		}
		
		Collections.sort(arr);
		makeSequence(-1, sequence);
		
		bw.flush();
		bw.close();
	}
	
	static void makeSequence(int prev, ArrayList<Integer> seq) throws IOException {
		if(seq.size() == M) {
			for(int i = 0; i < M; i++) {
				bw.write(seq.get(i) + " ");
			}
			
			bw.write("\n");
			return;
		}else {
			for(int i = 0; i < N; i++) {
				if(prev == -1) {
					seq.add(arr.get(i));
					makeSequence(arr.get(i), seq);
					seq.remove(seq.size() - 1);
				}else {
					if(seq.get(seq.size() - 1) <= arr.get(i)) {
						seq.add(arr.get(i));
						makeSequence(arr.get(i), seq);
						seq.remove(seq.size() - 1);
					}
				}
			}
		}
	}
}
