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
		String[] seqStr = br.readLine().split(" ");
		
		for(int i = 0; i < seqStr.length; i++) {
			arr.add(Integer.parseInt(seqStr[i]));
		}
		
		Collections.sort(arr);
		makeAscSequence(0, sequence);
		
		bw.flush();
		bw.close();
	}
	
	static void makeAscSequence(int idx, ArrayList<Integer> selected) throws IOException {
		if(selected.size() == M) {
			for(int num: selected) {
				bw.write(num + " ");
			}
			
			bw.write("\n");
			return;
		}else {
			for(int i = idx; i < N; i++) {
				selected.add(arr.get(i));
				makeAscSequence(i + 1, selected);
				selected.remove(selected.size() - 1);
			}
		}
	}
}
