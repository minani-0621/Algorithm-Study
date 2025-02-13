import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception, IOException {
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		ArrayList<Integer> array = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			array.add(Integer.parseInt(input[i]));
		}
		
		int x = Integer.parseInt(br.readLine());
		Collections.sort(array);
		
		int start = 0, end = n - 1, count = 0;
		
		while(start < end) {			
			int sum = array.get(start) + array.get(end);
			
			if(sum > x) {
				end--;
			}else if(sum == x) {
				count++;
				start++;
				end = n - 1;
			}else { // sum < x
				start++;
			}
		}
		
		System.out.println(count);
	}
}
