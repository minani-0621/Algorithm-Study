import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int TC = scanner.nextInt();
		
		for(int i = 0; i < TC; i++) {
			int N = scanner.nextInt();
			int M = scanner.nextInt();
			ArrayList<Integer> snacks = new ArrayList<>();
			
			for(int j = 0; j < N; j++) {
				snacks.add(scanner.nextInt());
			}
			
			Collections.sort(snacks);
			int start = 0, end = N - 1, max = 0;
			
			while(start < end) {
				int sum = snacks.get(start) + snacks.get(end);
				
				if(sum <= M) {
					max = Math.max(max, sum);
				}
				
				if(sum > M) {
					end--;
				}else if(sum == M) {
					start++;
					end = N - 1;
				}else if(sum < M) {
					start++;
				}
			}
			
			if(max == 0) {
				bw.write("#" + (i + 1) + " -1\n");
			}else {
				bw.write("#" + (i + 1) + " " + max + "\n");
			}
			
		}
		
		bw.flush();
		bw.close();
	}
}
