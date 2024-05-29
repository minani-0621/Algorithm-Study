import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String word = scanner.next();
		
		int[] array = new int[26];
		
		for(int i = 0; i < 26; i++) {
			array[i] = 0;
		}
		
		for(int i = 0; i < word.length(); i++) {
			array[word.charAt(i) - 97] += 1;
		}
		
		for(int i = 0; i < 26; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
