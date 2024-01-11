import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static String input;
	static String[] vowels = new String[]{"a", "e", "i", "o", "u", "A", "E", "I", "O", "U"};
	static ArrayList<Integer> answer = new ArrayList<>();
	
	public static void main(String[] args) {
		input = scanner.nextLine();
		
		while(!input.equals("#")) {
			int count = 0;
			for(int i = 0; i < input.length(); i++) {
				for(int j = 0; j < 10; j++) {
					if(String.valueOf(input.charAt(i)).equals(vowels[j])) {
						count++;
					}
				}
			}
			answer.add(count);
			input = scanner.nextLine();
		}
		
		for(int count: answer) {
			System.out.println(count);
		}
	}
}
