import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		
		HashMap<String, Integer> hashmap = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			String input = scanner.next();
			String[] inputArr = input.split("\\.");
			
			if(!hashmap.containsKey(inputArr[1])) {
				hashmap.put(inputArr[1], 1);
			}else {
				hashmap.replace(inputArr[1], hashmap.get(inputArr[1]) + 1);
			}
		}
		
		List<String> keySet = new ArrayList<>(hashmap.keySet());
		Collections.sort(keySet);
		
		for(String key: keySet) {
			System.out.println(key + " " + hashmap.get(key));
		}
	}
}
