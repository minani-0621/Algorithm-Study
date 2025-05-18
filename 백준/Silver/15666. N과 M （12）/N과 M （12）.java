import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static ArrayList<Integer> arr = new ArrayList<>();
	static ArrayList<Integer> sequence = new ArrayList<>();
	static HashSet<String> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		String[] nums = br.readLine().split(" ");
		
		for(int i = 0; i < nums.length; i++) {
			arr.add(Integer.parseInt(nums[i]));
		}
		
		Collections.sort(arr);
		makeSequence(-1, sequence);
		
		bw.flush();
		bw.close();
 	}
	
	static void makeSequence(int prev, ArrayList<Integer> seq) throws IOException {
		if(seq.size() == M) {
			String oneCase = seq.toString();
			
			if(!set.contains(oneCase)) {
				set.add(oneCase);
				
				for(int num: seq) {
					bw.write(num + " ");
				}
				
				bw.write("\n");
			}
			
			return;
		}else {
			for(int i = 0; i < arr.size(); i++) {
				if(seq.isEmpty() || seq.get(seq.size() - 1) <= arr.get(i)) {
					seq.add(arr.get(i));
					makeSequence(seq.get(seq.size() - 1), seq);
					seq.remove(seq.size() - 1);					
				}
			}
		}
	}
}
