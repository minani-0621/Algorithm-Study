import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		
		HashMap<Long, Long> hashmap = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			long input = scanner.nextLong();
			
			if(!hashmap.containsKey(input)) {
				hashmap.put(input, (long) 1);
			}else {
				hashmap.replace(input, hashmap.get(input) + 1);
			}
		}
		
		long mostFreq = 0;
		long mostFreqNum = 0;
		
		for(long num: hashmap.keySet()) {
			if(hashmap.get(num) >= mostFreq) {
				if(hashmap.get(num).equals(mostFreq) && num < mostFreqNum) {
					mostFreqNum = num;
				}else if(!hashmap.get(num).equals(mostFreq)) {
					mostFreqNum = num;
					mostFreq = hashmap.get(num);
				}
				
			}
		}
		
		System.out.println(mostFreqNum);
	}
}
