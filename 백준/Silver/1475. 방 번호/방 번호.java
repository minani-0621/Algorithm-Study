import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static HashMap<Integer, Integer> hashmap = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		String strN = Integer.toString(n);
		int count = 0;
		
		for(int i = 0; i < 10; i++) {
			hashmap.put(i, 0);
		}
		
		for(int i = 0; i < strN.length(); i++) {
			if(Character.getNumericValue(strN.charAt(i)) == 6) {
				if(hashmap.get(6) + hashmap.get(9) == count * 2) {
					count++;
					hashmap.replace(6, count);
				}else if(hashmap.get(6) < count) {
					hashmap.replace(6, hashmap.get(6) + 1);
				}else if(hashmap.get(6) == count && hashmap.get(9) < count) {
					hashmap.replace(9, hashmap.get(9) + 1);
				}
			}else if(Character.getNumericValue(strN.charAt(i)) == 9) {
				if(hashmap.get(6) + hashmap.get(9) == count * 2) {
					count++;
					hashmap.replace(9, count);
				}else if(hashmap.get(9) < count) {
					hashmap.replace(9, hashmap.get(9) + 1);
				}else if(hashmap.get(9) == count && hashmap.get(6) < count) {
					hashmap.replace(6, hashmap.get(6) + 1);
				}
			}else {
				if(hashmap.get(Character.getNumericValue(strN.charAt(i))) == count) {
					count++;
					hashmap.replace(Character.getNumericValue(strN.charAt(i)), count);
				}else {
					hashmap.replace(Character.getNumericValue(strN.charAt(i)), hashmap.get(Character.getNumericValue(strN.charAt(i)))+ 1);
				}
			}
		}
		
		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
	}
}
