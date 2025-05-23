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
	static ArrayList<Integer> sequence = new ArrayList<>();
	static ArrayList<Integer> numList = new ArrayList<>();
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		visited = new boolean[N];
		String[] inputNums = br.readLine().split(" ");
		
		for(int i = 0; i < N; i++) {
			numList.add(Integer.parseInt(inputNums[i]));
		}
		
		Collections.sort(numList);
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
				if(!visited[i]) {
					visited[i] = true;
					seq.add(numList.get(i));
					makeSequence(seq);
					seq.remove(seq.size() - 1);
					visited[i] = false;
				}
			}
		}
	}
}
