import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String word1 = scanner.next();
		String word2  = scanner.next();
		
		HashMap<Character, Integer> word1Freq = new HashMap<>();
		HashMap<Character, Integer> word2Freq = new HashMap<>();
		
		for(int i = 0; i < word1.length(); i++) {
			if(word1Freq.get(word1.charAt(i)) == null) {
				word1Freq.put(word1.charAt(i), 1);
			}else {
				word1Freq.replace(word1.charAt(i), word1Freq.get(word1.charAt(i)) + 1);
			}
		}
		
		for(int i = 0; i < word2.length(); i++) {
			if(word2Freq.get(word2.charAt(i)) == null) {
				word2Freq.put(word2.charAt(i), 1);
			}else {
				word2Freq.replace(word2.charAt(i), word2Freq.get(word2.charAt(i)) + 1);
			}
		}
		
		int diffCnt = 0;
		
		for(int i = 'a'; i <= 'z'; i++) {
			if(word1Freq.get((char)i) != null && word2Freq.get((char)i) != null && word1Freq.get((char)i) > word2Freq.get((char)i)) {
				diffCnt += (word1Freq.get((char)i) - word2Freq.get((char)i));
			}else if(word1Freq.get((char)i) != null && word2Freq.get((char)i) != null && word1Freq.get((char)i) < word2Freq.get((char)i)) {
				diffCnt += (word2Freq.get((char)i) - word1Freq.get((char)i));
			}else if(word1Freq.get((char)i) != null && word2Freq.get((char)i) == null) {
				diffCnt += word1Freq.get((char)i);
			}else if(word1Freq.get((char)i) == null && word2Freq.get((char)i) != null) {
				diffCnt += word2Freq.get((char)i);
			}
		}
		
		System.out.println(diffCnt);
	}
}
