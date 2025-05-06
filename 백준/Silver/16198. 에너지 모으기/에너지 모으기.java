import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static ArrayList<Integer> beads;
	static ArrayList<Integer> results;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		beads = new ArrayList<Integer>();
		results = new ArrayList<Integer>();
		String[] input = br.readLine().split(" ");
		
		for(int i = 0; i < input.length; i++) {
			beads.add(Integer.parseInt(input[i]));
		}
		
		calcEnergy(N, 0);
		
		Collections.sort(results, Collections.reverseOrder());
		System.out.println(results.get(0));
	}
	
	static void calcEnergy(int size, int tmp) {
		if(size == 2) {
			results.add(tmp);
			return;
		}
		
		for(int i = 1; i < size - 1; i++) {
			int e = beads.get(i - 1) * beads.get(i + 1);
			tmp += e;
			int energy = beads.get(i);
			beads.remove(i);
			calcEnergy(size - 1, tmp);
			beads.add(i, energy);
			tmp -= e;
		}
	}
}
